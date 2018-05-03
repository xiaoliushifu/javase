/**
 * 这是一个spring的bean类
 * 需要在beans.xml里配置，启动容器后就会自动加载配置文件，读取文件内容进行实例化
 */
package spring.beans;

public class Monster {
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
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the skill
	 */
	public String getSkill() {
		return skill;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Monster [name=" + name + ", id=" + id + ", skill=" + skill + "]";
	}
	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}
	private Integer id;
	public Monster(String name, Integer id, String skill) {
		this.name = name;
		this.id = id;
		this.skill = skill;
	}
	private String skill;
	public Monster() {
		super();
		//System.out.println("实例化了");
	}
	
	
}
