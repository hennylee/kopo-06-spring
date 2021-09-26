package kr.kro.globalpay.currency.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cardBalanceVO")
public class CardBalanceVO {
	private int no;
	private String cardNo;
	private String currencyEn;
	private double balance;
	private NationCodeVO nationCodeVO; // join할 테이블
	private ExchangeRateVO exchangeRateVO; // join할 테이블
}
