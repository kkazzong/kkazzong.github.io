package com.kkaboard.api.server.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kkaboard.api.server.dao.BoardDao;
import com.kkaboard.api.server.dto.input.BoardInputDto;
import com.kkaboard.api.server.dto.output.BoardOutputDto;
import com.kkaboard.api.server.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name="boardDao")
	private BoardDao boardDao;
	
	@Override
	public BoardOutputDto getBoard(int boardNo) {
		// TODO Auto-generated method stub
		boardDao.plusViewCnt(boardNo);
		return boardDao.getBoard(boardNo);
	}

	@Override
	public List<BoardOutputDto> getBoardAll(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return boardDao.getBoardAll(param);
	}

	@Override
	public int addBoard(BoardInputDto boardInputDto) {
		// TODO Auto-generated method stub
		return boardDao.addBoard(boardInputDto);
	}

	@Override
	public String getBoardPsd(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.getBoardPsd(boardNo);
	}

	@Override
	public int updBoard(BoardInputDto boardInputDto) {
		// TODO Auto-generated method stub
		return boardDao.updBoard(boardInputDto);
	}

	@Override
	public int delBoard(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.delBoard(boardNo);
	}

}
