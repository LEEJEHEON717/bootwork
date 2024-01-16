package com.khit.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khit.board.dto.BoardDTO;
import com.khit.board.entity.Board;
import com.khit.board.exception.BootBoardException;
import com.khit.board.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;

	public void save(BoardDTO boardDTO) {
		//dto -> entitiy로 변환
		Board board = Board.toSaveEntitiy(boardDTO);
		//entity를 db에 저장
		boardRepository.save(board);
	}

	public List<BoardDTO> findAll() {
		// db에서 entity list를 가져옴
		List<Board> boardList = boardRepository.findAll();
		//게시글을 담을 빈 리스트 생성
		List<BoardDTO> boardDTOList = new ArrayList<>();
		
		for(Board board : boardList) {
			//entity -> dto로 변환
			BoardDTO boardDTO = BoardDTO.toSaveDTO(board);
			boardDTOList.add(boardDTO);
		}	
		return boardDTOList;
	}

	public BoardDTO findById(Long id) {
		Optional<Board> findboard = boardRepository.findById(id);
		if(findboard.isPresent()) { //검색한 게시글이 있으면 dto를 컨트롤러로 반환함
			BoardDTO boardDTO = BoardDTO.toSaveDTO(findboard.get());
			return boardDTO;
		}else { //게시글이 없으면 에러 처리
			throw new BootBoardException("게시글을 찾을 수 없습니다.");
		}
	}
}
