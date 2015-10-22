package com.doublev2v.integralmall.designerCraft;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DesignerMapper {

	List<DesignerCraft> findCrafts(@Param("list") List<String> ids, @Param("userId") String userId);
}
