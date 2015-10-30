package com.doublev2v.integralmall.favour;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

public interface FavourMapper {

	List<UserFavour> userFavours(RowBounds rowBounds);
	
	List<CraftFavour> craftFavours(RowBounds rowBounds);
}
