package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {
	int fi_num; 
	int fi_bo_num; 
	String fi_name; 
	String fi_ori_name;

	public FileVO(int bo_num, String fileName, String fileOriName) {
		this.fi_bo_num = bo_num;
		this.fi_name= fileName;
		this.fi_ori_name = fileOriName;
	}
}
