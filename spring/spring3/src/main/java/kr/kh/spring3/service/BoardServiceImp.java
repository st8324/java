package kr.kh.spring3.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.dao.BoardDAO;
import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.utils.UploadFileUtils;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

	@Resource
	String uploadPath;
	
	private void uploadFile(int bo_num, MultipartFile file) {
		if(file == null || file.getOriginalFilename().length() == 0)
			return;
		try {
			String fileOriName = file.getOriginalFilename();
			//첨부파일 업로드 후 경로를 가져옴
			String fileName = 
				UploadFileUtils.uploadFile(
						uploadPath, 
						fileOriName, 
						file.getBytes());
			FileVO fileVO = new FileVO(bo_num, fileName, fileOriName);
			//DB에 첨부파일 정보를 추가
			boardDao.insertFile(fileVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null)
			cri = new Criteria();
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getBoardTotalCount(Criteria cri) {
		return boardDao.selectBoardTotalCount(cri);
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if( board == null || 
			board.getBo_title() == null || 
			board.getBo_content() == null) {
			return false;
		}
		if(user == null)
			return false;
		board.setBo_me_id(user.getMe_id());
		boolean res = boardDao.insertBoard(board);
		log.info(board);
		if(!res)
			return false;
		if(files == null || files.length == 0)
			return true;
		for(MultipartFile file : files) {
			uploadFile(board.getBo_num(), file);
		}
		return true;
	}

	

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

	@Override
	public void updateView(int num) {
		boardDao.updateView(num);
	}

	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}

	@Override
	public ArrayList<FileVO> getFileList(int num) {
		return boardDao.selectFileList(num);
	}
}
