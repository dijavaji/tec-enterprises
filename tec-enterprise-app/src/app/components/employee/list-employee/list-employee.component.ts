import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Employee } from '../../../models/employee';
import { EmployeeService } from '../../../services/employee.service';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

	lstEmployee: Employee[] = [];
	constructor(private empService: EmployeeService) { }

	ngOnInit() {
		this.recargarDatos();
	}

	recargarDatos() {
		this.empService.getEmployees().subscribe(res => {
			this.lstEmployee = res;
		},err => {
			console.error(err);
		})
		    	//this.lstEnterprise = this.enterpriseService.getEnterprises();
	}



}
