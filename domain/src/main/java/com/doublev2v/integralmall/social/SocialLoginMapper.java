package com.doublev2v.integralmall.social;

import org.apache.ibatis.annotations.Param;

public interface SocialLoginMapper {

	UserProfile getProfileBySocialId(String id);
	
	void bindSocialAccount(@Param("account") String account,
			@Param("socialId") String socialId, @Param("socialAvatar") String socialAvatar);
	
	void bindSocialUser(@Param("user_id") String user_id,@Param("social_id")String social_id,
			@Param("social_avatar")String social_avatar);
}
