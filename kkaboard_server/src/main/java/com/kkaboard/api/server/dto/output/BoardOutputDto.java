package com.kkaboard.api.server.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
public class BoardOutputDto {

	@JsonProperty("rn")
	public int rn;
	
	@JsonProperty("board_no")
	public int board_no;
	
	@JsonProperty("title")
	public String title;
	
	@JsonProperty("content")
	public String content;
	
	@JsonProperty("writer_name")
	public String writer_name;
	
	@JsonProperty("view_cnt")
	public int view_cnt;
	
	@JsonProperty("reply_cnt")
	public String reply_cnt;
	
	@JsonProperty("board_password")
	public String board_password;
	
	@JsonProperty("write_dt")
	public String write_dt;
}
