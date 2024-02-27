package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList();

	boolean insertBoard(@Param("board")BoardVO board);

}
