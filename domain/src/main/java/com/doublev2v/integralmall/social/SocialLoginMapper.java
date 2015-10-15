package com.doublev2v.integralmall.social;

import org.apache.ibatis.annotations.Param;

public interface SocialLoginMapper {

	UserProfile getProfileBySocialId(String id);
	
	void bindSocialAccount(@Param("account") String account,@Param("socialId") String socialId);
}
