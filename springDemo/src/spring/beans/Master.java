/**
 * 主人类，主人可以养妖怪
 */
package spring.beans;

import java.util.Map;

public class Master {
	private String name;
	private Monster m1;
	private Map<String,Monster> monsterMap;
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
	 * @return the m1
	 */
	public Monster getM1() {
		return m1;
	}
	/**
	 * @param m1 the m1 to set
	 */
	public void setM1(Monster m1) {
		this.m1 = m1;
	}
	/**
	 * @return the monsterMap
	 */
	public Map<String, Monster> getMonsterMap() {
		return monsterMap;
	}
	/**
	 * @param monsterMap the monsterMap to set
	 */
	public void setMonsterMap(Map<String, Monster> monsterMap) {
		this.monsterMap = monsterMap;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Master [name=" + name + ", m1=" + m1 + ", monsterMap=" + monsterMap + "]";
	}
}
