package in.co.rays.ors.bean;

/**
 * role JavaBean encapsulates role attributes
 * @author AYUSH
 *
 */
public class RoleBean extends BaseBean {
	
	/**
	 * predefined role
	 */
	public static final int ADMIN = 1;
	public static final int FACULTY = 2;
	public static final int STUDENT = 3;
	public static final int KIOSK = 4;
	public static final int COLLEGE = 5;
	
	
	/**
	 * role name
	 */
	private String name;
	
	/**
	 * role description
	 */
	public String description;
	
	/**
	 * accessor
	 */
	
	
	
	/**
     * @return
     */
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getKey() {
		return id+" ";
	}

	
	public String getValue() {
		return name;
	}

}
