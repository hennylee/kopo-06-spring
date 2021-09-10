package kr.kro.globalpay.currency.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cardBalanceVO")
public class CardBalanceVO {
	private int no;
	private String cardNo;
	private String currencyCode;
	private double balance;
	private int rank;
}
