package entity.brand;

import org.hibernate.validator.constraints.NotEmpty;

public class Brand {
	private int id;//品牌id
	@NotEmpty
	private String brand_name;//品牌称呢
	private String Brand_tel;//品牌电话
	private String code;//品牌编号
	private String brand_url;//品牌图片
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getBrand_tel() {
		return Brand_tel;
	}
	public void setBrand_tel(String brand_tel) {
		Brand_tel = brand_tel;
	}
	public int getId() {
		return id;
	}
	public String getBrand_url() {
		return brand_url;
	}
	public void setBrand_url(String brand_url) {
		this.brand_url = brand_url;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Brand [id=" + id + ", brand_name=" + brand_name + ", Brand_tel=" + Brand_tel + ", code=" + code
				+ ", brand_url=" + brand_url + "]";
	}
	
}
