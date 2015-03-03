package com.webwalker.others;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.webwalker.entity.Customer;
import com.webwalker.entity.JAXBEntity.Addresss;
import com.webwalker.entity.JAXBEntity.Customers;
import com.webwalker.entity.JAXBEntity.Order;
import com.webwalker.entity.JAXBEntity.Shop;

public class JAXBExample {

	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("mkyong");
		customer.setAge(29);

		// 将对象转为XML
		try {

			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		// 将XML转为对象
		try {

			File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			customer = (Customer) jaxbUnmarshaller.unmarshal(file);
			System.out.println(customer);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		// 其他示例
		Set<Order> orders = new HashSet<Order>();

		Addresss address1 = new Addresss("China", "ShangHai", "ShangHai",
				"Huang", "200000");
		Customers customer1 = new Customers("Jim", "male", "13699990000",
				address1);
		Order order1 = new Order("Mart", "LH59900", new Date(), new BigDecimal(
				60), 1);
		order1.setCustomer(customer1);

		Addresss address2 = new Addresss("China", "JiangSu", "NanJing",
				"ZhongYangLu", "210000");
		Customers customer2 = new Customers("David", "male", "13699991000",
				address2);
		Order order2 = new Order("Mart", "LH59800", new Date(), new BigDecimal(
				80), 1);
		order2.setCustomer(customer2);

		orders.add(order1);
		orders.add(order2);

		Addresss address3 = new Addresss("China", "ZheJiang", "HangZhou",
				"XiHuRoad", "310000");
		Shop shop = new Shop("CHMart", "100000", "EveryThing", address3);
		shop.setOrders(orders);

		FileWriter writer = null;

		try {
			JAXBContext context = JAXBContext.newInstance(Shop.class);
			Marshaller marshal = context.createMarshaller();
			marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshal.marshal(shop, System.out);

			writer = new FileWriter("shop.xml");
			marshal.marshal(shop, writer);

			Unmarshaller unmarshal = context.createUnmarshaller();
			FileReader reader = new FileReader("shop.xml");
			Shop shop1 = (Shop) unmarshal.unmarshal(reader);

			Set<Order> orders1 = shop1.getOrders();
			for (Order order : orders1) {
				System.out.println("***************************");
				System.out.println(order.getOrderNumber());
				System.out.println(order.getCustomer().getName());
				System.out.println("***************************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
