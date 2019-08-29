package service.Agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.agent.AgentDao;
import entity.agent.Agent;
import entity.page.PageEntity;

@Service
public class AgentService {
	@Autowired
	private AgentDao ad;
	/**
	 * 代理查询
	 * @return list
	 */
	@Transactional(readOnly = true)
	public List<Agent> select(String str,PageEntity pageEntity) {
		List<Agent> list = ad.select(str,pageEntity);
		return list;
	}
	/**
	 * 放入代理商名称查询到它的code
	 * @param name
	 * @return code
	 */
	@Transactional(readOnly = true)
	public String agentcode(String name) {
		String code = ad.agentcode(name);
		return code;
	}
	/**
	 * 代理添加
	 * @param brand
	 */
	@Transactional
	public void insert(Agent agent) {
		ad.insert(agent);
	}
	/**
	 * 代理修改
	 * @param brand
	 */
	@Transactional
	public void update(Agent agent) {
		ad.update(agent);
	}
	/**
	 * 代理删除
	 * @param id
	 */
	@Transactional
	public void delete(int id) {
		ad.delete(id);
	}
	/**
	 * 数据回显
	 * @param id
	 * @return brand
	 */
	@Transactional(readOnly = true)
	public Agent get(int id) {
		Agent agent = ad.get(id);
		return agent;
	}
	/**
	 * 查询是否有相同的代理名存在
	 * @param name
	 * @return a
	 */
	@Transactional(readOnly = true)
	public int count(String name) {
		int cou = ad.count(name);
		return cou;
	}
	/**
	 * 查出一共有多少条数据
	 * @return
	 */
	@Transactional(readOnly = true)
	public int agentCount(String name) {
		int count = ad.agentCount(name);
		return count;
	}
	/**
	 * 通过传入一个品牌名字获取到品牌的编码	gn
	 * @param name
	 * @return
	 */
	@Transactional(readOnly = true)
	public String selectcode(String name) {
		String code =ad.selectcode(name);
		return code;
	}
	/**
	 * 总页数
	 * @param pageCount  总条数
	 * @param pageSize	每页显示页数
	 */
	@Transactional(readOnly = true)
	public int pageCount(int count,int pageSize) {
		int page = ad.pageCount(count, pageSize);
		return page;
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Agent> Query(String name) {
		List<Agent> list = ad.Query(name);
		return list;
	}
}
