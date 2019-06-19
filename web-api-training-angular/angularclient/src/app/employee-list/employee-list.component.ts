import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Employee[];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employeeService.findAll().subscribe(data => {
      this.employees = data;
    });
  }

  delete(employee: Employee):void {
    this.employeeService.delete(employee)
      .subscribe( data => {
        this.employees = this.employees.filter(u => u !== employee);
      })
  }
  

}
