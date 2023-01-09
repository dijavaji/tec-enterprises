import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of, Observable, throwError } from 'rxjs';
import { map, catchError, tap  } from 'rxjs/operators';

import { Employee } from '../models/employee';
import { environment } from '../../environments/environment';

@Injectable()
export class EmployeeService {

	private baseUrl = 'http://127.0.0.1:8080/api/employees';
	
	readonly URL_SRV_EMPLOYEE = environment.urlSrvEmployee;
	private httpHeaders = new HttpHeaders({'Content-type': 'application/json'}); 
	constructor(private http: HttpClient) { }

	getEmployees(): Observable<Employee[]> {
		return this.http.get<Employee[]>(this.baseUrl);
	}

	getEmployee(id: number): Observable<Employee> {
    	return this.http.get<Employee>(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Employee):Observable <Employee>{
		return this.http.post(this.baseUrl, employee, { headers: this.httpHeaders }).pipe(
		map((response: any) => response.employee as Employee),
		catchError(e => {

			if(e.status == 400){
				return throwError(e);				
			}
			console.log("se crea exeption");
			console.error(e.error.mensaje);
			//swal(e.error.mensaje, e.error.error, 'error');
			return throwError(e);
		})
		);
	}

	updateEmployee(employee: Employee): Observable<any>{
  	//return this.http.put<Cliente>(`${this.urlEndPoint}/${cliente.id}`, cliente, {headers: this.httpHeaders})
  	 return this.http.put<any>(`${this.baseUrl}/${employee.id}`, employee, { headers: this.httpHeaders }).pipe(
      catchError(e => {

        if (e.status == 400) {
          return throwError(e);
        }

        console.error(e.error.mensaje);
        //swal(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }
}
