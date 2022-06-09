package com.kkaboard.api.server.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ImageOutputDto {

	@JsonProperty("board_no")
	private int board_no;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("file_name")
	private String file_name;
	
	@JsonProperty("file_path")
	private String file_path;
	
	@JsonProperty("write_dt")
	private String write_dt;
	
	@JsonProperty("file_blob")
	private String file_blob;
}
