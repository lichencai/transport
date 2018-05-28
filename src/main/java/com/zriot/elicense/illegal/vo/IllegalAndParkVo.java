package com.zriot.elicense.illegal.vo;

import java.util.Date;

import lombok.Data;

/**
 * 不合法以及违停的数量
 */
@Data
public class IllegalAndParkVo {
	private Integer park = 0;	//  违停数量
	private Integer illegal = 0;		//  违规数量
	private Date date;		//  属于哪一天
}
