package com.kkaboard.api.server.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kkaboard.api.server.dto.input.ImageInputDto;
import com.kkaboard.api.server.dto.output.ImageOutputDto;
import com.kkaboard.api.server.service.ImageService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ImageController {

	
	@Resource(name="imageService")
	private ImageService imageService;
	
	@Value("${file.tmp.upload}")
	private String TMP_UPLOAD_PATH;
	
	@GetMapping("/image/test")
	public String test() {
		return "Hello image";
	}
	
	@PostMapping("/image/upload-image")
	public Map<String, Object> uploadImage(@RequestParam MultipartFile files) {
		
		String originalFileName = files.getOriginalFilename();
		
		/* file upload start */
		String file_path = TMP_UPLOAD_PATH + "/" + originalFileName;
		File dest = new File(file_path);
		try {
			files.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* file upload end */
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("file_path", file_path);
		
		return result;
	}
	
	@PostMapping("/image/upload-image-blob")
	public Map<String, Object> uploadImageBlob(@RequestParam String file_blob) {
		log.info(file_blob);
		return null;
	}
	
	@PostMapping("/image/add-image")
	public int addImage(@RequestBody ImageInputDto imageInputDto) {
		return imageService.addImage(imageInputDto);
	}
	
	@GetMapping("/image/get-image-all")
	public List<ImageOutputDto> getImageAll(){
		return imageService.getImageAll(null);
	}
	
}
