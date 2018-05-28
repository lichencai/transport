package com.zriot.elicense.illegal.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * Created by linrufeng on 2017/3/28.
 */
@Slf4j
public class ObjectUtil {

    public static void fieldToString(Object sourceObject, Object targetObject) {
        fieldToString(sourceObject,targetObject,sourceObject.getClass(),targetObject.getClass());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void fieldToString(Object sourceObject, Object targetObject, Class source, Class target) {
            //获取所有属性
            Field[] fields = source.getDeclaredFields();
            for (Field field : fields) {
                try {
                    //拼接get方法名
                    StringBuffer getMethodName = new StringBuffer("get");
                    String fieldName = field.getName();
                    getMethodName.append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1));
                    //获取set方法
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, target);
                    //执行get、set方法
                    Method getMethod = source.getDeclaredMethod(getMethodName.toString());
                    Method setMethod = propertyDescriptor.getWriteMethod();
                    setMethod.invoke(targetObject, null == getMethod.invoke(sourceObject) ? null : getMethod.invoke(sourceObject).toString());
                } catch (Exception e) {
                }
            }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static void fieldToStringForList(List sourceList, List targetList, Class source, Class target) {
        for (Object sourceObject : sourceList) {
            try {
                Object targetObject =  target.newInstance();
                fieldToString(sourceObject, targetObject, source, target);
                targetList.add(targetObject);
            } catch (InstantiationException e) {
                log.warn(e.getMessage());
            } catch (IllegalAccessException e) {
                log.warn(e.getMessage());
            }
        }
    }

    /**
     * 校验参数是否存在违反逻辑的情况
     * @param bindingResult
     * @return
     */
    public static String checkParams(BindingResult bindingResult) {
        StringBuffer stringBuffer = new StringBuffer();
        for(ObjectError objectError : bindingResult.getAllErrors()) {
            stringBuffer.append(objectError.getDefaultMessage()).append(",");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    /**
     * 去除金额多余的0
     * @param string
     * @return
     */
    public static String subZero(String string) {
        if (string.lastIndexOf(".") > 0) {
            if (Integer.valueOf(string.substring(string.lastIndexOf(".") + 1)) == 0) {
                string = string.substring(0, string.lastIndexOf("."));
            } else if (Integer.parseInt(String.valueOf(string.substring(string.lastIndexOf(".") + 1).charAt(string.substring(string.lastIndexOf(".") + 1).length() - 1))) == 0) {
                string = string.substring(0, string.lastIndexOf(".") + 2);
            }
        }
        return string;
    }

    /**
     * 获取随机整数
     * @param maxVal
     * @return
     */
    public static Integer getRandomInt(Integer maxVal) {
        Random random = new Random();
        return random.nextInt(maxVal);
    }

    @SuppressWarnings("rawtypes")
	public static HashMap<String, String> toHashMap(Object object)
    {
        HashMap<String, String> data = new HashMap<String, String>();
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator it = jsonObject.keys();
        // 遍历jsonObject数据，添加到Map对象
        while (it.hasNext())
        {
            String key = String.valueOf(it.next());
            String value = jsonObject.get(key).toString();
            data.put(key, value);
        }
        return data;
    }

    public static String getRandomCode(int num){
        String str="";
        for(int i=0;i<num;i++){
            str+=String.valueOf((int)(Math.random()*9));
        }
        return str;
    }
    public static String getRandomChar(int num){
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String code = "";
        for(int i=0;i<2;i++){
            code += chars.charAt((int)(Math.random() * 26));
        }
        return code;
    }

    public static Integer decodeUid(Integer uid) {
        return (uid ^ 1136593273) / 397;
    }

    public static Integer encodeUid(Integer uid) {
        return uid * 397 ^ 1136593273;
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        String regex = "^1[0-9]{10}$";
        return phoneNumber.matches(regex);
    }

    public static String removeEmoji(String source) {
        if (source != null) {
            Pattern emoji = Pattern.compile(
                    "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
                    Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
            Matcher emojiMatcher = emoji.matcher(source);
            if (emojiMatcher.find()) {
                source = emojiMatcher.replaceAll("*");
                return source;
            }
            return source;
        }
        return source;
    }
}
