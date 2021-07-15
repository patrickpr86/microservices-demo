package com.patrick.hrworker.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@Id
	private String name;
	
	@Getter
	@Setter
	private Double dailyIncome;
	
	@Getter
	@Setter
	private Integer days;
	
	@Getter
	@Setter
	private Double total;
}
