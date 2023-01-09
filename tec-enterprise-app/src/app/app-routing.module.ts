import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListEnterpriseComponent } from './components/enterprise/list-enterprise/list-enterprise.component';
import { FormEnterpriseComponent } from './components/enterprise/form-enterprise/form-enterprise.component';
import { FormEmployeeComponent } from './components/employee/form-employee/form-employee.component';
import { ListEmployeeComponent } from './components/employee/list-employee/list-employee.component';

const routes: Routes = [
    { path: '', redirectTo: '/enterprise', pathMatch: 'full' },
    { path: 'enterprise', component: ListEnterpriseComponent },
    { path: 'enterprise/form/:id', component:FormEnterpriseComponent},
    { path: 'enterprise/form', component: FormEnterpriseComponent },
    { path: 'employees', component: ListEmployeeComponent },
    { path: 'employees/form/:id', component: FormEmployeeComponent},
    { path: 'employees/form', component: FormEmployeeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
