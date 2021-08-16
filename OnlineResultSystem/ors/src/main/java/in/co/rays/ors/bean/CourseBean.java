package in.co.rays.ors.bean;


/**
 * course JavaBean encapsulates course attributes
 * @author AYUSH
 *
 */


public class CourseBean extends BaseBean{

	/**
	 * name of course
	 */
	private String cname;
	
	/**
	 * name of duration
	 */
	private String duration;
	
	/**
	 * name of description
	 */
	private String description;
	
	/**
	 * accessor
	 */

	
	/**
     * @return
     */
	public String getcName() {
		return cname;
	}

	
	public void setcName(String name) {
		this.cname = name;
	}

	
	public String getDuration() {
		return duration;
	}

	
	public void setDuration(String duration) {
		this.duration = duration;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public String getKey() {
		return id+"";
	}

	
	public String getValue() {
		return cname;
	}

}
