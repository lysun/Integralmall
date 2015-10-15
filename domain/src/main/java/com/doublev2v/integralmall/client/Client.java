package com.doublev2v.integralmall.client;

import java.util.Map;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.doublev2v.foundation.core.rest.ErrorCodeException;
import com.doublev2v.foundation.utils.JsonSerializer;
import com.doublev2v.integralmall.util.SystemErrorCodes;
import com.fasterxml.jackson.databind.JsonNode;

public class Client {
	private static javax.ws.rs.client.Client client=ClientBuilder.newClient();
	private static Client instance;
	static{
		client.register(MultiPartFeature.class);
	}
	public static Client getInstance(){
		if(instance==null)
			instance=new Client();
		return instance;
	}
	public JsonNode get(String url,Map<String,String> params){
		WebTarget target=client.target(url);
		if(params!=null){
			for(String key:params.keySet()){
				target=target.queryParam(key, params.get(key));//queryParam方法返回的是new的一个新对象，要赋值给target
			}
		}
		Builder builder=target.request();
		Response response=builder.get();
		String result=response.readEntity(String.class);
		return readTree(result);
	}
	public JsonNode post(String url,Map<String,String> params){
		WebTarget target=client.target(url);
		Form form=new Form();
		if(params!=null){
			for(String key:params.keySet()){
				form.param(key, params.get(key));
			}
		}
		Builder builder=target.request();
		Response response=builder.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
		String result=response.readEntity(String.class);
//		System.out.println(result);
		return readTree(result);
	}
	public JsonNode delete(String url,Map<String,String> params){
		WebTarget target=client.target(url);
		if(params!=null){
			for(String key:params.keySet()){
				target=target.queryParam(key, params.get(key));//queryParam方法返回的是new的一个新对象，要赋值给target
			}
		}
		Builder builder=target.request();
		Response response=builder.delete();
		String result=response.readEntity(String.class);
		return readTree(result);
	}
	public JsonNode readTree(String json){
		JsonNode rootNode;
		try {
			rootNode = JsonSerializer.readTree(json);
			String errcode=rootNode.path("errcode").asText();
			if("0".equals(errcode)){
				return rootNode.path("data");
			}
			String errorMessage=rootNode.path("errmsg").asText();
			throw new ErrorCodeException(SystemErrorCodes.REMOTE_DATA_ERROR,errorMessage);
		} catch (Exception e) {
			throw new ErrorCodeException(SystemErrorCodes.REMOTE_DATA_PARSE_ERROR,"数据解析错误");
		} 
		
	}
}
