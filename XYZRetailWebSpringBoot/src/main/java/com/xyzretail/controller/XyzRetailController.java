package com.xyzretail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.service.ItemsService;

@Controller
public class XyzRetailController {
	
	@Autowired
	private ItemsService itemsService;


	@RequestMapping("/showAllItems")
	public ModelAndView showAllItemsController() {
		List<ItemDetails> items=itemsService.getAllItems();
		
		return new ModelAndView("showAllItem", "items", items);
	}
	
}
