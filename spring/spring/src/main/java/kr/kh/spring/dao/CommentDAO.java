package kr.kh.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.pagination.Criteria;

public interface CommentDAO {

	ArrayList<CommentVO> selectCommentList(@Param("cri")Criteria cri);

	int selectTotalCount(@Param("cri")Criteria cri);

}
