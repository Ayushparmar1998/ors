package in.co.rays.ors.bean;

/**
 * subject JavaBean encapsulates subject attributes
 * @author AYUSH
 *
 */
public class SubjectBean extends BaseBean {
    
	/**
	 * name of subject
	 */
	private String subjectName;
	/**
	 * description of subject
	 */
	private String description;
	/**
	 * name of course
	 */
	private String courseName;
	/**
	 * id of course
	 */
	private int courseId;
	
	

	/**
	 * accessor
	 */
	
	
	
	
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

	/**
     * @return
     */
	public String getSubjectName() {
		return subjectName;
	}

	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
		return subjectName;
	}

	}
