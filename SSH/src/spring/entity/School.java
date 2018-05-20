package spring.entity;

public class School {
	private Integer schoolId;
	private String schoolName;
	private String address;
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}
	public School(Integer schoolId, String schoolName, String address) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.address = address;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", address=" + address + "]";
	}
	/**
	 * @return the schoolId
	 */
	public Integer getSchoolId() {
		return schoolId;
	}
	/**
	 * @param schoolId the schoolId to set
	 */
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}
	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
