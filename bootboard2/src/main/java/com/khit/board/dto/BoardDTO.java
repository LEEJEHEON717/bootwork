package com.khit.board.dto;

import java.sql.Timestamp;
import java.util.List;

import com.khit.board.entity.Board;
import com.khit.board.entity.Member;
import com.khit.board.entity.Reply;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BoardDTO {
	
	private Integer id;
	
	private String title;
	
	private String content;
	
	private Member member;
	
	private List<Reply> replyList;
	
	private Timestamp createdDate;
	
	private Timestamp updateDate;
	
	//entity -> dto
	public static BoardDTO toSaveDTO(Board board) {
		BoardDTO boardDTO = BoardDTO.builder()
				.id(board.getId())
				.title(board.getTitle())
				.content(board.getContent())
				.member(board.getMember())
				.replyList(board.getReplyList())
				.createdDate(board.getCreatedDate())
				.updateDate(board.getUpdatedDate())
				.build();
		
		return boardDTO;
	}
}

