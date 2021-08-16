package in.co.rays.ors.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.CourseBean;
import in.co.rays.ors.bean.SubjectBean;
import in.co.rays.ors.util.JDBCDataSource;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.exception.DataBaseException;

/**
 * JDBC Implement of subject
 * @author AYUSH
 *
 */

public class SubjectModel {

	private static Logger log = Logger.getLogger(SubjectModel.class);
	
	/**
	 * create id
	 * @return pk
	 * @throws SQLException
	 */
	
	public Integer nextPk() throws SQLException{
		
        log.debug("");
        
		int pk=0;
		Connection conn=null;
		
		try{
			conn= JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement
					("select max(id) from st_subject");
			
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				pk= rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			conn.close();
		}
		return pk=pk+1; 
	}
	
	
	/**
	 * add subject
	 * @param bean
	 * @return pk
	 * @throws Exception
	 */
	
	public long add(SubjectBean bean) throws Exception{
		
		
		log.debug("");
		int pk=0;
		
		
		CourseModel cmodel= new CourseModel();
		CourseBean cbean = cmodel.findByPk(bean.getCourseId());
		System.out.println("course name"+cbean.getcName());
		bean.setCourseName(cbean.getcName());
		
		
		SubjectBean beanExist = findByName(bean.getSubjectName());
		System.out.println("beanExist="+beanExist);
		 if(beanExist!=null){
			 throw new Exception("subject name alredy exist");
		 }
		
		
		 Connection conn= null;
		
		try{
			pk=nextPk();
			conn=JDBCDataSource.getConnection();
            conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement
					("insert into st_subject values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,pk);
			pstmt.setInt(2,bean.getCourseId());
			pstmt.setString(3,bean.getCourseName());
			pstmt.setString(4,bean.getSubjectName());
//			pstmt.setString(5, bean.getSubjectId());
			pstmt.setString(5,bean.getDescription());
			pstmt.setString(6,bean.getCreatedBy());
			pstmt.setString(7,bean.getModifiedBy());
			pstmt.setTimestamp(8,bean.getCreatedDateTime());
			pstmt.setTimestamp(9,bean.getModifiedDateTime());
			
			pstmt.executeUpdate();
			System.out.println("record added");
			conn.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		finally{
			conn.close();
		}
		return pk;

		}
	
	
	/**
	 * delete subject
	 * @param bean
	 * @throws Exception
	 */
	
	public void delete(SubjectBean bean) throws Exception{
		log.debug("");
		System.out.println("model delete  started");		
		Connection conn= null;
        
		try{
			conn= JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement
					("delete from st_subject where id=?");
			pstmt.setLong(1,bean.getId());
			pstmt.executeUpdate();
			System.out.println("record deleted");
			conn.commit();
			pstmt.close();
		}
		catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		finally{
			conn.close();
		}
	}
	
	
	/**
	 * update subject
	 * @param bean
	 * @throws Exception
	 */
	
	public void update(SubjectBean bean) throws Exception{
		log.debug("");
		System.out.println("model update  started");		
		Connection conn= null;
		
		CourseModel cmodel= new CourseModel();
		CourseBean cbean = cmodel.findByPk(bean.getCourseId());
		System.out.println("course name"+cbean.getcName());
		bean.setCourseName(cbean.getcName());
		
		try{
			
			conn= JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement
					("update st_subject set course_id=?,course_name=?,subject_name=?,description=?,created_by=?,modified_by=?,created_datetime=?,modified_datetime=? where id=?");
			pstmt.setInt(1,bean.getCourseId());
			pstmt.setString(2,bean.getCourseName());
			pstmt.setString(3,bean.getSubjectName());
			pstmt.setString(4,bean.getDescription());
			pstmt.setString(5,bean.getCreatedBy());
			pstmt.setString(6,bean.getModifiedBy());
			pstmt.setTimestamp(7,bean.getCreatedDateTime());
			pstmt.setTimestamp(8,bean.getModifiedDateTime());
			pstmt.setLong(9,bean.getId());
			
			pstmt.executeUpdate();
			System.out.println("record updated");
			conn.commit();
			pstmt.close();
		}
		catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		finally{
			conn.close();
		}
	}
	
	
	/**
	 * find subject by pk
	 * @param pk
	 * @return bean
	 * @throws SQLException
	 */
	
	public SubjectBean findByPk(long pk) throws SQLException{
		log.debug("");
		System.out.println("model update  started");	
		
		SubjectBean bean = new SubjectBean();
		
		StringBuffer sql = new StringBuffer("select * from st_subject where id=?");
		Connection conn= null;
		
		try{
			conn= JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setLong(1,pk);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			while(rs.next()){
				
			  bean.setId(rs.getLong(1));
			  bean.setCourseId(rs.getInt(2));
			  bean.setCourseName(rs.getString(3));
			  bean.setSubjectName(rs.getString(4));
			  bean.setDescription(rs.getString(5));
			  bean.setCreatedBy(rs.getString(6));
			  bean.setModifiedBy(rs.getString(7));
			  bean.setCreatedDateTime(rs.getTimestamp(8));
			  bean.setModifiedDateTime(rs.getTimestamp(9));
			  			  
			}
			rs.close();
			pstmt.close();
		}
		catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		finally{
			conn.close();
		}
		
		return bean;
		
		
	}
	
	
	/**
	 * find subject by name
	 * @return bean
	 * @throws SQLException
	 */
	
	public SubjectBean findByName(String name) throws SQLException{
		log.debug("");
		System.out.println("model update  started");	
		
		SubjectBean bean = null;;
		
		StringBuffer sql = new StringBuffer("select * from st_subject where subject_name=?");
		Connection conn= null;
		
		try{
			conn= JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1,name);
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			while(rs.next()){
				bean = new SubjectBean();
				bean.setId(rs.getLong(1));
				  bean.setCourseId(rs.getInt(2));
				  bean.setCourseName(rs.getString(3));
				  bean.setSubjectName(rs.getString(4));
				  bean.setDescription(rs.getString(5));
				  bean.setCreatedBy(rs.getString(6));
				  bean.setModifiedBy(rs.getString(7));
				  bean.setCreatedDateTime(rs.getTimestamp(8));
				  bean.setModifiedDateTime(rs.getTimestamp(9));
			  			  
			}
			rs.close();
			pstmt.close();
		}
		catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		finally{
			conn.close();
		}
		
		return bean;
		
	}
	
	
	
	
	public List search(SubjectBean bean){
		return search(bean);
	}
	
	
	
	/**
	 * search subject
	 * @return list
	 * @throws SQLException
	 */
	public List search(SubjectBean bean,int pageNo,int pageSize) throws SQLException{
		
		log.debug("");
		
		List<SubjectBean> list = new ArrayList<SubjectBean>();
		
		StringBuffer sql = new StringBuffer
				("select * from st_subject where 1=1");
		
		Connection conn= null;
		
		if(bean!=null){
			
			if(bean.getId()>0){
				sql.append(" And ID ="+bean.getId());
				
			}
			if(bean.getCourseId()>0){
				sql.append(" And COURSE_ID ="+bean.getCourseId());
				
			}
			
			if(bean.getCourseName()!=null && bean.getCourseName().length()>0){
				sql.append(" AND COURSE_NAME LIKE '"+bean.getCourseName()+"%'");
			}
			
			if(bean.getSubjectName()!=null && bean.getSubjectName().length()>0){
				sql.append(" AND SUBJECT_NAME LIKE '"+bean.getSubjectName()+"%'");
			}
			
			if(bean.getDescription()!=null && bean.getDescription().length()>0){
				sql.append(" AND DESCRIPTION LIKE '"+bean.getDescription()+"%'");
			}
		}
		if(pageSize>0){
			pageNo= ((pageNo-1)*pageSize);
			sql.append(" LIMIT "+pageNo+" ,"+pageSize);
		}
		
		System.out.println("sal"+sql);
		try{
			conn= JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			SubjectBean bean1=null;
			while(rs.next()){
				bean1 = new SubjectBean();
				  
				  bean1.setId(rs.getLong(1));
				  bean1.setCourseId(rs.getInt(2));
				  bean1.setCourseName(rs.getString(3));
				  bean1.setSubjectName(rs.getString(4));
				  bean1.setDescription(rs.getString(5));
				  bean1.setCreatedBy(rs.getString(6));
				  bean1.setModifiedBy(rs.getString(7));
				  bean1.setCreatedDateTime(rs.getTimestamp(8));
				  bean1.setModifiedDateTime(rs.getTimestamp(9));
				  
				  list.add(bean1);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		finally{
			conn.close();
		}
		return list;
	}
	
	
	
	/**
	 * list of subject
	 * @return list
	 * @throws Exception
	 */
	public List list(int pageNo,int pageSize) throws Exception{
		
		System.out.println("inside list");
		Connection conn=null;
		List<SubjectBean> list = new ArrayList<SubjectBean>();
		
		StringBuffer sql = new StringBuffer("select * from st_subject");
		
		if(pageSize>0){
			pageNo= (pageNo-1)*pageSize;
		    sql.append(" LIMIT "+pageNo+" ,"+pageSize);	
		}
	     
		try{
			conn= JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			SubjectBean bean1=null;
			while(rs.next()){
				bean1 = new SubjectBean();
				
				  bean1.setId(rs.getLong(1));
				  bean1.setCourseId(rs.getInt(2));
				  bean1.setCourseName(rs.getString(3));
				  bean1.setSubjectName(rs.getString(4));
				  bean1.setDescription(rs.getString(5));
				  bean1.setCreatedBy(rs.getString(6));
				  bean1.setModifiedBy(rs.getString(7));
				  bean1.setCreatedDateTime(rs.getTimestamp(8));
				  bean1.setModifiedDateTime(rs.getTimestamp(9));
				  
				  list.add(bean1);			}
		}
		catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		finally{
			conn.close();
		}
	
		return list;
		
	}
	
	
	
	
	public List list() throws Exception{
		return list(0,0);
	}

}

