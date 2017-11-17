import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';
import { ConfigWeb } from './configWeb';
import { General } from './general';

@Injectable()

export class UserService {
	public apiUrl: string;

	constructor(
		private _http: Http,
		private _general: General
	){
		this.apiUrl = ConfigWeb.apiUrl;
	}

	register(userToRegister){
		let params = JSON.stringify(userToRegister);
		let headers = new Headers({'Content-type': 'application/json'});

		return this._http.post(this.apiUrl + 'register', params, {headers: headers})
			.map(res => res.json());
	}

	login(userToLogin, getToken = null){
		if(getToken != null){
			userToLogin.getToken = getToken;
		}

		let params = JSON.stringify(userToLogin);
		let headers = new Headers({'Content-Type': 'application/json'});

		return this._http.post(this.apiUrl + 'login', params, {headers: headers})
			.map(res => res.json());
	}

	updateUser(userToUpdate){
		let params = JSON.stringify(userToUpdate);
		let headers = new Headers({
			'Content-Type': 'application/json',
			'Authorization': this._general.getToken()
		});

		return this._http.put(this.apiUrl + 'update-user/' + userToUpdate._id, params, {headers: headers})
			.map(res => res.json());
	}
}