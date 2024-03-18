package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // 컨트롤러임을 인지시킴
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write") // 127.0.0.1:8090/board/write
    public String boardWriteForm(){

        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    @ResponseBody
    public String boardWritePro(Board board){

        boardService.write(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("List", boardService.boardList()); // boardService.boardLise에 반한된 리스트를 앞 "List"에 넘김

        return "boardlist";
    }

    @GetMapping("/board/view") // ex) 127.0.0.1:8090/board/view?id=1
    public String boardView(Model model, @RequestParam(name = "id") Integer id){

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(@RequestParam(name = "id") Integer id){

        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") @RequestParam(name = "id") Integer id){

        return "boardmodify";
    }
}
