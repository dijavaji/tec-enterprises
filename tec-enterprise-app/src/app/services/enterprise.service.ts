import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { of, Observable, throwError } from 'rxjs';
import { map, catchError, tap  } from 'rxjs/operators';

import { Enterprise } from '../models/enterprise';
import { environment } from '../../environments/environment';

@Injectable()
export class EnterpriseService {

	private baseUrl = 'http://127.0.0.1:8080/api/enterprises';
	
	readonly URL_SRV_ENTERPRISE = environment.urlSrvEnterprises;
	private httpHeaders = new HttpHeaders({'Content-type': 'application/json'}); 
	constructor(private http: HttpClient) { }

	getEnterprises(): Observable<Enterprise[]> {
		return this.http.get<Enterprise[]>(this.baseUrl);
	}

	getEnterprise(id: number): Observable<Enterprise> {
    	return this.http.get<Enterprise>(`${this.baseUrl}/${id}`);
  }

  createEnterprise(enterprise: Enterprise):Observable <Enterprise>{
		return this.http.post(this.baseUrl, enterprise, { headers: this.httpHeaders }).pipe(
		map((response: any) => response.enterprise as Enterprise),
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

	updateEnterprise(enterprise: Enterprise): Observable<any>{
  	//return this.http.put<Cliente>(`${this.urlEndPoint}/${cliente.id}`, cliente, {headers: this.httpHeaders})
  	 return this.http.put<any>(`${this.baseUrl}/${enterprise.id}`, enterprise, { headers: this.httpHeaders }).pipe(
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
