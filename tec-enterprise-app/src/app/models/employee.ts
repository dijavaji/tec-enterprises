export class Employee {
	id?: number;
	name?: string;
	email?: string;
	position?: string;
	surname?: string;
	age?: number;
	createdBy = 'user';
	createdDate?:string;
	modifiedBy='user';
	modifiedDate?: string;
	status?:boolean;
}
