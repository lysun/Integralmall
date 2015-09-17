package com.doublev2v.foundation.core.entity;

import java.util.Date;

public interface IBaseModel {
	Date getCreateTime();
	void setCreateTime(Date createTime);
	Date getUpdateTime();
	void setUpdateTime(Date createTime);
}
