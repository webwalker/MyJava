package com.webwalker.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.webwalker.entity.UserInfo;
import com.webwalker.utils.Consts;

public class TestMyBatis {

	public static void main(String[] args) throws Exception {

		Reader reader = Resources.getResourceAsReader(Consts.Path.PrefixBatis2
				+ "config/TestMyBatis.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(reader);
		SqlSession session = sessionFactory.openSession();

		testCrud(session);
	}

	private static void testCrud(SqlSession session) {

		UserInfo user = new UserInfo();
		user.setUserId(new Long(100));
		user.setUsername("测试");
		user.setPassword("pwd_1!aSw29");
		user.setAge(100);

		System.out.println("UserInfo.delete...");
		// test insert
		session.delete("UserInfo.delete", user);
		session.insert("UserInfo.insert", user);
		session.commit();
		session.close();
		System.out.println("UserInfo.commit!");

		// 以下的方式不存在转换，返回类型更安全
		// UserInfo userInfo = session.getMapper(UserInfo.class);
		// userInfo.getUserId();

		// UserInfo fromDb = (UserInfo) session.selectOne("UserInfo.getById",
		// user.getUserId());
		// session.commit();
		// System.out.println("user:"+user);
		// System.out.println("fromDb:"+fromDb);
		// assertTrue(user.equals(fromDb));
		//
		// //test update
		// user.setUsername("badqiu");
		// session.update("UserInfo.update",user);
		// fromDb = (UserInfo) session.selectOne("UserInfo.getById",
		// user.getUserId());
		// assertTrue(user.equals(fromDb));
		//
		// // test select
		// Long count = (Long)session.selectOne("UserInfo.count",user);
		// assertTrue(1 == count);
		// RowBounds rowBounds = new RowBounds(0,100);
		// List list = session.selectList("UserInfo.pageSelect",user,rowBounds);
		// fromDb = (UserInfo)list.get(0);
		// assertTrue(fromDb.getUsername().equals(user.getUsername()));
		// assertTrue(fromDb.equals(user));
		//
		// //test delete
		// session.delete("UserInfo.delete",user.getUserId());
		// fromDb = (UserInfo) session.selectOne("UserInfo.getById",
		// user.getUserId());
		// assertTrue(fromDb == null);
	}

	public static void assertTrue(boolean v) {
		if (!v) {
			throw new IllegalStateException("test expression must be true");
		}
	}

}
