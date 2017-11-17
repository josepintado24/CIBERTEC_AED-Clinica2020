import { Component, OnInit, DoCheck } from '@angular/core';
import { ConfigWeb } from './services/configWeb';
import { General } from './services/general';
import { User } from './models/user.model';
import { UserService } from './services/user.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	providers: [ General, UserService ]
})
export class AppComponent implements OnInit, DoCheck {
	public resources: string;
	public localUser: string;
	public loguedUser;
	public letterIcon: string;
	public dbImages: string;
	public user: User;

	constructor(
		private _general: General,
		private _userService: UserService
	){
		this.resources = ConfigWeb.resourcesImages;
		this.dbImages = ConfigWeb.dbImages;
	}

	ngOnInit(){
		this.loguedUser = this._general.getIdentity();
		this.letterIcon = this._general.getLetter();
		this.user = this.loguedUser;
	}

	ngDoCheck(){
		this.localUser = localStorage.getItem('user');
		this.headerBack();
		this.maleFemaleIcon();
	}

	prevent(ev){ this._general.prevent(ev); }

	removeUser(){
		localStorage.removeItem('user');
	}

	showUserOption(){
		$('.user-option').slideDown('fast');
	}

	hideUserOption(){
		$('.user-option').slideUp('fast');
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

	maleFemaleIcon(){
		var newUser = this._general.getIdentity();
		if(newUser != null && newUser.image == null){
			if(newUser.gender == 'Femenino')
				newUser.image = 'female-avatar.jpg';
			else
				newUser.image = 'male-avatar.jpg';
		}
		localStorage.setItem('identity', JSON.stringify(newUser));
	}
}