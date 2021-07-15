package com.patrick.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Worker implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private Double dailyIncome;

}
