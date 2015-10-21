package com.doublev2v.integralmall.questionnaire;

import org.springframework.data.repository.CrudRepository;

public interface QuestionNaireRepository extends CrudRepository<QuestionNaire, String> {
	QuestionNaire getByUserId(String userId);
	int countByUserId(String userId);
}
