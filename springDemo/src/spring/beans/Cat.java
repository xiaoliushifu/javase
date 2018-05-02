/**
 * 测试有声明周期的bean的配置
 */
package spring.beans;

public class Cat {
	//构造方法
	public Cat() {
		System.out.println("小猫出生了");
		// TODO Auto-generated constructor stub
	}
	private String name;
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
	public void init()
	{
		System.out.println("小猫初始化了");
	}
	public void play()
	{
		System.out.println("小猫在快乐的玩耍");
	}
	public void destroy()
	{
		System.out.println("小猫离开了");
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}
}
