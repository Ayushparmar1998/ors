package in.co.rays.ors.bean;

import java.util.Date;

/**
 * imeTable JavaBean encapsulates TimeTable attributes
 * @author AYUSH
 *
 */
public class TimetableBean extends BaseBean {

	/**
	 * course id of timetable
	 */
	private int courseId;
	/**
	 * course name of timetable
	 */
	private String courseName;
	/**
	 * subject id of timetable
	 */
	private int subjectId;
	/**
	 * subject name of time table
	 */
	private String subjectName;
	
	/**
	 * semester of college
	 */
	private String semester;
	/**
	 * exam date 
	 */
	private Date examDate;
	/**
	 * exam time
	 */
	private String examTime;
	
	
	/**
	 * accessor
	 */
	public int getCourseId() {
		return courseId;
	}

	
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
     * @return
     */
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

	
	public String getSemester() {
		return semester;
	}

	
	public void setSemester(String semester) {
		this.semester = semester;
	}

	
	public String getExamTime() {
		return examTime;
	}

	
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	
	public Date getExamDate() {
		return examDate;
	}

	
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	
	public String getKey() {
		return id+"";
	}

	
	public String getValue() {
		return courseName;
	}

	
	
}
