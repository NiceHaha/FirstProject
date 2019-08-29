package service.material;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.material.MaterialDao;
import entity.material.MaterialEntity;
import entity.page.PageEntity;

@Service
public class MaterialService {
	@Autowired
	private MaterialDao materialDao;
	
	/**
	  *  添加素材
	 * @param material
	 * @author zlj
	 */
	public void insertMaterial(MaterialEntity material) {
		materialDao.insertMaterial(material);
	}
	
	/**
	 * 检查素材名称不能重复
	 * @param materialName
	 * @return int
	 * @author zlj
	 */
	public int checkMaterialName(String materialName) {
		int mark = materialDao.checkMaterialName(materialName);
		return mark;
	}
	
	/**
	 * 修改时检查素材名称不能与其他相同
	 * @param materialName
	 * @param materialId
	 * @return int
	 * @author zlj
	 */
	public int checkUpdateMaterialName(String materialName,Integer materialId) {
		int mark = materialDao.checkUpdateMaterialName(materialName, materialId);
		return mark;
	}
	
	/**
	  * 删除素材
	 * @param materialId
	 * @author zlj
	 */
	public void deleteMaterial(Integer materialId) {
		materialDao.deleteMaterial(materialId);
	}
	
	/**
	 * 根据素材编号查询单条素材数据， 用于修改时回显,编号不能修改
	 * @param materialId
	 * @return material
	 * @author zlj
	 */
	public MaterialEntity queryOneMaterial(Integer materialId) {
		MaterialEntity material = materialDao.queryOneMaterial(materialId);
		return material;
	}
	
	/**
	  * 修改素材
	 * @param material
	 * @author zlj
	 */
	public void updateMaterial(MaterialEntity material) {
		materialDao.updateMaterial(material);
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @return List
	 * @author zlj
	 */
	public List<MaterialEntity> queryMaterialPage(PageEntity page) {
		List<MaterialEntity> listMaterial = materialDao.queryMaterialPage(page);
		return listMaterial;
	}
	
	/**
	 * 模糊查询加分页
	 * @param page
	 * @param materialName
	 * @return List
	 * @author zlj
	 */
	public List<MaterialEntity> queryMaterialPage(PageEntity page,String materialName) {
		List<MaterialEntity> listMaterial = materialDao.queryMaterialPage(page, materialName);
		return listMaterial;
	}
	
	/**
	  * 查询所有素材
	 * @author zlj
	 */
	public List<MaterialEntity> queryMaterial() {
		List<MaterialEntity> listMaterial = materialDao.queryMaterial();
		return listMaterial;
	}
}
