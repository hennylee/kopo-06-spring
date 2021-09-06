package kr.kro.globalpay.currency.vo;

import lombok.Data;

@Data
public class ExchangeRateVO {
	
	private String currencyCode;
	
	private String nationKr;
	private String nationEn;
	
	
	private double cashBuyRate;
	private double cashSellRate;
	private double cashBuySpread;
	private double cashSellSpread;
	
	private double transferSendRate;
	private double transferReceiveRate;
	private double transferCommission;

	private double buyBasicRate;
	private double usdChangeRate;
	private double tcBuyRate;
	private double foreignCheckSellRate;
	
	private String regDate;
	
}
