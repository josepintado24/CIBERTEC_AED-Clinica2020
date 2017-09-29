import { Component } from '@angular/core';
import { ConfigWeb } from '../services/configWeb';

@Component({
	selector: 'home',
	templateUrl: '../views/home.html'
})

export class HomeComponent {
	public resources: string;
	public user: string;
	public localUser: string;
	constructor(){
		this.resources = ConfigWeb.resourcesImages;
	}

	sendUser(){
		localStorage.setItem('user', this.user);
		this.localUser = localStorage.getItem('user');
		$('.user-name').val('');
		console.log(this.localUser);
	}
}