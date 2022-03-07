package com.greenlightplanet.got.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ComponentScan
@Table(name = "Battle")
public class Battle {

	@Id
	private int battleNumber;
	
	private String name;
	private int year;
	private String battleType;
	private int majorDeath;
	private int majorCapture;
	private int attackerSize;
	private int defenderSize;
	private String location;
	private String region;
	
	@Column(length=1000)
	private String note;
	
	private int summer;
	private String attackerKing;
	private String defenderKing;
	private String attacker1;
	private String attacker2;
	private String attacker3;
	private String attacker4;
	private String defender1;
	private String defender2;
	private String defender3;
	private String defender4;
	private String attackerOutcome;

	@OneToMany(mappedBy = "battleNumber")
	private List<CommanderDetails> commanderDetails;
	
}
