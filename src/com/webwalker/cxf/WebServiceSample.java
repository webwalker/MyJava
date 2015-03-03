package com.webwalker.cxf;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.webwalker.entity.ListObject;
import com.webwalker.entity.UserDTO;

/**
 * WebService接口定义类.
 * 
 * 使用@WebService将接口中的所有方法输出为Web Service. 可用annotation对设置方法、参数和返回值在WSDL中的定义.
 */
@WebService
public interface WebServiceSample {

	/**
	 * 一个简单的方法,返回一个字符串
	 * 
	 * @param hello
	 * @return
	 */
	String say(String hello);

	/**
	 * 稍微复杂一些的方法,传递一个对象给服务端处理
	 * 
	 * @param user
	 * @return
	 */
	String sayUserName(@WebParam(name = "user") UserDTO user);

	/**
	 * 最复杂的方法,返回一个List封装的对象集合
	 * 
	 * @return
	 */
	public @WebResult(partName = "o")
	ListObject findUsers();
}
