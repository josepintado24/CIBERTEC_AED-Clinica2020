import { Component, OnInit } from '@angular/core';

@Component({
	selector: 'add-data',
	templateUrl: '../views/add-data.html',
	styleUrls: ['../admin-style.scss']
})

export class AddDataComponent implements OnInit {
	public year;
	constructor(){
		this.year = new Date();
	}

	ngOnInit(){
		this.cboYear();
	}

	cboYear(){
		var actualYear = this.year.getFullYear();
		for(var i = 0; i < 100; i++){
			var newYear = actualYear--;
			$('.drop-list').append('<li _ngcontent-c1 class="drop-item" data-value="' + newYear + '">' + newYear + '</li>');
		}
		$('.drop-toggle').click(() => $('.drop-list').slideToggle());
		$('.drop-item').click((ev) => {
			var target = ev.target;
			var data = $(target).data('value');
			$('.drop-toggle span').text(data);
			$('.drop-list').slideUp();
		});
	}
}