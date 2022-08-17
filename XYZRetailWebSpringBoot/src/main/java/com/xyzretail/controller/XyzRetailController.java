package com.xyzretail.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.service.BillService;
import com.xyzretail.service.CartService;
import com.xyzretail.service.ItemsService;
import com.xyzretail.service.TransactionService;

@Controller
@SessionAttributes("customer")
public class XyzRetailController {
	
	@Autowired
	private ItemsService itemsService;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private TransactionService transactionService;

	@Autowired
	private BillService billService;
	
	public Customer getCustomer(HttpSession session) {
		return (Customer)session.getAttribute("customer");
	}
	
	@RequestMapping("/index")
	public ModelAndView indexController() {
		return new ModelAndView("Index");
	}
	
	@RequestMapping("/showAllItems")
	public ModelAndView showAllItemsController() {
		List<ItemDetails> items=itemsService.getAllItems();
		
		return new ModelAndView("showAllItem", "items", items);
	}

	@RequestMapping("/wantToShop")
	public ModelAndView shopController() {
		return new ModelAndView("CartPage");
	}

	
	
	@RequestMapping("/generateBill")
	public ModelAndView generateBillController(@ModelAttribute ItemBill bill,HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView();
		ItemBill itemsBill=billService.generateBill(getCustomer(session).getUserName());
		
		
		List<ItemsCart> itemsCarts =cartService.getAllItemsInCart(getCustomer(session).getUserName());
		
		String message=null;
	
		if (!itemsCarts.isEmpty() && itemsBill!=null ) {
			modelAndView.addObject("bill", itemsBill);
			message="Your Bill Details : ";
			modelAndView.addObject("itemsCarts", itemsCarts);
			modelAndView.addObject("message", message);
			
			
			for(ItemsCart item:itemsBill.getCart()) {
				itemsService.updateRecord(item.getItem().getItemId(), item.getPurchaseQuantity());	
			}
		
			modelAndView.addObject("msg", "Total Amount To Be Paid : ");
			
			
			if(billService.discount(getCustomer(session).getUserName())>0) {
				modelAndView.addObject("msg1", "Hey Congratulations !!!");
				modelAndView.addObject("msg2", "You are a Lucky Customer, you have got a discount of 15% for purchasing with us more than 5 times in this month!!!");
				modelAndView.addObject("msg3", "Your Bill Amount After Discount:");
				
			}
			boolean isComplete=transactionService.performTransaction(getCustomer(session).getUserName());
			if(isComplete) {
				modelAndView.addObject("msg4", "Transaction Completed Successfully !!!");
			}
			else {
				modelAndView.addObject("msg5", "Something Went Wrong !!!!!");
			}
			transactionService.insertIntoOrderTable(getCustomer(session).getUserName());		// Inserting into order table
			cartService.deleteItemFromCart(getCustomer(session).getUserName());
			modelAndView.setViewName("getBill");
		}
		else {
			modelAndView.addObject("message","Your Cart is empty !!");
			modelAndView.setViewName("Index");
		}
	
		return modelAndView;
		
	}

	@RequestMapping("/shopPage")
	public ModelAndView ShopPageController() {
		return new ModelAndView("shop");
	}
		
}
