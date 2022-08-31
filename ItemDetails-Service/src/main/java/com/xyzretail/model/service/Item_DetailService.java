package com.xyzretail.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xyzretail.bean.Item_Detail;
import com.xyzretail.bean.Item_Details;
@Service
public interface Item_DetailService {
	List<Item_Detail>  getAllItemDetails();
}
