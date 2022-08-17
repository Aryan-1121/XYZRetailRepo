package com.xyzretail.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.service.CartService;
import com.xyzretail.service.ItemsService;

@Controller

public class CartController {

	@Autowired
	private CartService cartService;
	
	
	@Autowired
	private ItemsService itemsService;

	public Customer getCustomer(HttpSession session) {
		return (Customer)session.getAttribute("customer");
	}
	@RequestMapping("/cart")
	public ModelAndView getCartController() {
		return new ModelAndView("CartPage");
	}
	
	
	
	@RequestMapping("/seeItemsInCart")
	public ModelAndView showItemsInCartController(HttpSession session) {
		//Customer customer=(Customer)session.getAttribute("customer");
		List<ItemsCart> cart=cartService.getAllItemsInCart(getCustomer(session).getUserName());
		if(cart!=null)
			return new ModelAndView("ShowItemsInCart","itemsCart",cart);
		else {
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("message", "No Items In Cart");
			modelAndView.setViewName("Output");
			return modelAndView;
		}
	}
	
	
	
//	@ModelAttribute("itemNames")
//	public List<String> getItemNames(){
//		List<ItemDetails> items=itemsService.getAllItems();
//
//		return (items.stream()).
//				map(ItemDetails :: getItemName).
//				distinct().
//				collect(Collectors.toList());
//
//	}
//	
	
	
	@ModelAttribute("itemIds")
	public List<String> getItemNames(){
		List<ItemDetails> items=itemsService.getAllItems();

		return (items.stream()).
				map(ItemDetails :: getItemId).
				distinct().
				collect(Collectors.toList());

	}
	
	
	@RequestMapping("/addItemPage")
	public ModelAndView addItem() {
		return new ModelAndView("addItems", "command", new ItemDetails());
	}
	
	

	@RequestMapping("/addItem")

	public ModelAndView addItemsController(@ModelAttribute("command") ItemDetails itemDetails,
			@RequestParam("purchaseQuantity") int quantity,@RequestParam("addItems") String action, HttpSession session) {



		ModelAndView modelAndView=new ModelAndView();


		Customer customer =(Customer)session.getAttribute("customer");
		session.setAttribute("itemDetails", itemDetails);

		String message=null;

		if(action.equals("Submit")) {
		if(cartService.addItemToCart(getCustomer(session).getUserName(), itemDetails.getItemId(), quantity)) 
		{
		
		ItemDetails iDetails= (ItemDetails)session.getAttribute("itemDetails");
				
//		if(cartService.addItemToCart(customer.getUserName(), itemDetails.getItemId(), quantity)) 
		if(cartService.addItemToCart(customer.getUserName(), iDetails.getItemId(), quantity)) 
//		if(cartService.addItemToCart(name, itemDetails.getItemId(), quantity)) 

			message="Item's Added Successfully To Your Cart";
		else 
			message="Item's Failed To Add";
		
		
		modelAndView.addObject("message", message);
		modelAndView.addObject("itemDetails",itemDetails);
		modelAndView.setViewName("addItems");
		
		return modelAndView;
	}}
		
	return modelAndView;}
	
	
	@RequestMapping("/inputItemIdToDelete")
	public ModelAndView inputItemIdToDeleteController() {
		return new ModelAndView("InputItemIdToDelete","command",new ItemsCart());
	}
	
	@RequestMapping("/deleteItem")
	public ModelAndView deleteItemController(@ModelAttribute("command") ItemsCart itemsCart,HttpSession session,@RequestParam("deleteItems") String action) {
		ModelAndView modelAndView =new ModelAndView();
		String message=null;
		
		if(action.equals("Submit")) {
			
		if(cartService.unselectFromCart(itemsCart.getItem().getItemId(), getCustomer(session).getUserName())>0) {
			ItemsCart itemCart= (ItemsCart)session.getAttribute("itemsCart") {
			message="Items Deleted Successfully";
		}
		else {
			message="Unable To Remove Item";
		}
		modelAndView.addObject("message", message);
		modelAndView.addObject("itemsCart",itemsCart);
		modelAndView.setViewName("InputItemToDelete");
		
		return modelAndView;
	}}
		return modelAndView;
}
}