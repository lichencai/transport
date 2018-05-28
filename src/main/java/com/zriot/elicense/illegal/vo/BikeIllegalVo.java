package com.zriot.elicense.illegal.vo;

import lombok.Data;

@Data
public class BikeIllegalVo {
	
	private Integer brandCount;		//  某个单车品牌的数量
	private String brandId;		//  品牌id
	private String brandName;	//  品牌名称
	private String logo;		//  品牌图标
	private Integer bikeTotal;
	private Integer publishedLicenseTotal;
	private Integer actualBikeTotal;
	private Integer expireBikeTotal;
	private String color;	//  品牌颜色
	
	private Integer amount;		//  停车的数量
	private Integer capacity;		//  可容纳的数量
	private String code;		//  停放位置region编号
}
