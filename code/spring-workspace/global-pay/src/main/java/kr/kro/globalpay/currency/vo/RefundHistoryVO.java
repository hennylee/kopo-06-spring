package kr.kro.globalpay.currency.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("refundHistoryVO")
public class RefundHistoryVO {
	private int no;
	private String accountNo;
	private String accountBank;
	private String regDate;
	private String currencyEn;
	private double krAmount;
	private String cardNo;
	private double exchangeRate;
	private double feAmount;
}
