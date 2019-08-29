package controller.empReciew;


import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.empReciew.EmpRecorEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.empReciew.EmpReciewService;

@Controller
@RequestMapping("/empReciewController")
public class EmpReciewController {
    @Autowired
    private EmpReciewService empReciewService;
	
	/**
	 * 查询
	 * @param depaName
	 * @param pageNow
	 * @return
	 */
		@ResponseBody
		@RequestMapping(value = "/empReciews",method = RequestMethod.GET)
		public Page<EmpRecorEntity> depaList(String depaName,Integer pageNow) {
		PageEntity pageEntity = new PageEntity();
		if(pageNow != null) {
			pageEntity.setPageNow(pageNow);
		}
		if(depaName == null ) {
			depaName = "";
		}
		int count = empReciewService.count(depaName); //得到总条数
		pageEntity.setCount(count);
		List<EmpRecorEntity> list = empReciewService.query(depaName,pageEntity);
		Page<EmpRecorEntity> page = new Page<EmpRecorEntity>();
		page.setList(list);
		page.setPageEntity(pageEntity);
		return page;
	}
	/**
	 * 查询跳转
	 * @return
	 */
	@RequestMapping("empReciewsList")
	public String empReciewsList() {
		return "admin/jsp/empReciew/empReciewList";
	}
	
		
		/**
		 * 删除
		 * @param id
		 * @return
		 */
	@ResponseBody
	@RequestMapping(value = "/empReciew/{id}",method = RequestMethod.DELETE)
	public String depaDelete(@PathVariable("id") int id) {
		try {
			empReciewService.delete(id);
			return "{\"depa\":1}";
		}catch (Exception e) {
			return "{\"depa\":0}";
		}
	}
	
	// 新增
	@RequestMapping(value ="/empReciew", method = RequestMethod.POST)
	public String add(@Valid EmpRecorEntity empRecorEntity,BindingResult result,String depaName,Map<String,Object> map,Locale locale) {
		if (result.getErrorCount() > 0) {
			System.out.println("出现异常------------------------------");
			for (FieldError fieldError : result.getFieldErrors()) {
				System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			// 国际化语言
			map.put("locale", locale.toString());
			return "admin/jsp/emp/empAdd";
		} 
		if(depaName != null) {
			empRecorEntity.setDepaCode(empReciewService.queryName(depaName));
		}
		empReciewService.insert(empRecorEntity);
		return "admin/jsp/emp/empList";
	}
	
	// 新增前用于跳转,中间意思(查询默认数据功能)
	@RequestMapping(value = "/empRecorPost", method = RequestMethod.GET)
	public String addPust(Locale locale,Map<String,Object> map) {
		map.put("locale",locale.toString());
		map.put("empRecorEntity", new EmpRecorEntity());
		return "admin/jsp/emp/empAdd";
	}
	
	
}
