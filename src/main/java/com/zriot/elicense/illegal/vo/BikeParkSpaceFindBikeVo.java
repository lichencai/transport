package com.zriot.elicense.illegal.vo;

import java.util.Date;

import lombok.Data;

/**
 * 某个停车位的车辆
 */
@Data
public class BikeParkSpaceFindBikeVo {
	private String qrCode;	//  标签编号
	private String bikeQrCode;	//  车身编号
	private String brandName;	//  所属运营商
	private Date updateDate;	//  停车位数据更新时间
	private Date createDate;	//  投放日期
	private Date expiryDate;	//  到期时间
	private String bikeParkSpaceName;	//  当前所在停车位
}
