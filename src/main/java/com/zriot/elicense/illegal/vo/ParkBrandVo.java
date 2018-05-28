package com.zriot.elicense.illegal.vo;

import lombok.Data;

/**
 * 某个停车位各个品牌的单车数量
 */
@Data
public class ParkBrandVo {
	private Integer count = 0;	//  品牌的个数
	private String brandId;		//  品牌id
	private String brandName;		//  品牌名称
	private String logo;	//  品牌图标
}
