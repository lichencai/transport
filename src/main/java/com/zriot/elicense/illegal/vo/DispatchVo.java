package com.zriot.elicense.illegal.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DispatchVo {
	private Date scheduleTime;	//  调度时间
	private String scheduleUid;		//  调度人员
	private String licenseMac;		//  标签编码
	private String serialNumber;	//  调度车辆编号
	private String scheduleOutPlace;	//  调出地点
	private String putPlace;	//  投放地点
	private Date putTime;		//  投放时间
}
