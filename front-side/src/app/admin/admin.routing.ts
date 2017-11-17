import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AdminComponent } from './admin.component';
import { ListDataComponent } from './components/list.component';
import { AddDataComponent } from './components/add.component';
import { EditDataComponent } from './components/edit.component';
import { SelectAnimalComponent } from './components/select-animal.component';

import { AdminGuards } from '../services/admin.guard';

const adminRoutes: Routes = [
	{
		path: 'admin',
		component: AdminComponent,
		canActivate: [ AdminGuards ],
		children: [
			{ path: 'list-data', component: ListDataComponent },
			{ path: 'add-data', component: AddDataComponent },
			{ path: 'select-animal', component: SelectAnimalComponent },
			{ path: 'edit-data/:id', component: EditDataComponent }
		]
	}
];

@NgModule({
	imports: [ RouterModule.forChild(adminRoutes) ],
	exports: [ RouterModule ]
})

export class AdminRouting {}