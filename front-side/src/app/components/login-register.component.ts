import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { ConfigWeb } from '../services/configWeb';
import { User } from '../models/user.model';
import { UserService } from '../services/user.service';
import { General } from '../services/general';

@Component({
	selector: 'login-register',
	templateUrl: '../views/login-register.html',
	providers: [ UserService, General ]
})

export class LoginRegisterComponent implements OnInit {
	public resources: string;
	public title: string;
	public subtitle: string;
	public description: string;
	public nameRegex: any;
	public passRegex: any;
	public emailRegex: any;
	public userRemember: any;
	public loginUser: string;
	public localLoginUser: any;
	public user: User;
	public statusRegister: boolean;
	public message: string;
	public identity;
	public token;
	public statusLogin;

	constructor(
		private _userService: UserService,
		private _route: ActivatedRoute,
		private _router: Router,
		private _general: General
	){
		this.resources = ConfigWeb.resourcesImages;
		this.title = 'Login';
		this.subtitle = 'Inicia sesión como usuario frecuente';
		this.description = 'Inicia sesión para que puedas tener una visita más personalizada en Zoo, dejarnos tus comentarios sobre tu experiencia y compartirlo con los demás usuarios.'
		this.nameRegex = /^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]{2,30}$/i;
		this.passRegex = /^[-\w.+]{6,24}$/;
		this.emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
		this.user = new User('', '', '', '', '', 'ROLE_USER', '');
		this.statusRegister = false;
		this.message = '.modal';
	}
	ngOnInit(){
		$(document).ready(() => this.init());
		this.loginOrRegister();
		this.remember();
	}

	init(){
		var ob = this;
		var functions = function(){
			ob.userModal();
			ob.modalHeight();
			ob.loginOrRegister();
			ob._general.focusInput($('.modal-user input[type="text"], .modal-user input[type="password"]'))
			ob.validateInput();
			ob.remember();
			ob._general.closeModal();
		}
		window.setTimeout(functions, 1);
	}

	registerSubmit(registerForm){
		this._userService.register(this.user).subscribe(
			response => {
				if(response.user && response.user._id){
					console.log('Registro correcto');
					this.statusRegister = true;
					$('.log-reg-messages').css('backgroundColor', 'rgba(83, 162, 83, 0.7)');
					registerForm.reset();
					$('.ipt-error, .ipt-correct').css({right: '-20px', opacity: '0'});
					$('.iptConfirmPass').val('');
				}
				else{
					console.log('Error en el registro');
					this.statusRegister = false;
					$('.log-reg-messages').css('backgroundColor', 'rgba(181, 51, 51, 0.7)');
				}
				$(this.message).slideDown('fast');
			},
			error => console.log(<any>error)
		);
	}

	loginSubmit(loginForm){
		this._userService.login(this.user).subscribe(
			response => {
				this.identity = response.user;
				if(!this.identity || !this.identity._id){
					console.log('Error al iniciar sesión');
				}
				else {
					localStorage.setItem('identity', JSON.stringify(this.identity));
					this.identity.password = '';
					this._userService.login(this.user, 'true').subscribe(
						response => {
							this.token = response.token;
							if(!this.token)
								console.log('No se ha generado el token');
							else {
								localStorage.setItem('token', this.token);
								loginForm.reset();
								$('.ipt-error, .ipt-correct').css({right: '-20px', opacity: '0'});
								$(this.message).slideUp('fast');
								location.reload();
							}
						},
						error => console.log(error)
					);
				}
			},
			error => {
				if(<any>error != null) {
					var bodyErr = JSON.parse(error._body);
					this.statusLogin = bodyErr.message;
					$(this.message).slideDown('fast');
				}
			}
		);
	}

	loginHere(){
		$('.log-reg-messages a').click(() => $('.nav-login').trigger('click'));
	}

	remember(){
		$('#remember').click(() => {
			if($('#remember').is(':checked'))
				this.userRemember = localStorage.setItem('loginUser', $('#user').val());
			else 
				localStorage.removeItem('loginUser');
		});
		this.localLoginUser = localStorage.getItem('loginUser');
		if(this.localLoginUser)
			$('#remember').attr('checked', true);
	}

	validateInput(){
		var iptText = $('.iptText');
		var iptEmail = $('.iptEmail');
		var iptPass = $('.iptPass');
		var getInputsRegister = $('#register-form input[type="text"], #register-form input[type="password"]');
		var registerInputs = '#register-form input[data-validate=';
		var getInputsLogin = $('#login-form input[type="text"], #login-form input[type="password"]');
		var loginInputs = '#login-form input[data-validate=';

		var validate = function(input, regex){
			input.focusout((ev) => {
				var target = ev.target;
				if(regex.test($(target).val())){
					$(target).siblings('.ipt-correct').animate({opacity: 1, right: 0}, 'fast');
					$(target).siblings('.ipt-error').animate({opacity: 0, right: '-20px'}, 'fast');
					$(target).attr('data-validate', 'true');
				}
				else {
					$(target).siblings('.ipt-error').animate({opacity: 1, right: 0}, 'fast');
					$(target).siblings('.ipt-correct').animate({opacity: 0, right: '-20px'}, 'fast');
					$(target).attr('data-validate', 'false');
				}
			});
		}
		validate(iptText, this.nameRegex);
		validate(iptEmail, this.emailRegex);
		validate(iptPass, this.passRegex);

		$('.iptConfirmPass').focusout(() => {
			if($('.iptConfirmPass').val() != $('#register-form .iptPass').val() || $('.iptConfirmPass').val() == ''){
				$('.iptConfirmPass').siblings('.ipt-error').animate({opacity: 1, right: 0}, 'fast');
				$('.iptConfirmPass').siblings('.ipt-correct').animate({opacity: 0, right: '-20px'}, 'fast');
				$('.iptConfirmPass').attr('data-validate', 'false');
			}
			else{
				$('.iptConfirmPass').siblings('.ipt-correct').animate({opacity: 1, right: 0}, 'fast');
				$('.iptConfirmPass').siblings('.ipt-error').animate({opacity: 0, right: '-20px'}, 'fast');
				$('.iptConfirmPass').attr('data-validate', 'true');
			}
		});

		var finalValidate = function(inputFocus, input, btnSubmit){
			inputFocus.focusout(() => {
				var iptValid = $(input + '"true"]').length;
				var iptInvalid = $(input + '"false"]').length;

				if(iptInvalid == 0)
					$(btnSubmit).removeAttr('disabled');
				else
					$(btnSubmit).attr('disabled', true);
			});
		}

		finalValidate(getInputsRegister, registerInputs, '#register-submit');
		finalValidate(getInputsLogin, loginInputs, '#login-submit');
	}

	modalHeight(){
		var loginFormHeight = $('#login-form').height();
		var registerFormHeight = $('#register-form').height();
		var forgotFormHeight = $('#forgot-form').height();
		$('.forms').css('height', loginFormHeight + 'px');

		if($('.nav-login').hasClass('nav-active')){
			$('.forms').css('height', loginFormHeight + 'px');
		}
		else if($('.nav-register').hasClass('nav-active')){
			$('.forms').css('height', registerFormHeight + 'px');
		}
		else if($('.nav-forgot').hasClass('nav-active')){
			$('.forms').css('height', forgotFormHeight + 'px');
		}
		
		var modalHeight = $('.modal-user').height();
		$('.modal-user').css('top', 'calc(50% - ' + modalHeight/2 +'px)');

		if($('.modal-user').height() > window.innerHeight) $('.modal-user').css('top', 0);
	}

	loginOrRegister(){
		$('.forgot').click(() => $('.nav-forgot').click());
		$('.user-nav a').click((ev) => {
			ev.preventDefault();
			var target = ev.target;
			if(!$(target).is('.nav-active')){
				$(target).addClass('nav-active').siblings('a').removeClass('nav-active');
			}
			if($('.nav-login').hasClass('nav-active')){
				$('#register-form, #forgot-form').fadeOut();
				$('#login-form').fadeIn();
				this.title = 'Login';
				this.subtitle = 'Inicia sesión como usuario frecuente';
				this.description = 'Inicia sesión para que puedas tener una visita más personalizada en Zoo, dejarnos tus comentarios sobre tu experiencia y compartirlo con los demás usuarios.'
			}
			else if($('.nav-register').hasClass('nav-active')){
				$('#login-form, #forgot-form').fadeOut();
				$('#register-form').fadeIn().removeClass('hidden');
				this.title = 'Registro';
				this.subtitle = 'Empieza a compartir con nosotros';
				this.description = 'Registrate para comenzar una nueva experiencia en Zoo, serás uno de los primeros en saber sobre noticias nuevas, visitas, eventos y cualquier novedad. ¡Bienvenido!'
			}
			else if($('.nav-forgot').hasClass('nav-active')){
				$('#login-form, #register-form').fadeOut();
				$('#forgot-form').fadeIn().removeClass('hidden');
				this.title = 'Nuevo inicio';
				this.subtitle = 'Recuperar contraseña';
				this.description = 'La mente es frágil y puedes olvidarte. Por suerte nosotros podemos ayudarte a recuperar tu contraseña y seguir compartiendo y disfrutando con nosotros.'
			}
			this.modalHeight();
		});
	}

	userModal(){
		$('#show-login').click((ev) => {
			ev.preventDefault();
			$('#usuario').css({
				transform: 'translateY(0)',
				opacity: 1
			});
			$('header, home > *').css('filter', 'blur(3px)');
		});
		$('.close-modal').click(() => {
			$('header, home > *').css('filter', 'none');
			$('#usuario').css({
				transform: 'translateY(-200%)',
				opacity: 0
			});
			$('.ipt-error, .ipt-correct').animate({
				opacity: 0,
				right: '-20px'
			});
		});
	}
}