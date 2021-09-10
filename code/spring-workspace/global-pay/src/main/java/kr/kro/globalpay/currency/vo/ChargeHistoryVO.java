package kr.kro.globalpay.currency.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("chargeHistoryVO")
public class ChargeHistoryVO {
	private int no;
	private String accountNo;
	private String accountBank;
	private String date;
	private String currencyCode;
	private double krAmount;
	private String cardNo;
	private double exchangeRate;
	private double feAmount;
}
