package com.greenlightplanet.got.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenlightplanet.got.model.Battle;
import com.greenlightplanet.got.service.BattleDetails;

@RestController
@RequestMapping("/battle")
public class BattleDetailsController {
	
	@Autowired
	BattleDetails battleDetailsService;
	
	@PostMapping("/save-in-table-from-csv")
	public ResponseEntity<String> saveDataFromCSV() throws IOException {
		battleDetailsService.saveDataFromCSVIntoTables();
		return ResponseEntity.ok("Data saved in tables!");
	}
	
	@PostMapping("/get-battle_details")
	public ResponseEntity<Battle> getBattleDetails(@RequestBody Integer battleNumber){
		return new ResponseEntity<Battle>(battleDetailsService.getBattleDetails(battleNumber), HttpStatus.OK);
	}
	
	@PostMapping("/get-region-and-locations")
	public ResponseEntity<List<String>> getRegionAndLocation(){
		return new ResponseEntity<List<String>>(battleDetailsService.getRegionAndLocation(), HttpStatus.OK);
	}
	
	@PostMapping("/get-count-of-records")
	public ResponseEntity<Long> getCountOfRecords(){
		return new ResponseEntity<Long>(battleDetailsService.getCountOfRecords(), HttpStatus.OK);
	}
}
