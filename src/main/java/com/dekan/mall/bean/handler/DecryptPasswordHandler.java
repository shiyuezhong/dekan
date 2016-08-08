package com.dekan.mall.bean.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;
import org.springframework.stereotype.Service;

@Service
public class DecryptPasswordHandler implements CallbackHandler {
	private static final Map<String, String> pwMockDB = new HashMap<String, String>();//①正确用户/密码的模拟数据
	static{
		pwMockDB.put("server", "c898cfba96533a7b156e3c043467648c");
	}

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		// TODO Auto-generated method stub
		WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];//②-1:获取回调对象
		String id = callback.getIdentifier();							//②-2:获取用户名
		String validPw = (String)pwMockDB.get(id);						//②-3:获取用户对应的正确密码
		callback.setPassword(validPw);									//②-4:向回调设置正确的密码（明文密码）
	}

}
