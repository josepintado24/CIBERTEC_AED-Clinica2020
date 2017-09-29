import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AdminComponent } from './admin.component';
import { ListDataComponent } from './components/list.component';
import { AddDataComponent } from './components/add.component';
import { EditDataComponent } from './components//edit.component';

import { AdminRouting } from './admin.routing';

@NgModule({
	declarations: [
		AdminComponent,
		ListDataComponent,
		AddDataComponent,
		EditDataComponent
	],
	imports: [
		CommonModule,
		FormsModule,
		HttpModule,
		AdminRouting
	],
	providers: []
})

export class AdminModule {}