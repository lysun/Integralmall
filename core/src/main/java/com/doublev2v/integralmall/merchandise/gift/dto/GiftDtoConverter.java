package com.doublev2v.integralmall.merchandise.gift.dto;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.core.dto.polymorphism.SimplePolymorphismConverter;
import com.doublev2v.foundation.dics.CategoryItem;
import com.doublev2v.foundation.dics.CategoryItemRepository;
import com.doublev2v.foundation.dics.dto.CategoryItemDTOConverter;
import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.foundation.media.MediaContentDto;
import com.doublev2v.foundation.media.MediaService;
import com.doublev2v.integralmall.merchandise.Merchandise;
import com.doublev2v.integralmall.merchandise.dto.MerchandiseDto;
import com.doublev2v.integralmall.merchandise.gift.Gift;
import com.doublev2v.integralmall.util.Constant;

@Component
public class GiftDtoConverter extends SimplePolymorphismConverter<Gift,GiftDto,Merchandise, MerchandiseDto> {
	@Autowired
	private MediaService mediaService;
	@Autowired
	private CategoryItemRepository categoryItemRepository;
	@Autowired
	private CategoryItemDTOConverter categoryItemDTOAdapter;
	@Override
	public MerchandiseDto postConvert(Merchandise d, MerchandiseDto t) {
		GiftDto gt=(GiftDto)t;
		Gift gd=(Gift)d;
		gt.setPrice(gd.getPrice());
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
		return t;
	}
	@Override
	public Merchandise postConvertD(MerchandiseDto t, Merchandise d) {
		return postUpdate(t, d);
	}
	@Override
	public Merchandise postUpdate(MerchandiseDto t, Merchandise d) {
		GiftDto gt=(GiftDto)t;
		Gift gd=(Gift)d;
		try {
			d.setIsShelve(Constant.SHELVE);//设置商品为上架
			gd.setPrice(gt.getPrice());
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
			if(StringUtils.isNotBlank(t.getBrandId())){
				CategoryItem brand=categoryItemRepository.findOne(t.getBrandId());
				d.setBrand(brand);
			}
			if(StringUtils.isNotBlank(t.getClassifyId())){
				CategoryItem classify=categoryItemRepository.findOne(t.getClassifyId());
				d.setClassify(classify);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return d;
	}
}
