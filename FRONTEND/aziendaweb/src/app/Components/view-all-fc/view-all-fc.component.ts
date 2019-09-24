import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ViewAllFCService } from 'src/app/Services/view-all-fc.service';
import { Persona } from 'src/app/Persona';



/**
 *
 *
 * @export
 * @class ViewAllFCComponent
 * @implements {OnInit}
 */
@Component({
  selector: 'app-view-all-fc',
  templateUrl: './view-all-fc.component.html',
  styleUrls: ['./view-all-fc.component.css']
})

export class ViewAllFCComponent implements OnInit {
  users :Persona[];

  constructor(private ruoter:Router, private viewAllService: ViewAllFCService) { }


  /**
   *
   *
   * @memberof ViewAllFCComponent
   */
  ngOnInit() {
    var that=this;
    this.viewAllService.viewAll().subscribe(data =>{
       console.log('data');
      that.users=data;
      console.log(data);
      })
   }   


   /**
    * Richiama il service per attuare l'eliminazione dell'oggetto persona,
    * successivamente ricarica la pagina.
    *
    * @param {*} per
    * @memberof ViewAllFCComponent
    */
   Delete(per){
    confirm ("Stai eliminando un utente");
    this.viewAllService.delete(per).subscribe(data =>{
     })
     location.reload();
   }

   /**
    * Alloca l'id dell'oggetto persona selezionato e 
    * successivamente rimanda al'EditFCComponent.
    *
    * @param {*} idp
    * @memberof ViewAllFCComponent
    */
   Edit(idp):void{  
     localStorage.setItem('idp',idp);
     this.ruoter.navigate(["edit"]);
    console.log(localStorage);
   }
   
}
