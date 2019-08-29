package controller.csr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;


import entity.csr.CsrEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.csr.CsrService;

/**
 * 客服Controller
 * 
 * @author :lyy
 * @date :下午9:34:27 2019年6月27日
 *
 */
@SessionAttributes("locale")
@Controller
public class CsrController {

	@Autowired
	private CsrService csrService;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;//用于国际化

	
	
	/**
	 * 客服查询
	 * 
	 * @param csrName 用于模糊查询 (客服所有数据)
	 * @param pageNow
	 * @return
	 */
	@ResponseBody // 返回json格式注解
	@RequestMapping(value = "/csrQueryAll", method = RequestMethod.GET)
	public Page<CsrEntity> CsrQueryAll(String csrName, Integer pageNow,Map<String,Object> map,Locale locale) {
		PageEntity pageEntity = new PageEntity();
		if (pageNow != null) {// 这里判断是否是第一次访问 如果不为null证明不是第一次访问 则把从页面的值set进去
			pageEntity.setPageNow(pageNow);
		}
		if (csrName == null) {// 如果客服名字等于null
			csrName = "";// 就进来赋个空
		}
		map.put("locale",locale.toString());
		int count = csrService.pageCount(csrName);// 得到总条数
		pageEntity.setCount(count);// 把数据set到页面对象
		List<CsrEntity> list = csrService.queryCsr(csrName, pageEntity);
		Page<CsrEntity> page = new Page<CsrEntity>();
		page.setList(list);
		page.setPageEntity(pageEntity);
		return page;
	}
	
	/**
	 * 	查询跳转
	 * @return
	 */
	@RequestMapping(value = "csrList",method = RequestMethod.GET)
	public String CsrQueryAllJump(Map<String,Object> map,Locale locale) {
		map.put("locale",locale.toString());
		return "/admin/jsp/csr/csrList";
	}
	
	
	
	
	
	
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/csr/{id}", method = RequestMethod.DELETE)
	public String csrDelete(@PathVariable("id") int id) {
		try {
			csrService.deleCsr(id);
			return "{\"csr\":1}";
		} catch (Exception e) {
			return "{\"csr\":0}";
		}
	}

	
	
	
	
	
	
	
	/**
	 *	 添加
	 * 
	 * @param csrEntity 客服对象
	 * @param result
	 * @param locale    用于国际化
	 * @return
	 */
	@RequestMapping(value ="/csr", method = RequestMethod.POST)
	public String add(@Valid CsrEntity csrEntity,Errors errors, @RequestParam("csrPicture") MultipartFile file,Map<String,Object> map,Locale locale) throws IOException{
		
		String path="d:\\Users\\king\\Desktop\\wjsc";
		//存储路径加名字
		path=path+"\\"+file.getOriginalFilename();
		File filepath=new File(path);
		//判断文件是否存在
		if(!filepath.exists()) {
			filepath.createNewFile();
		}
		OutputStream outputStream=new FileOutputStream(filepath);
		//得到一个byte数组 流每次输入多少
		InputStream inputStream = file.getInputStream();
		byte[] bytes=new byte[1024*1024*10];
		int length=0;
		
		while ((length=inputStream.read(bytes))!=-1) {
			//每次输出多少 从下标几开始 
			outputStream.write(bytes,0,length);
		}
		inputStream.close();
		outputStream.close();
		
		//数据效验
		if(errors.getErrorCount()>0) {
			List<FieldError> list=errors.getFieldErrors();
			for (FieldError fieldError : list) {
				//fieldError.getField()获取异常字段名,fieldError.getDefaultMessage()获取异常信息
				System.out.println("["+fieldError.getField()+"]"+":"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return "admin/jsp/csr/csrAdd";
		}
		csrEntity.setCsrPath(path);//图片
		int empCode = (int)Math.round(Math.random()*9999999);//客服编码（产生随机数）
		csrEntity.setEmpCode("KFB-CSR-"+empCode);//客服编号
		csrService.insertCsr(csrEntity);
		return "admin/jsp/csr/csrList";
	}
	
	/**
	 *  新增前用于跳转,中间意思(查询默认数据功能)
	 * @param locale
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/csrPut", method = RequestMethod.GET)
	public String addPust(Locale locale,Map<String,Object> map) {
		map.put("locale",locale.toString());
		map.put("csrEntity", new CsrEntity());
		return "admin/jsp/csr/csrAdd";
	}

	
	
	
	/**
	 * 	图片
	 * @param id
	 * @param rp
	 */
	@RequestMapping(value = "/getCsrImg",method = RequestMethod.GET)
    public void getImagesId(@RequestParam("CsrImgUrl") int id, HttpServletResponse rp) {
		CsrEntity csrEntity=csrService.queryCsrId(id);
        String filePath = csrEntity.getCsrPath();
        File imageFile = new File(filePath);
        if (imageFile.exists()) {
            FileInputStream fis = null;
            OutputStream os = null;
            try {
                fis = new FileInputStream(imageFile);
                os = rp.getOutputStream();
                int count = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((count = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, count);
                    os.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	
	
	/**
	 * 	修改出现异常时在跳转成修改页面
	 * @param csrEntity
	 * @param error
	 * @param path
	 * @return
	 */
	@RequestMapping("/csrJump")
	public String csrJump(@Valid CsrEntity csrEntity,Error error,String path) {
		return path;
	}
		
	/**
	 * 	修改跳转
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/csr/{id}", method = RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map) {
		// 回显用户
		CsrEntity csrEntity = csrService.queryCsrId(id);
		map.put("csrEntity",csrEntity);
		return "admin/jsp/csr/csrUpdate";
	}

	/**
	 * 	修改
	 * @param file
	 * @param csrEntity
	 * @param result
	 * @param map
	 * @param locale
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/csr", method = RequestMethod.PUT)
	public String update(@RequestParam("csrPicture") MultipartFile file,@Valid CsrEntity csrEntity, BindingResult result, Map<String, Object> map, Locale locale) throws IOException {
		
		String path="d:\\Users\\king\\Desktop\\wjsc";
		//存储路径加名字
		path=path+"\\"+file.getOriginalFilename();
		File filepath=new File(path);
		//判断文件是否存在
		if(!filepath.exists()) {
			filepath.createNewFile();
		}
		OutputStream outputStream=new FileOutputStream(filepath);
		//得到一个byte数组 流每次输入多少
		InputStream inputStream = file.getInputStream();
		byte[] bytes=new byte[1024*1024*10];
		int length=0;
		
		while ((length=inputStream.read(bytes))!=-1) {
			//每次输出多少 从下标几开始 
			outputStream.write(bytes,0,length);
		}
		inputStream.close();
		outputStream.close();
		
		//数据效验
		if(result.getErrorCount()>0) {
			List<FieldError> list=result.getFieldErrors();
			for (FieldError fieldError : list) {
				//fieldError.getField()获取异常字段名,fieldError.getDefaultMessage()获取异常信息
				System.out.println("["+fieldError.getField()+"]"+":"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return "forward:csrJump?path=/admin/jsp/csr/csrUpdate";
		}
		csrEntity.setCsrPath(path);
		map.put("locale",locale.toString());//国际化
		map.put("csrEntity",csrEntity);//回显
		csrService.updateCsr(csrEntity,csrEntity.getId());
		return "redirect:csrList";
	}
	
	
	
	
	
	

	/**
	 * 自定义视图
	 */
	@RequestMapping("/csrviewExcel")
	public String viewExcel(HttpServletRequest request,Map<String, Object> map, Locale locale) {
		map.put("locale",locale);
		return "excelViewResolver";
	}
	
		
}
