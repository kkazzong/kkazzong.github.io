package com.kkaboard.api.server.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkaboard.api.server.dao.ImageDao;
import com.kkaboard.api.server.dto.input.ImageInputDto;
import com.kkaboard.api.server.dto.output.ImageOutputDto;
import com.kkaboard.api.server.service.ImageService;

@Service("imageService")
public class ImageServiceImpl implements ImageService {

	
	@Resource(name="imageDao")
	private ImageDao imageDao;
	
	@Override
	public int addImage(ImageInputDto imageInputDto) {
		// TODO Auto-generated method stub
		return imageDao.addImage(imageInputDto);
	}

	@Override
	public List<ImageOutputDto> getImageAll(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return imageDao.getImageAll(param);
	}

}
