package com.api.repo;

import com.api.entity.Customer_site_address;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface Customer_site_AddressRepo extends JpaRepository<Customer_site_address,Integer> {
}
