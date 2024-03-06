package kr.kh.app.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.RecommendVO;
import kr.kh.app.pagination.Criteria;

public interface BoardDAO {

	boolean insertBoard(@Param("board")BoardVO board);

	ArrayList<CommunityVO> selectCommunityList();

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	int selectTotalCount(@Param("cri")Criteria cri);

	BoardVO selectBoard(@Param("num")int num);

	boolean updateView(@Param("num")int num);

	boolean deleteBoard(@Param("num")int num);

	boolean updateBoard(@Param("board")BoardVO board);

	void insertFile(@Param("file")FileVO file);

	ArrayList<FileVO> selectFileByBo_num(@Param("num")int num);

	void deleteFile(@Param("fi_num")int fi_num);

	FileVO selectFile(@Param("fi_num")int fi_num);

	RecommendVO selectRecommend(@Param("me_id")String me_id, @Param("bo_num")int bo_num);

	void insertRecommend(@Param("re")RecommendVO recommend);

	void updateRecommend(@Param("re")RecommendVO recommend);

}
