package sy.util.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VerifySignUtil {
	public static final String KEY = "5e692f7d17f46fb42eaf630c5333bfe3";

	/**
	 * 接口签名校验
	 */
	public static boolean verifySign(List<NameValuePair> signParams, String sign) {
		String appSign = sign(signParams);
		System.out.println("appSign:" + appSign + "-----sign:" + sign);
		if (!appSign.equals(sign)) {
			return true;
		} else {
			return false;
		}
	}

	public static String sign(List<NameValuePair> signParams) {
		List<NameValuePair> params_copy = null;
		String appSign="";
		try {
			params_copy = CommenUtil.deepCopy(signParams);
		} catch (Exception e) {
			e.printStackTrace();
			params_copy = signParams;
		}
		try {
			Collections.sort(params_copy);

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < params_copy.size(); i++) {
				sb.append(params_copy.get(i).getName());
				sb.append('=');

				String value = params_copy.get(i).getValue();
				sb.append(value);
				sb.append('&');
			}
			sb.append("key=");
			sb.append(KEY);

			appSign= MD5Util.md5(sb.toString()).toUpperCase();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return appSign;
	}

	/**
	 * 根据属性名获取属性值
	 * 
	 * */
	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}

}
