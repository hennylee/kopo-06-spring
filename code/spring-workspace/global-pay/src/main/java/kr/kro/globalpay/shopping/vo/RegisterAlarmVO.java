package kr.kro.globalpay.shopping.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("registerAlarmVO")
public class RegisterAlarmVO {
	private int no;
	private String regDate;
	private String memberId;
	private int productNo;
	private double alarmPrice;
	private double alarmRate;
	private String alarmCurrency;
}
