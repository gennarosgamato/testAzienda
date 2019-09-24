import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Persona } from 'src/app/Persona';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

import { environment } from './../../environments/environment';
import { User } from '../User';

@Injectable({
  providedIn: 'root'
})

export class ViewAllFCService {
  
 constructor(private http:HttpClient, private router:Router) {}

 /**
 * Genera una lista di oggetti Persona attraverso un metodo asincrono.
 *
 * @author: Michele
 *
 * @param {}
 * @returns {Observable<Persona[]>} restituisce una lista di persona
 */
viewAll(): Observable<Persona[]> {
    return this.http.get<Persona[]>(environment.baseUrl + 'codfiscale');
  }
   
/**
 * Elimina un oggetto persona dal DB.
 *
 * @param {Persona} persona
 * @returns {}
 * @memberof ViewAllFCService
 */
delete(persona:Persona){
  const httpOptions = {
  headers: new HttpHeaders({
      'Content-Type': 'application/json'
  }),
  body: persona 
};
    return  this.http.delete(environment.baseUrl + '/delete',httpOptions);
} 

/**
 * Calcola il codice fiscale dell'oggetto persona.
 *
 * @param {*} postData
 * @returns {} ritorna il codice fiscale generato a partire dai dati anagrafici
 * @memberof ViewAllFCService
 */
calculateCF(postData) {
 const httpOptions = {
      headers: new HttpHeaders({
          'Content-Type': 'application/json',
              responseType: 'json',
        })
      };
        return this.http.post(
          environment.baseUrl + '/merge',
          postData,
          httpOptions
      )
  }

/**
 * Salva un nuovo oggetto persona sul DB.
 *
 * @param {*} postData
 * @returns {}
 * @memberof ViewAllFCService
 */
save(postData){
  return this.http.post(environment.baseUrl + '/codfiscale', postData)
}

/**
 * Ricerca un oggetto persona in base all'id.
 *
 * @param {number} idp
 * @returns restituisce una lista di oggetti persona filtrata per id.
 * @memberof ViewAllFCService
 */
findById(idp:number){
  return this.http.get(environment.baseUrl + '/personaById'+'/'+idp);
 }

/**
 * Modifica un oggetto persona già esistente all'interno del DB.
 *
 * @param {Persona} persona
 * @returns {} 
 * @memberof ViewAllFCService
 */
update(persona:Persona){
  return this.http.put(environment.baseUrl + '/update', persona);
 }

}