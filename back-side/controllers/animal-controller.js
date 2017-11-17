'use strict'

var Animal = require('../models/animal-model');
var User = require('../models/user-model');
var fs = require('fs');
var path = require('path');

function status500(res, response){
	return res.status(500).send({response});
}

function status404(res, response){
	return res.status(404).send({response});
}

function status200(res, response){
	return res.status(200).send({response});
}

function prueba(req, res){
	res.status(200).send({
		message: 'Probando controlador de animales',
		user: req.user
	});
}

function saveAnimal(req, res){
	var animal = new Animal();
	var params = req.body;

	if(params.name){
		animal.name = params.name;
		animal.description = params.description;
		animal.year = params.year;
		animal.image = null;
		animal.user = req.user.sub;

		animal.save((err, animalStored) => {
			if(err) res.status(500).send({message: 'Error en el servidor.'});
			else {
				if(!animalStored)
					res.status(404).send({message: 'Error al guardar el animal.'})
				else
					res.status(200).send({
						animal: animalStored,
						message: 'El animal ha sido guardado exitosamente en base de datos.'
					});
			}
		});
	}
	else
		res.status(200).send({message: 'El nombre del animal es obligatorio.'});
}

function getAnimals(req, res){
	Animal.find({}).populate({path: 'user'}).exec((err, animals) => {
		if(err) res.status(500).send({message: 'Error en el servidor.'});
		else {
			if(!animals) res.status(404).send({message: 'No se encontraron animales.'});
			else res.status(200).send({
				animals: animals,
				message: 'Animales listados correctamente.'
			})
		}
	});
}

function getAnimal(req, res){
	var animalId = req.params.id;
	Animal.findById(animalId).populate({path: 'user'}).exec((err, animal) => {
		if(err) res.status(500).send({message: 'Error en el servidor.'});
		else {
			if(!animal) res.status(404).send({message: 'No se encontro el animal.'})
			else res.status(200).send({
				animal: animal,
				message: 'Animal obtenido correctamente.'
			});
		}
	});
}

function updateAnimal(req, res) {
	var animalId = req.params.id;
	var update = req.body;

	Animal.findByIdAndUpdate(animalId, update, {new: true}, (err, animalUpdated) => {
		if(err)
			status500(res, 'Erro en la petición');
		else {
			if(!animalUpdated)
				status404(res, 'No se ha actualizado el animal');
			else
				status200(res, animalUpdated);
		}
	});
}

function uploadImage(req, res){
	var animalId = req.params.id;
	var fileName = 'No subido';

	if(req.files){
		var filePath = req.files.image.path;
		var fileSplit = filePath.split('\\');
		var fileName = fileSplit[2];
		var typeSplit = fileName.split('.');
		var typeFile = typeSplit[1];

		if(typeFile == 'png' || typeFile == 'jpg' || typeFile == 'jpeg' || typeFile == 'gif'){
			if(animalId != req.user.sub)
				status500(res, 'No tienes permiso para actualizar el usuario');

			Animal.findByIdAndUpdate(animalId, {image: fileName}, {new: true}, (err, animalUpdated) => {
				if(err) res.status(500).send({message: 'Error al actualizar el animal.'});
				else {
					if(!animalUpdated) res.status(404).send({message: 'Animal no encontrado.'});
					else res.status(200).send({
						animal: animalUpdated,
						message: 'Imagen del animal guardada correctamente.'
					});
				}
			});
		}
		else{
			fs.unlink(filePath, (err) => {
				if(err)
					status200(res, 'Extensión no válida y archivo no eliminado');
				else
					status200(res, 'Extensión no válida');
			});
		}
	}
	else
		status200(res, 'No se han subido archivos');
}

function getImage(req, res){
	var imageFile = req.params.image;
	var pathFile = './uploads/animals/' + imageFile;

	fs.exists(pathFile, (exists) => {
		if(exists)
			res.sendFile(path.resolve(pathFile));
		else
			res.status(404).send({message: 'La imagen no existe'});
	});
}

function deleteAnimal(req, res){
	var animalId = req.params.id;

	Animal.findByIdAndRemove(animalId, (err, animalRemoved) => {
		if(err)
			status500(res, 'Error en el servidor');
		else
			if(!animalRemoved)
				status404(res, 'No se ha encontrado el animal');
			else{
				status200(res, animalRemoved);
			}
	});
}

module.exports = {
	prueba,
	saveAnimal,
	getAnimals,
	getAnimal,
	updateAnimal,
	uploadImage,
	getImage,
	deleteAnimal
}