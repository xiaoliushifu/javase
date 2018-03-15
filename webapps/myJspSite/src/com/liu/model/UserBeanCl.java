/**
 * 该类是专门处理UserBean的类
 * 这里写有关逻辑代码
 */
package com.liu.model;
import java.sql.*;
import java.util.ArrayList;

public class UserBeanCl {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private int pageSize=3;
    private int pageCount=0;
    private int rowCount=0;

    public boolean checkLogin(String u,String p) {
        boolean b=false;
        try{
            conn = new Conn().getConn();
            String sql="SELECT pass FROM  mwdb where uname=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,u);
            rs = stmt.executeQuery();
            if(rs.next()) {
                String db_pass = rs.getString(1);
                if(db_pass.equals(p)){
                    b=true;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            this.close();
        }
        return b;
    }


    public ArrayList getUserList(int pageNow){
        ArrayList al= new ArrayList();
        try{
            conn = new Conn().getConn();
            //获得总条数，并计算页数量
            String sql="SELECT count(1) FROM mwdb";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if(!rs.next()){
                return al;
            }
            rowCount = rs.getInt(1);
            if(rowCount%pageSize == 0){
                pageCount = rowCount/pageSize;
            }else{
                pageCount = rowCount/pageSize+1;
            }


            //查询具体信息
            sql="SELECT * FROM mwdb limit "+pageSize+" offset "+((pageNow-1)*pageSize);
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                UserBean ub = new UserBean();
                ub.setId(rs.getInt("id"));
                ub.setuName(rs.getString("uname"));
                ub.setPass(rs.getString("pass"));
                ub.setAge(rs.getInt("age"));

                al.add(ub);
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

    public int getPageCount() {
        return pageCount;
    }
    /**
     * 关闭资源
     */
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
