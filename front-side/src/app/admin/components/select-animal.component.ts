import { Component, OnInit } from '@angular/core';
import { AnimalService } from '../../services/animal.service';
import { Animal } from '../../models/animal.model';
import { General } from '../../services/general';

@Component({
	selector: 'select-animal',
	templateUrl: '../views/select-animal.html',
	styleUrls: ['../admin-style.scss'],
	providers: [ AnimalService, General ]
})

export class SelectAnimalComponent {

	public animal: Animal;

	constructor(
		private _animalService: AnimalService,
		private _general: General
	){}

	ngOnInit(){
		this.getAnimals();
	}

	getAnimals(){
		this._animalService.getAnimals().subscribe(
			response => {
				this.animal = response.animals;
				console.log(this.animal)
			},
			error => console.log(<any>error)
		);
	}

	dropToggle(ev){
		this._general.dropToggle(ev);
	}

	editAnimal(){
		
	}

}