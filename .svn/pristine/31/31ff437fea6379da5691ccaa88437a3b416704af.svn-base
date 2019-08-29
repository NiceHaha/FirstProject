package controller.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.util.JsonUtils;
import entity.project.ProjectEntity;
import entity.project.ProjectReport;
import service.project.ProjectService;

//举报前台后台增删改查
@Controller
public class ReportController {
	
	@Autowired
	private ProjectService projectService;
	
	
	//后台举报查询
	@RequestMapping("/reportquery")
	@ResponseBody
	public List<ProjectReport> reportquery(String projectFuzzy,HttpServletResponse response) throws Exception {
		
		List<ProjectReport> list = null;
		//如果前台返回的数据不是空和null(也就是有值)就调用模糊查询,查出特定的值
		if(projectFuzzy != null && !"".equals(projectFuzzy)) {
			list = projectService.jbmhcx(projectFuzzy);
		}else {
			//如果前台没有返回数据就调用普通查询,查出所有值
			list = projectService.chaxun();
		}
		
		return list;
	}
	
	//后台举报查询中转
	@RequestMapping("/reportList")
	public String a() {
		return "admin/jsp/project/projectreport";
		
	}
	
	//前台举报添加
	@RequestMapping("/reportinsert")
	private String reportinsert(String ArticleTitle,String reporting) {
		
		ProjectReport projectreport = new ProjectReport();
		projectreport.setArticletitle(ArticleTitle);
		projectreport.setReporting(reporting);
		
		projectService.insert1(projectreport);
		
		return "redirect:/foreground/goods.jsp";
	}
	
	
	//前台文章查询
	@RequestMapping("/reportecho")
	@ResponseBody
	public List<ProjectEntity> reportecho() {
		
		List<ProjectEntity> list = projectService.query();
		
		return list;
	}
	
	//前台文章查询中转
	@RequestMapping("/repo")
	public String b() {
//		return "foreground/jsp/project/project";
		return "/foreground/goods";
		
	}
	
	//前台举报文章回显
	@RequestMapping("/reportdisplay")
	public String reportdisplay(@PathParam("id") Integer id,HttpServletRequest request,Map<String,Object> map) {
		
		ProjectEntity projectentity = projectService.update1(id);
		
		//将从数据库中查出的值放入map中穿入jsp中
		map.put("projectentity",projectentity);
		
		return "foreground/jsp/project/report";
		
		
	}
	
	
}
