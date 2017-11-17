import { Component, OnInit, DoCheck } from '@angular/core';
import { UserService } from '../services/user.service';
import { General } from '../services/general';
import { User } from '../models/user.model';
import { ConfigWeb } from '../services/configWeb';
import { UploadService } from '../services/upload.service';

@Component({
	selector: 'profile',
	templateUrl: '../views/profile.html',
	providers: [ UserService, General, UploadService ]
})

export class ProfileComponent implements OnInit, DoCheck {
	public loguedUser;
	public resources;
	public filename: string;
	public userEdit: boolean;
	public user: User;
	public token;
	public apiUrl: string;
	public filesToUpload: Array<File>;
	public avatarEdit: boolean;
	public dbImages: string;

	constructor(
		private _general: General,
		private _userService: UserService,
		private _uploadService: UploadService
	){
		this.loguedUser = this._general.getIdentity();
		this.token = this._general.getToken();
		this.resources = ConfigWeb.resourcesImages;
		this.userEdit = false;
		this.avatarEdit = false;
		this.user = new User('', '', '', '', '', 'ROLE_USER', '', '');
		this.apiUrl = ConfigWeb.apiUrl;
		this.dbImages = ConfigWeb.dbImages;
	}

	ngOnInit(){
		this._general.focusInput($('#form-edit-profile input[type="text"], #form-edit-profile input[type="password"]'));
		this.user = this.loguedUser;
	}

	ngDoCheck(){
		this.validateInput();
		this.getGenero();
	}

	showEdit(){
		var topEdit = $('.body-profile').offset().top;
		$('html, body').animate({scrollTop: topEdit - 50});
		var inputs = $('#form-edit-profile').find('input[type="text"]:not(#edit-gender)');
		inputs.removeAttr('readonly').css({
			borderBottom: '2px solid #53a253'
		});
		$('#edit-gender').css({
			borderBottom: '2px solid #53a253',
			cursor: 'pointer'
		});
		this.userEdit = true;
		$('#form-edit-profile .ipt-correct, #form-edit-profile .ipt-error').css('display', 'inline-block');
		$('#form-edit-profile').find('.fa, .drop-list').css('display', 'block');
	}

	updateProfile(){
		this._userService.updateUser(this.user).subscribe(
			response => {
				localStorage.setItem('identity', JSON.stringify(this.user));
				location.reload();
			},
			error => console.log(<any>error)
		);
	}

	refreshUser(ev){
		this.user = ev.loguedUser;
		this._general.closeAlertModal();
		var inputs = $('#form-edit-profile').find('input[type="text"]:not(#edit-gender)');
		inputs.attr('readonly', true).css('borderColor', 'transparent');
		$('#edit-gender').css('borderColor', 'transparent');
		$('#edit-drop-gender').find('.fa, .drop-list').hide();
		$('#edit-gender').css('cursor', 'default');
	}

	refreshUserEdit(ev){
		this.userEdit = ev.refreshUserEdit;
	}

	selectAvatar(){
		var iptAvatar = $('#avatar-user');
		iptAvatar.trigger('click');
	}

	fileChange(fileInput: any){
		this.filesToUpload = <Array<File>>fileInput.target.files;
		if(this.filesToUpload) this.avatarEdit = true;
		console.log(this.filesToUpload);
	}

	submitChangeAvatar(){
		this._uploadService.makeFileRequest(this.apiUrl + 'upload-avatar-user/' + this.user._id, [], this.filesToUpload, this.token, 'image')
			.then((result: any) => {
				this.user.image = result.user.image;
				localStorage.setItem('identity', JSON.stringify(this.user));
				location.reload();
			});
		this.avatarEdit = false;
	}

	validateInput(){
		var inputs = '#form-edit-profile input[data-validate=';
		var iptValid = $(inputs + '"true"]').length;
		var iptInvalid = $(inputs + '"false"]').length;
		var btnSubmit = $('#updateUserSubmit');

		if(iptInvalid == 0)
			$(btnSubmit).removeAttr('disabled');
		else
			$(btnSubmit).attr('disabled', true);
	}

	showAlertModal(){ this._general.showAlertModal(); }

	dropToggle(ev){
		this._general.dropToggle(ev);
	}

	getGenero(){
		var iptGenero = $('#edit-gender').val();
		$('#edit-drop-gender .drop-item').click((ev) => {
			var target = ev.target;
			var gender = $(target).text();
			$('#edit-gender').val(gender);
			$('#edit-drop-gender .drop-list').slideUp();
			this.user.gender = gender;
		});
	}
}