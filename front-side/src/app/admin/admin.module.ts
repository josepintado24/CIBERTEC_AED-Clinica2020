import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AdminComponent } from './admin.component';
import { ListDataComponent } from './components/list.component';
import { AddDataComponent } from './components/add.component';
import { EditDataComponent } from './components//edit.component';
import { ModalsAdminComponent } from './components/modals-admin.component';
import { SelectAnimalComponent } from './components/select-animal.component';

import { AdminRouting } from './admin.routing';
import { AdminGuards } from '../services/admin.guard';
import { General } from '../services/general';

@NgModule({
	declarations: [
		AdminComponent,
		ListDataComponent,
		AddDataComponent,
		EditDataComponent,
		ModalsAdminComponent,
		SelectAnimalComponent
	],
	imports: [
		CommonModule,
		FormsModule,
		HttpModule,
		AdminRouting
	],
	providers: [
		AdminGuards,
		General
	]
})

export class AdminModule {}