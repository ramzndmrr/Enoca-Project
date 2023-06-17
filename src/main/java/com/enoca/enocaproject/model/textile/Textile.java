package com.enoca.enocaproject.model.textile;

import com.enoca.enocaproject.model.BaseEntity;
import com.enoca.enocaproject.model.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "txt_textile")
public class Textile extends BaseEntity {


	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "textile",cascade = CascadeType.REMOVE)
	List<Employee> employees;

	
}