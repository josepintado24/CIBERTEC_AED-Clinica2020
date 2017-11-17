import { Injectable } from '@angular/core';

@Injectable()

export class General {
	public xModal: string;
	public identity;
	public token;
	public url: string;

	constructor(){
		this.xModal = '.modal .modal-close';
		this.url = window.location.href;
	}

	prevent(ev){ ev.preventDefault(); }

	showAlertModal(){ $('#cancelUserUpdate').addClass('back-modal-active'); }
	closeAlertModal(){ $('#cancelUserUpdate').removeClass('back-modal-active'); }
	closeCornerModal() { $('#statusAdmin').fadeOut(); }

	headerWeb(){
		var localUrl = this.url.split("/");
		if(localUrl[3] == 'admin') $('#header-web').hide();
	}

	closeModal(){
		$(this.xModal).click((ev) => {
			var target = ev.target;
			$(target).parent('.modal').slideUp('fast');
		});
	}

	getIdentity(){
		let identity = JSON.parse(localStorage.getItem('identity'));
		if(identity != 'undefined')
			this.identity = identity;
		else
			this.identity = null;
		return this.identity;
	}

	getToken(){
		let token = localStorage.getItem('token');
		if(token != 'undefined')
			this.token = token;
		else
			this.token = null;
		return this.token;
	}

	focusInput(inputs){
		$.each(inputs, (index) => {
			$(inputs[index]).click((ev) => {
				var target = ev.target;
				$(target).siblings('.lblText').animate({opacity: 1}, 'fast')
					.parent().siblings().find('.lblText').animate({opacity: 0}, 'fast');
			});
			$(inputs[index]).after('<span class="ipt-correct fa fa-check"></span>')
				.after('<span class="ipt-error fa fa-times"></span>');
		});
		inputs.focusout(() => $('.lblText').animate({opacity: 0}, 'fast'));
	}

	dropToggle(ev){
		var target = ev.target;
		$(target).closest('.dropdown').find('.drop-list').slideToggle('fast');
	}

	getLetter(){
		if(this.getIdentity()){
			var firstLetter = this.getIdentity().name.charAt(0).toLowerCase();
			var lastLetter = this.getIdentity().surname.charAt(0).toLowerCase();
			return firstLetter + lastLetter;
		}
	}
}