import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { General } from '../services/general';
import { User } from '../models/user.model';
import { ConfigWeb } from '../services/configWeb';

@Component({
	selector: 'profile',
	templateUrl: '../views/profile.html',
	providers: [ UserService, General ]
})

export class ProfileComponent implements OnInit {
	public loguedUser;
	public resources;

	constructor(
		private _general: General,
		private _userService: UserService
	){
		this.loguedUser = this._general.getIdentity();
		this.resources = ConfigWeb.resourcesImages;
	}

	ngOnInit(){
		this._general.focusInput($('#form-edit-profile input[type="text"], #form-edit-profile input[type="password"]'));
	}

	showEdit(){
		var inputs = $('#form-edit-profile').find('input[type="text"]');
		inputs.removeAttr('readonly').css({
			borderBottom: '2px solid #53a253'
		});
	}

	updateProfile(){
		this._userService.updateUser(this.loguedUser, this.loguedUser._id).subscribe(
			response => {
				console.log('User updated: ' + response);
			},
			error => console.log(<any>error)
		);
	}
}