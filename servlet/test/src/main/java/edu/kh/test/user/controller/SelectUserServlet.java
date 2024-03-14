package edu.kh.test.user.controller;

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

import edu.kh.test.user.model.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;

@WebServlet("/select/user")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDao;
	
    public SelectUserServlet() {
    	String resource = "edu/kh/test/user/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			userDao = session.getMapper(UserDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		UserDTO user = userDao.selectUser(num);
		request.setAttribute("user", user);
		if(user != null) {
			request.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/views/searchFail.jsp").forward(request, response);
		}
	}
	
}
