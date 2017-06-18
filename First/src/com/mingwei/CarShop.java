/**
 * 继承是多态实现的基础，从字面上理解，多态就是一种类型（Car)表现出多种状态（BMW，cherryQQ，Audi）
 * 把方法的调用和方法所属的主体（类或者对象）关联起来，叫做绑定，绑定分为前期绑定和后期绑定
 * 1.前期绑定：在程序运行之前绑定，方法所属主体在编译时就已经确定，由编译器和连接程序完成，又叫做静态绑定，比如static方法，final,private方法
 * 2.后期绑定：在程序运行时根据具体对象的类型绑定，由方法调用机制实现，又叫做动态绑定，或者运行时绑定。前期绑定之外的方法，都属于
 * 后期绑定
 */
package com.mingwei;

//定义一个汽车销售店类  
public class CarShop {  
    //初始化总收入  
    private int totalMoney=0;  
    //卖车  
    public void sellCar(Car car)  
    {  
        System.out.println("售出车型："+car.name()+"，售价："+car.price());  
        //增加总收入  
        totalMoney+=car.price();  
    }  
    //返回总收入  
    public int GettotalMoney()  
    {  
        return totalMoney;  
    }  
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        CarShop cs=new CarShop();  
        //卖出一辆BMW  
        cs.sellCar(new BMW());  
        //卖出一辆CherryQQ  
        cs.sellCar(new CherryQQ());  
        //卖出一辆Audi  
        cs.sellCar(new Audi());  
        System.out.println("总销售额："+cs.GettotalMoney());  
    }  
}  
//定义一个汽车接口  
interface Car  
{  
    String name();  
    int price();  
}  
//定义一个BMW类  
class BMW implements Car  
{  
  
    public String name() {  
        return "BMW";  
    }  
    public int price() {  
        return 3500000;  
    }  
}  
//定义一个CherryQQ类  
class CherryQQ implements Car  
{  
    public String name() {  
        return "CherryQQ";  
    }  
    public int price() {  
        return 98000;  
    }  
}  
//定义一个Audi类  
class Audi implements Car  
{  
    public String name() {  
        return "Audi Q7";  
    }  
    public int price() {  
        return 3000000;  
    }  
}
