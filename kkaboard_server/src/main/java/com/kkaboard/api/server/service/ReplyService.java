package com.kkaboard.api.server.service;

import java.util.List;

import com.kkaboard.api.server.dto.input.ReplyInputDto;
import com.kkaboard.api.server.dto.output.ReplyOutputDto;

public interface ReplyService {
	
	public List<ReplyOutputDto> getReplyAll(int board_no);
	
	public int addReply(ReplyInputDto replyInputDto);
}
