package kr.kh.grade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.grade.dao.ManagerDAO;

@Service
public class ManagerServiceImp implements ManagerService {

	@Autowired
	ManagerDAO managerDao;
}
