package controller.advert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletException;
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

import dao.util.JsonUtils;
import dao.util.PathPropertiesUtil;
import entity.advert.AdvertEntity;
import entity.material.MaterialEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.advert.AdvertService;

@Controller
@RequestMapping("/advertHandler")
public class AdvertHandler {

	@Autowired
	private AdvertService advertService;
	
	/**
	  *  新增的中转
	 */
	@RequestMapping(value = "/advert",method = RequestMethod.GET)
	public String insertUrl() {
		return "admin/jsp/advert/advertAdd";
	}
	
	/**
	  * 新增
	 * @throws IOException 
	 */
	@RequestMapping(value = "/advert",method = RequestMethod.POST)
	public String insert(@Valid AdvertEntity advert,BindingResult errors,Map<String,Object> map,String advertGoodsCode,@RequestParam("file") MultipartFile file) throws IOException{
		System.out.println("新增");
		System.out.println(errors.getErrorCount());
		if (errors.getErrorCount()>0) {
			List<FieldError> list = errors.getFieldErrors();
			for (FieldError fieldError : list) {
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return "admin/jsp/advert/advertAdd";
		}
		
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
		
		/*点击次数，默认为0*/
		advert.setAdvertClick(0);
		/*展示状态，默认为0，不展示。1为展示*/
		advert.setAdvertShow(0);
		
		advert.setAdvertUrl(path);
		advert.setGoodsCode(advertGoodsCode);
		
		advertService.insertAdvert(advert);
		return "redirect:/advertHandler/advertList";
	}
	
	public String getFileName(String header) {
		// TODO Auto-generated method stub
		String[] temp1 = header.split(";");
		String[] temp2 = temp1[2].split("=");
		String fileName = temp2[1].substring(temp2[1].lastIndexOf("\\")+1).replaceAll("\"","");
		return fileName;
	}
	
	/**
	  * 删除
	 */
	@ResponseBody
	@RequestMapping(value = "/advert/{id}",method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		try { //删除成功
			advertService.deleteAdvert(id);
			return "{\"advDelStatus\":0}";//删除成功返回0
		} catch (Exception e) {//删除失败
			return "{\"advDelStatus\":1}";
		}
	}
	
	/**
	 *  PUT、DELETE转GET
	 */
	@RequestMapping("/jump")
	public String toPage(@Valid @ModelAttribute("AdvertEntity") AdvertEntity advert,BindingResult errors,Map<String,Object> map,String viewName) {
		map.put("advertEntity",advert);
		return viewName;
	}
	
	/**
	  *  修改的中转
	 * @throws Exception 
	 */
	@RequestMapping(value="/advert/{id}",method = RequestMethod.GET)
	public String queryOne(@PathVariable("id") Integer id,Map<String,Object> map) throws Exception {
		AdvertEntity advert = advertService.queryOneAdvert(id);
		map.put("advert", advert);
		return "admin/jsp/advert/advertUpdate";
	}

	/**
	 *  回显。进每个方法前都会先进这里。put的值给了jsp的ModelAttribute。
	 */
	@ModelAttribute
	public void getAdvert(@RequestParam(value="id",required = false) Integer id,Map<String, Object> map) {
		if (id != null) {//id不为null，则为修改,就要回显，以防修改时，未修改的值为空的
			map.put("advertEntity", advertService.queryOneAdvert(id));
		}
	}
	
	/**
	  * 修改
	 * @throws IOException 
	 */
	@RequestMapping(value="/advert",method = RequestMethod.PUT)
	public String update(@Valid  AdvertEntity advert,BindingResult errors,Map<String,Object> map,@RequestParam("file") MultipartFile file) throws IOException {
		if (errors.getErrorCount()>0) {//这里对错误进行了处理，所以如果有错误，不会返回到浏览器界面上，而是返回到后台这个方法里面来继续执行，但是这里面会得到错误。如果这里不处理，会返回400到浏览器
			List<FieldError> list = errors.getFieldErrors();
			for (FieldError fieldError : list) {
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return "forward:jump?viewName=admin/jsp/advert/advertUpdate";
		}
		
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
		
		advert.setAdvertUrl(path);
		
		advertService.updateAdvert(advert);
		return "redirect:/advertHandler/advertList";
	}
	
	
	/**
	  * 修改展示状态
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value="/advert/{id}",method = RequestMethod.PUT)
	public String update(int advertShow,@PathVariable("id") int id) {
		int mark = advertService.updateAdvertShow(advertShow,id);
		if (mark == 1) {//修改成功，改变效果
			return "{\"status\":0}";
		}else {//修改失败，不改变效果
			return "{\"status\":1}";
		}
	}
	
	/**
	  * 查询的中转
	 * @throws IOException 
	 */
	@RequestMapping(value="/advertList",method = RequestMethod.GET)
	public String advertList() {
		return "admin/jsp/advert/advertList";
	}
	
	/**
	  * 查询
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/adverts")
	public Page<AdvertEntity> query(String pageNow) {
		PageEntity page = new PageEntity();
		if (pageNow != null && !pageNow.equals("")) {
			page.setPageNow(Integer.parseInt(pageNow));
		}
		
		List<AdvertEntity> listAdvert = advertService.queryAdvertPage(page);
		
		Page<AdvertEntity> pageT = new Page<>();
		pageT.setList(listAdvert);
		pageT.setPageEntity(page);
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
}

