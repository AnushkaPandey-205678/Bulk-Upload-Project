package com.api.helper;

import com.api.entity.Customer_site_address;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {
    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }
    //convert excel to list of products

    public static List<Customer_site_address> convertExcelToListOfProduct(InputStream is) {
        List<Customer_site_address> list = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("Sheet1");
            
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                Customer_site_address p = new Customer_site_address();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                      /*  case 0:
                        	if(cell.getCellType()== CellType.NUMERIC)
                            p.setId((int) cell.getNumericCellValue());
                            break;*/
                        case 0:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setBookingId(cell.getStringCellValue());
                            break;
                        case 1:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setAccountName(cell.getStringCellValue());
                            break;
                            
                        case 2:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setCustomerName(cell.getStringCellValue());
                            break;
                            
                        case 3:
                        	if(cell.getCellType()== CellType.NUMERIC)
                            p.setContactNumber((long)cell.getNumericCellValue());
                            break;
                            
                        case 4:
                        	if(cell.getCellType()== CellType.NUMERIC)
                            p.setAlternateContactNumber((long)cell.getNumericCellValue());
                            break;
                            

                        case 5:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setEmailId(cell.getStringCellValue());
                            break;
                            
                        case 6:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setAddress(cell.getStringCellValue());
                            break;
                            
                        case 7:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setAddress2(cell.getStringCellValue());
                            break;
                      
                      
                        case 8:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setCity(cell.getStringCellValue());
                            break;
                            
                        case 9:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setState(cell.getStringCellValue());
                            break;
                       
                    
                        case 10:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setCountry(cell.getStringCellValue());
                            break; 
                     
                        case 11:
                        	if(cell.getCellType()== CellType.NUMERIC)
                            p.setPinCode(cell.getNumericCellValue());
                            break;
                            
                        case 12:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setFullAddress(cell.getStringCellValue());
                            break;    
                            
                        case 13:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setSiteName(cell.getStringCellValue());
                            break;   
                            
                        case 14:                   
                        	if(cell.getCellType()== CellType.NUMERIC)
                            p.setVehicleBookingDate(cell.getLocalDateTimeCellValue());
                            break;
                      
                        case 15:
                        	if(cell.getCellType()== CellType.STRING)
                            p.setBookingStatus(cell.getStringCellValue());
                            break;
                       
                     
                        default:
                            break;
                    }
                    cid++;
                }
                  
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
}
