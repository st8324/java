package kr.kh.spring.service;

import java.util.ArrayList;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.pagination.Criteria;

public interface BoardService {

	ArrayList<BoardVO> getBoardList(Criteria cri);

	int getBoardTotalCount(Criteria cri);

}
