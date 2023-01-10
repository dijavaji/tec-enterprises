package ec.com.technoloqie.enterprise.ws.apirest.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author root
 *
 */
@Entity
@Table(name="DEPARTMENT")
public class Department implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="DEPARTMENT_ID",nullable=false, unique=true)
	private Integer id;
	
	@Column(name="DESCRIPTION")
    private String description;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=4, max=256, message = "debe tener una longitud de entre 4 y 256")
	@Column(name="NAME",nullable=false, unique=true)
	private String name;
	
	@Column(name="PHONE")
	private String phone;
	
	@NotEmpty(message ="no puede estar vacio")
	@Column(name="CREATED_BY",nullable=false)
	private String createdBy;
	
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
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ENTERPRISE_ID", nullable = false)
	private Enterprise enterprise;
	//@JsonBackReference
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ENTERPRISE_ID", nullable = false)
	//@JsonIgnore
	private Enterprise enterprise;
	
	/*@JsonManagedReference	
	@OneToMany(mappedBy="department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DepartmentEmployee> departmentEmployeeCol;
	*/
	@PrePersist 
	public void prePersist() {
		createdDate = new Date();
		status = Boolean.TRUE;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	private static final long serialVersionUID = 1500048612837498071L;
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	/*public List<DepartmentEmployee> getDepartmentEmployeeCol() {
		return departmentEmployeeCol;
	}

	public void setDepartmentEmployeeCol(List<DepartmentEmployee> departmentEmployeeCol) {
		this.departmentEmployeeCol = departmentEmployeeCol;
	}*/

}
