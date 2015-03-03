package com.webwalker.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class JAXBEntity {

	@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "shop", propOrder = { "name", "number", "describer",
			"address", "orders" })
	@XmlRootElement(name = "CHMart")
	public static class Shop {

		@XmlAttribute
		private String name;

		// @XmlElement
		private String number;

		@XmlElement
		private String describer;

		@XmlElementWrapper(name = "orders")
		@XmlElement(name = "order")
		private Set<Order> orders;

		@XmlElement
		private Addresss address;

		public Shop() {
		}

		public Shop(String name, String number, String describer,
				Addresss address) {
			this.name = name;
			this.number = number;
			this.describer = describer;
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getDescriber() {
			return describer;
		}

		public void setDescriber(String describer) {
			this.describer = describer;
		}

		public Set<Order> getOrders() {
			return orders;
		}

		public void setOrders(Set<Order> orders) {
			this.orders = orders;
		}

		public Addresss getAddress() {
			return address;
		}

		public void setAddress(Addresss address) {
			this.address = address;
		}

	}

	@XmlType(name = "order", propOrder = { "shopName", "orderNumber", "price",
			"amount", "purDate", "customer" })
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement
	public static class Order {

		// @XmlElement　　
		private String shopName;

		@XmlAttribute
		private String orderNumber;

		// @XmlElement
		@XmlJavaTypeAdapter(value = DateAdapter.class)
		private Date purDate;

		// @XmlElement
		private BigDecimal price;

		// @XmlElement
		private int amount;

		// @XmlElement
		private Customers customer;

		public Order() {
		}

		public Order(String shopName, String orderNumber, Date purDate,
				BigDecimal price, int amount) {
			this.shopName = shopName;
			this.orderNumber = orderNumber;
			this.purDate = purDate;
			this.price = price;
			this.amount = amount;
		}

		public String getShopName() {
			return shopName;
		}

		public void setShopName(String shopName) {
			this.shopName = shopName;
		}

		public String getOrderNumber() {
			return orderNumber;
		}

		public void setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
		}

		public Date getPurDate() {
			return purDate;
		}

		public void setPurDate(Date purDate) {
			this.purDate = purDate;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public Customers getCustomer() {
			return customer;
		}

		public void setCustomer(Customers customer) {
			this.customer = customer;
		}

	}

	@XmlType
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement
	public static class Customers {

		@XmlAttribute
		private String name;

		private String gender;

		private String phoneNo;

		private Addresss address;

		private Set<Order> orders;

		public Customers() {
		}

		public Customers(String name, String gender, String phoneNo,
				Addresss address) {
			this.name = name;
			this.gender = gender;
			this.phoneNo = phoneNo;
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public Addresss getAddress() {
			return address;
		}

		public void setAddress(Addresss address) {
			this.address = address;
		}

		public Set<Order> getOrders() {
			return orders;
		}

		public void setOrders(Set<Order> orders) {
			this.orders = orders;
		}
	}

	@XmlType(propOrder = { "state", "province", "city", "street", "zip" })
	@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
	@XmlAccessorType(XmlAccessType.NONE)
	@XmlRootElement
	public static class Addresss {

		@XmlAttribute
		private String state;

		@XmlElement
		private String province;

		@XmlElement
		private String city;

		@XmlElement
		private String street;

		@XmlElement
		private String zip;

		public Addresss() {
			super();
		}

		public Addresss(String state, String province, String city,
				String street, String zip) {
			super();
			this.state = state;
			this.province = province;
			this.city = city;
			this.street = street;
			this.zip = zip;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}
	}

	public static class DateAdapter extends XmlAdapter<String, Date> {

		private String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat fmt = new SimpleDateFormat(pattern);

		@Override
		public Date unmarshal(String dateStr) throws Exception {

			return fmt.parse(dateStr);
		}

		@Override
		public String marshal(Date date) throws Exception {

			return fmt.format(date);
		}

	}
}
