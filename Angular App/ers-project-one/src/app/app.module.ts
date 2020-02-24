import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpHeaderComponent } from './components/emp-header/emp-header.component';
import { LoginComponent } from './components/content/login/login.component';
import { EmployeeViewComponent } from './components/content/employee-view/employee-view.component';
import { ManagerViewComponent } from './components/content/manager-view/manager-view.component';
import { ErsRequestsComponent } from './components/content/ers-requests/ers-requests.component';

@NgModule({
  declarations: [
    AppComponent,
    EmpHeaderComponent,
    LoginComponent,
    EmployeeViewComponent,
    ManagerViewComponent,
    ErsRequestsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
