package com.kkaboard.api.server.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ReplyOutputDto {
	
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
