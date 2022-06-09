package com.kkaboard.api.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkaboard.api.server.dao.ReplyDao;
import com.kkaboard.api.server.dto.input.ReplyInputDto;
import com.kkaboard.api.server.dto.output.ReplyOutputDto;
import com.kkaboard.api.server.service.ReplyService;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Resource(name="replyDao")
	private ReplyDao replyDao;
	
	@Override
	public List<ReplyOutputDto> getReplyAll(int board_no) {
		// TODO Auto-generated method stub
		return replyDao.getReplyAll(board_no);
	}

	@Override
	public int addReply(ReplyInputDto replyInputDto) {
		// TODO Auto-generated method stub
		return replyDao.addReply(replyInputDto);
	}

}
