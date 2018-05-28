package com.zriot.elicense.illegal.vo;

import lombok.Data;

@Data
public class BrandBikeCountVo {
	private Integer brandCount;		//  某个单车品牌的数量
	private String brandId;		//  品牌id
	private String brandName;	//  品牌名称
	private Double rate;	//  占用的比例
	private Integer bikeTotal;
	private String logo;
	private String color;	//品牌颜色
}
