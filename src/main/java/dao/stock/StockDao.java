package dao.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.db.Dao;
import entity.stock.StockEntity;

public class StockDao {
	//新增
	public void add(StockEntity stoc){
		String sql="insert into GF_stock(goods_name,num,goods_code)values(?,?,?)";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			conn=Dao.getConn();//获取连接
			ps=conn.prepareStatement(sql);//发送sql到数据库
			ps.setString(1, stoc.getGoodsName());
			ps.setInt(2, stoc.getNum());
			ps.setString(3, stoc.getGoodsCode());
			ps.execute();//执行
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Dao.closeConn(conn,ps,rs);
		}
	} 
	
	
	//删除
			public void delete(int id) {
				
				String sql="delete from GF_stock where id=?";
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					conn=Dao.getConn();//获取连接
					ps=conn.prepareStatement(sql);
					ps.setInt(1, id);
					ps.executeUpdate();//执行
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					Dao.closeConn(conn,ps,rs);
				}
			}
			
			
			//修改
			public void update(StockEntity stoc) {
				String sql="update GF_stock set goods_name=?,num=?,goods_code=? where id=?";
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					conn=Dao.getConn();//获取连接
					ps=conn.prepareStatement(sql);//发送sql到数据库
					ps.setString(1, stoc.getGoodsName());
					ps.setInt(2, stoc.getNum());
					ps.setString(3, stoc.getGoodsCode());
					ps.setInt(4, stoc.getId());
					ps.execute();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					Dao.closeConn(conn,ps,rs);
				}
			}
			
			
			//查询
			public List<StockEntity> query(){
				String sql="select * from GF_stock";
				
				StockEntity stoc=new StockEntity();
				List<StockEntity> list=new ArrayList<>();
				
				Connection conn=null;
				PreparedStatement ps=null;
				ResultSet re=null;
				try {
					conn=Dao.getConn();
					PreparedStatement pr=conn.prepareStatement(sql);
					re=pr.executeQuery();
					while (re.next()) {
						stoc.setId(re.getInt("id"));
						stoc.setGoodsName(re.getString("goods_name"));
						stoc.setNum(re.getInt("num"));
						stoc.setGoodsCode(re.getString("goods_code"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					Dao.closeConn(conn, ps, re);
				}
				return list;
			}
}
