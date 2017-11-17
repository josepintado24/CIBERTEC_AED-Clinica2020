import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { ConfigWeb } from './configWeb';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Observable';

@Injectable()

export class UploadService {

	public apiUrl: string;

	constructor(private _http: Http){
		this.apiUrl = ConfigWeb.apiUrl;
	}

	makeFileRequest(url: string, params: Array<any>, files: Array<File>, token: string, name: string){
		return new Promise((resolve, reject) => {
			var formData: any = new FormData();
			var xhr = new XMLHttpRequest();

			for(var i = 0; i < files.length; i++){
				formData.append(name, files[i], files[i].name);
			}

			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200)
						resolve(JSON.parse(xhr.response));
					else
						reject(xhr.response);
				}
			}

			xhr.open('POST', url, true);
			xhr.setRequestHeader('Authorization', token);
			xhr.send(formData);
		});
	}
}