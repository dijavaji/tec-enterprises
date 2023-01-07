package ec.com.technoloqie.enterprise.ws.apirest.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author root
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="EMPLOYEE_ID",nullable=false, unique=true)
	private Integer id;
	
	@Column(name="AGE")
    private String age;
	
	@Email(message="no es una direccion de correo bien formada")
	@Column(name="EMAIL",nullable=false, unique=true)
    private String address;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=4, max=256, message = "debe tener una longitud de entre 4 y 256")
	@Column(name="NAME",nullable=false, unique=true)
	private String name;
	
	@Column(name="POSITION")
	private String position;
	
	@Column(name="SURNAME")
	private String surname;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="CREATED_BY",nullable=false)
	private String createdBy;
	
	@NotNull(message= "no puede estar vacio")
	@Column(name="CREATED_DATE",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name="MODIFIED_DATE")
	@Temporal(TemporalType.DATE)
	private Date modifiedDate;
	
	@Column(name="STATUS")
	private Boolean status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	private static final long serialVersionUID = 1L;
	
}
