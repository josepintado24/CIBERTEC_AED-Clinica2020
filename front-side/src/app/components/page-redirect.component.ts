import { Component, OnInit } from '@angular/core';
import { ConfigWeb } from '../services/configWeb';

@Component({
	selector: 'page-redirect',
	templateUrl: '../views/page-redirect.html'
})

export class PageRedirectComponent {
	public resources: string;
	constructor(){
		this.resources = ConfigWeb.resourcesImages;
	}
}