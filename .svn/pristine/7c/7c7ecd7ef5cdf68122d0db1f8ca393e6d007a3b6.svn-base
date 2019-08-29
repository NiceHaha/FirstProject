package controller.material;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import dao.util.JsonUtils;
import dao.util.PathPropertiesUtil;
import entity.advert.AdvertEntity;
import entity.material.MaterialEntity;
import entity.page.Page;
import entity.page.PageEntity;
import entity.user.UserEntity;
import service.material.MaterialService;

@Controller
@RequestMapping("/materialHandler")
public class MaterialHandler {
	@Autowired
	private MaterialService materialService;
	
	/**
	  *  新增的中转
	 */
	@RequestMapping(value = "/material",method = RequestMethod.GET)
	public String insertUrl() {
		return "admin/jsp/material/materialAdd";
	}
	
	/**
	  * 新增
	 * @throws IOException 
	 */
	@RequestMapping(value = "/material",method = RequestMethod.POST)
	public String insert(@ModelAttribute("materialEntity") MaterialEntity material ,@RequestParam("file") MultipartFile file) throws IOException {
		/*广告图片*/
		String path = PathPropertiesUtil.getPath("path");//获取存储路径
		String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("\\")+1);
		path=path+"/"+fileName;
		File filepath=new File(path);
		if(!filepath.exists()) {
			filepath.createNewFile();
		}
		OutputStream outputStream=new FileOutputStream(filepath);
		InputStream inputStream = file.getInputStream();
		byte[] bytes=new byte[1024*1024*10];
		int length=0;
		
		while ((length=inputStream.read(bytes))!=-1) {
			outputStream.write(bytes,0,length);
		}
		inputStream.close();
		outputStream.close();
		
		/*素材编号*/
		int code = (int) Math.round(Math.random()*777777);
		String materialCode = "material"+String.valueOf(code);
		material.setMaterialCode(materialCode);
		material.setMaterialUrl(path); 
		
		materialService.insertMaterial(material);
		return "redirect:/materialHandler/materialList";
	}
	
	/**
	  * 删除
	 */
	@ResponseBody
	@RequestMapping(value = "/material/{id}",method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") int id) {
		try { //删除成功
			materialService.deleteMaterial(id);
			return "{\"mtrDelStatus\":0}";//删除成功返回0
		} catch (Exception e) {//删除失败
			// TODO: handle exception
			return "{\"mtrDelStatus\":1}";
		}
	}
	
	/**
	 *  PUT、DELETE转GET
	 */
	@RequestMapping("/jump")
	public String toPage(@Valid @ModelAttribute("materialEntity") MaterialEntity material,BindingResult errors,Map<String,Object> map,String viewName) {
		map.put("materialEntity",material);
		return viewName;
	}
	
	/**
	 *  修改中转
	 * @throws Exception 
	 */
	@RequestMapping(value="/material/{id}",method = RequestMethod.GET)
	public String queryOne(@PathVariable("id") Integer id,Map<String,Object> map) throws Exception {
		MaterialEntity material = materialService.queryOneMaterial(id);
		map.put("material", material);
		return "admin/jsp/material/materialUpdate";
	}
	
	/**
	 *  回显。进每个方法前都会先进这里。put的值给了jsp的ModelAttribute。
	 */
	@ModelAttribute
	public void getMaterial(@RequestParam(value="id",required = false) Integer id,Map<String, Object> map) {
		if (id != null) {//id不为null，则为修改,就要回显，以防修改时，未修改的值为空的
			map.put("materialEntity", materialService.queryOneMaterial(id));
		}
	}
	
	/**
	  * 修改
	 * @throws IOException 
	 */
	@RequestMapping(value="/material",method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("materialEntity") MaterialEntity material ,BindingResult errors,Map<String,Object> map,@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(errors.getErrorCount());
		if (errors.getErrorCount()>0) {//这里对错误进行了处理，所以如果有错误，不会返回到浏览器界面上，而是返回到后台这个方法里面来继续执行，但是这里面会得到错误。如果这里不处理，会返回400到浏览器
			List<FieldError> list = errors.getFieldErrors();
			for (FieldError fieldError : list) {
//				map.put("material", material);
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return "forward:jump?viewName=admin/jsp/material/materialUpdate";
		}
		
		String path = PathPropertiesUtil.getPath("path");//获取存储路径
		String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("\\")+1);
		path=path+"/"+fileName;
		File filepath=new File(path);
		if(!filepath.exists()) {
			filepath.createNewFile();
		}
		OutputStream outputStream=new FileOutputStream(filepath);
		InputStream inputStream = file.getInputStream();
		byte[] bytes=new byte[1024*1024*10];
		int length=0;
		
		while ((length=inputStream.read(bytes))!=-1) {
			outputStream.write(bytes,0,length);
		}
		inputStream.close();
		outputStream.close();
		
		material.setMaterialUrl(path); 
		materialService.updateMaterial(material);
		return "redirect:/materialHandler/materialList";
	}
	
	/**
	  * 查询的中转
	 * @throws IOException 
	 */
	@RequestMapping(value="/materialList",method = RequestMethod.GET)
	public String advertList() {
		return "admin/jsp/material/materialList";
	}
	
	/**
	 * @throws IOException 
	 */
	@RequestMapping(value="/change",method = RequestMethod.GET)
	public String advertList(Map<String, Object> map,Locale locale,HttpServletRequest request) {
		request.getSession().setAttribute("locale", locale);
		//map.put("locale", locale.toString());//把接收到的参数放入request
		return "admin/index";
	}
	
	/**
	  * 查询
	 */
	@ResponseBody
	@RequestMapping("/materials")
	public Page<MaterialEntity> query(String pageNow,String materialName) {
		PageEntity page = new PageEntity();
		if (pageNow != null && !pageNow.equals("")) {
			page.setPageNow(Integer.parseInt(pageNow));
		}
		
		Page<MaterialEntity> pageT = new Page<>();
		if (materialName==null || materialName.equals("")) {
			List<MaterialEntity> listMaterial = materialService.queryMaterialPage(page);
			pageT.setList(listMaterial);
			pageT.setPageEntity(page);
		}else {
			List<MaterialEntity> listMaterial = materialService.queryMaterialPage(page, materialName);
			pageT.setList(listMaterial);
			pageT.setPageEntity(page);
		}
		
		return pageT;
	}
	
	/**
	  *  图片显示
	 * @throws Exception 
	 */
	@RequestMapping(value= {"/showPhoto"},method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
	@ResponseBody
	public void showPhoto(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,@RequestParam("path") String path) throws Exception {
		InputStream inputStream = new FileInputStream(path);
		byte[] photo = new byte[inputStream.available()];
		inputStream.read(photo);
		httpServletResponse.setContentType("image/png");
		OutputStream outputStream = httpServletResponse.getOutputStream();
		outputStream.write(photo);
		outputStream.flush();
		outputStream.close();
	}
	
	/**
	 *  导出Excel表
	 * @throws Exception 
	 */
	 @RequestMapping(value = "/viewExcel")
	    public String viewExcel() {
//	        Map<String, Object> model = new HashMap<>();
//	        List<MaterialEntity> materialList = materialService.queryMaterial();
//	        model.put("materialList", materialList);
//	        return new ModelAndView(new ExcelView(), model);
		 return "excelView";
	    }
}