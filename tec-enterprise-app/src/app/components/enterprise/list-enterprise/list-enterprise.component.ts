import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Enterprise } from '../../../models/enterprise';
import { EnterpriseService } from '../../../services/enterprise.service';

@Component({
  selector: 'tec-list-enterprise',
  templateUrl: './list-enterprise.component.html',
  styleUrls: ['./list-enterprise.component.css']
})
export class ListEnterpriseComponent implements OnInit {

	lstEnterprise: Enterprise[] = [];
	constructor(private enterpriseService: EnterpriseService) { }

	ngOnInit() {
		this.recargarDatos();
	}

	recargarDatos() {
		this.enterpriseService.getEnterprises().subscribe(res => {
			this.lstEnterprise = res;
		},err => {
			console.error(err);
		})
		    	//this.lstEnterprise = this.enterpriseService.getEnterprises();
	}



}
