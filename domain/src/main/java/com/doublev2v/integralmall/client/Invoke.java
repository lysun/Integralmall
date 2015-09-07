package com.doublev2v.integralmall.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.doublev2v.integralmall.util.Constant;
import com.fasterxml.jackson.databind.JsonNode;


@Service
public class Invoke {
	 private Client client=Client.getInstance();
	 
	 /**
	  * 获取地址
	  */
	 public static final String ADDRESS=Constant.REMOTE_PATH+"/getaddress/";
	 public String getTypes(String addressId) {
		 JsonNode node=client.get(ADDRESS+addressId, null);
		 return node.path("xxx").asText();
	 }
}
