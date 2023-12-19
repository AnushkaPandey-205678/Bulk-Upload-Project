package com.api.controller;

import com.api.entity.Customer_site_address;
import com.api.helper.Helper;
import com.api.service.Customer_site_addressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private Customer_site_addressService customer_site_addressService;

    @PostMapping("/booking/upload")
 
    public ResponseEntity<?> upload( @Valid @RequestParam("File") MultipartFile file ) {
    	 // GlobalExceptionHandler ob = new GlobalExceptionHandler();
       //   boolean isnotvalid = ob.isvalid;
        //  Map<String, String> error = new HashMap<>();
        if (Helper.checkExcelFormat(file)) {
            //true

            this.customer_site_addressService.save(file);
           

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
        }
        
        //	error = ob.resp;
         //   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
        
}


	@GetMapping("/product")
    public List<Customer_site_address> getAllCustomer_site_address() {
        return this.customer_site_addressService.getAllProducts();
    }
    


}
