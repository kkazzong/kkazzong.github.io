package com.kkaboard.api.server.service;

import java.util.List;
import java.util.Map;

import com.kkaboard.api.server.dto.input.ImageInputDto;
import com.kkaboard.api.server.dto.output.ImageOutputDto;

public interface ImageService {

	
	public int addImage(ImageInputDto imageInputDto);
	
	public List<ImageOutputDto> getImageAll(Map<String, Object> param);
}
