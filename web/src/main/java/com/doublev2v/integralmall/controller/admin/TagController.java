package com.doublev2v.integralmall.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doublev2v.foundation.core.service.PagingService;
import com.doublev2v.integralmall.tag.Tag;
import com.doublev2v.integralmall.tag.TagService;

@Controller
@RequestMapping("/admin/tag")
public class TagController extends SimpleController<Tag> {
	@Autowired
	private TagService service;
	@Override
	protected PagingService<Tag, String> getService() {
		return service;
	}
	@Override
	protected String getMenuTab() {
		return "tag";
	}

}
