import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router, ActivatedRoute} from '@angular/router';

import { Enterprise } from '../../../models/enterprise';
import { EnterpriseService } from '../../../services/enterprise.service';

@Component({
  selector: 'tec-form-enterprise',
  templateUrl: './form-enterprise.component.html',
  styleUrls: ['./form-enterprise.component.css']
})
export class FormEnterpriseComponent implements OnInit {

	private enterprise:Enterprise = new Enterprise();

	private titulo: string = "Crear compa\u00f1ia";
	private errores: string[];

	constructor(private enterpriseService: EnterpriseService, private router:Router, 
					private activatedRoute: ActivatedRoute) { 

	}

	ngOnInit() {
		this.loadEnterprise();
	}

	loadEnterprise(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.enterpriseService.getEnterprise(id).subscribe( (enterprise) => this.enterprise = enterprise);
        //console.log(this.enterprise);
      }
    })
  }

  createEnterprise():void{
  	//console.log("crear compania click");
		
		this.enterpriseService.createEnterprise(this.enterprise).subscribe(enterprise => {
        this.router.navigate(['/enterprise']);
        //swal('Cliente nuevo', `El cliente ${cliente.nombre} creado correctamente.`, 'success');
      },
      err =>{
        this.errores = err.error.errors as string[];
        console.error('codigo de error desde el backend ' + err.status);
        console.error(err.error.errors);
      }
      );
  }

  updateEnterprise(): void{
		this.enterpriseService.updateEnterprise(this.enterprise).subscribe( json => {
      		this.router.navigate(['/enterprise'])
          //console.log(cliente);
      		//swal('Cliente actualizado', `${json.mensaje}: ${json.cliente.nombre}`, 'success')
    		},
        err =>{
        this.errores = err.error.errors as string[];
        console.error('codigo de error desde el backend ' + err.status);
        console.error(err.error.errors);
      }
    	)
	}


}
