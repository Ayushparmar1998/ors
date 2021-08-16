package in.co.rays.ors.bean;

import java.util.Date;

/**
 *  faculty JavaBean encapsulates faculty attributes
 * @author AYUSH
 *
 */
public class FacultyBean extends BaseBean{

	/**
	 * firstName of faculty
	 */
    private String firstName;
    /**
	 * lastName of faculty
	 */
	private String lastName;
	/**
	 * gender of faculty
	 */
	private String gender;
	/**
	 * loginId of faculty
	 */
	private String loginId;
	/**
	 * address of faculty
	 */
	private String address;
	/**
	 *  dateofJoining of faculty
	 */
	private Date dateOfJoining;
	/**
	 * qualification of faculty
	 */
	private String qualification;
	/**
	 * mobile no of faculty
	 */
	private String mobileNo;
	/**
	 * college id of faculty
	 */
	private int collegeId;
	/**
	 * college Name of faculty
	 */
	private String collegeName;
	/**
	 * course Id of faculty
	 */
	private int courseId;
	/**
	 * course name of faculty
	 */
	private String courseName;
	/**
	 * subject Id of faculty
	 */
	private int subjectId;
	/**
	 * subject name of faculty
	 */
	private String subjectName;

	
	/**
	 * accessor
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

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getGender() {
		return gender;
	}

	
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getLoginId() {
		return loginId;
	}

	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	
	public String getAddress(){
		return address;
	}
	
	
	public void setAddress(String address){
		this.address=address;
	}
	
	
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	
	public String getQualification() {
		return qualification;
	}

	
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	
	public String getMobileNo() {
		return mobileNo;
	}

	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	public int getCollegeId() {
		return collegeId;
	}

	
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	
	public String getCollegeName() {
		return collegeName;
	}

	
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	
	public int getCourseId() {
		return courseId;
	}

	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	
	public String getCourseName() {
		return courseName;
	}

	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
	public int getSubjectId() {
		return subjectId;
	}

	
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	
	public String getSubjectName() {
		return subjectName;
	}

	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
	public String getKey() {
		return id+"";
	}

	
	public String getValue() {
		return firstName+" "+lastName;
	}
}
