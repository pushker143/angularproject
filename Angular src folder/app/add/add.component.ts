import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export interface Employee {
  employeeName: string;
  designation: string;
  experience: string;
  contactNum: string;
  salary: string;
}

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  [x: string]: any;

  employee: Employee;
  employeeName: string;
  designation: string;
  experience: string;
  contactNum: string;
  salary: string;
  jsonObj: string;
  msg: string;

  constructor(private httpClient: HttpClient) {

  }

  ngOnInit() {
  }
  addEmployee() {
    this.employee = {
      employeeName: this.employeeName,
      designation: this.designation,
      experience: this.experience,
      contactNum: this.contactNum,
      salary: this.salary
    };
    const header = {
      'Content-Type': 'application/json',
      'dataType': 'JSON',
      'mimeType': 'application/json'
    };
    const headers = new HttpHeaders(header);
    this.jsonObj = JSON.stringify(this.employee);
    this.httpClient.post('http://localhost:3030/EmployeeRest/rest/employee/add', this.jsonObj, {headers : headers})
      .subscribe(
      (data: any) => {
        console.log(data);
        this.result = data;
        this.msg = 'Employee Inserted with Employee ID : ' + this.result.employeeId;
        this.employeeName = '';
        this.contactNum = '';
        this.designation = '';
        this.experience = '';
        this.salary = '';
      }
    );
  }
}
