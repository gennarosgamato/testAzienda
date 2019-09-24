import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders, HttpResponse } from '@angular/common/http';
import { BehaviorSubject, Observable, config } from 'rxjs';


import { User } from 'src/app/User';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    params = new HttpParams()
    .set('username', '')
    .set('password', '');

    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient, private router:Router) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(user:User) {
      var u="{\"userDTO\":"+JSON.stringify(user)+"}";
      console.log(u);
        const httpOptions = {
            headers: new HttpHeaders({ 'Content-Type': 'application/json'}),
            observe: 'response' as 'response'
          }; 
        var link = environment.baseUrl+`/api/authenticate?username=${user._username}&password=${user._password}`;

          this.http.post(link,undefined,httpOptions).subscribe((res: HttpResponse<any>) => {
            localStorage.setItem('token',res.headers.get('Authorization'));
            location.replace("/");
          })
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('token');
        this.currentUserSubject.next(null);
        location.replace("/");
    }

    getToken(): string {
        return localStorage.getItem('token');
      }
}