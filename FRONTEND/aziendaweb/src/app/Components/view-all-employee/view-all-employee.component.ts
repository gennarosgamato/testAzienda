import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ViewAllEmployeeService } from 'src/app/Services/view-all-employee.service';
import { Employee } from 'src/app/Employee';

@Component({
  selector: 'app-view-all-employee',
  templateUrl: './view-all-employee.component.html',
  styleUrls: ['./view-all-employee.component.css']
})
export class ViewAllEmployeeComponent implements OnInit {
employee:Employee[];

  constructor(private ruoter:Router, private viewAllEmployee: ViewAllEmployeeService) { }
  t:string;
  ngOnInit() {
    var that=this;
    this.t=window.sessionStorage.getItem('currentUser');
    this.viewAllEmployee.viewAll(this.t).subscribe(data =>{
       console.log('employee');
      that.employee=data;
      console.log(data);
      })
  }

}
