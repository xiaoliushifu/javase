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
            conn = new ConnDb().getConn();
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
