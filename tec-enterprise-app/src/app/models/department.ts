import {Enterprise} from './enterprise';

export class Department {
	id?: number;
	name?: string;
	description?: string;
	phone?: string;
	createdBy='user-web';
	createdDate?:string;
	modifiedBy= 'user-web';
	modifiedDate?: string;
	status?:boolean;
	enterprise?:Enterprise;

	//constructor 
   constructor() { 
      this.enterprise = new Enterprise; 
   }  
}
