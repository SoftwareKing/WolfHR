package com.wolf.hr.struts2.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.JSONResult;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;


import com.wolf.hr.domain.Department;
import com.wolf.hr.domain.Form;
import com.wolf.hr.domain.FormTemplate;
import com.wolf.hr.domain.PageBean;
import com.wolf.hr.domain.Post;
import com.wolf.hr.domain.User;
import com.wolf.hr.service.DepartmentService;
import com.wolf.hr.service.PostService;
import com.wolf.hr.service.UserService;
import com.wolf.hr.struts2.action.base.BaseAction;
import com.wolf.hr.utils.DeleteMode;
import com.wolf.hr.utils.HqlHelper;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>  implements ServletResponseAware{
	private javax.servlet.http.HttpServletResponse response;
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	@Resource(name="postService")
	private PostService postService;
  
	
	private String dname;
	
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	private File photo;
	private File jianli;
	
	
	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public File getJianli() {
		return jianli;
	}

	public void setJianli(File jianli) {
		this.jianli = jianli;
	}

	private Long did;
	
	private Long[] pids;
	
	private String message;
	
	private String usernames;
	
	
	public String getUsernames() {
		return usernames;
	}

	public void setUsernames(String usernames) {
		this.usernames = usernames;
	}

	public String getMessage() {
		return message;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public Long[] getPids() {
		return pids;
	}

	public void setPids(Long[] pids) {
		this.pids = pids;
	}

	
	private String jobnumbers;
	
	public String getJobnumbers() {
		return jobnumbers;
	}

	public void setJobnumbers(String jobnumbers) {
		this.jobnumbers = jobnumbers;
	}

	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		 this.response =response;;
	}
	public String getAllUser(){
		Collection<User> userList = this.userService.getAllUser();
		ActionContext.getContext().getValueStack().push(userList);
		return listAction;
	}
	
	public String deleteUser(){
		User user=this.userService.getUserById(this.getModel().getUid());
		//①删除数据库中的记录
		this.userService.deleteUserByID(this.getModel().getUid(), DeleteMode.DEL_PRE_RELEASE);
		//②删除在服务器上的文件
		File photo= new File(user.getPhotourl());
		if(photo.exists())
		{
			photo.delete();
			
		}
		
		File jianli= new File(user.getJianliurl());
		if(jianli.exists())
		{
			jianli.delete();
			
		}
		return action2action;
	}
	
	public String addUUI(){
		
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
		Collection<Post> postList = this.postService.getAllPost();
		ActionContext.getContext().put("postList", postList);
		return "addUUI";
	}
	public String add2(){
		/**
		 * 如何获取页面中的数据
		 *    *  如果页面中的数据来源于一张表，直接用模型驱动获取就可以了
		 *    *  如果页面中的数据来源于多张表，则可以采用模型驱动结合属性驱动的方式
		 */
		/**
		 * 1、创建一个user对象
		 * 2、把模型驱动的值赋值给user对象
		 * 3、根据 did提取出该部门
		 * 4、根据pids提取出岗位
		 * 5、建立user对象和部门和岗位之间的关系
		 * 6、执行save操作
		 */
		User user = new User();
		//一般属性的赋值
		BeanUtils.copyProperties(this.getModel(), user);
		//建立user与department之间的关系
		Department department = this.departmentService.getDepartmentById(this.did);
		user.setDepartment(department);
		//建立user与posts之间的关系
		Set<Post> posts = this.postService.getPostsByIds(this.pids);
		user.setPosts(posts);
		//this.userService.saveUser(user);
		
	    	 this.userService.saveUserFile(user,photo,jianli);
	    
	   
		return "Userbasic";
	}
	public String getAllUserbasic(){
		Collection<User> userList = this.userService.getAllUser();
		ActionContext.getContext().getValueStack().push(userList);
		return "basiclist";
	}
	
	public String updateUserbasicUI(){
		
		//把用户放入到对象栈中
		User user = this.userService.getUserById(this.getModel().getUid());
		ActionContext.getContext().getValueStack().push(user);
		this.did = user.getDepartment().getDid();
		Set<Post> posts = user.getPosts();
		int index = 0;
		this.pids = new Long[posts.size()];
		for(Post post:posts){
			this.pids[index] = post.getPid();
			index++;
		}
		//把部门表和岗位表的数据提取出来
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
		Collection<Post> postList = this.postService.getAllPost();
		ActionContext.getContext().put("postList", postList);
		
		return "updateUserbasicUI";
	}
	
	public String updatebasic(){
		/**
		 * 1、利用模型驱动获取用户的一般数据
		 * 2、利用属性驱动获取最新的did和pids
		 * 3、根据用户的id提取出user对象
		 * 4、把模型驱动的值复制到user对象中
		 * 5、重新建立user对象和岗位和部门之间的关系
		 */
		//一般属性的赋值
		User user = this.userService.getUserById(this.getModel().getUid());
		BeanUtils.copyProperties(this.getModel(), user);
		//重新建立user和部门之间的关系
		Department department = this.departmentService.getDepartmentById(this.did);
		user.setDepartment(department);
		//重新建立user与岗位之间的关系
		Set<Post> posts = this.postService.getPostsByIds(this.pids);
		user.setPosts(posts);
		
		if(photo != null&&jianli !=null)//如果文件上传了
		{
			File file1= new File(user.getPhotourl());
			File file2= new File(user.getJianliurl());
			if(file1.exists()&&file2.exists())
			  {
				file1.delete();
				file2.delete();
				
				
			 }
				
			//使用新文件，更新到数据库中
			
			this.userService.updateUserFile(user,photo,jianli);
		}else if(photo != null&&jianli==null)
		{
			
			File file1= new File(user.getPhotourl());
			if(file1.exists())
			  {
				file1.delete();
				
				
				
			 }
			this.userService.updateUserphoto(user,photo);
		}else if(photo==null&&jianli!=null)
		{
			File file2= new File(user.getJianliurl());
			if(file2.exists())
			  {
				
				file2.delete();
				
				
			 }
				
			//使用新文件，更新到数据库中
			
			this.userService.updateUserjianli(user,jianli);
		}
		else
		{
			this.userService.updateUser(user);
		}
		
		return "Userbasic";
	}
	
	public String userbasicByID()
	{
		
		User user = this.userService.getUserById(this.getModel().getUid());
		ActionContext.getContext().put("user", user);
		return "basic";
		
	}
	public String addUPP(){
		
		return "addUPP";
	}
	public String addUI(){
		/**
		 * 1、把部门表的所有的数据查询出来
		 * 2、把岗位表的数据查询出来
		 * 3、跳转到增加页面
		 */
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
		Collection<Post> postList = this.postService.getAllPost();
		ActionContext.getContext().put("postList", postList);
		return addUI;
	}
	
	public String add(){
		/**
		 * 如何获取页面中的数据
		 *    *  如果页面中的数据来源于一张表，直接用模型驱动获取就可以了
		 *    *  如果页面中的数据来源于多张表，则可以采用模型驱动结合属性驱动的方式
		 */
		/**
		 * 1、创建一个user对象
		 * 2、把模型驱动的值赋值给user对象
		 * 3、根据 did提取出该部门
		 * 4、根据pids提取出岗位
		 * 5、建立user对象和部门和岗位之间的关系
		 * 6、执行save操作
		 */
		User user = new User();
		//一般属性的赋值
		BeanUtils.copyProperties(this.getModel(), user);
		//建立user与department之间的关系
		Department department = this.departmentService.getDepartmentById(this.did);
		user.setDepartment(department);
		//建立user与posts之间的关系
		Set<Post> posts = this.postService.getPostsByIds(this.pids);
		user.setPosts(posts);
		this.userService.saveUser(user);
		return action2action;
	}
	/**
	 * 如果是页面跳转到action,在action中有一个Long[]数组，struts2的拦截器可以自动赋值
	 * 但是如果是回显数据，必须在程序中创建数组的对象
	 * @return
	 */
	public String updateUI(){
		/**
		 * 1、值的回显
		 *    * 用户的一般属性的回显
		 *    * 部门的回显
		 *    * 岗位的回显
		 * 2、 把部门的数据全部提取出来
		 * 3、把岗位的数据全部提取出来
		 */
		//把用户放入到对象栈中
		User user = this.userService.getUserById(this.getModel().getUid());
		ActionContext.getContext().getValueStack().push(user);
		this.did = user.getDepartment().getDid();
		Set<Post> posts = user.getPosts();
		int index = 0;
		this.pids = new Long[posts.size()];
		for(Post post:posts){
			this.pids[index] = post.getPid();
			index++;
		}
		//把部门表和岗位表的数据提取出来
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
		Collection<Post> postList = this.postService.getAllPost();
		ActionContext.getContext().put("postList", postList);
		return updateUI;
	}
	
	public String update(){
		/**
		 * 1、利用模型驱动获取用户的一般数据
		 * 2、利用属性驱动获取最新的did和pids
		 * 3、根据用户的id提取出user对象
		 * 4、把模型驱动的值复制到user对象中
		 * 5、重新建立user对象和岗位和部门之间的关系
		 */
		//一般属性的赋值
		User user = this.userService.getUserById(this.getModel().getUid());
		BeanUtils.copyProperties(this.getModel(), user);
		//重新建立user和部门之间的关系
		Department department = this.departmentService.getDepartmentById(this.did);
		user.setDepartment(department);
		//重新建立user与岗位之间的关系
		Set<Post> posts = this.postService.getPostsByIds(this.pids);
		user.setPosts(posts);
		this.userService.updateUser(user);
		return action2action;
	}
	public String initpassword(){
		User user = this.userService.getUserById(this.getModel().getUid());
		//使用明文的MD5加密
		String md5Digest=DigestUtils.md5Hex("123456");
		
		user.setPassword(md5Digest);
		this.userService.updateUser(user);
		return action2action;
	}
	public String resetpswUI(){
		
		return "resetpswUI";
	}
	
	//修改密码
    public String resetpsw() throws IOException{
    	User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
    	String Newpassword=this.getModel().getPassword();
    	String md5Digest=DigestUtils.md5Hex(Newpassword);
    	user.setPassword(md5Digest);
		this.userService.updateUser(user);
		response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
		PrintWriter out = response.getWriter();;
	    out.print("<script>alert('密码修改成功！')</script>");
		return "resetpswUI";
	}
	
	

    public String queryList()
    {
    	// 1，构建查询条件
		HqlHelper hqlHelper = new HqlHelper(User.class, "u");
	
		// 2，查询分页信息
		PageBean pageBean = this.userService.getPageBean(pageNum, hqlHelper);
		ActionContext.getContext().getValueStack().push(pageBean);

		Collection<User> userList = this.userService.getAllUser();
		ActionContext.getContext().put("userList", userList);
    	
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
		
		
    	return "queryaddUI";
    }
	
    public String personalUI()
    {
    	
    	//User user=(User)ServletActionContext.getRequest().getSession().getAttribute("user");
    	//ActionContext.getContext().getValueStack().push(user);
    	//this.did = user.getDepartment().getDid();
    	
    	return "personalUI";
    }
    
    public String personalim()
    {
    	User personal = this.userService.getUser() ;
    	ActionContext.getContext().put("personal", personal);
    	return "personal";
    } 
    public String getUserByJobnumber()
    {
    	System.out.println(jobnumbers);
    	Collection<User>  userlist=this.userService.getUserByJobnumber(jobnumbers);
    	ActionContext.getContext().put("userList",userlist );
    	Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
    	return "queryaddUI";
    }
	public String getUserByUsername()
	{
		
		Collection<User> userlist=this.userService.getUserByUsername(usernames);
		ActionContext.getContext().put("userList", userlist);
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
		
		return "queryaddUI";
		
	}
	public String getUserBydid()
	{
		
		Collection<User> userlist=this.userService.getUserBydid(did);
		ActionContext.getContext().put("userList", userlist);
		Collection<Department> departmentList = this.departmentService.getAllDepartment();
		ActionContext.getContext().put("departmentList", departmentList);
		
		return "queryaddUI";
		
	}
}
