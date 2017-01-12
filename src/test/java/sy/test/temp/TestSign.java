package sy.test.temp;

import java.util.LinkedList;
import java.util.List;

import sy.constant.Constant;
import sy.util.base.NameValuePair;
import sy.util.base.VerifySignUtil;

public class TestSign {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<NameValuePair> signParams = new LinkedList<NameValuePair>();
		signParams.add(new NameValuePair("data.loginname", "admin1"));
		signParams.add(new NameValuePair("data.pwd", "123456"));

		String sign = VerifySignUtil.sign(signParams);
		System.out.println(sign);
	}
}
