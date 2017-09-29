'use strict'

var mongoose = require('mongoose');
var app = require('./app');
var port = process.env.PORT || 1234;

mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost:27017/zoo', {useMongoClient: true})
	.then(() => {
		console.log('Conexión a la base de datos zoo correcta');
		app.listen(port, () => {
			console.log(`Servidor corriendo en puerto http://localhost:${port}`);
		});
	})
	.catch(err => console.log(err));