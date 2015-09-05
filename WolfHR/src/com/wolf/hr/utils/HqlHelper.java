package com.wolf.hr.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于辅助生成HQL语句与参数列表
 * 
 * @author tyg
 * 
 */
public class HqlHelper {

	private String fromClause; // From子句
	private String whereClause = ""; // Where子句，初始化为空字符串
	private String orderByClause = ""; // OrderBy子句,初始化为空字符串

	private List<Object> parameters = new ArrayList<Object>(); // 参数列表

	/**
	 * 生成From子句
	 * 
	 * @param clazz //类名
	 * @param alias //别名
	 */
	public HqlHelper(Class clazz, String alias) {
		fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}

	public HqlHelper(Class clazz) {
		fromClause = "FROM " + clazz.getSimpleName();
	}
	/**
	 * 拼接Where子句（添加的多个过滤条件之间是使用AND连接的）
	 * 
	 * @param condition
	 *            一个过滤条件
	 * @param params
	 */
	public HqlHelper addWhereCondition(String condition, Object... params) {
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition;
		} else {
			whereClause += " AND " + condition;
		}

		if (params != null && params.length > 0) {
			for (Object param : params) {
				this.parameters.add(param);
			}
		}

		return this;
	}

	/**
	 * 如果第一个参数为true，则拼接Where子句（添加的多个过滤条件之间是使用AND连接的）
	 * 
	 * @param append
	 * @param condition
	 *            一个过滤条件
	 * @param params  //可变参数
	 */
	public HqlHelper addWhereCondition(boolean append, String condition, Object... params) {
		if (append) {
			addWhereCondition(condition, params);
		}
		return this;
	}

	/**
	 * 拼接OrderBy子句
	 * 
	 * @param propertyName
	 * @param isAsc
	 */
	public HqlHelper addOrderByProperty(String propertyName, boolean isAsc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName + (isAsc ? " ASC" : " DESC");
		} else {
			orderByClause += ", " + propertyName + (isAsc ? " ASC" : " DESC");
		}
		return this;
	}

	/**
	 * 如果第一个参数为true，则拼接OrderBy子句
	 * 
	 * @param propertyName
	 * @param isAsc
	 */
	public HqlHelper addOrderByProperty(boolean append, String propertyName, boolean isAsc) {
		if (append) {
			addOrderByProperty(propertyName, isAsc);
		}
		return this;
	}

	/**
	 * 获取查询数据列表的的HQL语句
	 * 
	 * @return
	 */
	public String getQueryListHql() {
		return fromClause + whereClause + orderByClause;
	}

	/**
	 * 获取查询总记录数的的HQL语句
	 * 
	 * @return
	 */
	public String getQueryCountHql() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}

	/**
	 * 获取参数列表
	 * 
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}

}
