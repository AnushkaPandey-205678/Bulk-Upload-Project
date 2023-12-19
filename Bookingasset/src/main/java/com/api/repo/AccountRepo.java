package com.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;

import com.api.entity.Account;
@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	// Optional <Account> findByName(String name);
 // @Query(value="SELECT id FROM Account  WHERE name=:n", nativeQuery = true)	
  //public int getIdByName(@Param("n")String name);
}
