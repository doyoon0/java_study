package chapter21_mini_project.repository;

import java.util.List;

import chapter21_mini_project.model.BookVo;
import chapter21_mini_project.model.CartVo;
import chapter21_mini_project.model.ReceiptVo;

public interface CartRepository {
	public List<CartVo> cartList(String userid);
	public int clear(String userid);
	public int add(CartVo cartvo);
	public List<BookVo> bookListAll();
	public int reduce(CartVo cartvo);
	public int remove(CartVo cartvo);
	public List<ReceiptVo> receipt(String userid, String address);
}
