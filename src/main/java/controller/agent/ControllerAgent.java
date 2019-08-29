package controller.agent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import entity.agent.Agent;
import entity.page.Page;
import entity.page.PageEntity;
import service.Agent.AgentService;

@SessionAttributes("locale")
@Controller
public class ControllerAgent {
	@Autowired
	private AgentService as;
	
	/**
	 * 查询是否输入了相同的名称
	 * @param agName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("agent/count")
	public String count(String agName) {
		// 在页面上拿到输入的值
		Integer i = as.count(agName); // 查询用户名是存在, 0表示不存在
		if (i == 0) { // 如果数据库中没有此值表示可插入
			return "0";
		} else { // 不进行插入
			return "1";
		}
	}
	
	/**
	  * 查询的中转
	 * @throws IOException 
	 */
	@RequestMapping(value="/agentList",method = RequestMethod.GET)
	public String agentList(Locale locale,HttpServletRequest request,Map<String,Object> map) {
		map.put("locale",locale.toString());
		return "admin/jsp/agent/agentList";
	}
	
	/**
	 * 查询
	 * @param str
	 * @param pageNow
	 * @return
	 */
	@ResponseBody
	@RequestMapping("agents")
	public Page<Agent> queryagent(String str,String pageNow) {
		PageEntity pageEntity = new PageEntity();
		if(pageNow != null && !pageNow.equals("")) {
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		if (str == null) {
			str = "";
		}
		int count = as.agentCount(str); //得到总条数
		pageEntity.setCount(count);
		int pageCount = as.pageCount(count,pageEntity.getPageSize());//得到总页数
		pageEntity.setPageCount(pageCount);
		List<Agent> ag = as.select(str, pageEntity);
		Page<Agent> page = new Page<>();
		page.setList(ag);
		page.setPageEntity(pageEntity);
		System.out.println("查询");
		return page;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="agent/{id}",method = RequestMethod.DELETE)
	public String deleteagent(@PathVariable("id") Integer id) {
		// 在页面上拿到输入的值
		as.delete(id);
		System.out.println("删除");
		return "{\"del\":0}";
	}
	
	/**
	  *  新增的中转
	 */
	@RequestMapping(value = "/agent/add",method = RequestMethod.GET)
	public String addUrl() {
		return "admin/jsp/agent/agentAdd";
	}
	
	/**
	 * 添加
	 * @param agent
	 * @param result
	 * @param mm
	 * @return
	 */
	@RequestMapping(value="/agent", method=RequestMethod.POST)
	public String addagent(@Valid Agent agent,BindingResult result,ModelMap mm,Locale locale,String goodsp) {
		// 0表示没错，大于0表示有错
		if (result.getErrorCount() > 0) {
			// 得到所有有错的字段
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
				mm.addAttribute(error.getField(), error.getDefaultMessage());
			}
			mm.addAttribute("agent", agent);
			return "admin/jsp/agent/agentAdd";
		}
		int code = (int)Math.round(Math.random()*9999999);
		String b= as.selectcode(goodsp);
		agent.setBrand_code(b);
		agent.setBrand_name(goodsp);
		agent.setAgent_code("agent_"+code);
		as.insert(agent);
		System.out.println("添加");
		return "redirect:/agentList";
	}
	
	/**
	 * 回显
	 * @param id
	 * @return
	 */
	@RequestMapping(value="agent/{id}",method = RequestMethod.GET)
	public String Get(@PathVariable("id") Integer id,ModelMap mm) {
		Agent agent = as.get(id);
		mm.addAttribute("agent", agent);
		System.out.println("回显");
		return "admin/jsp/agent/agentUpdate";
	}
	
	@ModelAttribute
	public void getAgent(@RequestParam(value="id",required=false) Integer id,Map<String, Object> map){
		if(id != null){
			map.put("agent", as.get(id));
			System.out.println("modelattrbute");
		}
	}
	
	/**
	 * 修改
	 * @param agent
	 * @param goodsp
	 * @param result
	 * @param mm
	 * @param locale
	 * @return
	 */
	@RequestMapping(value="agent",method = RequestMethod.PUT)
	public String updateagent(@Valid Agent agent,BindingResult result,ModelMap mm,Locale locale,String goodsp) {
		// 0表示没错，大于0表示有错
		if (result.getErrorCount() > 0) {
			// 得到所有有错的字段
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
				mm.addAttribute(error.getField(), error.getDefaultMessage());
			}
			mm.addAttribute("agent", agent);
			return "forward:/ee?url=admin/jsp/agent/agentUpdate";
		}
		String b = as.selectcode(goodsp);
		agent.setBrand_code(b);
		agent.setBrand_name(goodsp);
		as.update(agent);
		System.out.println("修改");
		return "redirect:/agentList";
	}
	
	/**
	 * 
	 * 重定向
	 * @param userEntity
	 * @param bindResult
	 * @param url
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/ee")
	public String ee(String url,@Valid Agent agent,BindingResult bindResult,Map<String,Object> map) {
		map.put("agent", agent);
		System.out.println("重定向");
		return url;
	}
	
	/**
	 * 自定义视图
	 */
	@RequestMapping("/agent/viewExcel")
	public String viewExcel(ModelMap mm,Locale locale) {
		mm.addAttribute("locale", locale);
		return "agentExcel";
	}
}
