package com.khit.board.entity;

import com.khit.board.dto.BoardDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_board")
@Entity
public class Board extends BaseEntity{ //테이블이 생성되는 역할을 하는 클래스
	@Id	//pk(프라이머리키)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String boardTitle;
	
	@Column(length = 30, nullable = false)
	private String boardWriter;
	
	@Column(length = 2000, nullable = false)
	private String boardContent;
	
	@Column
	private Integer boardHits;
	
	//dto를 entity롤 변환하는 정적 메서드
	public static Board toSaveEntitiy(BoardDTO boardDTO) {
		Board board = Board.builder()
				.boardTitle(boardDTO.getBoardTitle())
				.boardWriter(boardDTO.getBoardWriter())
				.boardContent(boardDTO.getBoardContent())
				.boardHits(0)
				.build();
		return board;
	}
}
