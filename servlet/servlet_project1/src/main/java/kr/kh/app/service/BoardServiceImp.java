package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;

public class BoardServiceImp implements BoardService{

	private BoardDAO boardDao;
	
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertBoard(BoardVO board , Part filePart) {
		if( board == null || 
			!checkString(board.getBo_content()) || 
			!checkString(board.getBo_title())) {
			return false;
		}
		if(!checkString(board.getBo_me_id())) {
			return false;
		}
		boolean res = boardDao.insertBoard(board);
		
		return res;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectTotalCount(cri);
	}

	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}

	@Override
	public boolean updateView(int num) {
		return boardDao.updateView(num);
	}

	@Override
	public boolean deleteBoard(int num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//다오에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardDao.selectBoard(num);
		//게시글이 없거나 게시글 작성자와 회원 아이디가 다르면 false 반환
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//같으면 게시글 삭제 후 삭제 여부를 반환
		return boardDao.deleteBoard(num);
	}

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if( board == null || 
			!checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		//게시글 번호를 이용하여 게시글을 가져옴
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		//게시글 작성자와 회원 아이디를 비교하여 다르면 false 반환
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//같으면 게시글 수정
		return boardDao.updateBoard(board);
	}
	private boolean checkString(String str) {
		if(str == null || str.length() == 0) {
			return false;
		}
		return true;
	}
}



