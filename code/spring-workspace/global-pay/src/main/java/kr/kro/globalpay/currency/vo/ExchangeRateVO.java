package kr.kro.globalpay.currency.vo;

import lombok.Data;

@Data
public class ExchangeRateVO {
	
	private String currencyCode;
	private String nationKr;
	private String nationEn;
	
	private double buyBasicRate;
	
	private double cashBuyRate;
	private double cashSellRate;
	private double cashBuySpread;
	private double cashSellSpread;
	
	private double transferSendRate;
	private double transferReceiveRate;
	private double transferSendSpread;
	private double transferReceiveSpread;

	private double usdChangeRate;
	
	private String regDate;
	
}
