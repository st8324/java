package kr.kh.test.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.test.model.dao.BoardDAO;
import kr.kh.test.model.vo.BoardVO;

@WebServlet("/select/board")
public class SelectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardDAO boardDao;
	
    public SelectBoardServlet() {
    	String resource = "kr/kh/test/config/mybatis-config.xml";
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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boNum = 0;
		try {
			boNum = Integer.parseInt(request.getParameter("boardNum"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		BoardVO board = boardDao.selectBoard(boNum);
		request.setAttribute("board", board);
		if(board != null) {
			request.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/searchFail.jsp").forward(request, response);
		}
	}
	
}
