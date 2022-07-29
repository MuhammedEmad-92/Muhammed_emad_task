package com.progresssoft.muhammedShattap.Service;

import java.util.List;

import com.progresssoft.muhammedShattap.entity.Deal;
import com.progresssoft.muhammedShattap.error.DealExsist;
import com.progresssoft.muhammedShattap.error.DealNotFound;

public interface DealService {

public Deal getDeal(String dealId) throws DealNotFound;	//tested
public Deal saveDeal(Deal deal) throws DealExsist;
public Deal updateDeal(String id,Deal deal) throws DealNotFound;
public List<Deal> getAllDeals();
public String deleteDeal(String dealId);


}
