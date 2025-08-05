package chapter21_mini_project.service;

public interface CartService {
	public void menuCartItemList(String userid);
	public void menuCartClear(String userid);
	public void menuCartAddItem(String userid);
	public void menuCartRemoveItemCount(String userid);
	public void menuCartRemoveItem(String userid);
	public void menuCartBill(String userid);
	public void menuExit();
}
