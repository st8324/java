package kr.kh.app.service;

import java.io.File;
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
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.utils.FileUploadUtils;

public class BoardServiceImp implements BoardService{

	private BoardDAO boardDao;
	private String uploadPath = "D:\\uploads";
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
	public boolean insertBoard(BoardVO board , ArrayList<Part> partList) {
		if( board == null || 
			!checkString(board.getBo_content()) || 
			!checkString(board.getBo_title())) {
			return false;
		}
		if(!checkString(board.getBo_me_id())) {
			return false;
		}
		boolean res = boardDao.insertBoard(board);
		
		if(!res) {
			return false;
		}
		
		//첨부파일 업로드
		for(Part filePart : partList) {
			uploadFile(filePart, board.getBo_num());
		}
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
		
		//게시글의 첨부파일을 서버 폴더에서 삭제(실제 파일)
		//게시글의 첨부파일을 DB에서 삭제
		//게시글에 있는 첨부파일 정보을 가져옴
		//FileVO file = boardDao.selectFileByBo_num(num);
		
		//deleteFile(file);
				
		//같으면 게시글 삭제 후 삭제 여부를 반환
		return boardDao.deleteBoard(num);
	}

	

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user, ArrayList<Integer> nums, ArrayList<Part> fileList) {
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
		
		//첨부파일 추가
		for(Part file : fileList) {
			uploadFile(file, board.getBo_num());
		}
		
		//첨부파일 삭제
		for(int fi_num : nums) {
			FileVO fileVo = boardDao.selectFile(fi_num);
			deleteFile(fileVo);
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
	private void uploadFile(Part filePart, int bo_num) {
		//업로드할 첨부 파일이 없으면
		if(filePart == null) {
			return ;
		}
		String fileOriName = FileUploadUtils.getFileName(filePart);
		if(fileOriName == null || fileOriName.length() == 0) {
			return;
		}
		String fileName = FileUploadUtils.upload(uploadPath, filePart);
		FileVO file = new FileVO(bo_num, fileName, fileOriName);
		boardDao.insertFile(file);
	}
	
	private void deleteFile(FileVO fileVo) {
		if(fileVo == null) {
			return;
		}
		File file = new File(uploadPath 
				+ fileVo.getFi_name().replace('/', File.separatorChar));
		if(file.exists()) {
			file.delete();
		}
		boardDao.deleteFile(fileVo.getFi_num());
	}

	@Override
	public ArrayList<FileVO> getFile(int num) {
		return boardDao.selectFileByBo_num(num);
	}
}



