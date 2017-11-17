import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Animal } from '../../models/animal.model';
import { AnimalService } from '../../services/animal.service';

@Component({
	selector: 'edit-data',
	templateUrl: '../views/add-edit-data.html',
	styleUrls: ['../admin-style.scss'],
	providers: [ AnimalService ]
})

export class EditDataComponent implements OnInit {

	public title: string;
	public animal: Animal;

	constructor(
		private _animalService: AnimalService,
		private _router: Router,
		private _route: ActivatedRoute
	){
		this.title = 'Editar datos de animales';
		this.getAnimals();
	}

	ngOnInit(){
		this.animal = new Animal('', '', '', 0, '', '');
	}

	getAnimals(){
		this._route.params.forEach((params: Params) => {
			let id = params['id'];
			this._animalService.getAnimal(id).subscribe(
				response => {
					this.animal = response.animal;
				},
				error => console.log(<any>error),
				() => {
					$('#year').val(this.animal.year);
				}
			);
		});
	}

}