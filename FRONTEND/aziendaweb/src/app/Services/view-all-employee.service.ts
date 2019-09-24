import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../Employee';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { User } from '../User';


@Injectable({
  providedIn: 'root'
})
export class ViewAllEmployeeService {
  user:string;
  constructor(router:Router,private http:HttpClient,public auth: AuthenticationService) { 
  }

  viewAll(t:string): Observable<Employee[]> {
   this.user = localStorage.getItem('currentUser');
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: 'Bearer '+localStorage.getItem('token')
      })
    };
    return this.http.get<Employee[]>(environment.baseUrl + '/dipendenti', httpOptions);
  }
}
