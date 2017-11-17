import { Component, OnInit, Input } from '@angular/core';
import { General } from '../../services/general';

@Component({
	selector: 'modals-admin',
	templateUrl: '../views/modals-admin.html',
	styleUrls: ['../admin-style.scss'],
	providers: [ General ]
})

export class ModalsAdminComponent {

	@Input() status: string;

	constructor(private _general: General){}

	closeModal(){ this._general.closeCornerModal(); }

}