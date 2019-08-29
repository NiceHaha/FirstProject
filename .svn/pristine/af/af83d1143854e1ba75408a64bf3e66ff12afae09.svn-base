package dao.material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import dao.db.Dao;
import entity.advert.AdvertEntity;
import entity.material.MaterialEntity;
import entity.page.Page;
import entity.page.PageEntity;

@Repository
public class MaterialDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	  *  添加素材
	 * @param material
	 * @author zlj
	 */
	public void insertMaterial(MaterialEntity material) {
		String sql="insert into GF_material(material_code,material_name,material_url) values(?,?,?)";
		jdbcTemplate.update(sql, material.getMaterialCode(),material.getMaterialName(),material.getMaterialUrl());
	}
	
	/**
	  * 删除素材
	 * @param materialId
	 * @author zlj
	 */
	public void deleteMaterial(Integer materialId) {
		String sql = "delete from GF_material where id=?";
		jdbcTemplate.update(sql, materialId);
	}
	
	/**
	  * 修改素材
	 * @param material
	 * @author zlj
	 */
	public void updateMaterial(MaterialEntity material) {
		String sql = "update GF_material set material_name=?,material_url=? where id=?";
		jdbcTemplate.update(sql, material.getMaterialName(),material.getMaterialUrl(),material.getMaterialId());
	}
	
	/**
	  * 查询所有素材
	 * @author zlj
	 */
	public List<MaterialEntity> queryMaterial() {
		RowMapper<MaterialEntity> rowMapper = new BeanPropertyRowMapper<>(MaterialEntity.class);
		String sql="select id as materialId ,material_code as materialCode,material_name as materialName,material_url as materialUrl from GF_material";
		List<MaterialEntity> listMaterial = jdbcTemplate.query(sql, rowMapper);
		return listMaterial;
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @return List
	 * @author zlj
	 */
	public List<MaterialEntity> queryMaterialPage(PageEntity page) {
		RowMapper<MaterialEntity> rowMapper = new BeanPropertyRowMapper<>(MaterialEntity.class);
		//查询总条数
		String countSql = "select count(*) from GF_material";
		Integer count = jdbcTemplate.queryForObject(countSql, Integer.class);
		//给page设总条数
		page.setCount(count);
		
		//分页查询
		String pageSql="select id as materialId ,material_code as materialCode,material_name as materialName,material_url as materialUrl from GF_material limit ?,?";
		/* 起始下标 */
		int pageStartIndex = (page.getPageNow() - 1) * page.getPageSize();
		/* 每页显示多少条 */
		int pageSize = page.getPageSize();
		
		List<MaterialEntity> listMaterial = jdbcTemplate.query(pageSql, rowMapper ,pageStartIndex,pageSize);
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
		RowMapper<MaterialEntity> rowMapper = new BeanPropertyRowMapper<MaterialEntity>(MaterialEntity.class);
		//模糊查询总条数
		String countSql = "select count(*) from GF_material where material_name like ?";
		int count = jdbcTemplate.queryForObject(countSql, Integer.class, "%"+materialName+"%");
		page.setCount(count);
		
		//模糊查询加分页
		String sql="select id as materialId,material_code as materialCode,material_name as materialName,material_url as materialUrl from GF_material where material_name like ? limit ?,?";
		int pageStartIndex = (page.getPageNow() - 1) * page.getPageSize();
		int pageSize = page.getPageSize();
		List<MaterialEntity> listMaterial = jdbcTemplate.query(sql, rowMapper, "%"+materialName+"%",pageStartIndex,pageSize);
		return listMaterial;
	}
	
	
	/*模糊查询素材*/
//	public ArrayList<MaterialEntity> queryMaterial(String materialName) {
//		ArrayList<MaterialEntity> listMaterial = new ArrayList<MaterialEntity>();
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			conn = Dao.getConn();
//			String sql="select * from GF_material where material_name like ?";
//			ps = conn.prepareStatement(sql);
//			StringBuffer materialNameBuffer = new StringBuffer();
//			materialNameBuffer.append("%\\");
//			materialNameBuffer.append(materialName);
//			materialNameBuffer.append("%");
//			String materialNameString = materialNameBuffer.toString();
//			ps.setString(1, materialNameString);
//			ps.executeQuery();
//			rs = ps.getResultSet();
//			while(rs.next()) {
//				MaterialEntity material = new MaterialEntity();
//				material.setMaterialId(rs.getInt("id"));
//				material.setMaterialCode(rs.getString("material_code"));
//				material.setMaterialName(rs.getString("material_name"));
//				material.setMaterialUrl(rs.getString("material_url"));
//				listMaterial.add(material);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			Dao.closeConn(conn, ps, rs);
//		}
//		return listMaterial;
//	}
	
	/**
	 * 根据素材编号查询单条素材数据， 用于修改时回显,编号不能修改
	 * @param materialId
	 * @return material
	 * @author zlj
	 */
	public MaterialEntity queryOneMaterial(Integer materialId) {
		RowMapper<MaterialEntity> rowMapper = new BeanPropertyRowMapper<>(MaterialEntity.class);
		String sql = "select id as materialId ,material_code as materialCode,material_name as materialName,material_url as materialUrl from GF_material where id = ?";
		MaterialEntity material = jdbcTemplate.queryForObject(sql, rowMapper, materialId);
		return material;
	}
	
	/**
	 * 检查素材名称不能重复
	 * @param materialName
	 * @return int
	 * @author zlj
	 */
	public int checkMaterialName(String materialName) {
		int mark = 0;
		try {
			String countSql = "select count(*) from GF_material where material_name=?";
			mark = jdbcTemplate.queryForObject(countSql, Integer.class, materialName);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
		int mark = 0;
		try {
			String countSql = "select count(*) from GF_material where material_name=? and id!=?";
			mark = jdbcTemplate.queryForObject(countSql, Integer.class, materialName,materialId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mark;
	}
	
}
