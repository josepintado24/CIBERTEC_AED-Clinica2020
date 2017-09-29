import { Component, OnInit, DoCheck } from '@angular/core';
import { ConfigWeb } from './services/configWeb';
import { General } from './services/general';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	providers: [ General ]
})
export class AppComponent implements OnInit, DoCheck {
	public resources: string;
	public localUser: string;
	public loguedUser;
	public letterIcon: string;

	constructor(private general: General){
		this.resources = ConfigWeb.resourcesImages;
	}

	ngOnInit(){
		this.loguedUser = this.general.getIdentity();
		this.getLetter();
	}

	ngDoCheck(){
		this.localUser = localStorage.getItem('user');
		this.headerBack();
	}

	removeUser(){
		localStorage.removeItem('user');
	}

	showUserOption(){
		$('.user-option').slideDown('fast');
	}

	hideUserOption(){
		$('.user-option').slideUp('fast');
	}

	getLetter(){
		if(this.loguedUser){
			var firstLetter = this.loguedUser.name.charAt(0).toLowerCase();
			var lastLetter = this.loguedUser.surname.charAt(0).toLowerCase();
			this.letterIcon = firstLetter + lastLetter;
		}
	}

	logOut(){
		localStorage.removeItem('identity');
		localStorage.removeItem('token');
		location.reload();
	}

	headerBack(){
		var url = window.location.href.split('/');
		if(url[3] != 'home' && url[3] != 'admin')
			$('header').css({
				backgroundColor: '#203a1f',
				boxShadow: '0 1px 5px 0 rgba(0,0,0,0.75)'
			});
		else
			$('header').css({
				backgroundColor: 'transparent',
				boxShadow: 'none'
			});
	}
}