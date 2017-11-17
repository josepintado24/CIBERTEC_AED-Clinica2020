import { Component, OnInit } from '@angular/core';
import { ConfigWeb } from '../services/configWeb';
import { General } from '../services/general';

@Component({
	selector: 'admin',
	templateUrl: './admin.html',
	styleUrls: ['admin-style.scss'],
	providers: [ General ]
})

export class AdminComponent implements OnInit {
	public url: string;
	public resources: string;
	public identity: Array<any>;
	public token: string;
	public dbImages: string;
	public letterIcon: string;

	constructor(
		private _general: General
	){
		this.url = window.location.href;
		this.resources = ConfigWeb.resourcesImages;
		this.identity = this._general.getIdentity();
		this.token = this._general.getToken();
		this.dbImages = ConfigWeb.dbImages;
	}

	ngOnInit(){
		this._general.headerWeb();
		this.letterIcon = this._general.getLetter();
	}

	headerWeb(){ $('#header-web').show(); }
	prevent(ev){ this._general.prevent(ev); }

	showUserOption(){ $('.menu-user-admin').slideDown('fast'); }
	hideUserOption() { $('.menu-user-admin').slideUp('fast') }

	logOut(){
		localStorage.removeItem('identity');
		localStorage.removeItem('token');
		location.reload();
	}

}