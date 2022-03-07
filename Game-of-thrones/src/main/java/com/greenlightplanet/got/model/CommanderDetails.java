package com.greenlightplanet.got.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Commander_details")
public class CommanderDetails {
	@Id
	private int battleNumber;
	
	private String attackCommander;
	private String defendCommander;
	
}
