import { Component, OnInit } from '@angular/core';
import { ConfigWeb } from '../services/configWeb';

@Component({
	selector: 'admin',
	templateUrl: './admin.html',
	styleUrls: ['admin-style.scss']
})

export class AdminComponent implements OnInit {
	public url: string;
	public resources: string;
	constructor(){
		this.url = window.location.href;
		this.resources = ConfigWeb.resourcesImages;
	}

	ngOnInit() {
		var localUrl = this.url.split("/");
		if(localUrl[3] == 'admin') $('#header-web').hide();
	}
}