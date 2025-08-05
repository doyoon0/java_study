package chapter21_mini_project.repository;

import java.util.List;

import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;

public interface CartRepository {
	public List<CartVo> menuCartItemList(String userid);
	public int menuCartClear(String userid);
	public int menuCartAddItem(CartVo cartvo);
	public List<BookVo> bookListAll();
	public int menuCartRemoveItemCount(CartVo cartvo);
	public int menuCartRemoveItem(CartVo cartvo);
}
