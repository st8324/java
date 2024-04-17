package com.ncs.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.test.dao.BoardDAO;
import com.ncs.test.model.vo.Board;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

	@Override
	public Board getBoard(Board board) {
		if(board == null)
			return null;
		return boardDao.selectBoard(board.getBoNum());
	}
}
