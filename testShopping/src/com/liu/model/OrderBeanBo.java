/**
 * OrderBean,和OrderBeanDetail表的操作业务类
 */
package com.liu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class OrderBeanBo {
	private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    
    
    public OrderInfoBean addOrder(MycartBo mb,String userId){
    	OrderInfoBean oib = new OrderInfoBean();
    	boolean b = false;
    	try{
    		conn = new ConnDb().getConn();
    		String sql="insert into orders (userId,isPayed,totalPrice) values(?,?,?)";
    		stmt = conn.prepareStatement(sql);
    		stmt.setString(1, userId);
    		stmt.setString(2, "1");
    		stmt.setFloat(3, mb.getAllPrice());
    		int a  = stmt.executeUpdate();
    		if(a==1){
    			b=true;
    			//获得订单id，准备入订单详情表
    			Integer lastId=0;
    			stmt = conn.prepareStatement("select max(ordersId) from orders");
    			rs = stmt.executeQuery();
    			while(rs.next()){
    				lastId = rs.getInt(1);
    			}
    			//循环遍历购物车信息，批量插入方式
    			Statement st = conn.createStatement();
    			ArrayList al = mb.showCart();
    			for(int i=0;i<al.size();i++){
    				GoodsBean gb = (GoodsBean)al.get(i);
    				st.addBatch("insert into orderDetail (ordersId,goodsId,nums) values('"+lastId+"','"+gb.getGoodsId()+"','"+gb.getGoodsNum()+"')");
    			}
    			st.executeBatch();
    			
    			//查出orderInfo信息并返回
    			oib.setOrdersId(lastId);
    			oib.setTotalPrice(mb.getAllPrice());
    			
    		}
    	}catch(Exception e){
    		
    		e.printStackTrace();
    	}finally{
    		this.close();
    	}
    	if(b){
    		return oib;
    	}else{
    		return null;
    	}
    }
    
    public void close(){
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}