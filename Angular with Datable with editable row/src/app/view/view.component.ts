import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DataTablesModule } from 'angular-datatables';

export interface Employee {
  employeeId: string;
  employeeName: string;
  designation: string;
  experience: string;
  contactNum: string;
  salary: string;
}

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  result: any[];
  emp: Employee;
  delMsg: string;
  updMsg: string;
  msg: string;
  jsonObj: string;
  editRowId: any;

  constructor(private httpClient: HttpClient) {
    this.getEmployees();  }


  ngOnInit() {

  }
  getEmployees() {
    this.httpClient.get('http://localhost:3030/EmployeeRest/rest/employee/findAll')
    .subscribe(
      (data: any[]) => {
        this.result = data;
      }
    );
  }

  fetchUpdateEmployee(employeeId) {
    console.log('Getting in fetchUpdate');
        console.log('[fetchUpdate] data: ');
    this.httpClient.get('http://localhost:3030/EmployeeRest/rest/employee/' + employeeId)
    .subscribe(
      (data: any) => {
        this.emp = data;
        console.log(data);
      }
    );
    this.editRowId = employeeId;
  }

  updateEmployee() {
    console.log(this.emp);
    const header = {
      'Content-Type': 'application/json',
      'dataType': 'JSON',
      'mimeType': 'application/json'
    };
    const headers = new HttpHeaders(header);
    this.jsonObj = JSON.stringify(this.emp);
    this.httpClient.put('http://localhost:3030/EmployeeRest/rest/employee/update', this.jsonObj, {headers : headers})
    .subscribe(
      (data: any) => {
        console.log(data);
          this.msg = 'Employee Updated with Employee ID : ' + this.emp.employeeId;
            this.updMsg = 'Employee Updated with Employee Id : ' + this.emp.employeeId;
            this.delMsg = '';
	    this.editRowId = -1;
            this.getEmployees();
      }
    );
  }
  clearupdateEmployee() {
    this.editRowId = -1;
  }
  deleteEmployee(employeeId) {
    this.httpClient.delete('http://localhost:3030/EmployeeRest/rest/employee/' + employeeId)
    .subscribe(
      (data: any) => {
        console.log(data);
        console.log('Inside delete operation...' + JSON.stringify(data) + ', status=' + status);
          this.updMsg = '';
          this.getEmployees();
          this.delMsg = 'Employee Deleted with Employee Id : ' + employeeId;
      }
    );
  }

}
