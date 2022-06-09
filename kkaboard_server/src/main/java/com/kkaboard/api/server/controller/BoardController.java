package com.kkaboard.api.server.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kkaboard.api.server.dto.input.BoardInputDto;
import com.kkaboard.api.server.dto.output.BoardOutputDto;
import com.kkaboard.api.server.service.BoardService;


/**
 * C : post
 * R : get
 * U : put
 * D : delete
 * @author kkazzong
 * */
@RestController
public class BoardController {
	
	@Resource(name="boardService")
	private BoardService boardService;

	@GetMapping("/test")
	public String test() {
		return "hello kkaboard server!";
	}
	
	@PostMapping("/board/add-board")
	public int addBoard(@RequestBody BoardInputDto boardInputDto) {
		return boardService.addBoard(boardInputDto);
	}
	
	@GetMapping("/board/get-board/{boardNo}")
	public BoardOutputDto getBoard(@PathVariable int boardNo) {
		return boardService.getBoard(boardNo);
	}
	
	@GetMapping("/board/get-board-all")
	public List<BoardOutputDto> getBoardAll() {
		return boardService.getBoardAll(null);
	}
	
	@GetMapping("/board/check-board-psd/{boardNo}")
	public String checkBoardPsd(@PathVariable int boardNo) {
		return boardService.getBoardPsd(boardNo);
	}
	
	@PutMapping("/board/upd-board")
	public int updBoard(@RequestBody BoardInputDto boardInputDto) {
		return boardService.updBoard(boardInputDto);
	}
	
	@DeleteMapping("/board/del-board/{boardNo}")
	public int delBoard(@PathVariable int boardNo) {
		return boardService.delBoard(boardNo);
	}
	
}
