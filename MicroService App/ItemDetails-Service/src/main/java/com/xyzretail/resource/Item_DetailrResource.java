package com.xyzretail.resource;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.bean.ItemDetailsList;
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
	
	
	@GetMapping(path="/itemDetail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemDetailsList> getAllItem_Detailesource() {
		ItemDetailsList itemDetailsList =new ItemDetailsList(item_DetailService.getAllItemDetails());
		return new ResponseEntity<ItemDetailsList> (itemDetailsList,HttpStatus.FOUND );

	}
	
	@GetMapping(path="/itemDetail/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemDetail getItemByIdResource(@PathVariable("id")String itemId) {
		return item_DetailService.findByItemId(itemId).orElse(new ItemDetail());
	}
	
	@GetMapping(path="/itemDetail/{id}/{quantity}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemDetail getItemByIdResource(@Param("id")String itemId,@PathVariable("quantity")int availableQuantity) {
		return item_DetailService.findByItemId_AndAvailable_Quantity(itemId,availableQuantity);
	}
	
}










