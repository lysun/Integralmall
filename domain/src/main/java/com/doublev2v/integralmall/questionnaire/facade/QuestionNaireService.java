package com.doublev2v.integralmall.questionnaire.facade;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.integralmall.questionnaire.QuestionNaire;
import com.doublev2v.integralmall.questionnaire.QuestionNaireRepository;
import com.doublev2v.integralmall.userinfo.token.UserInfoTokenRepository;
import com.doublev2v.integralmall.util.SystemErrorCodes;

@Service
@Transactional
public class QuestionNaireService {

	@Autowired
	private QuestionNaireRepository repository;
	@Autowired
	private UserInfoTokenRepository tokenRepository;
	
	public boolean hasAnswered(String userId) {
		if(StringUtils.isBlank(userId)) {
			throw new ErrorCodeException(SystemErrorCodes.NONE_ACCOUNT,"用户账号错误");
		}
		//QuestionNaire qn=repository.getByUserId(userId);
		//return qn!=null;
		return repository.countByUserId(userId)>0;
	}
	
	public boolean save(QuestionNaire qn) {
		QuestionNaire oqn=repository.getByUserId(qn.getUserId());
		if(oqn!=null) {
			return false;
		}
		repository.save(qn);
		return true;
	}
}
