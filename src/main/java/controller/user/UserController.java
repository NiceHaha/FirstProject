package controller.user;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import entity.depa.DepaEntity;
import entity.page.Page;
import entity.page.PageEntity;
import entity.user.UserEntity;
import service.user.UserService;

/**
 * 	用户
 * @author TXY 
 *
 * 2019年6月27日下午7:27:59
 */
@Controller
@SessionAttributes(names = {"locale"})
@RequestMapping(value = "/userController")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 	用户查询
	 * @param userName
	 * @param pageNow
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/userQueryAll",method = RequestMethod.GET)
	public Page<UserEntity> userQueryAll(String userName,Integer pageNow,Locale locale,Map<String,Object> map){
		PageEntity pageEntity = new PageEntity();
		if(pageNow != null) {
			pageEntity.setPageNow(pageNow);
		}
		if (userName == null) {
			userName = "";
		}
		map.put("locale",locale.toString());
		int count = userService.count(userName);//得到总条数
		pageEntity.setCount(count);
		List<UserEntity> list = userService.query(userName, pageEntity);
		Page<UserEntity> page = new Page<UserEntity>();
		page.setList(list);
		page.setPageEntity(pageEntity);
		return page;
	}
	/**
	  * 查询的中转
	 * @throws IOException 
	 */
	@RequestMapping(value="/userList",method = RequestMethod.GET)
	public String advertList(Locale locale,Map<String,Object> map) {
		map.put("locale",locale.toString());
		return "admin/jsp/user/userList";
	}
	
	
	/**
	 * 	删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
	public String csrDelete(@PathVariable("id") int id) {
		try {
			userService.delete(id);
			return "{\"user\":1}";
		} catch (Exception e) {
			return "{\"user\":0}";
		}
	}
	

	/**
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String insert(@Valid UserEntity userEntity, BindingResult result, Locale locale,Map<String,Object> map) {
		if (result.getErrorCount() > 0) {
			System.out.println("出现异常------------------------------");
			for (FieldError fieldError : result.getFieldErrors()) {
				System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			// 国际化语言
			map.put("userEntity", userEntity);
			map.put("locale", locale.toString());
			return "admin/jsp/user/userAdd";
		} 
		userService.insert(userEntity);
		return "admin/jsp/user/userList";
	}

	// 新增前用于跳转,中间意思(查询默认数据功能)
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addPust(Locale locale, Map<String, Object> map) {
		map.put("locale", locale.toString());
		map.put("userEntity", new DepaEntity());
		return "admin/jsp/user/userAdd";
	}
	
	
	
	
	
	
	
	/**
	 * 修改回显使用
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getEmployee(@RequestParam(value ="id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			map.put("userEntity", userService.queryId(id));
		}
	}
	
	// 修改跳转
	@RequestMapping(value = "/updateJump/{id}", method = RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
		// 回显用户
		UserEntity userEntity = userService.queryId(id);
		map.put("userEntity",userEntity);
		// 国际化语言
		return "admin/jsp/user/userUpdate";
	}

	@RequestMapping("/jump/user")
	public String toPage(String viewName, @Valid UserEntity userEntity, BindingResult result, Map<String, Object> map) {
		map.put("userEntity", userEntity);
		// viewName要跳转页面路径
		return viewName;
	}

	// 修改
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public String update(@Valid UserEntity userEntity, BindingResult result, Map<String, Object> map, Locale locale) {
		if (result.getErrorCount() > 0) {
			System.out.println("出现异常------------------------------");
			for (FieldError fieldError : result.getFieldErrors()) {
				System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			// 国际化语言
			map.put("locale", locale.toString());
			return "forward:jump/user?viewName=/admin/jsp/user/userUpdate";
		} 
		userService.update(userEntity,userEntity.getId());
		return "redirect:userList";
	}
	
	
	/**
	 * 自定义视图
	 */
	@RequestMapping("/viewExcel")
	public String viewExcel(HttpServletRequest request,Map<String, Object> map, Locale locale) {
		map.put("locale",locale);
		return "userExcel";
	}
}
