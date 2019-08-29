package controller.depa;

import java.io.IOException;
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

import entity.depa.DepaEntity;
import entity.depa_reciew.DepaReciewEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.depa.DepaService;
import service.depa_reciew.DepaReciewService;

@Controller
@SessionAttributes("locale")
@RequestMapping("/depaController")
public class DepaController {
	@Autowired
	private DepaService depaService;
    @Autowired
    private DepaReciewService depaReciewService;

	/**
	 * 查询
	 * @param depaName
	 * @param pageNow
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/depas", method = RequestMethod.GET)
	public Page<DepaEntity> depaList(String depaName, Integer pageNow, Locale locale, Map<String, Object> map) {
		PageEntity pageEntity = new PageEntity();
		if (pageNow != null) {
			pageEntity.setPageNow(pageNow);
		}
		if (depaName == null) {
			depaName = "";
		}
		map.put("locale", locale.toString());
		int count = depaService.count(depaName); // 得到总条数
		pageEntity.setCount(count);
		List<DepaEntity> list = depaService.query(depaName, pageEntity);
		Page<DepaEntity> page = new Page<DepaEntity>();
		page.setList(list);
		page.setPageEntity(pageEntity);
		return page;
	}
	/**
	  * 查询的中转
	 * @throws IOException 
	 */
	@RequestMapping(value="/depaList",method = RequestMethod.GET)
	public String advertList(Map<String, Object> map, Locale locale) {
		map.put("locale",locale.toString());
		return "admin/jsp/depa/depaList";
	}
		
		/**
		 * 删除
		 * @param id
		 * @return
		 */
	@ResponseBody
	@RequestMapping(value = "/depa/{id}",method = RequestMethod.DELETE)
	public String depaDelete(@PathVariable("id") int id) {
		try {
			depaService.delete(id);
			return "{\"depa\":1}";
		}catch (Exception e) {
			return "{\"depa\":0}";
		}
	}
	
	// 新增
	@RequestMapping(value ="/depaAdd/{id}", method = RequestMethod.GET)
	public String add(@PathVariable("id") int id) {
		DepaReciewEntity depaReciewEntity = depaReciewService.queryId(id);
		depaReciewService.delete(depaReciewEntity.getId());
		DepaEntity depaEntity = new DepaEntity();
		depaEntity.setCode(depaReciewEntity.getCode());
		depaEntity.setName(depaReciewEntity.getName());
		depaService.insert(depaEntity);
		return "admin/jsp/depaReciew/depaReciewList";
	}
	
	// 新增前用于跳转,中间意思(查询默认数据功能)
	@RequestMapping(value = "/depaPust", method = RequestMethod.GET)
	public String addPust(Locale locale,Map<String,Object> map) {
		map.put("locale",locale.toString());
		map.put("userEntity", new DepaEntity());
		return "admin/jsp/depa/depaAdd";
	}
	/**
	 * 修改回显使用
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getEmployee(@RequestParam(value ="id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			map.put("depaEntity", depaService.queryId(id));
		}
	}
	
	// 修改跳转
	@RequestMapping(value = "/depa/{id}", method = RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
		// 回显用户
		DepaEntity depaEntity = depaService.queryId(id);
		map.put("depaEntity",depaEntity);
		// 国际化语言
		return "admin/jsp/depa/depaUpdete";
	}

	@RequestMapping("/jump")
	public String toPage(String viewName, @Valid DepaEntity depaEntity, BindingResult result, Map<String, Object> map) {
		map.put("depaEntity", depaEntity);
		// viewName要跳转页面路径
		return viewName;
	}

	// 修改
	@RequestMapping(value = "/depa", method = RequestMethod.PUT)
	public String update(@Valid DepaEntity depaEntity, BindingResult result, Map<String, Object> map, Locale locale) {
		if (result.getErrorCount() > 0) {
			System.out.println("出现异常------------------------------");
			for (FieldError fieldError : result.getFieldErrors()) {
				System.out.println(fieldError.getField() + ":" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			// 国际化语言
			map.put("locale", locale.toString());
			return "forward:jump?viewName=/admin/jsp/depa/depaUpdete";
		} 
		depaService.update(depaEntity,depaEntity.getId());
		return "redirect:depaList";
	}
	
	
}
