package controller.project;

import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import entity.page.Page;
import entity.page.PageEntity;
import entity.project.ProjectEntity;
import service.project.ProjectService;


//前台增删改查
@Controller
@SessionAttributes(names = {"locale"})
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	//国际化注解
	private ResourceBundleMessageSource messageSource;
	
	//总查询(包含分页和模糊查询)
	@RequestMapping("/projects")
	@ResponseBody
	public Page ProjectList(String projectFuzzy,String pageNow,HttpServletRequest request,Locale locale,Map<String, Object> map) throws Exception {
		
		PageEntity pageEntity = new PageEntity();
		
		//分页
		if(pageNow != null && !"".equals(pageNow)) {
			//将得到的当前页放入实体类中
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		int count = projectService.zshuju(projectFuzzy);  //得到总条数
		pageEntity.setCount(count);     //将得到的总条数放入实体类中
		
		List<ProjectEntity> list = projectService.query(projectFuzzy, pageEntity);
		
		Page<?> page=new Page<>();
		page.setList(list);
		page.setPageEntity(pageEntity);
		
		return page;
		
	}
	
	
	//查询中转
	@RequestMapping("/projectList")
	public String a(Locale locale,Map<String, Object> map) {
		//国际化
		map.put("locale",locale.toString());
		return "admin/jsp/project/projectQuery";
		
	}
	
	//导出Excel表
	@RequestMapping("/excel")
	public String Excel(Locale locale,Map<String, Object> map) {
//		map.put("locale",messageSource.getMessage("project.see", null, locale));
		map.put("locale",locale);
		return "viewExcel";
	}
	
	
	
	//添加
	@RequestMapping(value = "/project",method = RequestMethod.POST)
	public String ProjectInsert(@Valid ProjectEntity projectentity,BindingResult result,Map<String, Object> map){
		
		if(result.getErrorCount() > 0 ) {
			System.out.println(result.getErrorCount());
			//得到所有有错的字段
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
				map.put(error.getField(),error.getDefaultMessage());
			}
			
			//将输入的值传到jsp页面回显
			map.put("a",projectentity);
			return "admin/jsp/project/projectInsert";
			
		}
		
		projectService.insert(projectentity);
		
		return "redirect:/projectList";
		
	}
	
	//添加中转
	@RequestMapping("/projectadd")
	public String b() {
		return "admin/jsp/project/projectInsert";
	}
	
	//删除
	@RequestMapping(value = "/project/{id}",method = RequestMethod.DELETE)
	public String ProjectDelete(@PathVariable("id") Integer id,HttpServletResponse response) throws Exception {
		
		projectService.delete(id);
		
		PrintWriter out = response.getWriter();
		out.print("\"status\":0}");
		out.flush();
		out.close();
		
		return "redirect:/projectList";
		
	}
	
	
	
	//修改
	@RequestMapping(value = "/project",method = RequestMethod.PUT)
	public String ProjectUpdate(String ArticleTitle,String ArticleText,Integer id) {
		
 		ProjectEntity porjectEntity = new ProjectEntity();
 		porjectEntity.setId(id);
		porjectEntity.setArticle_text(ArticleTitle);
		porjectEntity.setArticle_title(ArticleText);
		
		projectService.update(porjectEntity);
		
		return "redirect:/projectList";
	}
	
	
	//回显
	@RequestMapping(value = "/project",method = RequestMethod.GET)
	public String projectEcho(@PathParam("id") Integer id,HttpServletRequest request,Map<String,Object> map) {
		
		ProjectEntity projectentity = projectService.update1(id);
		
		map.put("projectentity",projectentity);
		
		return "admin/jsp/project/projectUqdate";
	}
	
	
	//循环查出正文内容
	@RequestMapping("/projectQuery/{id}")
	public void projectQuery(@PathVariable("id") Integer id,HttpServletResponse response) throws Exception {
		response.setContentType("application/text;charset=utf-8");
		String a = projectService.select(id);
		
		PrintWriter out = response.getWriter();
		out.println(a);
		out.flush();
		out.close();
		
	}
	
	
}
