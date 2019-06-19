import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../employee';
import { Observable } from 'rxjs';

@Injectable()
export class EmployeeService {

  private employeesUrl: string;
  private deleteEmployeeUrl: string;
  private addEmployeeUrl: string;

  constructor(private http: HttpClient) { 
    this.employeesUrl = 'http://localhost:8080/employees';
    this.addEmployeeUrl = 'http://localhost:8080/add-employee';
    this.deleteEmployeeUrl = 'http://localhost:8080/delete-employee';
  }

  public findAll(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.employeesUrl);
  }

  public save(employee: Employee) {
    return this.http.post<Employee>(this.addEmployeeUrl, employee);
  }

  public delete(employee) {
    return this.http.delete<Employee>(this.deleteEmployeeUrl + "/"+ employee.id);
  
  }
}
