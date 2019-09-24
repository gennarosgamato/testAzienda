import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';

import { LinguaService } from 'src/app/Services/lingua.service';
import { Traduzioni } from './Traduzioni';
import { typeWithParameters } from '@angular/compiler/src/render3/util';
import { AuthenticationService } from './Services/authentication.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  home = "";
  iscrizione = "";
  accedi = "";
  prodotti = "";
  contatti = "";
  it = new Array();
  en = new Array();
  ch = new Array();
  private isButtonVisible = false;


  /**
   *Creates an instance of AppComponent.
   * @param {FormBuilder} formBuilder
   * @param {LinguaService} linguaService
   * @param {Router} router
   * @memberof AppComponent
   */
  constructor(private formBuilder: FormBuilder, private linguaService: LinguaService, private router: Router,public auth:AuthenticationService) { }


  ngOnInit() {
    var token=localStorage.getItem('token')
    if (token!==null){
      this.isButtonVisible=true;
    }

    this.home = "HOME";
    this.iscrizione = "VISUALIZZA TUTTI I CODICI FISCALI";
    this.accedi = "ACCEDI";
    this.prodotti = "PRODOTTI";
    this.contatti = "CONTATTI";
    for (var _i = 0; _i < 15; _i++) {
      if (_i < 1) {
        this.findTesto(1, "it");
      } else if (_i > 1 && _i < 3) {
        this.findTesto(1, "en");
      } else if (_i > 3 && _i < 5) {
        this.findTesto(1, "ch");
      }
    }
  }

  initLan() {
    var that = this;
    for (var i; i < 4; i++) {
      this.linguaService.getLinguaByLan("ch").subscribe(data => {
        console.log("first: " + JSON.stringify(data[2]));
        that.ch.push(data[i]);
      })
      this.linguaService.getLinguaByLan("it").subscribe(data => {
        console.log("first: " + JSON.stringify(data[2]));
        that.it.push(data[i]);
      })
      this.linguaService.getLinguaByLan("en").subscribe(data => {
        console.log("first: " + JSON.stringify(data[2]));
        that.en.push(data[i]);
      })
    }
  }

  /**
   *
   * Ricerca il testo da inserire sulla Navbar salvandoli in Array suddividendo il testo per lingua 
   * @param {number} id
   * @param {String} lingua
   * @memberof AppComponent
   */
  findTesto(id: number, lingua: String) {
    var that = this;
    this.linguaService.getLingua(id, lingua).subscribe(data => {

      if (data[0].lingua.toLowerCase() === "it") {
        that.it.push(data[0].testo)
      } else if (data[0].lingua.toLowerCase() === "en") {
        that.en.push(data[0].testo);
      } else {
        that.ch.push(data[0].testo);
      }
    })
    id++
    this.linguaService.getLingua(id, lingua).subscribe(data => {

      if (data[0].lingua.toLowerCase() === "it") {
        that.it.push(data[0].testo)
      } else if (data[0].lingua.toLowerCase() === "en") {
        that.en.push(data[0].testo);
      } else {
        that.ch.push(data[0].testo);
      }
    })
    id++
    this.linguaService.getLingua(id, lingua).subscribe(data => {

      if (data[0].lingua.toLowerCase() === "it") {
        that.it.push(data[0].testo)
      } else if (data[0].lingua.toLowerCase() === "en") {
        that.en.push(data[0].testo);
      } else {
        that.ch.push(data[0].testo);
      }
    })
    id++
    this.linguaService.getLingua(id, lingua).subscribe(data => {

      if (data[0].lingua.toLowerCase() === "it") {
        that.it.push(data[0].testo)
      } else if (data[0].lingua.toLowerCase() === "en") {
        that.en.push(data[0].testo);
      } else {
        that.ch.push(data[0].testo);
      }
    })
    id++
    this.linguaService.getLingua(id, lingua).subscribe(data => {

      if (data[0].lingua.toLowerCase() === "it") {
        that.it.push(data[0].testo)
      } else if (data[0].lingua.toLowerCase() === "en") {
        that.en.push(data[0].testo);
      } else {
        that.ch.push(data[0].testo);
      }
    })

  }


  /**
   *
   *Imposta i parametri da visualizzare sulla Navbar in Inglese
   * @memberof AppComponent
   */
  enLan() {

    this.home = this.en[0];
    this.iscrizione = this.en[1];
    this.accedi = this.en[2];
    this.prodotti = this.en[3];
    this.contatti = this.en[4];
    this.router.navigate;
  }


  /**
   *
   *Imposta i parametri da visualizzare sulla Navbar in Italiano
   * @memberof AppComponent
   */
  itLan() {

    this.home = this.it[0];
    this.iscrizione = this.it[1];
    this.accedi = this.it[2];
    this.prodotti = this.it[3];
    this.contatti = this.it[4];
    this.router.navigate;
  }


  /**
   *
   * Imposta i parametri da visualizzare sulla Navbar in Cinese
   * @memberof AppComponent
   */
  chLan() {

    this.home = this.ch[0];
    this.iscrizione = this.ch[1];
    this.accedi = this.ch[2];
    this.prodotti = this.ch[3];
    this.contatti = this.ch[4]
    this.router.navigate;
  }

  /**
 *
 *
 * @memberof AppComponent
 */
ViewAll(){
  this.router.navigate(["viewAll"]);
}

logout(){
this.auth.logout();
}

}
