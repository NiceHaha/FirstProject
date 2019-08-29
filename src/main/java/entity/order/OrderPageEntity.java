package entity.order;

import java.util.ArrayList;
import java.util.List;

public class OrderPageEntity<T> {
	private List<T> list = new ArrayList<T>();
	private OrderPage page;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public OrderPage getPage() {
		return page;
	}

	public void setPage(OrderPage page) {
		this.page = page;
	}
}
