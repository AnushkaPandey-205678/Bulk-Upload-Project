package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

//import com.api.repo.State_province_detail_repo;
@Entity
@Table(name = "State_province_details")
public class State_province_details {
	
	//private State_province_detail_repo stateprovrepo;
	
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "gst_code")
   private String gst_code;
    
    
    @Column(name = "name")
    private String name;
    
  @Column(name = "short_code")
  private String short_code;
    
   // @Column(name = "country id")
  //  @ManyToOne
  //  @JoinColumn(name = "country_id")
   // private Country_details country_id;


	public void setId(long id) {
		this.id = id;
	}


	public long getId() {
		//this.id= stateprovrepo.getIdByName(name);// TODO Auto-generated method stub
		return this.id;
	}


	/*public Long getId(String name) {
		this.id= stateprovrepo.getIdByName(name);// TODO Auto-generated method stub
		return this.id;
	}*/

    


public String getGst_code() {
		return gst_code;
	}


	public void setGst_code(String gst_code) {
		this.gst_code = gst_code;
	}
	
	
    
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}





	public String getShort_code() {
		return short_code;
	}


	public void setShort_code(String short_code) {
		this.short_code = short_code;
	}

	
	

	/*public Country_details getCountry_id() {
		return country_id;
	}


	public void setCountry_id(Country_details country_id) {
		this.country_id = country_id;
	}*/


}
