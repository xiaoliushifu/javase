/**
 * 处理购物车逻辑的业务类
 * 载体使用HashMap
 * php中可以使用session
 */
package com.liu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class MycartBo {
	
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	/**
	 * 购物车里的商品总价
	 */
	private float allPrice=0.0f;
	public float getAllPrice(){
		return this.allPrice;
	}

	HashMap<String,String> hm = new HashMap<String,String>();
		//1添加货物
	public void addGoods(String goodsId,String goodsNum){
		hm.put(goodsId, goodsNum);
	}
		//2删除货物
	public void delGoods(String goodsId){
		hm.remove(goodsId);
	}
	
		//3修改数量
	public void updateNum(String goodsId,String goodsNewNum){
		hm.put(goodsId, goodsNewNum);
	}
	
		//4清空购物车
	public void clear(){
		hm.clear();
	}
	/**
	 * 5显示购物车,实则展示购物车里的所有货物
	 * 由于HashMap中只存储货物的ID和货物的购买数量
	 * 而货物名称等具体信息则存储与数据库中，故需读取数据库
	 * @return
	 */
	public ArrayList<GoodsBean> showCart(){
		ArrayList<GoodsBean> al = new ArrayList<GoodsBean>();
		try{
			//
			String sql="select * from goods where goodsId in";//(1,4,5)
			//使用迭代器遍历HashMap的key集合，组装sql参数
			Iterator it = hm.keySet().iterator();
			//sql参数
			String s1="(";
			while(it.hasNext()){
				String k = (String) it.next();
				//若还有下一个则可以是"(2,3,"
				if(it.hasNext()){
					s1 +=k+",";
				}else{
					//否则就是"(2,3)"
					s1 +=k+")";
				}
			}
			sql +=s1;
			conn = new ConnDb().getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//每次显示时清空总价
			this.allPrice=0.0f;
			Float unit = 0.0f;
			Byte num =0;
			while(rs.next()){
            	GoodsBean gb = new GoodsBean();
            	gb.setGoodsId(rs.getInt("goodsId"));
				gb.setGoodsIntro(rs.getString("goodsIntro"));
				gb.setGoodsName(rs.getString("goodsName"));
				num = Byte.parseByte(hm.get(rs.getString("goodsId")));
				//rs.getString()虽然goodsId在数据库中是整型，java将会转成String
				gb.setGoodsNum(num);
				unit = rs.getFloat("goodsPrice");
				gb.setGoodsPrice(unit);
				gb.setPhoto(rs.getString("photo"));
				gb.setPublisher(rs.getString("publisher"));
				gb.setType(rs.getString("type"));
				
				//单价x数量，得到累积的总价
				this.allPrice +=unit*num;
				
                al.add(gb);
            }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.close();
		}
		return al;
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
