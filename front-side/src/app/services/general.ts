import { Injectable } from '@angular/core';

@Injectable()

export class General {
	public xModal: string;
	public identity;
	public token;

	constructor(){
		this.xModal = '.modal .modal-close';
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
		// var inputs = $('.user-modal input[type="text"], .user-modal input[type="password"]');
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
}