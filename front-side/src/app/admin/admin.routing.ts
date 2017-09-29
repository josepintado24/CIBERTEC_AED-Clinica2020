import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AdminComponent } from './admin.component';
import { ListDataComponent } from './components/list.component';
import { AddDataComponent } from './components/add.component';
import { EditDataComponent } from './components//edit.component';

const adminRoutes: Routes = [
	{
		path: 'admin',
		component: AdminComponent,
		children: [
			{ path: 'list-data', component: ListDataComponent },
			{ path: 'add-data', component: AddDataComponent },
			{ path: 'edit-data', component: EditDataComponent }
		]
	}
];

@NgModule({
	imports: [ RouterModule.forChild(adminRoutes) ],
	exports: [ RouterModule ]
})

export class AdminRouting {}