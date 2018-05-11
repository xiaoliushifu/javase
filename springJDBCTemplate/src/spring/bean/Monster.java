package spring.bean;

public class Monster {
	private Integer id;
	private String name;
	private String skill;
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
	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public Monster(String name, Integer id, String skill) {
		this.name = name;
		this.id = id;
		this.skill = skill;
	}
	public Monster() {
		super();
		//System.out.println("实例化了");
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Monster [id=" + id + ", name=" + name + ", skill=" + skill + "]";
	}
}
