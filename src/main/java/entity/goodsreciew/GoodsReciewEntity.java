package entity.goodsreciew;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class GoodsReciewEntity {
	private int id;
	private String goodsCode;//商品编号
	@Length(max = 2)
//	@NotEmpty
	private String goodsName;//商品名字
	private int goodsPrice;//商品价格
	private int goodsNum;//商品数量
	private String goodsPath;//商品图片
	private String goodsDescribe;//商品描述
	private String goodsColor;//商品颜色
	private String typeCode;//商品类型编号
	private String agentCode;//代理商编号
	private int goodsTo;//审核状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsPath() {
		return goodsPath;
	}
	public void setGoodsPath(String goodsPath) {
		this.goodsPath = goodsPath;
	}
	public String getGoodsDescribe() {
		return goodsDescribe;
	}
	public void setGoodsDescribe(String goodsDescribe) {
		this.goodsDescribe = goodsDescribe;
	}
	public String getGoodsColor() {
		return goodsColor;
	}
	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public int getGoodsTo() {
		return goodsTo;
	}
	public void setGoodsTo(int goodsTo) {
		this.goodsTo = goodsTo;
	}
	@Override
	public String toString() {
		return "GoodsReciew [id=" + id + ", goodsCode=" + goodsCode + ", goodsName=" + goodsName + ", goodsPrice="
				+ goodsPrice + ", goodsNum=" + goodsNum + ", goodsPath=" + goodsPath + ", goodsDescribe="
				+ goodsDescribe + ", goodsColor=" + goodsColor + ", typeCode=" + typeCode + ", agentCode=" + agentCode
				+ ", goodsTo=" + goodsTo + "]";
	}
	
	
}
