package com.ncs.test.dao;

import org.apache.ibatis.annotations.Param;

import com.ncs.test.model.vo.Board;

public interface BoardDAO {

	Board selectBoard(@Param("boNum")int boNum);

}
