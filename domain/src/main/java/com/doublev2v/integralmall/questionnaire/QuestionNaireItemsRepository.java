package com.doublev2v.integralmall.questionnaire;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

public interface QuestionNaireItemsRepository extends CrudRepository<QuestionNaireItems, Long> {

	@Override
	@QueryHints(value={@QueryHint(name="org.hibernate.cacheable",value="true")})
	public QuestionNaireItems findOne(Long id);
}
