package com.doublev2v.integralmall.converter;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.core.dto.common.SimpleDtoConverter;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.foundation.dics.CategoryItemRepository;
import com.doublev2v.foundation.dics.dto.CategoryItemDtoConverter;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.foundation.media.MediaContentDto;
import com.doublev2v.foundation.media.MediaService;
import com.doublev2v.integralmall.entity.BranchShopDto;
import com.doublev2v.integralmall.entity.MerchandiseDto;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.shop.branch.BranchShop;
import com.doublev2v.integralmall.shop.branch.BranchShopRepository;
import com.doublev2v.integralmall.util.Constant;
import com.doublev2v.integralmall.util.DateUtil;

@Component
public class MerchandiseDtoConverter extends SimpleDtoConverter<Merchandise, MerchandiseDto>{
	@Autowired
	private MediaService mediaService;
	@Autowired
	private CategoryItemRepository categoryItemRepository;
	@Autowired
	private CategoryItemDtoConverter categoryItemDTOAdapter;
	@Autowired
	private BranchShopRepository shopRepository;
	@Autowired
	private BranchShopDtoConverter shopDtoConverter;
	
	public MerchandiseDto postConvert(Merchandise d,MerchandiseDto t){
		if(d.getStartDate()!=null){
			t.setStart(DateUtil.format(d.getStartDate()).substring(0, 10));
		}
		if(d.getEndDate()!=null){
			t.setEnd(DateUtil.format(d.getEndDate()).substring(0, 10));
		}
		if(d.getMainPicMedia()!=null){
			MediaContentDto md=new MediaContentDto();
			md.setId(d.getMainPicMedia().getId());
			md.setUrl(d.getMainPicMedia().getUrl());
			t.setMainPicDto(md);
		}
		Set<MediaContent> medias=d.getMedias();
		if(medias!=null) {
			Set<MediaContentDto> set=new HashSet<>();
			for (MediaContent media : medias) {
				MediaContentDto md=new MediaContentDto();
				md.setId(media.getId());
				md.setUrl(media.getUrl());
				set.add(md);
			}
			t.setMediaDtos(set);
		}
		if(d.getBrand()!=null){
			t.setBrandDto(categoryItemDTOAdapter.convert(d.getBrand()));
			t.setBrandId(d.getBrand().getId());
		}
		if(d.getClassify()!=null){
			t.setClassifyDto(categoryItemDTOAdapter.convert(d.getClassify()));
			t.setClassifyId(d.getClassify().getId());
		}
		if(d.getShops()!=null&&d.getShops().size()>0){
			Set<BranchShopDto> set=new HashSet<BranchShopDto>(shopDtoConverter.convertTs(d.getShops()));
			t.setShopDtos(set);
			t.setShopId(set.iterator().next().getShopId());
		}
		return t;
	}
	public Merchandise postConvertD(MerchandiseDto t,Merchandise d){
		return postUpdate(t, d);
	}
	public Merchandise postUpdate(MerchandiseDto t,Merchandise d){
		try {
			d.setIsShelve(Constant.SHELVE);
			if(Constant.ACTUAL.equals(t.getType())){
				d.setType(Constant.ACTUAL);
			}else{
				d.setType(Constant.VIRTUAL);
			}
			if(StringUtils.isNotBlank(t.getMainpicFile().getOriginalFilename())){
				MediaContent media=mediaService.save(t.getMainpicFile());
				d.setMainPicMedia(media);
			}
			Set<MediaContent> medias=d.getMedias();
			if(medias==null){
				medias=new HashSet<>();
			}
			MultipartFile[] mediafFiles=t.getMediaFiles();
			if(mediafFiles!=null) {
				for (MultipartFile mediaFile : mediafFiles) {
					if(StringUtils.isNotBlank(mediaFile.getOriginalFilename())){
						MediaContent media=mediaService.save(mediaFile);
						medias.add(media);
					}
				}
				d.setMedias(medias);
			}
			if(StringUtils.isNotBlank(t.getStart())){
				d.setStartDate(DateUtil.parse(t.getStart()));
			}
			if(StringUtils.isNotBlank(t.getEnd())){
				d.setEndDate(DateUtil.parse(t.getEnd()));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		if(StringUtils.isNotBlank(t.getBrandId())){
			CategoryItem brand=categoryItemRepository.findOne(t.getBrandId());
			d.setBrand(brand);
		}
		if(StringUtils.isNotBlank(t.getClassifyId())){
			CategoryItem classify=categoryItemRepository.findOne(t.getClassifyId());
			d.setClassify(classify);
		}
		System.out.println("dd:"+t.getBranchshopIds());
		if(t.getBranchshopIds()!=null&&t.getBranchshopIds().size()>0){
			Set<BranchShop> set=new HashSet<BranchShop>();
			for(String branchshopId:t.getBranchshopIds()){
				set.add(shopRepository.findOne(branchshopId));
			}
			d.setShops(set);
		}
		return d;
	}
}
