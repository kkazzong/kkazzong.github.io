package com.kkaboard.api.server.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kkaboard.api.server.dto.input.ReplyInputDto;
import com.kkaboard.api.server.dto.output.ReplyOutputDto;
import com.kkaboard.api.server.service.ReplyService;

@RestController
public class ReplyController {

	@Resource(name="replyService")
	private ReplyService replyService;
	
	@GetMapping("/reply/test")
	public String test() {
		return "hello reply controller!";
	}
	
	@PostMapping("/reply/add-reply")
	public int addReply(@RequestBody ReplyInputDto replyInputDto) {
		return replyService.addReply(replyInputDto);
	}
	
	@GetMapping("/reply/get-reply-all/{boardNo}")
	public List<ReplyOutputDto> getReplyAll(@PathVariable int boardNo){
		return replyService.getReplyAll(boardNo);
	}
}
