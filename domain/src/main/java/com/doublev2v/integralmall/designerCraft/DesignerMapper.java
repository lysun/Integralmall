package com.doublev2v.integralmall.designerCraft;

import java.util.List;

public interface DesignerMapper {

	List<DesignerCraft> findCrafts(List<String> ids);
}
