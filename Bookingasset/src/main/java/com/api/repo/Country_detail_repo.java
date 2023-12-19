package com.api.repo;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

//import com.api.entity.account;
import com.api.entity.Country_details;
@Repository
public interface Country_detail_repo extends JpaRepository<Country_details, Long> {

	
	//  @Query(value = "SELECT u FROM Country_details u WHERE u.name=:n", nativeQuery = true)	
	 // public int getIdByName(@Param("n")String name);
	
	//ptional<Country_details> findByName(String name);
}
