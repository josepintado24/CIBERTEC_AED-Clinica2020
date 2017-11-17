import { Component, OnInit } from '@angular/core';
import { Animal } from '../../models/animal.model';
import { General } from '../../services/general';
import { AnimalService } from '../../services/animal.service';
import { UploadService } from '../../services/upload.service';
import { ConfigWeb } from '../../services/configWeb';

@Component({
	selector: 'add-data',
	templateUrl: '../views/add-edit-data.html',
	styleUrls: ['../admin-style.scss'],
	providers: [ General, AnimalService, UploadService ]
})

export class AddDataComponent implements OnInit {

	public title: string;
	public year;
	public animal: Animal;
	public user: string;
	public getYear: number;
	public identity;
	public token: string;
	public status: string;
	public fileName: string;
	public apiUrl: string;
	public filesToUpload: Array<File>;

	constructor(
		private _general: General,
		private _animalService: AnimalService,
		private _uploadService: UploadService
	){
		this.title = 'Agregar datos de animales';
		this.year = new Date();
		this.user = this._general.getIdentity().name;
		this.animal = new Animal('', this.user, '', 0, '', '');
		this.identity = this._general.getIdentity();
		this.token = this._general.getToken();
		this.apiUrl = ConfigWeb.apiUrl;
	}

	ngOnInit(){
		this.cboYear();
		this.nameFile();
	}

	cboYear(){
		var actualYear = this.year.getFullYear();
		for(var i = 0; i < 100; i++){
			var newYear = actualYear--;
			$('.drop-list').append('<li class="drop-item" data-value="' + newYear + '">' + newYear + '</li>');
		}
		$('.drop-toggle').click(() => $('.drop-list').slideToggle());
		$('.drop-item').click((ev) => {
			var target = ev.target;
			this.getYear = $(target).data('value');
			$('#year').val(this.getYear);
			$('.drop-list').slideUp();
			if(this.getYear == 0)
				$('#year').val('');
		});
	}

	saveAnimal(addForm){
		if(this.getYear)
			this.animal.year = this.getYear;

		this._animalService.saveAnimal(this.animal, this.token).subscribe(
			response => {
				if(this.animal.name){
					addForm.reset();
					$('.corner-modal').css('backgroundColor', 'rgba(83, 162, 83, 0.8)');
				}
				else 
					$('.corner-modal').css('backgroundColor', 'rgba(181, 51, 51, 0.8)');

				$('#statusAdmin').fadeIn();
				this.status = response.message;
				setTimeout(() => {
					$('#statusAdmin').fadeOut();
				}, 3500);
				this._uploadService.makeFileRequest(this.apiUrl + 'upload-image-animal/' + this.identity._id, [], this.filesToUpload, this.token, 'image')
					.then((result: any) => {
						this.identity.image = result.animal.image;
						localStorage.setItem('identity', JSON.stringify(this.identity));
					});
			},
			error => console.log(<any>error)
		);
	}

	nameFile(){
		$('.image-add button').click(() => $('#animal-image').trigger('click'));
		$('#animal-image').change(() => {
			var filePath = $('#animal-image').val();
			this.fileName = filePath.split('\\').pop();
		});
		$('.image-add').on('click', '.file-name i', () => {
			$('#animal-image').val('');
			this.fileName = $('#animal-image').val();
		});
	}

	fileChange(fileInput: any){
		this.filesToUpload = <Array<File>>fileInput.target.files;
		console.log(this.filesToUpload);
	}

}