package com.zriot.elicense.illegal.vo;

import lombok.Data;
/**
 * 某个区域（天河区）停车位的列表
 */
@Data
public class RegionParkStatisticsVo {
	private Integer loadStatus;		//  停车位状态 超载 1 紧张 2 空闲 3
	private Double longitude;	//  经度
	private Double latitude;	//  纬度
	private String id;		//  停车位id
}
