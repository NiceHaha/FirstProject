package controller.emp;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import entity.emp.EmpEntity;
import entity.empReciew.EmpRecorEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.emp.EmpService;
import service.empReciew.EmpReciewService;

@Controller
@SessionAttributes("locale")
@RequestMapping("/empController")
public class EmpController {
	@Autowired
	private EmpService empService;
	@Autowired
	private EmpReciewService empReciewService;
	/**
	 * 查询
	 * 
	 * @param empName
	 * @param pageNow
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/emps", method = RequestMethod.GET)
	public Page<EmpEntity> empList(String empName, Integer pageNow,Map<String, Object> map, Locale locale) {
		map.put("locale",locale.toString());
		PageEntity pageEntity = new PageEntity();
		if (pageNow != null) {
			pageEntity.setPageNow(pageNow);
		}
		if (empName == null) {
			empName = "";
		}
		map.put("locale",locale.toString());
		int count = empService.count(empName);// 得到共有多少数据
		pageEntity.setCount(count);
		List<EmpEntity> list = empService.query(empName, pageEntity);
		Page<EmpEntity> page = new Page<EmpEntity>();
		page.setList(list);
		page.setPageEntity(pageEntity);
		return page;
	}
	/**
	 * 查询跳转
	 * @return
	 */
	@RequestMapping("/empList")
	public String empList(Map<String, Object> map, Locale locale) {
		map.put("locale",locale.toString());
		return "admin/jsp/emp/empList";
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	protected String doGet(@PathVariable("id") int id){
		try {
			empService.delete(id);
			return "{\"emp\":1}";
		}catch (Exception e) {
			return "{\"emp\":0}";
		}
	}
	
	// 新增
	@RequestMapping(value ="/empAdd/{id}", method = RequestMethod.GET)
	public String add(@PathVariable("id") int id,Locale locale,Map<String, Object> map) {
		map.put("locale",locale.toString());
		EmpRecorEntity empRecorEntity = empReciewService.queryId(id);
		int code = (int)Math.round(Math.random()*9999999);
		EmpEntity empEntity = new EmpEntity();
		empEntity.setName(empRecorEntity.getName());
		empEntity.setTel(empRecorEntity.getTel());
		empEntity.setAddr(empRecorEntity.getAddr());
		empEntity.setAccount(empRecorEntity.getAccount());
		empEntity.setPassword(empRecorEntity.getPassword());
		empEntity.setDepaCode(empRecorEntity.getDepaCode());
		String depaName = "";
		if(empRecorEntity.getDepaCode() != null) {
			depaName = empReciewService.queryCode(empRecorEntity.getDepaCode());//根据code查出部门名字
		}
		empEntity.setPosition(empRecorEntity.getPosition());
		empEntity.setEmpCode("EMP-" + code);
		empEntity.setSex(empRecorEntity.getSex());
		empEntity.setAge(empRecorEntity.getAge());
		empEntity.setState(empRecorEntity.getState());
		empService.insert(empEntity);
		empReciewService.delete(id);
		return "admin/jsp/empReciew/empReciewList";
	}	
	
	/**
	 * 修改回显使用
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getEmployee(@RequestParam(value ="id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			map.put("empEntity", empService.queryid(id));
		}
	}
	
	// 修改跳转
	@RequestMapping(value = "/empPut/{id}", method = RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
		// 回显用户
		EmpEntity empEntity = empService.queryid(id);
		map.put("empEntity",empEntity);
		// 国际化语言
		return "admin/jsp/emp/empUpdate";
	}

	@RequestMapping("/jump/emp")
	public String toPage(String viewName, @Valid EmpEntity empEntity, BindingResult result, Map<String, Object> map) {
		// viewName要跳转页面路径
		return viewName;
	}

	// 修改
	@RequestMapping(value = "/emp", method = RequestMethod.PUT)
	public String update(@Valid  EmpEntity empEntity, BindingResult result, Map<String, Object> map, Locale locale) {
		if (result.getErrorCount() > 0) {
			System.out.println("出现异常------------------------------");
			for (FieldError fieldError : result.getFieldErrors()) {
				System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			// 国际化语言
			map.put("locale", locale.toString());
			return "forward:jump/emp?viewName=/admin/jsp/emp/empUpdate";
		} 
		empService.update(empEntity,empEntity.getId());
		return "redirect:empList";
	}
}
