package entity.agent;

import org.hibernate.validator.constraints.NotEmpty;

public class Agent {
	private int id;// 代理商id
	@NotEmpty
	private String agent_name;// 代理商名称
	@NotEmpty
	private String agent_city;// 代理商地址
	private String agent_tel;// 代理商联系方式
	private String agent_code;//代理商code
	private String brand_code;// 关联的品牌code
	private String brand_name;// 关联的品牌名称
	private int pageNow = 1;// 分页当前页数
	private int pageSize = 2;// 分页每条多少条数据
	private int pageCount;// 分页数据的总数据
	private int pageSun;// 分页的总页数

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSun() {
		return pageSun;
	}

	public void setPageSun(int pageSun) {
		this.pageSun = pageSun;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name;
	}

	public String getAgent_city() {
		return agent_city;
	}

	public void setAgent_city(String agent_city) {
		this.agent_city = agent_city;
	}

	public String getAgent_tel() {
		return agent_tel;
	}

	public void setAgent_tel(String agent_tel) {
		this.agent_tel = agent_tel;
	}

	public String getBrand_code() {
		return brand_code;
	}

	public void setBrand_code(String brand_code) {
		this.brand_code = brand_code;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getAgent_code() {
		return agent_code;
	}

	public void setAgent_code(String agent_code) {
		this.agent_code = agent_code;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", agent_name=" + agent_name + ", agent_city=" + agent_city + ", agent_tel="
				+ agent_tel + ", agent_code=" + agent_code + ", brand_code=" + brand_code + ", brand_name=" + brand_name
				+ ", pageNow=" + pageNow + ", pageSize=" + pageSize + ", pageCount=" + pageCount + ", pageSun="
				+ pageSun + "]";
	}
}
