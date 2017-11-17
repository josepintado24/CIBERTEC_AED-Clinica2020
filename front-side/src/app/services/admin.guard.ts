import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { General } from './general';

@Injectable()

export class AdminGuards implements CanActivate {
	
	constructor(
		private _router: Router,
		private _general: General
	){}

	canActivate(){
		let identity = this._general.getIdentity();
		if(identity && identity.role == 'ROLE_ADMIN')
			return true;
		else{
			this._router.navigate(['/page-redirect']);
			return false;
		}
	}

}