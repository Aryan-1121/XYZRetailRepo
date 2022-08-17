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
	
	@ModelAttribute("itemsInCart")
	public List<String> getItemsInCart(HttpSession session){
		List<ItemsCart> item=cartService.getAllItemsInCart(getCustomer(session).getUserName());
		List<ItemDetails> items=item.stream().map(ItemsCart::getItem).distinct().collect(Collectors.toList());
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
		//Customer customer =(Customer)session.getAttribute("customer");
		session.setAttribute("itemDetails", itemDetails);
		String message=null;

		if(action.equals("Submit")) {
			if(cartService.addItemToCart(getCustomer(session).getUserName(), itemDetails.getItemId(), quantity)) 
			{
			message="Item's Added Successfully To Your Cart";}



		else 
			{message="Item's Failed To Add";}
		modelAndView.addObject("message", message);
		modelAndView.addObject("itemDetails",itemDetails);
		modelAndView.setViewName("addItems");
		
		return modelAndView;

			}
		modelAndView.addObject("message", "Invalid Addition of Item to Cart");
		modelAndView.addObject("itemDetails",new ItemDetails());
		modelAndView.setViewName("addItems");
		return modelAndView;
		}
		

	

	
	@RequestMapping("/inputItemIdToDelete")
	public ModelAndView inputItemIdToDeleteController() {
		return new ModelAndView("InputItemIdToDelete","command",new ItemsCart());
	}
	
	@RequestMapping("/deleteItem")
	public ModelAndView deleteItemController(@ModelAttribute("command") ItemsCart itemsCart,HttpSession session,@RequestParam("deleteItems") String action) {
		ModelAndView modelAndView =new ModelAndView();
		String message=null;
		session.setAttribute("itemsCart", itemsCart);
		if(action.equals("Submit")) {
			
		if(cartService.unselectFromCart(itemsCart.getItem().getItemId(), getCustomer(session).getUserName())>0) {

			message="Items Deleted Successfully";
		}
		
		else {
			message="Unable To Remove Item";
		}
		modelAndView.addObject("message", message);
		modelAndView.addObject("itemsCart",itemsCart);
		modelAndView.setViewName("InputItemIdToDelete");
		
		return modelAndView;
	}
		modelAndView.addObject("message", "Invalid Deletion of Items From Cart");
		modelAndView.addObject("itemsCart", new ItemsCart());
		modelAndView.setViewName("InputItemIdToDelete");
		return modelAndView;
}


	@RequestMapping("/modifyItemPage")
	public ModelAndView modifyItem() {
		return new ModelAndView("modifyItems", "command", new ItemsCart());
	}
	
	
	@RequestMapping("/modifyItem")
	public ModelAndView modifyItemsController(@ModelAttribute("command") ItemsCart itemsCart,
			@RequestParam("modifyQuantity") int quantity,@RequestParam("modifyItems") String action, HttpSession session) {
		
		ModelAndView modelAndView=new ModelAndView();
		//Customer customer =(Customer)session.getAttribute("customer");
		session.setAttribute("itemsCart", itemsCart);
		String message=null;
		if(action.equals("Submit")) {
			if(cartService.modifyItemsInCart(getCustomer(session).getUserName(), itemsCart.getItem().getItemId(), quantity)) 
			{
				message="Updated Item Id : "+itemsCart.getItem().getItemId()+ " with new quantity of : "+ quantity;
			}
			else {
				message="Unable to update your cart";
			}
			modelAndView.addObject("message", message);
			modelAndView.addObject("itemsCart",itemsCart);
			modelAndView.setViewName("modifyItems");
	
			return modelAndView;
		}
		modelAndView.addObject("message", "Invalid modification of Item in Cart");
		modelAndView.addObject("itemsCart",new ItemsCart());
		modelAndView.setViewName("modifyItems");
		
		return modelAndView;
		
	}
	}


