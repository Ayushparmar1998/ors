package in.co.rays.ors.bean;

import java.util.Date;
import java.sql.Timestamp;

/**
 * user JavaBean encapsulates user attributes
 * @author AYUSH
 *
 */

public class UserBean extends BaseBean{
	
	/**
	 * first name of user
	 */
	private String firstName;
	/**
	 * last name of user
	 */
	private String lastName;
	/**
	 * login id name of user
	 */
	private String login;
	/**
	 * password of user
	 */
	private String password;
	/**
	 * address of user
	 */
	private String address;
	
	/**
	 * date of birth of user
	 */
	private Date dob;
	/**
	 * mobile no of user
	 */
	private String mobileNo;
	/**
	 * role id of user
	 */
	long roleId;
	/**
	 * role Name of user
	 */
	private String roleName;

	/**
	 * gender of user
	 */
	private String gender;	
    /**
	 * confirm password of user
	 */

	private String confirmPassword;	
	
	
	
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getKey() {
		return id+"";
	}

	public String getValue() {
		return firstName+""+lastName;
	}

}
