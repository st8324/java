package kr.kh.spring.service;

import java.util.ArrayList;

import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.pagination.Criteria;

public interface CommentService {

	ArrayList<CommentVO> getCommentList(Criteria cri);

	int getTotalCount(Criteria cri);

}
