package kr.kh.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.pagination.Criteria;

public interface BoardDAO {

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectBoardTotalCount(@Param("cri")Criteria cri);

	ArrayList<CommunityVO> selectCommunityList();

	boolean insertBoard(@Param("bo")BoardVO board);

	void insertFile(@Param("fi")FileVO fileVo);

	BoardVO selectBoard(@Param("bo_num")int boNum);

	void updateView(@Param("bo_num")int boNum);

	ArrayList<FileVO> selectFileList(@Param("bo_num")int boNum);

}
