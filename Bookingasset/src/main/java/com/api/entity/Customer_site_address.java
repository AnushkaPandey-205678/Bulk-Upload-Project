package com.api.entity;
import java.io.IOException;
import java.time.LocalDateTime;


import org.springframework.format.annotation.DateTimeFormat;

//import com.api.exception.EmailValidationException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;





@Entity
public class Customer_site_address {
    @Id
    @Column(unique = true , name= "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String address;
    
    
    @NotNull
    @Digits(integer = 10, fraction = 0, message = "Alternate Contact number must be a numeric value with up to 10 digits")
    @Column(name ="alternate_contact_number",unique= false,length= 10 )
    private Long alternateContactNumber;
   
    
 // Example email validation
  

  
  
    private String city;
    
    @NotNull
    @Digits(integer = 10, fraction = 0, message = " Contact number must be a numeric value with up to 10 digits")
    @Column(name ="contact_number",unique= false,length=10 )
    private Long contactNumber;
    
    
    private String accountName;
    private long accountId;
    private String country;
    private long countryId;
    public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}
	@NotEmpty 
    private String customerName;
    @NotEmpty
    @CustomEmail(message = "Must be a well-formed email address")
    @Column(name = "email_id" , unique = false )
    private String emailId;
   
    private Double pinCode;
    private String siteName;
    private String state;
    private long  stateId;
    private String address2;
    
    @Column(unique = true , name= "bookingId")
    private String bookingId;
    private String bookingStatus;
    @VehicleBookingDate
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private LocalDateTime vehicleBookingDate;
    private String fullAddress;
    public Customer_site_address(Integer Id,String address,Long alternateContactNumber, String city,Long contactNumber,String country ,
    		String customerName ,String emailId ,Double pinCode, String siteName ,String state ,String address2 , String bookingId ,
    		String bookingStatus ,LocalDateTime vehicleBookingDate ,String accountName,String fullAddress)
    {
      //  this.Id = Id;
        this.address = address;
        this.alternateContactNumber = alternateContactNumber;
        this.city = city;
        this.contactNumber = contactNumber;
        this.country = country;
        this.customerName = customerName;
        this.emailId = emailId;
        this.pinCode = pinCode;
        this.siteName = siteName;
        this.state = state;
        this.address2 = address2;
        this.bookingId = bookingId;
        this.bookingStatus = bookingStatus;
        this.vehicleBookingDate = vehicleBookingDate;
        this.accountName = accountName;
        this.fullAddress = fullAddress;
    }
	public Customer_site_address() {
    }
	public Integer getId() {
		return Id;
	}
	/*public void setId(Integer id) {
		Id = id;
	}*/
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getAlternateContactNumber() {
		return alternateContactNumber;
	}
	public void setAlternateContactNumber(Long alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		
		return emailId;
		
	}
	public void setEmailId(String emailId) {

		this.emailId = emailId;
	}
	public Double getPinCode() {
		return pinCode;
	}
	public void setPinCode(Double pinCode) {
		this.pinCode = pinCode;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
		public LocalDateTime getVehicleBookingDate() {
			return vehicleBookingDate;
		}
		public void setVehicleBookingDate(LocalDateTime vehicleBookingDate) {
			this.vehicleBookingDate = vehicleBookingDate;
		}
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public String getFullAddress() {
			return fullAddress;
		}
		public void setFullAddress(String fullAddress) {
			this.fullAddress = fullAddress;
		}
}
