import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router, ActivatedRoute} from '@angular/router';

import { Department } from '../../../models/department';
import { DepartmentService } from '../../../services/department.service';

@Component({
  selector: 'tec-form-department',
  templateUrl: './form-department.component.html',
  styleUrls: ['./form-department.component.css']
})
export class FormDepartmentComponent implements OnInit {

	private department:Department = new Department();

	private titulo: string = "Crear Departamento";
	private errores: string[];

	constructor(private deptService: DepartmentService, private router:Router, 
					private activatedRoute: ActivatedRoute) { 

	}

	ngOnInit() {
		this.loadDepartment();
	}

	loadDepartment(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.deptService.getDepartment(id).subscribe( (dept) => this.department = dept);
        //console.log(this.enterprise);
      }
    })
  }

  createDepartment():void{
  	//console.log("crear dept click");
		
		this.deptService.createDepartment(this.department).subscribe(dept => {
        this.router.navigate(['/departments']);
        //swal('Cliente nuevo', `El cliente ${cliente.nombre} creado correctamente.`, 'success');
      },
      err =>{
        this.errores = err.error.errors as string[];
        console.error('codigo de error desde el backend ' + err.status);
        console.error(err.error.errors);
      }
      );
  }

  updateDepartment(): void{
		this.deptService.updateDepartment(this.department).subscribe( json => {
      		this.router.navigate(['/departments'])
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
