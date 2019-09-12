import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';
import { Traduzioni } from 'src/app/Traduzioni';

@Injectable({
  providedIn: 'root'
})
export class LinguaService {

  constructor(private http: HttpClient, private router: Router) { }


  /**
   *
   * Interroga il Backend richiamando il metodo di ricerca degli elementi di tutte le lingue presenti sul DB, per poi inserirle nella Navbar
   * @param {number} id
   * @param {String} lingua
   * @returns
   * @memberof LinguaService
   */
  getLingua(id: number, lingua: String) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        responseType: 'json',
      }),
    };
    return this.http.get(environment.baseUrl + 'translate/' + id + '/' + lingua)
  }

  getLinguaByLan(lingua: String) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        responseType: 'json',
      }),
    };
    return this.http.get(environment.baseUrl + 'translate/'+ lingua)
  }

}