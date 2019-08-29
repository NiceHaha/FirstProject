package controller.goods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.brand.BrandDao;
import dao.util.JsonUtils;
import dao.util.PathPropertiesUtil;
import entity.goods.GoodsEntity;
import entity.goodsreciew.GoodsReciewEntity;
import entity.page.Page;
import entity.page.PageEntity;
import service.brand.BrandService;
import service.goods.GoodsService;

@Controller
@RequestMapping("/goodsHandler")
public class GoodsHandler {
	@Autowired 
	private GoodsService goodsService;
	@Autowired
	private BrandService brandService;
	
//	查询中转
	@RequestMapping("/goodss/goods")
	public String quyer() {
		return "/admin/jsp/goods/oktrialList";
	}
//	查询
	@RequestMapping("/goodss")
	@ResponseBody
	public Page goodsList(String dataName,String pageNow) {
		//当前第几页
		List<GoodsEntity> list= null;
		PageEntity pageEntity=new PageEntity();
		if(pageNow !=null && !"".equals(pageNow))
		pageEntity.setPageNow(Integer.parseInt(pageNow));
		//得到总条数
		int conut=goodsService.pageCount(dataName);
		pageEntity.setCount(conut);
		//查询方法
		list=goodsService.Query(dataName, pageEntity);
		
		//泛型
		Page page=new Page();
		page.setList(list);
		page.setPageEntity(pageEntity);
		return page;
	}
	
	@RequestMapping(value = "/getImage",method = RequestMethod.GET)
    @ResponseBody
    public void getImagesId(@RequestParam("materialUrl") int id, HttpServletResponse rp) {
		GoodsEntity entity=goodsService.Query1(id);
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
	
//	删除
	@RequestMapping("/goods/{id}")
	@ResponseBody
	public String deleteGoods(@PathVariable("id")int id) {
		//Json的编码格式
		goodsService.delete(id);
		String aa="{'aa'=0}";
		return aa;
	}
	
//	修改中转
	@RequestMapping("/updatetrial")
	public String update(@PathParam("id") int id,Map<String, Object> map) {
		GoodsEntity entity=goodsService.Query1(id);
		map.put("goods", entity);
		return "/admin/jsp/goods/updateOkTrialGoods";
	}
//	修改
	@RequestMapping(value = "/goods",method =RequestMethod.PUT)
	public String update1(@RequestParam("Goodsimg") MultipartFile file ,int id,String goodsp,String goodsd,String goodsname,String goodsCode,String goodsj,String goodsm,String goodsy) throws IOException {
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
				String goodstype=brandService.selectcode(goodsp);
				GoodsEntity goods=new GoodsEntity();
				goods.setTypeCode(goodstype);
				goods.setId(id);
				goods.setCode(goodsCode);
				goods.setGoodsName(goodsname);
				goods.setGoodsPrice(Integer.parseInt(goodsj));
				goods.setGoodsDescribe(goodsm);
				goods.setGoodsColor(goodsy);
				goods.setGoodsPath(path);
				
				goodsService.update(goods);
				return "redirect:/goodsHandler/goodss/goods";
	}
	
}

