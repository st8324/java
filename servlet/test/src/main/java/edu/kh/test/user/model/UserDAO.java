package edu.kh.test.user.model;

import org.apache.ibatis.annotations.Param;

import edu.kh.test.user.model.vo.UserDTO;

public interface UserDAO {

	UserDTO selectUser(@Param("num")int num);

}
