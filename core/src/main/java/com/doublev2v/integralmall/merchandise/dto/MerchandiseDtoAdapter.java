package com.doublev2v.integralmall.merchandise.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doublev2v.foundation.core.dto.SimpleAbstractDtoAdater;
import com.doublev2v.foundation.core.dto.polymorphic.PolymorphicDtoAdapter;
import com.doublev2v.integralmall.merchandise.Merchandise;

@Component
public class MerchandiseDtoAdapter extends SimpleAbstractDtoAdater<Merchandise, MerchandiseDto> {
	
	@Autowired
	private List<PolymorphicDtoAdapter<Merchandise,MerchandiseDto>> adapters;

	@Override
	public MerchandiseDto convert(Merchandise d) {
		for (PolymorphicDtoAdapter<Merchandise, MerchandiseDto> adapter : adapters) {
			if(adapter.support(d)){
				return adapter.convert(d);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	
	@Override
	public Merchandise convertToDo(MerchandiseDto t) {
		for (PolymorphicDtoAdapter<Merchandise, MerchandiseDto> adapter : adapters) {
			if(adapter.supportT(t)){
				return adapter.reConvert(t);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	@Override
	public Merchandise update(MerchandiseDto t, Merchandise d) {
		for (PolymorphicDtoAdapter<Merchandise, MerchandiseDto> adapter : adapters) {
			if(adapter.supportT(t)){
				return adapter.update(t,d);
			}
		}
		throw new RuntimeException("没有合适的转换器");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 *
	@Autowired
	private MediaService mediaService;
	@Autowired
	private CategoryItemRepository categoryItemRepository;
	@Autowired
	private CategoryItemDTOAdapter categoryItemDTOAdapter;
	
	@Override
	public MerchandiseDto convert(Merchandise d) {
//		if(d.getExpiryDate()!=null){
//			t.setExpiryTime(d.getExpiryDate().format(DateTimeFormatter.ISO_DATE));
//		}
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
	public Merchandise postConvertToDo(MerchandiseDto t, Merchandise d) {
		return postUpdate(t,d);
	}

	@Override
	public Merchandise postUpdate(MerchandiseDto t, Merchandise d) {
		try {
			d.setIsShelve(Constant.SHELVE);//设置商品为上架
			switch(t.getIsActual()){
				case Constant.VIRTUAL:
					Coupon coupon=new Coupon();
					if(StringUtils.isNotBlank(t.getExpiryTime())){
						LocalDateTime expiryDate=LocalDateTime.parse(t.getExpiryTime()+"T23:59:59", DateTimeFormatter.ISO_DATE_TIME);
						coupon.setExpiryDate(expiryDate);
					}else{
						coupon.setExpiryDate(null);
					}
					
					break;
				case Constant.ACTUAL:
					Gift gift=new Gift();
					gift.setPrice(t.getPrice());
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
	}*/
}
