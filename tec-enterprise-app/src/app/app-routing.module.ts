import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListEnterpriseComponent } from './components/enterprise/list-enterprise/list-enterprise.component';
import { FormEnterpriseComponent } from './components/enterprise/form-enterprise/form-enterprise.component';


const routes: Routes = [
    { path: '', redirectTo: '/enterprise', pathMatch: 'full' },
    { path: 'enterprise', component: ListEnterpriseComponent },
    {path: 'enterprise/form/:id', component:FormEnterpriseComponent},
    { path: 'enterprise/form', component: FormEnterpriseComponent },
    
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
