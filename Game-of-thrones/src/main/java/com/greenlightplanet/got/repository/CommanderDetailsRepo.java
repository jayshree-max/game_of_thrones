package com.greenlightplanet.got.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenlightplanet.got.model.CommanderDetails;

@Repository
public interface CommanderDetailsRepo extends JpaRepository<CommanderDetails, Long>{

}
