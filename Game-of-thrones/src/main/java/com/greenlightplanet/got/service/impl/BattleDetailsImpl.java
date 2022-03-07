package com.greenlightplanet.got.service.impl;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenlightplanet.got.model.Battle;
import com.greenlightplanet.got.model.CommanderDetails;
import com.greenlightplanet.got.repository.BattleRepository;
import com.greenlightplanet.got.repository.CommanderDetailsRepo;
import com.greenlightplanet.got.service.BattleDetails;

@Service
@Transactional
public class BattleDetailsImpl implements BattleDetails {
	
	@Autowired
	private BattleRepository battleRepo;
	
	
	@Autowired
	private CommanderDetailsRepo commanderRepo;

	@Override
	public void saveDataFromCSVIntoTables() throws IOException {
		Reader in = new FileReader("C:\\Users\\jatak\\Desktop\\Books\\Greenlight Planet\\Battles.csv");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		
		List<Battle> battleList = new ArrayList<>();
		List<CommanderDetails> commanderList = new ArrayList<>();
		
		for (CSVRecord record : records) {
			int battleNumber = Integer.parseInt(record.get("battle_number"));
			createRecordsForBattle(record, battleList, battleNumber);
		    createRecordsForCommanderDetails(record, commanderList, battleNumber);
		}
		
		battleRepo.saveAll(battleList);
		commanderRepo.saveAll(commanderList);
	}

	private void createRecordsForBattle(CSVRecord record, List<Battle> battleList, int battleNumber) {
		Battle battle = new Battle();
		battle.setBattleNumber(battleNumber);
	    battle.setName( record.get("name"));
	    battle.setBattleType(record.get("battle_type"));
	    battle.setYear(isNullOrEmpty(record.get("year"))?0:Integer.parseInt(record.get("year")));
		battle.setMajorDeath(isNullOrEmpty(record.get("major_death"))?0:Integer.parseInt(record.get("major_death")));
		battle.setMajorCapture(isNullOrEmpty(record.get("major_capture"))?0:Integer.parseInt(record.get("major_capture")));
		battle.setAttackerSize(isNullOrEmpty(record.get("attacker_size"))?0:Integer.parseInt(record.get("attacker_size")));
		battle.setDefenderSize(isNullOrEmpty(record.get("defender_size"))?0:Integer.parseInt(record.get("defender_size")));
		battle.setLocation(record.get("location"));
		battle.setRegion(record.get("region"));
		battle.setNote(record.get("note"));
		battle.setSummer(isNullOrEmpty(record.get("summer"))?0:Integer.parseInt(record.get("summer")));
		battle.setBattleNumber(battleNumber);
		battle.setAttacker1(record.get("attacker_1"));
	    battle.setAttacker2(record.get("attacker_2"));
	    battle.setAttacker3(record.get("attacker_3"));
	    battle.setAttacker4(record.get("attacker_4"));
	    battle.setAttackerKing(record.get("attacker_king"));
	    battle.setAttackerOutcome(record.get("attacker_outcome"));
	    battle.setDefender1(record.get("defender_1"));
	    battle.setDefender2(record.get("defender_2"));
	    battle.setDefender3(record.get("defender_3"));
	    battle.setDefender4(record.get("defender_4"));
	    battle.setDefenderKing(record.get("defender_king"));
		
		battleList.add(battle);
	}

	private void createRecordsForCommanderDetails(CSVRecord record, List<CommanderDetails> commanderList, int battleNumber) {
		CommanderDetails commanders = new CommanderDetails();
		commanders.setBattleNumber(battleNumber);
		commanders.setAttackCommander(record.get("attacker_commander"));
		commanders.setDefendCommander(record.get("defender_commander"));
		commanderList.add(commanders);
	}

	private boolean isNullOrEmpty(String value) {
		return value.isEmpty() || value == null;
	}

	@Override
	public Battle getBattleDetails(Integer battleNumber) {
		Optional<Battle> battle = battleRepo.findById(battleNumber);
		Battle battleObj = null;
		if(battle.isPresent()) {
			battleObj = battle.get();
		}
		return battleObj;
	}

	@Override
	public List<String> getRegionAndLocation() {
		return battleRepo.findAll()
						.stream()
						.map(record -> "Battle number: "+record.getBattleNumber()+" Region: "+record.getRegion()+ " Location: " +" " +record.getLocation())
						.collect(Collectors.toList())	;
	}

	@Override
	public long getCountOfRecords() {
		return battleRepo.count();
	}

}
