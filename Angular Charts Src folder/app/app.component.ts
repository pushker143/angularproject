import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  result: any[];
  chart: any[];
  border: any;
  title = 'app';
  option: any;
  charts = [
  {key : 'Line Chart',
      value : '1'
    },
    {key : 'Bar Chart',
      value : '2'
    },
    {key : 'Pie Chart',
      value : '3'
    },
    {
      key : 'Doughnut Chart',
      value : '4'
    },
    {
      key : 'Polar Area Chart',
      value : '5'
    },
    {
      key : 'Radar Chart',
      value : '6'
    }
  ];
  constructor(private http: HttpClient) {

  }
  ngOnInit() {
    this.getHttp();
    this.chartforoption('1');
  }
  getHttp() {
    this.http.get('http://localhost:3030/EmployeeRest/rest/bankusers/findAll')
    .subscribe(
      (data: any[]) => {
        this.result = data;
        console.log(this.result);
        console.log(this.result.length);
      }
    );
  }
  chartforoption(option: any) {
    if (option === '1') {
      this.drawChart('line');
      this.border = '#3cba9f';
      this.option = {
            legend: {
              display: false
            },
            scales: {
              xAxes: [{
                display: true
              }],
              yAxes: [{
                display: true
              }]
            }
          };
    } else if (option === '2') {
      this.drawChart('bar');
      this.border = '#ffffff';
      this.option = {
            legend: {
              display: false
            },
            scales: {
              xAxes: [{
                display: true
              }],
              yAxes: [{
                display: true
              }]
            }
          };
    } else if (option === '3') {
      this.drawChart('pie');
      this.border = '#ffffff';
      this.option = {
        legend: {
          display: true
        },
        animation: {
          animateRotate: false,
          animateScale: true
        }
      };
    } else if (option === '4') {
      this.drawChart('doughnut');
      this.border = '#ffffff';
      this.option = {
        legend: {
          display: true
        },
        animation: {
          animateRotate: false,
          animateScale: true
        }
      };
    } else if (option === '5') {
      this.drawChart('polarArea');
      this.border = '#ffffff';
      this.option = {
        legend: {
          display: true
        },
        animation: {
          animateRotate: false,
          animateScale: true
        }
      };
    } else if (option === '6') {
      this.drawChart('radar');
      this.border = '#3cba9f';
      this.option = {
        legend: {
          display: false
        }
      };
    }
  }
  drawChart(chartType: any) {
    this.http.get('http://localhost:3030/EmployeeRest/rest/bankusers/findAll')
    .subscribe(
      (result: any[]) => {
        const users = [];
    const allusers = [];
    console.log('Hello');
    const len = this.result.length;
    for (let _i = 0; _i < len; _i++) {
      users.push(this.result[_i].trafficPercentage);
      allusers.push(this.result[_i].trafficName);
    }
        console.log(users);
        console.log(allusers);
        const ctx: HTMLElement  = document.getElementById('chartcanvas');
        console.log('canv');
        console.log(ctx);
    this.chart = new Chart(ctx, {
          type: chartType,
          data: {
            labels: allusers,
            datasets: [
              {
                data: users,
                borderColor: this.border,
                lineTension: 0,
                pointBackgroundColor: '#000000',
                pointHoverBackgroundColor: [
                  '#FF6384',
                  '#63FF84',
                  '#84FF63',
                  '#8463FF',
                  '#6384FF',
                  '#84AF63',
                  '#8133FF',
                  '#7384FF'
                ],
                backgroundColor: [
                  '#FF6384',
                  '#63FF84',
                  '#84FF63',
                  '#8463FF',
                  '#6384FF',
                  '#84AF63',
                  '#8133FF',
                  '#7384FF'
                ],
                fill: false
              },
            ]
          },
          options: this.option
        });
        console.log(this.chart);
        console.log(this.result);
        console.log(this.result.length);
      }
    );
  }
}
