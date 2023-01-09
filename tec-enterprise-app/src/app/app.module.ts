import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

//Servicios
import { EnterpriseService} from './services/enterprise.service';
import { EmployeeService} from './services/employee.service';
//componentes
import { ListEnterpriseComponent } from './components/enterprise/list-enterprise/list-enterprise.component';
import { FormEnterpriseComponent } from './components/enterprise/form-enterprise/form-enterprise.component';
import { ListEmployeeComponent } from './components/employee/list-employee/list-employee.component';
import { FormEmployeeComponent } from './components/employee/form-employee/form-employee.component';
import { ListDepartmentComponent } from './components/department/list-department/list-department.component';
import { FormDepartmentComponent } from './components/department/form-department/form-department.component';

@NgModule({
  declarations: [
    AppComponent,
    ListEnterpriseComponent,
    FormEnterpriseComponent,
    ListEmployeeComponent,
    FormEmployeeComponent,
    ListDepartmentComponent,
    FormDepartmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [EnterpriseService, EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
