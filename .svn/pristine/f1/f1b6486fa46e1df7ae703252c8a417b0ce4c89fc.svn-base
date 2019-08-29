package controller.goods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletOutputStream;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import entity.goods.GoodsEntity;
import entity.goodsreciew.GoodsReciewEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.Agent.AgentService;
import service.brand.BrandService;
import service.goods.GoodsService;
import service.goodsreciew.GoodsreciewService;

@Controller
@RequestMapping(value = "/goodsreciewHandler")
@SessionAttributes(names = {"locale"})
public class goodsreciewHandler {
	@Autowired
	private ResourceBundleMessageSource messageSource;
	@Autowired 
	private GoodsreciewService goodsreciewService;
	@Autowired
	private AgentService agentService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private GoodsService goodsService;
	
	
//	查询跳转
	@RequestMapping(value = "/goodsreciews/goodsreciew")
	public String query(Locale locale,Map<String, Object> map) {
		System.out.println(locale);
		map.put("locale", locale);
		return "/admin/jsp/goods/goodsList";
	}
//	审核页面跳转
	@RequestMapping(value = "/goodsreciews/goodsreciewa")
	public String query1() {
		
		return "/admin/jsp/goods/trialList";
	}
	/**
	 * 查询
	 * @param dateName
	 * @param pageNow
	 * @return
	 */
	@RequestMapping(value = "/goodsreciews",method = RequestMethod.GET)
	@ResponseBody
	public Page queryGoodsreciew(String dateName,String pageNow) {
		List<GoodsReciewEntity> list=null;
		PageEntity pageentity=new PageEntity(); 
		//将值设到page对象里面
		if(pageNow !=null && !"".equals(pageNow))
		pageentity.setPageNow(Integer.parseInt(pageNow));
		//得到总条数
		int conut=goodsreciewService.pageCount(dateName);
		pageentity.setCount(conut);
		//得到List对象
		list = goodsreciewService.query3(dateName, pageentity);
		Page<?> page = new Page();
		page.setList(list);
		page.setPageEntity(pageentity);
		return page;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "goodsreciew/{cc}",method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteGoodsreciews(@PathVariable("cc") int id) {
		goodsreciewService.delete(id);
		String aa="{'aa'=0}";
		return aa;
	}
	
	@RequestMapping(value = "/goodsreciew/addgoods")
	public String allGoods() {
		return "/admin/jsp/goods/goodsAdd";
	}
	
	
	@RequestMapping(value = "/goodsreciew",method = RequestMethod.POST)
	public String addGoodsreciew(@RequestParam("Goodsimg") MultipartFile file,@Valid GoodsReciewEntity goodsReciewEntity,BindingResult result,String goodsp,String goodsd,String goodsj,String goodsm,String goodsy,String goodsName,Map<String,Object> map) throws IOException {
		if(result.getErrorCount() > 0 ) {
			System.out.println(result.getErrorCount());
			//得到所有有错的字段
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
				map.put(error.getField(),error.getDefaultMessage());
			}
			//将输入的值传到jsp页面回显
			return "/admin/jsp/goods/goodsAdd";
		}
		
		String path="C:\\Users\\Administrator\\Desktop\\saveFile";
//		存储路径加名字
		path=path+"\\"+file.getOriginalFilename();
		File filepath=new File(path);
//		判断文件是否存在
		if(!filepath.exists()) {
//			不存在就创建一个
			filepath.createNewFile();
		}
		OutputStream outputStream=new FileOutputStream(filepath);
//		得到一个byte数组 流每次输入多少
		InputStream inputStream = file.getInputStream();
		byte[] bytes=new byte[1024*1024*10];
		int length=0;
		
		while ((length=inputStream.read(bytes))!=-1) {
//			每次输出多少 从下标几开始 
			outputStream.write(bytes,0,length);
		}
		inputStream.close();
		outputStream.close();
		
		//得到代理商编号
		String ageetcode= agentService.agentcode(goodsd);
	
		//得到品牌的编码
		String goodstype= brandService.selectcode(goodsp);
	
		//表名加随机数成一个编码
		int code = (int)Math.round(Math.random()*888888);
		
		//默认给审核状态填入一个0 0代表未审核
		int to=0;
		
		//设值
		GoodsReciewEntity goods=new GoodsReciewEntity();
		goods.setGoodsCode("Goods"+code);
		goods.setGoodsName(goodsName);
		if(goodsj !=null && !goodsj.equals("")) {
		goods.setGoodsPrice(Integer.parseInt(goodsj));
		}else {
			goods.setGoodsPrice(0);
		}
		goods.setGoodsDescribe(goodsm);
		goods.setGoodsColor(goodsy);
		goods.setTypeCode(goodstype);
		goods.setGoodsTo(to);
		//商品图片
		goods.setGoodsPath(path);
		goods.setAgentCode(ageetcode);
		
		goodsreciewService.add(goods);
		return "/admin/jsp/goods/goodsList";
	
}
	
	@RequestMapping(value = "/getImage",method = RequestMethod.GET)
    @ResponseBody
    public void getImagesId(@RequestParam("materialUrl") int id, HttpServletResponse rp) {
		GoodsReciewEntity entity=goodsreciewService.query1(id);
        String filePath = entity.getGoodsPath();
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
	
//	修改中转
	@RequestMapping("/updatetrial")
	public String update(@PathParam("id") int id,Map<String, Object> map) {
		GoodsReciewEntity entity=goodsreciewService.query1(id);
		map.put("goods", entity);
		
		return "/admin/jsp/goods/updateTrialGoods";
	}
	
	
//	修改
	@RequestMapping(value = "/goodsreciew",method = RequestMethod.PUT)
	public String update(@RequestParam("Goodsimg") MultipartFile file,int id,String goodsp,String goodsd,String goodsname,String goodsCode,String goodsj,String goodsm,String goodsy) throws IOException {
		String path="C:\\Users\\Administrator\\Desktop\\saveFile";
//		存储路径加名字
		path=path+"\\"+file.getOriginalFilename();
		File filepath=new File(path);
//		判断文件是否存在
		if(!filepath.exists()) {
//			不存在就创建一个
			filepath.createNewFile();
		}
		OutputStream outputStream=new FileOutputStream(filepath);
//		得到一个byte数组 流每次输入多少
		InputStream inputStream = file.getInputStream();
		byte[] bytes=new byte[1024*1024*10];
		int length=0;
		
		while ((length=inputStream.read(bytes))!=-1) {
//			每次输出多少 从下标几开始 
			outputStream.write(bytes,0,length);
		}
		inputStream.close();
		outputStream.close();

				//品牌编码
				String goodstype= brandService.selectcode(goodsp);
				
				//默认给审核状态填入一个0 0代表未审核
				int to=0;
				
				GoodsReciewEntity goods=new GoodsReciewEntity();
				goods.setTypeCode(goodstype);
				goods.setId(id);
				goods.setGoodsCode(goodsCode);
				goods.setGoodsName(goodsname);
				goods.setGoodsPrice(Integer.parseInt(goodsj));
				goods.setGoodsDescribe(goodsm);
				goods.setGoodsPath(path);
				goods.setGoodsColor(goodsy);
				goods.setGoodsTo(to);
				goodsreciewService.update(goods);
				
				return "redirect:/goodsreciewHandler/goodsreciews/goodsreciew";
	}
	
	
//	通过审核
	@RequestMapping("goodsTrial")
	public String goodsTrial(int id) {
		List<GoodsReciewEntity> list =goodsreciewService.query(id);
		for (GoodsReciewEntity goodse : list) {
			//品牌编号
			String typecode=goodse.getTypeCode();
			//代理商编号
			String goodsagetntcode=goodse.getAgentCode();
			//商品编号
			String goodscode= goodse.getGoodsCode();
			//商品名字
			String goodsname= goodse.getGoodsName();
			//商品图片
			String goodspate=goodse.getGoodsPath();
			//商品价格
			int goodsprice=goodse.getGoodsPrice();
			//商品颜色
			String goodscolor=goodse.getGoodsColor();
			//商品描述
			String goodsdescride=goodse.getGoodsDescribe();
			
			GoodsEntity goods=new GoodsEntity();
			//商品编号
			goods.setCode(goodscode);
			//商品名字
			goods.setGoodsName(goodsname);
			//商品的品牌编号
			goods.setTypeCode(typecode);
			//商品代理商的编号
			goods.setAgentCode(goodsagetntcode);
			//商品的颜色
			goods.setGoodsColor(goodscolor);
			//商品的描述
			goods.setGoodsDescribe(goodsdescride);
			//商品的价格
			goods.setGoodsPrice(goodsprice);
			//商品的图片
			goods.setGoodsPath(goodspate);
			//GoodsDao goodsdao=new GoodsDao();
			goodsService.add(goods);
		}
		//审核通过之后把未审核那里给删了
		goodsreciewService.delete(id);
		return "redirect:/admin/jsp/goods/trialList.jsp";
	}
	
//	导出到Excel
	@RequestMapping(value = "/getExcel")
	public String getExcel() {
		return "getExecel";
	}

}
