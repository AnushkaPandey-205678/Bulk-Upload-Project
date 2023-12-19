package com.api.repo;

import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

//import com.api.entity.account;
import com.api.entity.State_province_details;
@Repository
public interface State_province_detail_repo extends JpaRepository<State_province_details, Long>  {

	 Optional<State_province_details> findByName(String name);
	//  @Query(value = "SELECT u FROM State_province_details u WHERE u.name=:n", nativeQuery = true)	
	//  @Query("SELECT u FROM State_province_details u WHERE u.name=:n")
	//  public Long getIdByName(@Param("n")String name);

}
