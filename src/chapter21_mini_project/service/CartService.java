package chapter21_mini_project.service;

public interface CartService {
	public void cartList(String userid);
	public void clear(String userid);
	public void add(String userid);
	public void reduce(String userid);
	public void remove(String userid);
	public void receipt(String userid);
	public void exit();
}
