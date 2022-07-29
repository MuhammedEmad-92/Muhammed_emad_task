package com.progresssoft.muhammedShattap.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.progresssoft.muhammedShattap.Service.DealService;
import com.progresssoft.muhammedShattap.Service.DealServiceImpl;
import com.progresssoft.muhammedShattap.entity.Deal;
import com.progresssoft.muhammedShattap.error.DealExsist;
import com.progresssoft.muhammedShattap.error.DealNotFound;

@RestController
public class DealController {
	
	@Autowired
	private DealService service;
	
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DealController.class);
	@PutMapping("/deals/{id}")
	public Deal updateDeal(@PathVariable("id") String id,@Valid @RequestBody Deal deal) throws DealNotFound {
		LOGGER.info("inside update deal");
		
		return service.updateDeal(id,deal);
	}
	
	
	@DeleteMapping("/deals/{id}")
	public String deleteDeal(@PathVariable("id") String id) {
		LOGGER.info("inside delete deal");
		return service.deleteDeal(id);
	}
	
	
	
	@GetMapping("/deals/")
	public List<Deal> getDeal() {
		LOGGER.info("inside get all deal");
		return service.getAllDeals();
	}
	
	
	@PostMapping("/deals")
	public Deal saveDeal(@Valid @RequestBody Deal deal) throws DealExsist {
		LOGGER.info("inside save deal");
		return service.saveDeal(deal);
	}

}
