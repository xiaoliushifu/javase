//对应goods模型操作的类BO,业务操作
package com.liu.model;

import java.sql.*;
public class GoodsBeanBo {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public GoodsBean getGood(Integer goodsId){
		
		GoodsBean gb = new GoodsBean();
		try {
			conn = new ConnDb().getConn();
			ps = conn.prepareStatement("select * from goods where goodsId=?");
			ps.setInt(1, goodsId);
			rs = ps.executeQuery();
			while(rs.next()){
				gb.setGoodsId(rs.getInt("goodsId"));
				gb.setGoodsIntro(rs.getString("goodsIntro"));
				gb.setGoodsName(rs.getString("goodsName"));
				gb.setGoodsNum(rs.getByte("goodsNum"));
				gb.setGoodsPrice(rs.getFloat("goodsPrice"));
				gb.setPhoto(rs.getString("photo"));
				gb.setPublisher(rs.getString("publisher"));
				gb.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close();
		}
		return gb;
	}
	
	/**
	 * 关闭数据库资源
	 */
	public void close(){
	try {
		if(conn != null) {
			conn.close();
		}
		if(ps != null) {
			ps.close();
		}
		if(rs != null) {
			rs.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
