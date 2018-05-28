package com.zriot.elicense.illegal.vo;

import lombok.Data;

/**
 * 区域停车位统计
 */
@Data
public class BikeCountVo {
	private Integer regionId;	//  区域id
	private String rname;	//  区域名称
	private Integer over = 0;		//  超载停车位数量
	private Integer nervous = 0;	//  紧张停车位数量
	private Integer free = 0;;		//  空闲停车位数量
	private String overRate = "0.00%";	//  超载比例
	private String nervousRate = "0.00%";	//  紧张比例
	private String freeRate = "0.00%";	//  空闲比例
	private Integer bikesCount = 0;		//  单车个数
	private Integer totalBikeParks = 0;		//  总停车位个数
}
