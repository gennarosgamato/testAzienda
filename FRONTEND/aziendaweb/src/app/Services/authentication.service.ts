import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders, HttpResponse } from '@angular/common/http';
import { BehaviorSubject, Observable, config } from 'rxjs';
import { map } from 'rxjs/operators';

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

    login(username: string, password: string) {
        const httpOptions = {
            headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
            observe: 'response' as 'response'
          };
          
        var link = environment.baseUrl+"/api/authenticate?username="+username+"&password="+password;

          this.http.post(link,undefined,httpOptions).subscribe((res: HttpResponse<any>) => {
            localStorage.setItem('token',res.headers.get('Authorization'));
          })
    }

    logout() {
        // remove user from local storage to log user out
        
        localStorage.removeItem('Authorization');
        this.currentUserSubject.next(null);
        this.router.navigate(['/']);
    }

    getToken(): string {
        return localStorage.getItem('token');
      }
}