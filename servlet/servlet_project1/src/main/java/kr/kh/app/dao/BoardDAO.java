package kr.kh.app.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO board);

}
