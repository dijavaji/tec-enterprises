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
}
