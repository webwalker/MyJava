package com.webwalker.cxf;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.webwalker.entity.User;
import com.webwalker.entity.Users;

@WebService
public interface IComplexUserService {
	public User getUserByName(@WebParam(name = "name") String name);

	public void setUser(User user);

	public Users getUsers(int i);

	public void setUsers(Users users);

	public Users getUserArray(int i);

	public void setUserArray(Users users);

	public void setUserMap(Users maps);

	public Users getUserMap();
}