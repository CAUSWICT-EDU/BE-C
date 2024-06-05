package com.yourpackage.service;

import com.yourpackage.entity.Board;
import com.yourpackage.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository repository;

    public List<Board> getAllBoards() {
        return repository.findAll();
    }

    public Board getBoardById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Board saveBoard(Board board) {
        return repository.save(board);
    }

    public void deleteBoard(Integer id) {
        repository.deleteById(id);
    }
}
