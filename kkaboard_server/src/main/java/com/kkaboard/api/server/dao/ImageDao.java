package com.kkaboard.api.server.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kkaboard.api.server.dto.input.ImageInputDto;
import com.kkaboard.api.server.dto.output.ImageOutputDto;

@Repository("imageDao")
public class ImageDao extends AbstractDAO {
	
	private final String dbName = "imageDB";
	
	public int addImage(ImageInputDto imageInputDto) {
		return (int)insert(dbName+".addImage", imageInputDto);
	}
	
	@SuppressWarnings("unchecked")
	public List<ImageOutputDto> getImageAll(Map<String, Object> param){
		return (List<ImageOutputDto>)selectList(dbName+".getImageAll", param);
	}
}
