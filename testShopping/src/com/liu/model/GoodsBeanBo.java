//对应goods模型操作的类BO,业务操作
package com.liu.model;

import java.sql.*;
import java.util.*;

public class GoodsBeanBo {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	private Integer rowCount=0;
	private Integer pageSize=6;
	private Integer pageCount=0;
	
	/**
	 * @parameter Integer pageNow当前页
	 * @author liushifu
	 */
	public ArrayList getGoodsList(int pageNow){
        ArrayList<GoodsBean> al= new ArrayList<GoodsBean>();
        try{
            conn = new ConnDb().getConn();
            //获得总条数，并计算页数量
            String sql="SELECT count(1) FROM goods";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(!rs.next()){
                return al;
            }
            rowCount = rs.getInt(1);
            if(rowCount%pageSize == 0){
                setPageCount(rowCount/pageSize);
            }else{
                setPageCount(rowCount/pageSize+1);
            }
            //查询具体信息
            sql="SELECT * FROM goods limit "+pageSize+" offset "+((pageNow-1)*pageSize);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            	GoodsBean gb = new GoodsBean();
            	gb.setGoodsId(rs.getInt("goodsId"));
				gb.setGoodsIntro(rs.getString("goodsIntro"));
				gb.setGoodsName(rs.getString("goodsName"));
				gb.setGoodsNum(rs.getByte("goodsNum"));
				gb.setGoodsPrice(rs.getFloat("goodsPrice"));
				gb.setPhoto(rs.getString("photo"));
				gb.setPublisher(rs.getString("publisher"));
				gb.setType(rs.getString("type"));
                al.add(gb);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            this.close();
        }
        return al;
    }
	/**
	 * 得到商品详情
	 * @param goodsId
	 * @return
	 */
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
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
}
