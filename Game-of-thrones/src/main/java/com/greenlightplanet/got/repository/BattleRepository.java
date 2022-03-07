package com.greenlightplanet.got.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greenlightplanet.got.model.Battle;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Integer>{
	
//	public static final String FIND_REGION_AND_LOCATION = "SELECT region, location FROM battle";
//	
//	@Query(value = FIND_REGION_AND_LOCATION, nativeQuery = true)
//	public List<Battle> findAll();
}
