package com.doublev2v.integralmall.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.shortmessage.MessageSender;
import com.doublev2v.foundation.shortmessage.SendMessageException;
import com.doublev2v.integralmall.social.SocialLoginManager;
import com.doublev2v.integralmall.social.SocialLoginManager.LoginResult;
import com.doublev2v.integralmall.userinfo.UserInfo;
import com.doublev2v.integralmall.userinfo.UserInfoRepository;
import com.doublev2v.integralmall.util.RequestResult;
import com.doublev2v.integralmall.util.SystemErrorCodes;

/**
 * 没有很好地进行设计，这个项目先这样了，不要在需要继续长期维护的项目中像这样进行开发！
 * @author pc
 *
 */
@RestController("accountController")
public class AccountController {

	@Autowired
	private UserInfoRepository repository;
	@Autowired
	private MessageSender sender;
	@Autowired
	private SocialLoginManager socialManager;
	
	@RequestMapping("sendPassword")
	public String sendPassword(String telephone) {
		UserInfo userInfo=repository.findByAccount(telephone);
		if(userInfo==null) {
			throw new ErrorCodeException(SystemErrorCodes.NOUSER);
		}
		String[] data={userInfo.getPassword()};
		try {
			sender.sendMessage(telephone, "40950", data);
		} catch (SendMessageException e) {
			throw new ErrorCodeException(SystemErrorCodes.NOUSER, e);
		}
		return RequestResult.success("发送成功").toJson();
	}
	
	@RequestMapping(value="socialLogin",method=RequestMethod.POST)
	public String socialLogin(String userid) {
		LoginResult result=socialManager.login(userid);
		return RequestResult.success(result).toJson();
	}
	
	@RequestMapping(value="socialBind",method=RequestMethod.POST)
	public String socialBind(String userid, String phoneNum, int type, 
			String nickname, String avatarUrl) {
		LoginResult result=socialManager.bind(phoneNum, userid, type, nickname, avatarUrl);
		return RequestResult.success(result).toJson();
	}
}
