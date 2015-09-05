package com.wolf.hr.struts2.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wolf.hr.domain.Post;
import com.wolf.hr.service.PostService;
import com.wolf.hr.struts2.action.base.BaseAction;



@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post>{
	@Resource(name="postService")
	private PostService postService;
	public String getAllPost(){
		Collection<Post> postList = this.postService.getAllPost();
		ActionContext.getContext().put("postList", postList);
		return listAction;
	}
	
	public String addUI(){
		return addUI;
	}
	
	public String add(){
		Post post = new Post();
		BeanUtils.copyProperties(this.getModel(), post);
		this.postService.savePost(post);
		return action2action;
	}
	
	public String delete(){
		this.postService.deletePost(this.getModel().getPid());
		return action2action;
	}
	
	public String updateUI(){
		Post post = this.postService.getPostById(this.getModel().getPid());
		ActionContext.getContext().getValueStack().pop();
		ActionContext.getContext().getValueStack().push(post);
		return updateUI;
	}
	
	public String update(){
		Post post = this.postService.getPostById(this.getModel().getPid());
		BeanUtils.copyProperties(this.getModel(), post);
		this.postService.updatePost(post);
		return action2action;
	}
}
