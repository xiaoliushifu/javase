/**
 * 所谓UserBean类似于Yii2里的AR
 */
package com.liu;

public class UserBean {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int Id;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    private String uName=null;
    private String pass=null;
    private int age;
}
