package kr.kh.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;

public interface AccountDAO {

	List<Type> selectTypeList();

	List<Category> selectCategoryList(@Param("ty_name")String type);

	boolean insertItem(@Param("item")Item item);

}
