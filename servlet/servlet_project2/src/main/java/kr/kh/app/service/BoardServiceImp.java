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

public class BoardServiceImp implements BoardService {

	private BoardDAO boardDao;
	private String uploadPath = "D:\\uploads";
	
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdirs();
		}
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		//현재 페이지정보 null 처리 
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public boolean insertBoard(BoardVO board, ArrayList<Part> partList) {
		if( board == null || 
			!checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		
		boolean res = boardDao.insertBoard(board);
		//게시글 등록에 실패한 경우
		if(!res) {
			return false;
		}
		//첨부파일이 없는 경우
		if(partList == null || partList.size() == 0) {
			return true;
		}
		for(Part part : partList) {
			uploadFile(part, board.getBo_num());
		}
		return true;
	}
	
	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectTotalCount(cri);
	}

	@Override
	public boolean updateView(int num) {
		return boardDao.updateView(num);
	}

	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}

	@Override
	public boolean deleteBoard(int num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//게시글을 가져옴
		BoardVO board = boardDao.selectBoard(num);
		//게시글이 없거나 작성자가 아니면 false를 리턴
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		
		//첨부파일을 삭제
		//게시글 번호에 맞는 첨부파일을 가져오라고 시킴
		ArrayList<FileVO> fileList = boardDao.selectFileList(num);
		for(FileVO file : fileList) {
			deleteFile(file);
		}
		
		//게시글을 삭제 요청
		return boardDao.deleteBoard(num);
	}

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user, String[] nums, ArrayList<Part> partList) {
		//게시글 null 체크
		if( board == null || 
			!checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		//회원 null 체크
		if(user == null) {
			return false;
		}
		//게시글 번호를 이용하여 게시글을 가져옴 
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		//게시글이 없거나 게시글 작성자가 회원이 아니면 false를 리턴
		if(dbBoard == null || !dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		
		//삭제할 첨부파일 삭제
		for(String numStr : nums) {
			try {
				int num = Integer.parseInt(numStr);
				FileVO fileVo = boardDao.selectFile(num);
				deleteFile(fileVo);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//추가할 첨부파일 추가
		for(Part part : partList) {
			uploadFile(part, board.getBo_num());
		}
		
		//서비스에게 게시글을 주면서 수정하라고 요청
		return boardDao.updateBoard(board);
	}
	@Override
	public ArrayList<FileVO> getFileList(int num) {
		return boardDao.selectFileList(num);
	}
	
	private void uploadFile(Part part, int bo_num) {
		if(part == null || bo_num == 0) {
			return;
		}
		//서버에 업로드
		String fileOriginalName = FileUploadUtils.getFileName(part);
		if(!checkString(fileOriginalName)) {
			return;
		}
		String fileName = FileUploadUtils.upload(uploadPath, part);
		//DB에 추가
		FileVO fileVo =new FileVO(bo_num, fileName, fileOriginalName);
		boardDao.insertFile(fileVo);
	}

	//문자열이 null이거나 빈 문자열이면 false, 아니면 true를 반환하는 메서드
	public boolean checkString(String str) {
		if(str == null || str.length() == 0) {
			return false;
		}
		return true;
	}
	private void deleteFile(FileVO file) {
		if(file == null) {
			return;
		}
		String fileName = uploadPath + 
				file.getFi_name().replace('/', File.separatorChar);
		//서버에서 실제 파일을 삭제
		FileUploadUtils.deleteFile(fileName);
		boardDao.deleteFile(file.getFi_num());
	}
	
}
