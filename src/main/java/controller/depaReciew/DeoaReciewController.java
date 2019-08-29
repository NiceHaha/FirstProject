package controller.depaReciew;


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
import org.springframework.web.bind.annotation.SessionAttributes;

import entity.depa_reciew.DepaReciewEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.depa_reciew.DepaReciewService;

@Controller
@SessionAttributes("locale")
@RequestMapping(value = "/depaReciewController")
public class DeoaReciewController {
    @Autowired
    private DepaReciewService depaReciewService;
	
	/**
	 * 查询
	 * @param depaName
	 * @param pageNow
	 * @return
	 */
		@ResponseBody
		@RequestMapping(value = "/depaReciews",method = RequestMethod.GET)
		public Page<DepaReciewEntity> depaAll(String depaName,Integer pageNow,Map<String,Object> map,Locale locale) {
			PageEntity pageEntity = new PageEntity();
			if(pageNow != null) {
				pageEntity.setPageNow(pageNow);
			}
			if(depaName == null) {
				depaName = "";
			}
			map.put("locale",locale.toString());
			int count = depaReciewService.count(depaName);//总条数
			pageEntity.setCount(count);
			List<DepaReciewEntity> list= depaReciewService.query(depaName, pageEntity);
			Page<DepaReciewEntity> page = new Page<DepaReciewEntity>();
			page.setList(list);
			page.setPageEntity(pageEntity);
			return page;
	}
	/**
	 * 查询跳转
	 * @return
	 */
	@RequestMapping("depaReciewList")
	public String DepaReciewList(Map<String,Object> map,Locale locale) {
		map.put("locale",locale.toString());
		return "admin/jsp/depaReciew/depaReciewList";
	}
		
		
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/depaReciew/{id}",method = RequestMethod.DELETE)
	public String depaDelete(@PathVariable("id") int id) {
		try {
			depaReciewService.delete(id);
			return "{\"depa\":1}";
		}catch (Exception e) {
			return "{\"depa\":0}";
		}
	}
	
	// 新增
	@RequestMapping(value ="/depaReciew", method = RequestMethod.POST)
	public String add(@Valid DepaReciewEntity depaReciewEntity, BindingResult result,Map<String,Object> map,Locale locale) {
		if (result.getErrorCount() > 0) {
			System.out.println("出现异常------------------------------");
			for (FieldError fieldError : result.getFieldErrors()) {
				System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			// 国际化语言
			map.put("depaReciewEntity",depaReciewEntity);
			map.put("locale", locale.toString());
			return "admin/jsp/depa/depaAdd";
		} 
		String code = "DEPA-"+(int)Math.round(Math.random()*9999999);
		depaReciewEntity.setCode(code);
		depaReciewService.insert(depaReciewEntity);
		return "admin/jsp/depa/depaList";
	}
}
