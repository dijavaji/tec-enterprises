import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of, Observable, throwError } from 'rxjs';
import { map, catchError, tap  } from 'rxjs/operators';

import { Department } from '../models/department';
import { environment } from '../../environments/environment';

@Injectable()
export class DepartmentService {

	private baseUrl = 'http://127.0.0.1:8080/api/departments';
	
	readonly URL_SRV_ENTERPRISE = environment.urlSrvEnterprises;
	private httpHeaders = new HttpHeaders({'Content-type': 'application/json'}); 
	constructor(private http: HttpClient) { }

	getDepartments(): Observable<Department[]> {
		return this.http.get<Department[]>(this.baseUrl);
	}

	getDepartment(id: number): Observable<Department> {
    	return this.http.get<Department>(`${this.baseUrl}/${id}`);
  }

  createDepartment(dept: Department):Observable <Department>{
		return this.http.post(this.baseUrl, dept, { headers: this.httpHeaders }).pipe(
		map((response: any) => response.enterprise as Department),
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

	updateDepartment(dept: Department): Observable<any>{
  	//return this.http.put<Cliente>(`${this.urlEndPoint}/${cliente.id}`, cliente, {headers: this.httpHeaders})
  	 return this.http.put<any>(`${this.baseUrl}/${dept.id}`, dept, { headers: this.httpHeaders }).pipe(
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
