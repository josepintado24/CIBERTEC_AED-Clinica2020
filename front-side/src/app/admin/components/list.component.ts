import { Component } from '@angular/core';

@Component({
	selector: 'list-data',
	templateUrl: '../views/list-data.html',
	styleUrls: ['../admin-style.scss']
})

export class ListDataComponent {
	public data;
	constructor(){
		this.data = new Array(8);
	}
}