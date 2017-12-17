package com.test1;
import java.io.*;

public class Demo5_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//初始化一个存放四只狗的对象数组，初始化时四个空间都是null
		Dog dogs[]=new Dog[4];
//		System.out.println(dogs[0]);
		/*for(int i=0;i<dogs.length;i++) 
		{
			dogs[i]=new Dog();
		}
		dogs[0].setName("花花");
		dogs[0].setWeight(4.5f);
		*/
		
		//从控制台输入各个狗的信息
		//isr好比和控制台绑定了一般
		//学习了之后的IO才知道，这个属于字符输入流，只有它才可以绑定控制台的in，它的子类
		//FileReader不可以。
		InputStreamReader isr=new InputStreamReader(System.in);
		//由isr流对象从控制台读入的数据，缓冲给br对象，br是缓冲对象
		//为啥使用缓冲对象，其实写得多了就知道了，这是惯例写法。
		BufferedReader br=new BufferedReader(isr);
		for(int i=0;i<4;i++)
		{
			dogs[i]=new Dog();
			System.out.println("请输入第"+(i+1)+"只狗的名字");
			//从缓冲区里读取一行到代码的内存中，注意，这里需要处理IO异常。异常另说。
			//程序将会在此处暂停，等待用户的输入 输入的数据都是字符串类型
			String na=br.readLine();
			dogs[i].setName(na);
			
			System.out.println("请输入第"+(i+1)+"只狗的体重");
			String s_weight=br.readLine();
			//字符串类型转成float类型 String=====>float
			float weight = Float.parseFloat(s_weight);
			dogs[i].setWeight(weight);
		}
		
		//计算平均体重
		//计算总体重
		float allWeight=0;
		for(int i=0;i<4;i++)
		{
			allWeight+=dogs[i].getWeight();
		}
		float avgWeight=allWeight/dogs.length;
		System.out.println
		("总体重: "+allWeight+" 平均体重: "+avgWeight);
	}

}

//定义一个狗类
class Dog
{
	private String name;
	private float weight;
	
	public Dog(String name,float weight) {
		this.name=name;
		this.weight=weight;
	}
	public Dog() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
}
