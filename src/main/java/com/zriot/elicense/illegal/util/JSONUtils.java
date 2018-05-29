package com.zriot.elicense.illegal.util;

import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * 通用方法，用于转换json到bean，或者bean 到json
 */
public class JSONUtils {

	/**
	 * json 字符串转 为对象
	 * 
	 * @param jsonText
	 * @param objCls
	 * @return
	 */
	public static <T> T jsonToObjectBean(String jsonText, Class<T> objCls) {
		if (StringUtils.isEmpty(jsonText)) {
			return null;
		}
		return JSON.parseObject(jsonText, objCls);
	}

	/**
	 * json 字符串转为集合对象
	 * 
	 * @param jsonText
	 * @param arrayCls
	 * @return
	 */
	public static <T> List<T> jsonToArrayBean(String jsonText, Class<T> arrayCls) {
		if (StringUtils.isEmpty(jsonText)) {
			return null;
		}
		return JSON.parseArray(jsonText, arrayCls);
	}

	/**
	 * 对象转json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> String beanToJSONString(T obj) {
		if (obj == null) {
			return null;
		}
		return JSON.toJSONString(obj);
	}

}