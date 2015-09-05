package com.wolf.hr.dao;

import java.util.Set;



import com.wolf.hr.dao.base.BaseDao;
import com.wolf.hr.domain.Post;



public interface PostDao<T> extends BaseDao<T>{
	public Set<Post> getPostsByIDS(Long[] pids);
}
