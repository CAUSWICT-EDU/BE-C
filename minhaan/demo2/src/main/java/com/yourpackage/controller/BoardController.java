package com.yourpackage.controller;

import com.yourpackage.entity.Board;
import com.yourpackage.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping
    public List<Board> getAllBoards() {
        return service.getAllBoards();
    }

    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable Integer id) {
        return service.getBoardById(id);
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return service.saveBoard(board);
    }

    @PutMapping("/{id}")
    public Board updateBoard(@PathVariable Integer id, @RequestBody Board board) {
        board.setBoard_id(id);
        return service.saveBoard(board);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Integer id) {
        service.deleteBoard(id);
    }
}

