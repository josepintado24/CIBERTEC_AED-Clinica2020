'use strict'

var express = require('express');
var AnimalController = require('../controllers/animal-controller');
var api = express.Router();
var mdAuth = require('../middlewares/authenticated');
var multipart = require('connect-multiparty');
var mdUpload = multipart({uploadDir: './uploads/animals'});
var mdAdmin = require('../middlewares/is-admin');

api.get('/prueba', mdAuth.ensureAuth, AnimalController.prueba);
api.post('/save-animal', [mdAuth.ensureAuth, mdAdmin.isAdmin], AnimalController.saveAnimal);
api.get('/get-animals', AnimalController.getAnimals);
api.get('/get-animal/:id', AnimalController.getAnimal);
api.put('/update-animal/:id', [mdAuth.ensureAuth, mdAdmin.isAdmin], AnimalController.updateAnimal);
api.post('/upload-image-animal/:id', [mdAuth.ensureAuth, mdUpload], AnimalController.uploadImage);
api.get('/get-image-animal/:image', AnimalController.getImage);
api.delete('/delete-animal/:id', [mdAuth.ensureAuth, mdAdmin.isAdmin], AnimalController.deleteAnimal);

module.exports = api;