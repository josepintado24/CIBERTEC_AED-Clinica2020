import { Component, Input, Output, EventEmitter } from '@angular/core';
import { General } from '../services/general';
import { User } from '../models/user.model';

@Component({
	selector: 'modals',
	templateUrl: '../views/modals.html',
	providers: [ General ]
})

export class ModalsComponent {

	@Input() user: User;
	@Output() refreshUser = new EventEmitter();
	@Output() refreshUserEdit = new EventEmitter();
	public loguedUser;

	constructor(private _general: General){
		this.loguedUser = this._general.getIdentity();
	}

	closeAlertModal() { this._general.closeAlertModal(); }
	cancelUpdateUser() {
		this.refreshUser.emit({'loguedUser': this.loguedUser});
		this.refreshUserEdit.emit({'refreshUserEdit': false});
	}

}