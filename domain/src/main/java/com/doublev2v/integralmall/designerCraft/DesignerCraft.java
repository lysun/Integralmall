package com.doublev2v.integralmall.designerCraft;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(catalog="jefen",name="designercraft")
public class DesignerCraft {

	private String id;
	private String picUrl;
	private Set<Attachments> attachments;
	@Id
	@GenericGenerator(name="idGenerator",strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="craftphotosattachment",joinColumns={@JoinColumn(name="craftid")},
	inverseJoinColumns={@JoinColumn(name="ATTACHMENTID")})
	@OrderBy("id")
	public Set<Attachments> getAttachments() {
		return attachments;
	}
	public void setAttachments(Set<Attachments> attachments) {
		this.attachments = attachments;
	}
	
	@Transient
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
