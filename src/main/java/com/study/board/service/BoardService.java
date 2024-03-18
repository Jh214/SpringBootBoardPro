package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired // 스프링이 알아서 읽어와서 boardRepository에 주입해주는 어노테이션(디펜던시 인젝션)
    private BoardRepository boardRepository;

//    글 작성
    public void write(Board board){

        boardRepository.save(board);
    }

//    게시글 리스트 처리
    public List<Board> boardList(){

        return boardRepository.findAll(); // 리시트에 보드라는 클래스가 담긴 리스트를 반환해주는 기능 findAll()
    }

//    특정 게시글 불러오기
    public Board boardView(Integer id){

        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id){

        boardRepository.deleteById(id);
    }
}
