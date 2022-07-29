package com.progresssoft.muhammedShattap.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progresssoft.muhammedShattap.Repository.DealRepository;
import com.progresssoft.muhammedShattap.entity.Deal;
import com.progresssoft.muhammedShattap.error.DealExsist;
import com.progresssoft.muhammedShattap.error.DealNotFound;

@Service
public class DealServiceImpl implements DealService {

	@Autowired
	private DealRepository dealRepository;

	@Override
	public Deal saveDeal(Deal deal) throws DealExsist {

		Optional<Deal> dealOptional = dealRepository.findById(deal.getId());

		if (dealOptional.isPresent())
			throw new DealExsist("Deal already processed");

		return dealRepository.save(deal);
	}

	@Override
	public Deal updateDeal(String id, Deal deal) throws DealNotFound {

		Optional<Deal> dealOptional = dealRepository.findById(id);

		if (!dealOptional.isPresent())
			throw new DealNotFound("Deal not found");

		Deal dealSaved = dealRepository.findById(id).get();

		if (Objects.nonNull(deal.getFromCurCode()) && !"".equalsIgnoreCase(deal.getFromCurCode())) {
			dealSaved.setFromCurCode(deal.getFromCurCode());
		}

		if (Objects.nonNull(deal.getToCurCode()) && !"".equalsIgnoreCase(deal.getToCurCode())) {
			dealSaved.setToCurCode(deal.getToCurCode());
		}

		if (Objects.nonNull(deal.getDealTimeStamp()) && !"".equalsIgnoreCase(deal.getDealTimeStamp())) {
			dealSaved.setDealTimeStamp(deal.getDealTimeStamp());
		}

		if (Objects.nonNull(deal.getDealAmount())) {
			dealSaved.setDealAmount(deal.getDealAmount());
		}

		return dealRepository.save(dealSaved);
	}

	@Override
	public Deal getDeal(String dealId) throws DealNotFound {
		// TODO Auto-generated method stub

		Optional<Deal> dealOptional = dealRepository.findById(dealId);

		if (!dealOptional.isPresent())
			throw new DealNotFound("Deal not found");
		else
			return dealRepository.findById(dealId).get();

	}

	@Override
	public List<Deal> getAllDeals() {
		// TODO Auto-generated method stub
		return dealRepository.findAll();
	}

	@Override
	public String deleteDeal(String dealId) {
		// TODO Auto-generated method stub

		dealRepository.deleteById(dealId);
		return "Deal deleted sucssufully";

	}

}
