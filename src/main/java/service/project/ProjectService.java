package service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.project.Jdbclinks;
import entity.page.PageEntity;
import entity.project.ProjectEntity;
import entity.project.ProjectReport;


@Service
public class ProjectService {
	
	@Autowired
	private Jdbclinks jdbclinks;
	
	/**
	 * 添加
	 * @param projectentity
	 */
	public void insert(ProjectEntity projectentity) {
		jdbclinks.insert(projectentity);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Integer id) {
		jdbclinks.delete(id);
	}
	
	/**
	 * 修改
	 * @param projectentity
	 */
	public void update(ProjectEntity projectentity){
		jdbclinks.update(projectentity);
	}
	
	/**
	 * 查询
	 * @return
	 */
	public List<ProjectEntity> query() {
		return jdbclinks.query();
	}
	
	/**
	 * 模糊查询分页
	 * @param projectFuzzy
	 * @param pageEntity
	 * @return
	 */
	public List<ProjectEntity> query(String projectFuzzy,PageEntity pageEntity) {
		return jdbclinks.query(projectFuzzy, pageEntity);
	}
	
	/**
	 * 查出总数据
	 * @param name
	 * @return
	 */
	public int zshuju(String name) {
		return jdbclinks.zshuju(name);
	}
	
	/**
	 * 循环查出正文内容
	 * @param id
	 * @return
	 */
	public String select(int id) {
		return jdbclinks.select(id);
	}
	
	/**
	 * 修改回显
	 * @param id
	 * @return
	 */
	public ProjectEntity update1(int id) {
		return jdbclinks.update1(id);
	}
	
	/**
	 * 举报添加
	 * @param projectreport
	 */
	public void insert1(ProjectReport projectreport) {
		jdbclinks.insert1(projectreport);
	}
	
	/**
	 * 举报查询
	 * @return
	 */
	public List<ProjectReport> chaxun() {
		return jdbclinks.chaxun();
	}
	
	/**
	 * 举报模糊查询
	 * @param fuzzy
	 * @return
	 */
	public List<ProjectReport> jbmhcx(String fuzzy) {
		return jdbclinks.jbmhcx(fuzzy);
	}
	
	/**
	 * 查出所有数据导入Excel表
	 * @return
	 */
	public List<ProjectEntity> excel(){
		return jdbclinks.excel();
	}
	
	
}
