package com.api.service;

import com.api.entity.Account;
import com.api.entity.Country_details;
import com.api.entity.Customer_site_address;
import com.api.entity.State_province_details;
import com.api.helper.Helper;
import com.api.repo.AccountRepo;
import com.api.repo.Country_detail_repo;
import com.api.repo.Customer_site_AddressRepo;
import com.api.repo.State_province_detail_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@Validated
public class Customer_site_addressService {

    @Autowired
    private Customer_site_AddressRepo customer_site_AddressRepo;
    @Autowired
    private   AccountRepo accountRepo ;
    
    @Autowired
    private   Country_detail_repo countrydetailRepo;

    @Autowired
    private   State_province_detail_repo stateprovRepo;

    public void save(MultipartFile file) {


        try {
            List<Customer_site_address> customer_site_address = Helper.convertExcelToListOfProduct(file.getInputStream());
            //List<Customer_site_address> customer_site_address = Helper.convertExcelToListOfBooking(file.getInputStream());
            List <State_province_details> stateProvinceDetails = stateprovRepo.findAll();
            List <Account> accountdetail =accountRepo.findAll();
            List <Country_details> countrydetail = countrydetailRepo.findAll();
           // List<Customer_site_address> uniquecustomerdetails = new LinkedList<>(); 
            fillStateIds(customer_site_address, stateProvinceDetails);
            fillAccountIds(customer_site_address, accountdetail);
            fillCountryIds(customer_site_address, countrydetail);
           // this.customer_site_AddressRepo.saveAll(customer_site_address);
            for (Customer_site_address customerDetail : customer_site_address) {
                try {
                    // Save each customer detail
                	customer_site_AddressRepo.save(customerDetail);
                } catch (DataIntegrityViolationException e) {
                    // Handle the unique key constraint violation
                    handleDuplicateEntry(e, customerDetail);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Customer_site_address> getAllProducts() {
        return this.customer_site_AddressRepo.findAll();
    }

  //State_id
  	private static void fillStateIds(List<Customer_site_address> addresses, List<State_province_details> stateDetails) {
          for (Customer_site_address address : addresses) {
              String stateName = address.getState();
              long stateId = getStateIdByName(stateDetails, stateName);
              address.setStateId(stateId);
          }
      }
  	 private static long getStateIdByName(List<State_province_details> stateDetails, String stateName) {
  	        for (State_province_details stateDetail : stateDetails) {
  	            if (stateDetail.getName().equalsIgnoreCase(stateName)) {
  	                return stateDetail.getId();
  	            }
  	        }
  	        return -1; // Return -1 (or another sentinel value) if state_name is not found
  	    }
  	
  // Account_id
  private static void fillAccountIds(List<Customer_site_address> addresses, List<Account> accountdetail) {
      for (Customer_site_address address : addresses) {
          String accountName = address.getAccountName();
          long accountId = getAccountIdByName(accountdetail, accountName);
          address.setAccountId(accountId );
      }
  }
   private static long getAccountIdByName(List<Account> accountDetails, String accountName) {
          for (Account accountDetail : accountDetails) {
              if (accountDetail.getName().equalsIgnoreCase(accountName)) {
                  return accountDetail.getId();
              }
          }
          return -1; // Return -1 (or another sentinel value) if state_name is not found
      }

  //Country_id
  private static void fillCountryIds(List<Customer_site_address> addresses, List<Country_details> countryDetails) {
      for (Customer_site_address address : addresses) {
          String countryName = address.getCountry();
          long countryId = getCountryIdByName(countryDetails, countryName);
          address.setCountryId(countryId);
      }
  }
   private static long getCountryIdByName(List<Country_details> countryDetails, String countryName) {
          for (Country_details countryDetail : countryDetails) {
              if (countryDetail.getName().equalsIgnoreCase(countryName)) {
                  return countryDetail.getId();
              }
          }
          return -1; // Return -1 (or another sentinel value) if state_name is not found
      }

   private void handleDuplicateEntry(DataIntegrityViolationException e, Customer_site_address customerDetail) {
       String errorMessage = e.getMostSpecificCause().getMessage();

       if (errorMessage.contains("customer_site_address.UK_3frl1swlqpg1qlrx7xn31h47w")) {
           // This is the specific constraint violation you are expecting
           // Print the conflicting ID as an alert message
           System.out.println("Alert: Duplicate entry for ID " + customerDetail.getBookingId());
       } else {
           // Handle other types of integrity constraint violations if needed
           e.printStackTrace(); // Log or handle the exception accordingly
       }
   }
}

 

