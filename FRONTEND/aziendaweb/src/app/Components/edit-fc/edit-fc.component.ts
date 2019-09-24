import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ViewAllFCService } from 'src/app/Services/view-all-fc.service';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { Persona } from 'src/app/Persona';
declare var per: Persona;
declare var CodiceFiscale: any;

/**
 *
 *
 * @export
 * @class EditFCComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'app-edit-fc',
  templateUrl: './edit-fc.component.html',
  styleUrls: ['./edit-fc.component.css']
})



export class EditFCComponent implements OnInit {
   myGroup: FormGroup;
   persona: Persona;
   codFiscale = new FormControl('');
   cfCheck = true;
   cfConnection = true;


/**
 *Creates an instance of EditFCComponent.
 * Inizializza i campi della form di edit.
 * 
 * @param {FormBuilder} formBuilder
 * @param {Router} router
 * @param {ViewAllFCService} viewAllService
 * @memberof EditFCComponent
 */
constructor(private formBuilder: FormBuilder,private router:Router,private viewAllService:ViewAllFCService) {
  this.myGroup = this.formBuilder.group({
    idp:this.ptemp.idp,
    name:this.ptemp.name,
    lastname: this.ptemp.lastname,
    date: this.ptemp.date,
    city: this.ptemp.city,
    gender: this.ptemp.gender,
    codFiscale: this.ptemp.cod_fiscale
  });
} 
ptemp = new Persona();

/**
 * Precarica i dati dell'oggetto persona selezionata 
 * all'interno dei campi della form. 
 *
 * @memberof EditFCComponent
 */
ngOnInit() {  
    let id = localStorage.getItem('idp');
    var that = this;

    this.viewAllService.findById(+id).subscribe(
      data=>{
        that.ptemp=data[0];
               
        this.myGroup = this.formBuilder.group({
          idp:this.ptemp.idp,
          name:this.ptemp.name,
          lastname: this.ptemp.lastname,
          date: this.ptemp.date,
          city: this.ptemp.city,
          gender: this.ptemp.gender,
          codFiscale: this.ptemp.cod_fiscale
        });
    });
    
}


/**
 * Ricalcola il codice fiscale in base ai nuovi dati inseriti
 * nella form di edit.
 *
 * @memberof EditFCComponent
 */
calcolaCF() {
  let date = this.myGroup.value.date.match(/^\s*(\d+).(\d+).(\d+)/);
  let generality = {
      name: this.myGroup.value.name,
      lastname: this.myGroup.value.lastname,
      day: date[3],
      month: date[2],
      year: date[1],
      isMale: (this.myGroup.value.gender == "M"),
      city: this.myGroup.value.city
  };
  let CF = CodiceFiscale(generality).taxCode();
  this.myGroup.value.codFiscale = CF;
  this.codFiscale.setValue(CF);
  let send = JSON.stringify(this.myGroup.value);
  
  var that = this;
  this.viewAllService.calculateCF(this.myGroup.value).subscribe(
      responseData => {
          console.log("Risposta:" + responseData);
          },
      err => {
          that.cfConnection = false;
          console.error('Problemi di connessione: ' + err)
      },
      () => console.log('Comunque termino')
   )
 }

 /**
 * Richiama il service per effetture l'update dell'oggetto 
 * persona con i nuovi dati provenienti dall form di edit.
 * Successivamente aggiorna la pagina.
 *  
 *
 * @param {*} event
 * @memberof EditFCComponent
 */
Save(event){
  this.viewAllService.update(this.myGroup.value).subscribe(res=>{})
  location.replace("viewAll");
}
}
