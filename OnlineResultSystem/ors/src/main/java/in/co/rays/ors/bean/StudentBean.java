package in.co.rays.ors.bean;

import java.util.Date;

/**
 * student JavaBean encapsulates student attributes
 * @author AYUSH
 *
 */
public class StudentBean extends BaseBean {
	
	/**
	 * name of student
	 */
	private String firstName;
	

	/**
	 * last Name of student
	 */
	private String lastName;
	/**
	 * date of birth of student
	 */
	private Date dob;
	/**
	 * mobile no of student
	 */
	private String mobileNo;
	
	/**
	 * address of student
	 */
	private String address;
	
	/**
	 * email id of student
	 */
	private String email;
	/**
	 * college id of student
	 */
	private long collegeId;
	/**
	 * college name of student
	 */
	private String collegeName;
	

	/**
	 *accessor
	 */

	
	
	
	/**
     * @return
     */
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}

	
	public Date getDob() {
		return dob;
	}

	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	
	public String getMobileNo() {
		return mobileNo;
	}

	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	public String getAddress(){
		return address;
	}
	
	
	public void setAddress(String address){
		this.address=address;
	}
	
	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public long getCollegeId() {
		return collegeId;
	}

	
	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	
	public String getCollegeName() {
		return collegeName;
	}

	
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	
	public String getKey() {
		return id+"";
	}

	
	public String getValue() {
		return firstName+" "+lastName;
	}

}
