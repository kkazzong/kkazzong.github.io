package com.kkaboard.api.server.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReplyInputDto {
	
	@JsonProperty("board_no")
	private int board_no;
	
	@JsonProperty("reply_no")
	private int reply_no;
	
	@JsonProperty("reply")
	private String reply;
	
	@JsonProperty("origin_no")
	private int origin_no;
	
	@JsonProperty("reply_depth")
	private int reply_depth;
	
	@JsonProperty("reply_name")
	private String reply_name;
	
	@JsonProperty("write_dt")
	private String write_dt;
}
