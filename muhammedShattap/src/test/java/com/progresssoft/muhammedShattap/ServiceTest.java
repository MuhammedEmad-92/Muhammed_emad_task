package com.progresssoft.muhammedShattap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.progresssoft.muhammedShattap.Repository.DealRepository;
import com.progresssoft.muhammedShattap.Service.DealService;
import com.progresssoft.muhammedShattap.entity.Deal;
import com.progresssoft.muhammedShattap.error.DealNotFound;

@SpringBootTest
public class ServiceTest {
	
	@Autowired
	DealService dealservice;
	
	@MockBean
	private DealRepository dealRepo;
	
	Deal testDeal;
	@BeforeEach
	void setUp() {
		testDeal= new Deal("1", "jod", "usd", "01/01/2020", new BigDecimal(100));
		Optional<Deal> dealOpt =  Optional.of(testDeal);
		
		Mockito.when(dealRepo.findById("1")).thenReturn(dealOpt);
		
	}
	@Test
	public void whenValidDealId_thenDealShouldBeFound() throws DealNotFound {
		BigDecimal dealAmount = new BigDecimal(100);
		
		
		assertEquals(dealAmount, dealservice.getDeal("1").getDealAmount());
	}
	

}
