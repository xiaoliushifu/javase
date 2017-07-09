/**
 * ArrayList  LinkedList  Vector  Map
 * 
 */

package com.jihe;

import java.util.*;
import java.io.*;
public class Demo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		EmpManage em = new EmpManage();
		Emp emp1 = new Emp("emp0001","唐僧",1000);
		em.addEmp(emp1);
		em.showInfo("emp0001");
		
		//来个简易的命令菜单
		//又来一个和命令行交互的使用
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("请选择你要进行的操作:");
			System.out.println("1: 增加一个员工");
			System.out.println("2: 查看一个员工");
			System.out.println("3: 更新一个员工的薪水");
			System.out.println("4: 删除一个员工");
			System.out.println("5: 退出系统");
			
			//读取一个命令行字节流
			String sel = br.readLine();
			if(sel.equals("1")) {
				System.out.println("请输入新员工的员工号");
				String newEmpNo = br.readLine();
				System.out.println("请输入新员工的姓名");
				String name = br.readLine();
				System.out.println("请输入新员工的工资");
				float newsal = Float.parseFloat(br.readLine());
				
				Emp emp = new Emp(newEmpNo,name,newsal);
				em.addEmp(emp);
				
				
			} else if(sel.equals("2")) {
				System.out.println("请输入要查看的员工号");
				String empNo = br.readLine();
				em.showInfo(empNo);
			} else if(sel.equals("3")) {
				System.out.println("请输入要更新的员工号");
				String empNo = br.readLine();
				System.out.println("请输入新的工资");
				String newsal = br.readLine();
				em.updateSal(empNo, Float.parseFloat(newsal));
			} else if(sel.equals("4")) {
				
			} else if(sel.equals("5")) {
				
			} else {
				System.out.println(" 输入错误,系统停止");
				System.exit(0);
			}
			
		}

	}

}

class EmpManage
{
	private ArrayList al =null;
	
	public EmpManage()
	{
		al = new ArrayList();
	}
	
	//加入员工
	public void addEmp(Emp emp)
	{
		this.al.add(emp);
	}
	
	//显示员工的信息,根据员工号
	public void showInfo(String empNo) 
	{
		for(int i=0;i<al.size();i++) {
			Emp emp = (Emp)al.get(i);
			if (emp.getEmpno().equals(empNo)) {
				System.out.println("员工名字是："+emp.getName());
				System.out.println("员工编号是："+empNo);
				System.out.println("员工薪水是："+emp.getSalary());
			}
		}
	}
	
	//更新员工的薪水
	public void updateSal(String empNo,float newsal)
	{
		for (int i=0;i<al.size();i++) {
			Emp emp = (Emp)al.get(i);
			if (emp.getEmpno().equals(empNo)) {
				emp.setSalary(newsal);
				break;
			}
		}
	}
	
	/**
	 * 删除一个员工
	 * @param empNo
	 */
	public void delEmp(String empNo) {
		for(int i=0;i<al.size();i++) {
			Emp emp = (Emp)al.get(i);
			if(emp.getEmpno().equals(empNo)){
				al.remove(i);
				break;
			}
		}
	}
}

class Emp
{
	private String empNo;
	private String name;
	private float salary;
	
	/**
	 * @return the empNo
	 */
	public String getEmpno() {
		return empNo;
	}

	/**
	 * @param empno the empNo to set
	 */
	public void setEmpno(String empno) {
		empNo = empno;
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
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Emp(String empno,String name,float sal) {
		this.name = name;
		this.empNo = empno;
		this.salary = sal;
	}
	
}
