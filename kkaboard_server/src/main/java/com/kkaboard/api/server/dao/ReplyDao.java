package com.kkaboard.api.server.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kkaboard.api.server.dto.input.ReplyInputDto;
import com.kkaboard.api.server.dto.output.ReplyOutputDto;

@Repository("replyDao")
public class ReplyDao extends AbstractDAO {
	
	private final String dbName = "replyDB";
	
	@SuppressWarnings("unchecked")
	public List<ReplyOutputDto> getReplyAll(int board_no){
		return (List<ReplyOutputDto>)selectList(dbName+".getReplyAll", board_no);
	}
	
	public int addReply(ReplyInputDto replyInputDto) {
		return (int)insert(dbName+".addReply", replyInputDto);
	}
}
