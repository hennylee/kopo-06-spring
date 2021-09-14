package kr.kro.globalpay.shopping.vo;

import org.apache.ibatis.type.Alias;
import lombok.Data;

@Data
@Alias("partnerShopVO")
public class PartnerShopVO {
	private String code;
	private String site;
	private String name;
	private String currency;
	private String regDate;
	private String nationKr;
}




