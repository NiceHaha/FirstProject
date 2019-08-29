package entity.stock;

public class StockEntity {
	private int id;
	private String goodsName;//商品名字
	private int num;//总数
	private String goodsCode;//商品编号
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", goodsName=" + goodsName + ", num=" + num + ", goodsCode=" + goodsCode + "]";
	}
	
}
