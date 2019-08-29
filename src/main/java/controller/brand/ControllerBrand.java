package controller.brand;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;

import entity.brand.Brand;
import entity.page.Page;
import entity.page.PageEntity;
import service.brand.BrandService;
@Controller
@SessionAttributes("locale")
public class ControllerBrand {
	@Autowired
	private BrandService bs;
	
	

	/**
	 * 查询是否输入了相同的名称
	 * 
	 * @param agName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("brand/count")
	public String count(String brName) {
		// 在页面上拿到输入的值
		Integer i = bs.count(brName); // 查询用户名是存在, 0表示不存在
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
	@RequestMapping(value="/brandList",method = RequestMethod.GET)
	public String agentList(Locale locale,HttpServletRequest request) {
		request.getSession().setAttribute("locale", locale.toString());
		return "admin/jsp/brand/brandList";
	}
	
	/**
	 * 查询
	 * @param str
	 * @param pageNow
	 * @return
	 */
	@ResponseBody
	@RequestMapping("brands")
	public Page<Brand> querybrand(String str,String pageNow) {
		PageEntity pageEntity = new PageEntity();
		if(pageNow != null && !pageNow.equals("")) {
			pageEntity.setPageNow(Integer.parseInt(pageNow));
		}
		if(str == null) {
			str = "";
		}
		int count = bs.brandCount(str); //得到总条数
		pageEntity.setCount(count);
		int pageCount = bs.pageCount(count,pageEntity.getPageSize());//得到总页数
		pageEntity.setPageCount(pageCount);
		List<Brand> br = bs.select(str, pageEntity);
		Page<Brand> page = new Page<>();
		page.setList(br);
		page.setPageEntity(pageEntity);
		return page;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="brand/{id}",method = RequestMethod.DELETE)
	public String deletebrand(@PathVariable("id") Integer id) {
		// 在页面上拿到输入的值
		Brand br = bs.get(id);
		bs.deletegoods(br.getCode());
		bs.deleteag(br.getCode());
		bs.delete(id);
		return "0";
	}
	
	/**
	  *  新增的中转
	 */
	@RequestMapping(value = "/brand",method = RequestMethod.GET)
	public String addUrl() {
		return "admin/jsp/brand/brandAdd";
	}
	
	/**
	 * 添加
	 * @param brName
	 * @param brTel
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="brand/add",method = RequestMethod.POST)
	public String addbrand(@Valid Brand brand,BindingResult result, @RequestParam("brurl") MultipartFile file,ModelMap mm,Locale locale) throws IOException {
		// 0表示没错，大于0表示有错
		if (result.getErrorCount() > 0) {
			// 得到所有有错的字段
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
				mm.addAttribute(error.getField(), error.getDefaultMessage());
			}
			mm.addAttribute("Brand", brand);
			return "admin/jsp/brand/brandAdd";
		}
		String path = "C:\\Users\\Administrator\\Desktop\\1";
		// 存储路径加名字
		path = path + "\\" + file.getOriginalFilename();
		File filepath = new File(path);
		//判断文件是否存在
		if (!filepath.exists()) {
			//不存在就创建一个 
			filepath.createNewFile();
		}
		OutputStream outputStream = new FileOutputStream(filepath);
		//得到一个byte数组 流每次输入多少
		InputStream inputStream = file.getInputStream();
		byte[] bytes = new byte[1024 * 1024 * 10];
		int length = 0;

		while ((length = inputStream.read(bytes)) != -1) {
			//每次输出多少 从下标几开始 
			outputStream.write(bytes, 0, length);
		}
		inputStream.close();
		outputStream.close();
		int code = (int) Math.round(Math.random() * 9999999);
		brand.setCode("hor_" + code);
		brand.setBrand_url(path);
		bs.insert(brand);
		return "redirect:/brandList";
	}
	
	/**
	 * 回显
	 * @param id
	 * @param mm
	 * @return
	 */
	@RequestMapping(value="brand/{id}",method = RequestMethod.GET)
	public String getbrand(@PathVariable("id") Integer id,ModelMap mm) {
		Brand brand = bs.get(id);
		mm.addAttribute("brand", brand);
		return "admin/jsp/brand/brandUpdate";
	}
	
	@ModelAttribute
	public void getBrand(@RequestParam(value="id",required=false) Integer id,Map<String, Object> map){
		if(id != null){
			map.put("brand", bs.get(id));
			System.out.println("modelattrbute");
		}
	}
	
	/**
	 * 修改
	 * @param brName
	 * @param brTel
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="brand/update",method = RequestMethod.POST)
	public String updatebrand(@Valid Brand brand,BindingResult result,@RequestParam("brurl") MultipartFile file,ModelMap mm,Locale locale) throws IOException {
		// 0表示没错，大于0表示有错
				if (result.getErrorCount() > 0) {
					// 得到所有有错的字段
					for (FieldError error : result.getFieldErrors()) {
						System.out.println(error.getField() + ":" + error.getDefaultMessage());
						mm.addAttribute(error.getField(), error.getDefaultMessage());
					}
					mm.addAttribute("Brand", brand);
					return "forward:/aa?url=admin/jsp/brand/brandUpdate";
				}
		String path = "C:\\Users\\Administrator\\Desktop\\1";
		//存储路径加名字
		path = path + "\\" + file.getOriginalFilename();
		File filepath = new File(path);
		//判断文件是否存在
		if (!filepath.exists()) {
			//不存在就创建一个 
			filepath.createNewFile();
		}
		OutputStream outputStream = new FileOutputStream(filepath);
		//得到一个byte数组 流每次输入多少
		InputStream inputStream = file.getInputStream();
		byte[] bytes = new byte[1024 * 1024 * 10];
		int length = 0;

		while ((length = inputStream.read(bytes)) != -1) {
			//每次输出多少 从下标几开始 
			outputStream.write(bytes, 0, length);
		}
		inputStream.close();
		outputStream.close();
		brand.setBrand_url(path);
		bs.update(brand);
		return "redirect:/brandList";
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
	@RequestMapping(value = "/aa")
	public String ee(String url,@Valid Brand brand,BindingResult bindResult,Map<String,Object> map) {
		map.put("Brand", brand);
		System.out.println("重定向");
		return url;
	}
	
	/**
	 * 自定义视图
	 */
	@RequestMapping("/brand/viewExcel")
	public String viewExcel(ModelMap mm,Locale locale) {
		mm.addAttribute("locale", locale);
		return "brandExcel";
	}
}
