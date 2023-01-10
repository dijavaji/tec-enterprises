import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Department } from '../../../models/department';
import { DepartmentService } from '../../../services/department.service';

@Component({
  selector: 'app-list-department',
  templateUrl: './list-department.component.html',
  styleUrls: ['./list-department.component.css']
})
export class ListDepartmentComponent implements OnInit {

  lstDpt: Department[] = [];
	constructor(private deptService: DepartmentService) { }

	ngOnInit() {
		this.recargarDatos();
	}

	recargarDatos() {
		this.deptService.getDepartments().subscribe(res => {
			this.lstDpt = res;
		},err => {
			console.error(err);
		})
		    	//this.lstEnterprise = this.enterpriseService.getEnterprises();
	}


}
