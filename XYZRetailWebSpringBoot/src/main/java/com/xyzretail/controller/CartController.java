package com.xyzretail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.service.CartService;

@Controller
@SessionAttributes("customer")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}
	
	@RequestMapping("/cart")
	public ModelAndView getCartController() {
		return new ModelAndView("CartPage");
	}
	@RequestMapping("/seeItemsInCart")
	public ModelAndView showItemsInCartController() {
		List<ItemsCart> cart=cartService.getAllItemsInCart(getCustomer().getUserName());
		if(cart!=null)
			return new ModelAndView("ShowItemsInCart","itemsCart",cart);
		else {
			ModelAndView modelAndView=new ModelAndView();
			modelAndView.addObject("message", "No Items In Cart");
			modelAndView.setViewName("Output");
			return modelAndView;
		}
	}
	
	@RequestMapping("/item")
	public ModelAndView addItemsController(@ModelAttribute("command") ItemDetails itemDetails,@RequestParam(value="purchaseQuantity",required = false) int quantity) {
		ModelAndView modelAndView=new ModelAndView();
		
		String message=null;
		if(cartService.addItemToCart(getCustomer().getUserName(), itemDetails.getItemId(), quantity)) {
			message="Item's Added Successfully To Your Cart";
		}
		else {
			message="Item's Failed To Add";
		}
		modelAndView.addObject("message", message);
		modelAndView.setViewName("addItems");
		
		return modelAndView;
	}
	
}
