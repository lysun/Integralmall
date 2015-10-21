package com.doublev2v.integralmall.questionnaire.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.integralmall.questionnaire.QuestionNaireItems;
import com.doublev2v.integralmall.questionnaire.QuestionNaireItemsRepository;

@Service
@Transactional
public class QuestionNaireItemsService {	
	
	@Autowired
	private QuestionNaireItemsRepository repository;
	@Autowired
	private QuestionNaireItemsAdapter adapter;

	public QuestionNaireItemsVo findOne(Long id) {
		QuestionNaireItems items=repository.findOne(id);
		return adapter.convertToVo(items);
	}
	
	public void save(Long id, QuestionNaireItemsVo vo) {
		if(repository.exists(id)) {
			repository.delete(id);
		}
		QuestionNaireItems items=adapter.convertToDo(vo);
		repository.save(items);			
	}
}
