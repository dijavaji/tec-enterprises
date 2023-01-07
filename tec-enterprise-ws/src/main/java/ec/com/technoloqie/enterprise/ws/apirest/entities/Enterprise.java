package ec.com.technoloqie.enterprise.ws.apirest.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author root
 *
 */
@Entity
@Table(name="ENTERPRISE")
public class Enterprise implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="ENTERPRISE_ID",nullable=false, unique=true)
	private Integer id;
	
	@NotEmpty(message ="no puede estar vacio")
	@Size(min=4, max=256, message = "debe tener una longitud de entre 4 y 256")
	@Column(name="NAME",nullable=false, unique=true)
	private String name;
	
	@Column(name="ADDRESS")
    private String address; 
	
	@Column(name="PHONE")
	private String phone;
	
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
	
    @OneToMany(mappedBy="enterprise", cascade = CascadeType.ALL)
    private List<Department> departmentCol;
    
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public List<Department> getDepartmentCol() {
		return departmentCol;
	}

	public void setDepartmentCol(List<Department> departmentCol) {
		this.departmentCol = departmentCol;
	}
	
	private static final long serialVersionUID = 1L;

}
