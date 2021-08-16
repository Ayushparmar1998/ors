package in.co.rays.ors.bean;

/**
 * DropdownList interface is implemented by Beans those are used to create 
 * drop down list on HTML pages
 * @author AYUSH
 *
 */
public interface DropDownListBean {
	
	
	/**
	 * return key of list element
	 * @return key
	 */
	public String getKey();
	
	/**
	 * display list of key element
	 * @return value
	 */
	public String getValue();

}
