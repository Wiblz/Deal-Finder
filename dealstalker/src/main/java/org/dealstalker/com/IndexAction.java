/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dealstalker.com;


import com.opensymphony.xwork2.ActionSupport;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 */
@Conversion()
public class IndexAction extends ActionSupport {
	
	
	private ArrayList<Product> productList; 
	public Integer currentPage = 0;
	public Integer productPerPage = 50;
	
	public SearchEntry entry;
	public List<String> categories =  Arrays.asList("Clothing","Shoes","Accessories");
	public List<String> genders = Arrays.asList("Male","Female","Doesn`t matter, I am not a sexist!!");
	
	public List<String> aCat = Arrays.asList( "Activewear" ,
			"Jackets & Coats" ,"Hoodies & Sweatshirts" ,"Jeans & Trousers" ,
			"Shirts" ,"T-shirts" ,"Shorts" ,"Loungewear","Swimming stuff");
	
	public List<String> bCat = Arrays.asList("Boots", "Shoes","Sanadals, Sliders & Flip Flpos" ,"Sneakers & Trainers");
	
	public List<String> cCat = Arrays.asList("Wallets & Purses","Socks" ,"Begs" ,
			"Belts & Braces" ,"Hats & Caps" ,"Ties" ,"Glasses"  ,
			"Gloves and Scarfs","Underwear" ,"Not really useful stuff");
	
	public List<String> subCategories = new ArrayList<String>();
	
	
    public String execute() throws Exception {        

        return SUCCESS;
    }
    
    public String search() throws Exception {        
        Connection cnx = DriverLoader.getMySqlConnection();
        Statement stmt = null;
        String query = "Select * from Products LIMIT 10000;";
        
        productList = new ArrayList<Product>();
        
        try {
        	    stmt =  cnx.createStatement(
        	                           ResultSet.TYPE_FORWARD_ONLY,
        	                           ResultSet.CONCUR_READ_ONLY);
        	    
        	    ResultSet rs =  stmt.executeQuery(query);
        	    Product tempProduct = null;
                
        	    while (rs.next()) {
        	    	tempProduct = new Product();
        	    	tempProduct.setId((rs.getInt("id")));
        	    	tempProduct.setBrandName(rs.getString("Brand"));
        	    	tempProduct.setPrimaryCategory((rs.getString("PrimaryCategory")));
        	    	tempProduct.setSubCategory(rs.getString("SubCategory"));
        	    	tempProduct.setModelName(rs.getString("ModelName"));
        	    	tempProduct.setPrice(rs.getFloat("Price"));
        	    	tempProduct.setPriceCurrency(rs.getString("PriceCurrency"));
        	    	tempProduct.setDescription(rs.getString("Description"));
        	    	tempProduct.setSource(rs.getString("SourceUrl"));
        	    	tempProduct.setResource(rs.getString("ResourceUrl"));
        	    	tempProduct.setIsDiscounted(rs.getInt("isDiscounted"));
        	    	tempProduct.setImageUrl(rs.getString("ImageUrl"));
        	    	productList.add(tempProduct);
                }
        	 
        	}
        	catch(Exception ex) {
        		System.out.println("Handle me please, I am Mysql exception");
        	}
        	finally {		
        		  if (stmt != null) {  stmt.close(); }
        		  cnx.close();
        	}
        return SUCCESS;
    }
    
    
    public void setEntry(SearchEntry s) {
    	this.entry = s;
    }
    
    public SearchEntry getEntry() {
    	return this.entry;
    }
    
    public List<Product> getProductList() {
    	if(productList.size() == 0)
    		return productList; 	
    	return  
    		 productList.subList(currentPage * 50, 
			 ((currentPage + 1) * 50 < productList.size()) ? 
					(currentPage+1) * 50 : productList.size() - 1);
    }
  
    public void setProductList(ArrayList<Product> productList) {
    	this.productList = productList;
    }
    
}
