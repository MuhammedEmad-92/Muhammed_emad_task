package com.progresssoft.muhammedShattap;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.progresssoft.muhammedShattap.Repository.DealRepository;
import com.progresssoft.muhammedShattap.entity.Deal;
import com.progresssoft.muhammedShattap.error.DealNotFound;


@DataJpaTest
class RepositoryTest {

	@Autowired
	private DealRepository dealRepo;
	
	@Autowired
	private TestEntityManager entitymanager;
	
	Deal testDeal;
	@BeforeEach
	void setUp() {
		testDeal= new Deal("1", "jod", "usd", "01/01/2020", new BigDecimal(100));
		entitymanager.persist(testDeal);
		
	}
	
	@Test
	public void whenValidDeal_thenDealShouldBeFound() throws DealNotFound {
		
		System.out.println("####################################################");
		System.out.println(dealRepo.findById("1").get().getDealAmount());
		
		
		assertEquals("usd", dealRepo.findById("1").get().getToCurCode());
	}
	
	

}
