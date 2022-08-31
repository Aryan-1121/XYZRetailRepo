package com.xyzretail.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyzretail.bean.Item_Details;
import com.xyzretail.model.service.Item_DetailService;

@RestController
public class Item_DetailrResource {
	@Autowired
	private Item_DetailService item_DetailService;
	
	
//	@GetMapping(path="/Item_Details", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Item_Details getAllItem_Detailesource() {
//		return new Item_Details(item_DetailService.getAllItemDetails());
////		if(item_Details != null)
////			return new ResponseEntity<Item_Details> (item_Details, HttpStatus.FOUND);
////		return new ResponseEntity<Item_Details>(new Item_Details(), HttpStatus.NOT_FOUND);
//	}
	
	
	@GetMapping(path="/Item_Details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item_Details> getAllItem_Detailesource() {
//		List<Item_Detail>item_Details =item_DetailService.getAllItemDetails();
		Item_Details item_Details =new Item_Details(item_DetailService.getAllItemDetails());
		return new ResponseEntity<Item_Details> (item_Details,HttpStatus.FOUND );

	}
}










