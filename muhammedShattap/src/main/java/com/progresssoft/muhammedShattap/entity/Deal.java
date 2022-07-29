package com.progresssoft.muhammedShattap.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Deal {

	@Id
	@JsonProperty("deal_id")
	@NotBlank(message = "Deal id is null")
	private String id;
	@JsonProperty("ordering_currency")
	@NotBlank(message = "From currency is null")
	private String fromCurCode;
	@JsonProperty("to_currency_code")
	@NotBlank(message = "To Currency code is null")
	private String toCurCode;
	@JsonProperty("time_stamp")
	@NotBlank(message = "Time stamp is null")
	private String dealTimeStamp;
	@JsonProperty("amount")
	@DecimalMin("0")
	@DecimalMax("99999")
	@PositiveOrZero
	@NotNull(message = "Amount is null")
	private BigDecimal dealAmount;
	
	public Deal() {
		super();
	}

	public Deal(String id, String fromCurCode, String toCurCode, String dealTimeStamp,  BigDecimal dealAmount) {
		super();
		this.id = id;
		this.fromCurCode = fromCurCode;
		this.toCurCode = toCurCode;
		this.dealTimeStamp = dealTimeStamp;
		this.dealAmount = dealAmount;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromCurCode() {
		return fromCurCode;
	}
	public void setFromCurCode(String fromCurCode) {
		this.fromCurCode = fromCurCode;
	}
	public String getToCurCode() {
		return toCurCode;
	}
	public void setToCurCode(String toCurCode) {
		this.toCurCode = toCurCode;
	}
	public String getDealTimeStamp() {
		return dealTimeStamp;
	}
	public void setDealTimeStamp(String dealTimeStamp) {
		this.dealTimeStamp = dealTimeStamp;
	}
	public BigDecimal getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(@NotNull BigDecimal dealAmount) {
		this.dealAmount = dealAmount;
	}
	@Override
	public String toString() {
		return "Deal [id=" + id + ", fromCurCode=" + fromCurCode + ", toCurCode=" + toCurCode + ", dealTimeStamp="
				+ dealTimeStamp + ", dealAmount=" + dealAmount + "]";
	}
	

	
	
	
	
}
