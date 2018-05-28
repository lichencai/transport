package com.zriot.elicense.illegal.vo;

import java.util.List;

import lombok.Data;

/**
 * 城市停车位统计
 */
@Data
public class BikeParkVo {
	private Integer overBikeParks = 0;		//  城市超载停车位个数
	private Integer nervousBikeParks = 0;		//  城市紧张停车位个数
	private Integer freeBikeParks = 0;		//  城市空闲停车位个数
	private List<BikeCountVo> bikeParks = null;		//  该城市下面各个区域停车位情况
}
