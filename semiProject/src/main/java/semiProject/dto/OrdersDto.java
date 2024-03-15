package semiProject.dto;

import java.sql.Date;

public class OrdersDto {
	private int ordersNo;
	private int memberNo;
	private int storeNo;
	private String storeName;
	private int menuNo;
	private String menuName;
	private int ordersQty;
	private int ordersTotal;
	private Date ordersTime;
	public OrdersDto() {
		super();
	}
	public int getOrdersNo() {
		return ordersNo;
	}
	public void setOrdersNo(int ordersNo) {
		this.ordersNo = ordersNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getOrdersQty() {
		return ordersQty;
	}
	public void setOrdersQty(int ordersQty) {
		this.ordersQty = ordersQty;
	}
	public int getOrdersTotal() {
		return ordersTotal;
	}
	public void setOrdersTotal(int ordersTotal) {
		this.ordersTotal = ordersTotal;
	}
	public Date getOrdersTime() {
		return ordersTime;
	}
	public void setOrdersTime(Date ordersTime) {
		this.ordersTime = ordersTime;
	}
	
}