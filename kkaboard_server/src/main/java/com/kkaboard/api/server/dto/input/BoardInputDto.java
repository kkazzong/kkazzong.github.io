package com.kkaboard.api.server.dto.input;

import lombok.Data;

@Data
public class BoardInputDto {

	public int board_no;
	
	public String writer_name;
	
	public String board_password;
	
	public String title;
	
	public String content;
	
	public String write_dt;
	
}
