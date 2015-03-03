package com.webwalker.entity;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 自定义类型处理器，覆盖系统内建的类型处理StringTypeHandler
 * 
 * @author Administrator
 * 
 */
public class EncodingStringTypeHandlerCallback implements TypeHandler {

	public void setParameter(PreparedStatement ps, int i, Object parameter,
			JdbcType jdbcType) throws SQLException {
		// System.out.println(jdbcType.name());
		if (jdbcType.name() instanceof String) {
			ps.setString(i, StringUtils.gbk2ISO((String) parameter));
		}

	}

	public Object getResult(ResultSet rs, String columnName)
			throws SQLException {
		return StringUtils.isoTOGBK(rs.getString(columnName));
	}

	public Object getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return StringUtils.isoTOGBK(cs.getString(columnIndex));
	}

	@Override
	public Object getResult(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	// public Object getResult(ResultGetter arg0) throws SQLException {
	// return StringUtils.isoTOGBK(arg0.getString());
	// }
	//
	// public void setParameter(ParameterSetter setter, Object arg1)
	// throws SQLException {
	// if (arg1 instanceof String){
	// setter.setString(StringUtils.gbk2ISO((String) arg1));
	// }
	// }
	//
	// public Object valueOf(String arg0) {
	// return StringUtils.isoTOGBK(arg0);
	// }

}