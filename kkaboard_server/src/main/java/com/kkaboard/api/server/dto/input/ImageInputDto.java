package com.kkaboard.api.server.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ImageInputDto {
	
	@JsonProperty("board_no")
	private int board_no;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("file_name")
	private String file_name;
	
	@JsonProperty("file_path")
	private String file_path;
	
	@JsonProperty("file_blob")
	private String file_blob;
}
