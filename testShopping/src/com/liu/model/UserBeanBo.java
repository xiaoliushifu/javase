/**
 * 该类是专门处理UserBean的类
 * 这里写有关逻辑代码
 */
package com.liu.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class UserBeanBo {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    //存储登录用户的信息,这里算是初始化成员属性还是，还是java语句？
    private  static HashMap<String, UserBean> hm = new HashMap<String,UserBean>();
    /**
     * 设置用户信息到ub中
     * 
     */
    public void setUserBean(String name,ResultSet rs){
    	try {
    		UserBean ub = new UserBean();
			ub.setUserid(rs.getInt("Userid"));
			ub.setUsername(rs.getString("username"));
			ub.setTruename(rs.getString("truename"));
			ub.setPasswd(rs.getString("passwd"));
			ub.setAddress(rs.getString("address"));
			ub.setEmail(rs.getString("email"));
			ub.setPhone(rs.getString("phone"));
			ub.setPostcode(rs.getString("postcode"));
			hm.put(name,ub);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 返回登录成功时设置的UserBean
     * @param u
     * @return
     */
    public UserBean getUserBean(String u){
    	return hm.get(u);
    }
    
    /*
     * 登录
     * 登录成功后为了节省资源，直接设置UserBean
     * 
     */
    public boolean Login(String u,String p) {
        boolean b=false;
        try{
            conn = new ConnDb().getConn();
            String sql="SELECT * FROM  users where username=? limit 1";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,u);
            rs = stmt.executeQuery();
            if(rs.next()) {
                String db_pass = rs.getString("passwd");
                if(db_pass.equals(p)){
                    b=true;
                    //登录成功，就设置UserBean
                    this.setUserBean(u, rs);
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
