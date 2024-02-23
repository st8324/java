package kr.kh.app.service;

import java.util.ArrayList;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;

public interface BoardService {

	boolean insertBoard(BoardVO board);

	ArrayList<CommunityVO> getCommunityList();

}
