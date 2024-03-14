package kr.kh.grade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.grade.dao.SutdentDAO;

@Service
public class SutdentServiceImp implements SutdentService {

	@Autowired
	SutdentDAO SutdentDao;
}
