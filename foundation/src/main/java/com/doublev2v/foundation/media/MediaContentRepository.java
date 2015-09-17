package com.doublev2v.foundation.media;

import org.springframework.data.repository.CrudRepository;

public interface MediaContentRepository extends CrudRepository<MediaContent, String> {
	public MediaContent findByFileName(String fileName);
}
