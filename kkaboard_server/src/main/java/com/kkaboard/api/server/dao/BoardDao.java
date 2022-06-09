package com.kkaboard.api.server.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kkaboard.api.server.dto.input.BoardInputDto;
import com.kkaboard.api.server.dto.output.BoardOutputDto;

@Repository("boardDao")
public class BoardDao extends AbstractDAO {
	
	private final String dbName = "boardDB";
	
	public BoardOutputDto getBoard(int boardNo) {
		return (BoardOutputDto)selectOne(dbName+".getBoard", boardNo);
	}
	
	@SuppressWarnings("unchecked")
	public List<BoardOutputDto> getBoardAll(Map<String, Object> param){
		return (List<BoardOutputDto>)selectList(dbName+".getBoardAll", param);
	}
	
	public int plusViewCnt(int boardNo) {
		return (int)update(dbName+".plusViewCnt", boardNo);
	}
	
	public int addBoard(BoardInputDto boardInputDto) {
		return (int)insert(dbName+".addBoard", boardInputDto);
	}
	
	public String getBoardPsd(int boardNo) {
		return (String)selectOne(dbName+".getBoardPsd", boardNo);
	}
	
	public int updBoard(BoardInputDto boardInputDto) {
		return (int)update(dbName+".updBoard", boardInputDto);
	}
	
	public int delBoard(int boardNo) {
		return (int)delete(dbName+".delBoard", boardNo);
	}
}
