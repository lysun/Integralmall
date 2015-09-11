package com.doublev2v.integralmall.userinfo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.doublev2v.foundation.core.service.AbstractPagingAndSortingService;
@Service
@Transactional
public class UserInfoService extends AbstractPagingAndSortingService<UserInfo, String>{



}
