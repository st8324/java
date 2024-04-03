package kr.kh.spring3.dao;

import java.util.ArrayList;

import kr.kh.spring3.model.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

}
