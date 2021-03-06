package in.co.rays.ors.bean;


/**
 * marksheet JavaBean encapsulates marksheet attributes
 * @author AYUSH
 *
 */
public class MarksheetBean extends BaseBean {
	
	/**
	 * rollNo of student
	 */
	private String rollNo;
	
	/**
	 * Id of StudentId
	 */
	private long studentId;
	
	/**
	 * student name
	 */
	private String name;
	
	/**
	 * physics marks
	 */
	private int physics;
	
	/**
	 * chemistry
	 */
	private int chemistry;
	
	/**
	 * maths marks
	 */
	private int maths;

	
	/**
	 * accessor
	 */
	
	
	/**
     * @return
     */
	public String getRollNo() {
		return rollNo;
	}

	
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	
	public long getStudentId() {
		return studentId;
	}

	
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public int getPhysics() {
		return physics;
	}

	
	public void setPhysics(int physics) {
		this.physics = physics;
	}

	
	public int getChemistry() {
		return chemistry;
	}

	
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	
	public int getMaths() {
		return maths;
	}

	
	public void setMaths(int maths) {
		this.maths = maths;
	}

	
	public String getKey() {
		return id + "";
	}

	
	public String getValue() {
		return rollNo;
	}

}
