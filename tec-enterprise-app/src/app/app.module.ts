import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListEnterpriseComponent } from './components/enterprise/list-enterprise/list-enterprise.component';
import { EnterpriseService} from './services/enterprise.service';
import { FormEnterpriseComponent } from './components/enterprise/form-enterprise/form-enterprise.component';

@NgModule({
  declarations: [
    AppComponent,
    ListEnterpriseComponent,
    FormEnterpriseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [EnterpriseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
