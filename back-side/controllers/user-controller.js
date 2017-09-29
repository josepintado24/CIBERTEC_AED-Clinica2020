'use strict'

var bcrypt = require('bcrypt-nodejs');
var User = require('../models/user-model');
var jwt = require('../services/jwt');
var fs = require('fs');
var path = require('path');

function register(req, res){
	var user = new User();
	var params = req.body;

	if(params.password && params.name && params.surname && params.email){
		user.name = params.name;
		user.surname = params.surname;
		user.email = params.email;
		user.role = 'ROLE_USER';
		user.image = null;
		
		User.findOne({email: user.email.toLowerCase()}, (err, issetUser) => {
			if(err) {
				res.status(500).send({
					message: 'Error al comprobar el usuario'
				});
			}
			else {
				if(!issetUser){
					// Cifrar contraseña
					bcrypt.hash(params.password, null, null, (err, hash) => {
						user.password = hash;
						// Guardar user en bbdd
						user.save((err, userStored) => {
							if(err)
								res.status(500).send({
									message: 'Error al guardar usuario'
								});
							else {
								if(!userStored)
									res.status(404).send({
										message: 'No se ha registrado el usuario'
									});
								else 
									res.status(200).send({user: userStored});
							}
						});
					});
				}
				else {
					res.status(200).send({
						message: 'El usuario ya existe'
					});
				}
			}
		});
	}
	else
		res.status(200).send({
			message: 'Introduce correctamente los datos.'
		});
}

function login(req, res){
	var params = req.body;
	var email = params.email;
	var password = params.password;

	User.findOne({email: params.email.toLowerCase()}, (err, user) => {
		if(err)
			res.status(500).send({message: 'Error al comprobar usuario'});
		else {
			if(user){
				bcrypt.compare(password, user.password, (err, check) => {
					if(check)
						if(params.getToken)
							res.status(200).send({token: jwt.createToken(user)});
						else
							res.status(200).send({user: user});
					else
						res.status(404).send({message: 'La contraseña es incorrecta'});
				});
			}
			else {
				res.status(400).send({message: 'El usuario no existe'});
			}
		}
	});
}

function updateUser(req, res){
	var userId = req.params.id;
	var update = req.body;

	if(userId != req.user.sub)
		return res.status(500).send({message: 'No tienes permiso para actualizar el usuario'});

	User.findByIdAndUpdate(userId, update, {new: true}, (err, userUpdated) => {
		if(err)
			res.status(500).send({message: 'Error al actualizar usuario'});
		else {
			if(!userUpdated)
				res.status(404).send({message: 'Usuario no encontrado'});
			else
				res.status(200).send({user: userUpdated});
		}
	});
}

function uploadImage(req, res){
	var userId = req.params.id;
	var fileName = 'No subido';

	if(req.files){
		var filePath = req.files.image.path;
		var fileSplit = filePath.split('\\');
		var fileName = fileSplit[2];
		var typeSplit = fileName.split('.');
		var typeFile = typeSplit[1];

		if(typeFile == 'png' || typeFile == 'jpg' || typeFile == 'jpeg' || typeFile == 'gif'){
			if(userId != req.user.sub)
				return res.status(500).send({message: 'No tienes permiso para actualizar el usuario'});

			User.findByIdAndUpdate(userId, {image: fileName}, {new: true}, (err, userUpdated) => {
				if(err)
					res.status(500).send({message: 'Error al actualizar usuario'});
				else {
					if(!userUpdated)
						res.status(404).send({message: 'Usuario no encontrado'});
					else
						res.status(200).send({user: userUpdated});
				}
			});
		}
		else{
			fs.unlink(filePath, (err) => {
				if(err)
					res.status(200).send({message: 'Extensión no válida y archivo no eliminado'})
				else
					res.status(200).send({message: 'Extensión no válida'});
			});
		}
	}
	else
		res.status(200).send({message: 'No se han subido archivos'});
}

function getAvatarUser(req, res){
	var imageFile = req.params.image;
	var pathFile = './uploads/users/' + imageFile;

	fs.exists(pathFile, (exists) => {
		if(exists)
			res.sendFile(path.resolve(pathFile));
		else
			res.status(404).send({message: 'La imagen no existe'});
	});
}

function getKeepers(req, res){
	User.find({role: 'ROLE_ADMIN'}).exec((err, users) => {
		if(err)
			res.status(500).send({message: 'Error en la petición'});
		else {
			if(!users)
				res.status(404).send({message: 'No hay cuidadores'});
			else
				res.status(200).send({users: users});
		}
	});
}

module.exports = {
	register,
	login,
	updateUser,
	uploadImage,
	getAvatarUser,
	getKeepers
};