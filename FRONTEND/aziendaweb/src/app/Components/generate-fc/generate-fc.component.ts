import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder } from '@angular/forms';
import { ViewAllFCService } from 'src/app/Services/view-all-fc.service';
import { ControlContainer, NgForm } from '@angular/forms';
import { Persona } from 'src/app/Persona';
import { Router } from '@angular/router';

declare var CodiceFiscale: any;
declare var p:Persona;


/**
 *
 *
 * @export
 * @class GenerateFCComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'app-generate-fc',
  templateUrl: './generate-fc.component.html',
  styleUrls: ['./generate-fc.component.css'],
  viewProviders: [{ provide: ControlContainer, useExisting: NgForm}]
})

export class GenerateFCComponent implements OnInit {
    
    form: FormGroup;
    codFiscale = new FormControl('');
    cfCheck = true;
    cfConnection = true;
    persona: Object;
    

      
/**
 *Creates an instance of GenerateFCComponent.
 * @param {FormBuilder} formBuilder
 * @param {ViewAllFCService} viewAllService
 * @param {Router} router
 * @memberof GenerateFCComponent
 */
constructor(private formBuilder: FormBuilder,
private viewAllService: ViewAllFCService, private router:Router) {

    this.form = this.formBuilder.group({
    name: '',
    lastname: '',
    date: '',
    city: '',
    gender: '',
    codFiscale: ''
});
}       


/**
 *
 *
 * @memberof GenerateFCComponent
 */
ngOnInit() {

}


/**
 * Genera il codice fiscale in base ai dati anagrafici.
 *
 * @memberof GenerateFCComponent
 */
calcolaCF() {
  let date = this.form.value.date.match(/^\s*(\d+).(\d+).(\d+)/);
  let generality = {
        name: this.form.value.name,
        lastname: this.form.value.lastname,
        day: date[3],
        month: date[2],
        year: date[1],
        isMale: (this.form.value.gender == "M"),
        city: this.form.value.city
    };
   
   let CF = CodiceFiscale(generality).taxCode();
        this.form.value.codFiscale = CF;
        this.codFiscale.setValue(CF);
        let send = JSON.stringify(this.form.value);
        
        this.viewAllService.calculateCF(this.form.value).subscribe(
            responseData => {
                console.log("Risposta:" + responseData);
                },
            err => {
                this.cfConnection = false;
                console.error('Problemi di connessione: ' + err)
            },
            () => console.log('Comunque termino'))
    }
   

/**
 * Salva l'oggetto persona e relativo codice fiscale sul DB.
 *
 * @param {*} event
 * @memberof GenerateFCComponent
 */
Save(event){
    let date = this.form.value.date.match(/^\s*(\d+).(\d+).(\d+)/);
    let generality = {
        name: this.form.value.name,
        lastname: this.form.value.lastname,
        day: date[3],
        month: date[2],
        year: date[1],
        isMale: (this.form.value.gender == "M"),
        city: this.form.value.city
    };
    let CF = CodiceFiscale(generality).taxCode();
        this.form.value.codFiscale = CF;
        this.codFiscale.setValue(CF);
        console.log("Risposta:" + JSON.stringify(this.form.value)); 
        console.log(CodiceFiscale(generality).taxCode());
        
        alert ("Sto salvando questa Persona");
        this.viewAllService.save(this.form.value).subscribe(data =>{
            console.log("Risposta:" + JSON.stringify(data));
         })

         this.router.navigate(["viewAll"]);
       }   
}