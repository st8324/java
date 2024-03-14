package kr.kh.test.model.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.model.vo.BoardVO;

public interface BoardDAO {

	BoardVO selectBoard(@Param("bo_num")int boNum);

}
