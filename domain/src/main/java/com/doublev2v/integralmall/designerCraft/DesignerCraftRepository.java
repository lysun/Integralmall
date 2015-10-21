package com.doublev2v.integralmall.designerCraft;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DesignerCraftRepository extends PagingAndSortingRepository<DesignerCraft, String>,
	JpaSpecificationExecutor<DesignerCraft>{
	
}
