package entity.order;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderEntity {
	private Integer id;//id
	private String orderCode;//编码
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Past
	private Date orderDate;//发货时间
	private String shippingAddr;//发货地址
	@NotEmpty
	private String receivingAddr;//收货地址
	@NotEmpty
	private String receiver;//收货人
	private Integer goodsNum;//商品数量
	private Double goodsPrice;//订单价
	private Integer orderStatus;//是否取消订单
	private Integer receiptStatus;//是否收货
	@Future
//	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date receiptTime;//收货时间
	private Integer paymentStatus;//付款1表示已付款2表示未付款3表示已退款
	private Integer logisticsCode;//物流编号
	private Integer expressCode;//快递
	private Integer payment;//支付方式
	private String goodsName;//商品名称
	private String goodsCode;//商品编号
	private String orderDescride;//描述
	private String userCode;//购买人编号
	private int deletes;//删除 1表示删除2表示已删除
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getDeletes() {
		return deletes;
	}
	public void setDeletes(int deletes) {
		this.deletes = deletes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getShippingAddr() {
		return shippingAddr;
	}
	public void setShippingAddr(String shippingAddr) {
		this.shippingAddr = shippingAddr;
	}
	public String getReceivingAddr() {
		return receivingAddr;
	}
	public void setReceivingAddr(String receivingAddr) {
		this.receivingAddr = receivingAddr;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getReceiptStatus() {
		return receiptStatus;
	}
	public void setReceiptStatus(Integer receiptStatus) {
		this.receiptStatus = receiptStatus;
	}
	public Date getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getLogisticsCode() {
		return logisticsCode;
	}
	public void setLogisticsCode(Integer logisticsCode) {
		this.logisticsCode = logisticsCode;
	}
	public Integer getExpressCode() {
		return expressCode;
	}
	public void setExpressCode(Integer expressCode) {
		this.expressCode = expressCode;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getOrderDescride() {
		return orderDescride;
	}
	public void setOrderDescride(String orderDescride) {
		this.orderDescride = orderDescride;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderCode=" + orderCode + ", orderDate=" + orderDate + ", shippingAddr="
				+ shippingAddr + ", receivingAddr=" + receivingAddr + ", receiver=" + receiver + ", goodsNum="
				+ goodsNum + ", goodsPrice=" + goodsPrice + ", orderStatus=" + orderStatus + ", receiptStatus="
				+ receiptStatus + ", receiptTime=" + receiptTime + ", paymentStatus=" + paymentStatus
				+ ", logisticsCode=" + logisticsCode + ", expressCode=" + expressCode + ", payment=" + payment
				+ ", goodsName=" + goodsName + ", goodsCode=" + goodsCode + ", orderDescride=" + orderDescride
				+ ", userCode=" + userCode + ", deletes=" + deletes + "]";
	}
	
}
