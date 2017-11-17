import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home.component';
import { LoginRegisterComponent } from './components/login-register.component';
import { ProfileComponent } from './components/profile.component';
import { ModalsComponent } from './components/modals.component';
import { PageRedirectComponent } from './components/page-redirect.component';

import { routing, appRoutingProviders } from './app.routing';
import { AdminModule } from './admin/admin.module';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginRegisterComponent,
    ProfileComponent,
    ModalsComponent,
    PageRedirectComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    AdminModule
  ],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
