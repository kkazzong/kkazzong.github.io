package com.kkaboard.api.server.service;

import java.util.List;
import java.util.Map;

import com.kkaboard.api.server.dto.input.BoardInputDto;
import com.kkaboard.api.server.dto.output.BoardOutputDto;

public interface BoardService {
	
	public BoardOutputDto getBoard(int boardNo);
	
	public List<BoardOutputDto> getBoardAll(Map<String, Object> param);
	
	public int addBoard(BoardInputDto boardInputDto);
	
	public String getBoardPsd(int boardNo);
	
	public int updBoard(BoardInputDto boardInputDto);
	
	public int delBoard(int boardNo);
}
