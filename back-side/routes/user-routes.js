'use strict'

var express = require('express');
var UserController = require('../controllers/user-controller');
var api = express.Router();
var mdAuth = require('../middlewares/authenticated');
var multipart = require('connect-multiparty');
var mdUpload = multipart({uploadDir: './uploads/users'});

api.post('/register', UserController.register);
api.post('/login', UserController.login);
api.put('/update-user/:id', mdAuth.ensureAuth, UserController.updateUser);
api.post('/upload-avatar-user/:id', [mdAuth.ensureAuth, mdUpload], UserController.uploadImage);
api.get('/get-avatar-user/:image', UserController.getAvatarUser);
api.get('/keepers', UserController.getKeepers);

module.exports = api;