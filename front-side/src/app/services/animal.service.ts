import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Router, Params, ActivatedRoute } from '@angular/router';
import { Animal } from '../models/animal.model';
import { ConfigWeb } from '../services/configWeb';

@Injectable()

export class AnimalService {

	public apiUrl: string;

	constructor(private _http: Http){
		this.apiUrl = ConfigWeb.apiUrl;
	}

	saveAnimal(animal, token){
		let params = JSON.stringify(animal);
		let headers = new Headers({
			'Content-Type': 'application/json',
			'Authorization': token
		});
		
		return this._http.post(this.apiUrl + 'save-animal', params, {headers: headers})
			.map(res => res.json());
	}

	getAnimal(id){
		return this._http.get(this.apiUrl + 'get-animal/' + id)
			.map(res => res.json());
	}

	getAnimals(){
		return this._http.get(this.apiUrl + 'get-animals')
			.map(res => res.json());
	}

}