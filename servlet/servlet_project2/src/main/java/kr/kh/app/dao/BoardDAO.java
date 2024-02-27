package kr.kh.app.dao;

import java.util.ArrayList;

import kr.kh.app.model.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

}
