package edu.kh.test.user.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	int user_no;
	String user_id;
	String user_name;
	int user_age;
}
