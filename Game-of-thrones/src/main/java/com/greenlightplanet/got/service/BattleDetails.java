package com.greenlightplanet.got.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.greenlightplanet.got.model.Battle;

public interface BattleDetails {
	List<Battle> battleDetails = new ArrayList<>();

	void saveDataFromCSVIntoTables() throws IOException;

	Battle getBattleDetails(Integer battleNumber);

	List<String> getRegionAndLocation();

	long getCountOfRecords();

}
