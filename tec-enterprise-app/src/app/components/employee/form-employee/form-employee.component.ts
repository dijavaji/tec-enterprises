import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Router, ActivatedRoute} from '@angular/router';

import { Employee } from '../../../models/employee';
import { EmployeeService } from '../../../services/employee.service';

@Component({
  selector: 'tec-form-employee',
  templateUrl: './form-employee.component.html',
  styleUrls: ['./form-employee.component.css']
})
export class FormEmployeeComponent implements OnInit {
	private employee:Employee = new Employee();

	private titulo: string = "Crear empleado";
	private errores: string[];

	constructor(private empService: EmployeeService, private router:Router, 
					private activatedRoute: ActivatedRoute) { 

	}

	ngOnInit() {
		this.loadEmployee();
	}

	loadEmployee(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.empService.getEmployee(id).subscribe( (emp) => this.employee = emp);
        //console.log(this.enterprise);
      }
    })
  }

  createEmployee():void{
  	//console.log("crear compania click");
		
		this.empService.createEmployee(this.employee).subscribe(emp => {
        this.router.navigate(['/employees']);
        //swal('Cliente nuevo', `El cliente ${cliente.nombre} creado correctamente.`, 'success');
      },
      err =>{
        this.errores = err.error.errors as string[];
        console.error('codigo de error desde el backend ' + err.status);
        console.error(err.error.errors);
      }
      );
  }

  updateEmployee(): void{
		this.empService.updateEmployee(this.employee).subscribe( json => {
      		this.router.navigate(['/employees'])
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
