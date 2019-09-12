import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { ViewAllFCService } from './Services/view-all-fc.service';
import { ViewAllService } from './Services/view-all.service';
import { GenerateService } from './Services/generate.service';

import { AppComponent } from './app.component';
import { AddFCComponent } from './Components/add-fc/add-fc.component';
import { DeleteFCComponent } from './Components/delete-fc/delete-fc.component';
import { EditFCComponent } from './Components/edit-fc/edit-fc.component';
import { GenerateFCComponent } from './Components/generate-fc/generate-fc.component';
import { ViewAllFCComponent } from './Components/view-all-fc/view-all-fc.component';
import { LinguaService } from './Services/lingua.service';
import { LoginComponent } from './Components/login/login.component';
import { UserService } from './Services/user.service';
import { AuthenticationService } from './Services/authentication.service';
import { AlertService } from './Services/alert.service';
import { ViewAllEmployeeComponent } from './Components/view-all-employee/view-all-employee.component';
import { ViewAllEmployeeService } from './Services/view-all-employee.service';
// { TokenInterceptor } from './Interceptor/TokenInterceptor';


const routes: Routes = [
  {path: 'generate', component:GenerateFCComponent},
  {path: 'viewAll', component:ViewAllFCComponent},
  {path: 'delete', component:DeleteFCComponent},
  {path: 'save', component:AddFCComponent},
  {path: 'edit', component:EditFCComponent},
  {path: 'login', component:LoginComponent},
  {path: 'viewallempl', component:ViewAllEmployeeComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    AddFCComponent,
    DeleteFCComponent,
    EditFCComponent,
    GenerateFCComponent,
    ViewAllFCComponent,
    LoginComponent,
    ViewAllEmployeeComponent
  ],

  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes)
  ],

  providers: [
    ViewAllFCService,
    ViewAllService,
    GenerateService,
    LinguaService,
    UserService,
    AuthenticationService,
    AlertService,
    ViewAllEmployeeService
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: TokenInterceptor,
    //   multi: true
    // }
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
