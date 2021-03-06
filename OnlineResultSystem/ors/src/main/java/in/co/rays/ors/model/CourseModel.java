package in.co.rays.ors.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.CourseBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.util.JDBCDataSource;
import in.co.rays.ors.exception.DataBaseException;

/**
 * JDBC Implements of course model
 * @author AYUSH
 *
 */
public class CourseModel {

	private static Logger log = Logger.getLogger(CourseModel.class);

	/**
	 * create id 
	 * @return pk
	 */
	public Integer nextPk() throws Exception {
		log.debug("nextpk method has started");
		int pk = 0;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_COURSE");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return pk = pk + 1;
	}

	
	/**
	 * add new course
	 * @return pk
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public long add(CourseBean bean) throws DuplicateRecordException, ApplicationException {

		log.debug("course add method has started");
		int pk = 0;
		 
		CourseBean beanExist=null;
		try {
			beanExist = findByName(bean.getcName());
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		if(beanExist!=null){
			throw new DuplicateRecordException("course name already exist!!! enter new course");
			
		}
				
		Connection conn = null;
		
		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into st_course values(?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getcName());
			pstmt.setString(3, bean.getDuration());
			pstmt.setString(4, bean.getDescription());
			pstmt.setString(5, bean.getCreatedBy());
			pstmt.setString(6, bean.getModifiedBy());
			pstmt.setTimestamp(7, bean.getCreatedDateTime());
			pstmt.setTimestamp(8, bean.getModifiedDateTime());

			pstmt.executeUpdate();
			System.out.println("record inserted");
			conn.commit();
			pstmt.close();
		}  catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
				
			} catch(Exception e1) {
				e1.printStackTrace();
				throw new ApplicationException("Exception in roll back"+e1.getMessage());
			}
			throw new ApplicationException("Exception in add course");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("course add method has ended");
		return pk;
	}

	
	/**
	 * delete course information in table
	 * @param bean
	 */
	public void delete(CourseBean bean) throws Exception {

		log.debug("course delete method has started");
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_course where id=?");
			pstmt.setLong(1, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println("record deleted");
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		log.debug("course delete method has ended");
	}

	
	/**
	 * update course information
	 * @param bean
	 * @throws Exception
	 */
	public void update(CourseBean bean) throws Exception {

		log.debug("course update method has started");
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update st_course set cname=?,duration=?,description=?,created_by=?,modified_by=?,created_datetime=?,modified_datetime=? where id=?");
            pstmt.setString(1, bean.getcName());
			pstmt.setString(2, bean.getDuration());
			pstmt.setString(3, bean.getDescription());
			pstmt.setString(4, bean.getCreatedBy());
			pstmt.setString(5, bean.getModifiedBy());
			pstmt.setTimestamp(6, bean.getCreatedDateTime());
			pstmt.setTimestamp(7, bean.getModifiedDateTime());
			pstmt.setLong(8, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println("record updated"+i);
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		log.debug("course update method has ended");
	}

	
	/**
	 * find information by pk
	 * @return bean
	 * @throws Exception
	 */
	public CourseBean findByPk(long pk) throws Exception {

		log.debug("course findbypk method has started");
        System.out.println("insidde pk");
		CourseBean bean = null;
		Connection conn = null;

		StringBuffer sql = new StringBuffer("select * from st_course where id=?");
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setLong(1, pk);

			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			while (rs.next()) {
				bean = new CourseBean();

				bean.setId(rs.getLong(1));
				bean.setcName(rs.getString(2));
				bean.setDuration(rs.getString(3));
				bean.setDescription(rs.getString(4));
				bean.setCreatedBy(rs.getString(5));
				bean.setModifiedBy(rs.getString(6));
				bean.setCreatedDateTime(rs.getTimestamp(7));
				bean.setModifiedDateTime(rs.getTimestamp(8));
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
		return bean;
	}

	
	/**
	 * find course by name
	 * @return bean
	 * @throws Exception
	 */
	public CourseBean findByName(String name) throws Exception {
		log.debug("");

		CourseBean bean = null;
		Connection conn = null;
       
		StringBuffer sql = new StringBuffer("select * from st_course where cname=?");
       
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1,name);

			ResultSet rs = pstmt.executeQuery();
			conn.commit();
			while (rs.next()) {
				bean = new CourseBean();

				bean.setId(rs.getLong(1));
				bean.setcName(rs.getString(2));
				bean.setDuration(rs.getString(3));
				bean.setDescription(rs.getString(4));
				bean.setCreatedBy(rs.getString(5));
				bean.setModifiedBy(rs.getString(6));
				bean.setCreatedDateTime(rs.getTimestamp(7));
				bean.setModifiedDateTime(rs.getTimestamp(8));
			}

			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

		return bean;
	}
	
	
	
	public List search(CourseBean bean) throws Exception{
		return search(bean,0,0);
	}
	
	
	/**
	 * search list of course detail
	 * @return list
	 * @throws Exception
	 */
	public List search(CourseBean bean,int pageNo,int pageSize) throws Exception{
		
		log.debug("");
		System.out.println("inside search");
		
		Connection conn= null;
		StringBuffer sql = new StringBuffer
				("select * from st_course where 1=1");
		
		if(bean!=null){
			
			if(bean.getId()>0){
				sql.append(" And id "+ bean.getId());
			}
			
			if(bean.getcName()!=null && bean.getcName().length()>0){
				sql.append(" AND CNAME like '" + bean.getcName()+ "%'");
			}
		
			if(bean.getDuration()!=null && bean.getDuration().length()>0){
				sql.append(" AND DURATION like '" + bean.getDuration()+ "%'");
			}
			
			if(bean.getDescription()!=null && bean.getDescription().length()>0){
				sql.append(" AND DESCRIPTION like '" + bean.getDescription()+ "%'");
			}
			
		}
		
		if(pageSize>0){
			pageNo= (pageNo-1)*pageSize;
			sql.append(" LIMIT "+pageNo+ " ," +pageSize);
		}
		
		List<CourseBean> list = new ArrayList<CourseBean>();
		
		try{
			
			conn= JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			CourseBean bean1;
			while(rs.next()){
				bean1= new CourseBean();
				
				bean1.setId(rs.getLong(1));
				bean1.setcName(rs.getString(2));
				bean1.setDuration(rs.getString(3));
				bean1.setDescription(rs.getString(4));
				bean1.setCreatedBy(rs.getString(5));
				bean1.setModifiedBy(rs.getString(6));
				bean1.setCreatedDateTime(rs.getTimestamp(7));
				bean1.setModifiedDateTime(rs.getTimestamp(8));
				
				list.add(bean1);
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
		return list;
	}
	
	
	
	/**
	 * to show course list
	 * @return list
	 * @throws Exception
	 */
	public List list(int pageNo,int pageSize) throws Exception{
		
		log.debug("");
		
		List<CourseBean> list = new ArrayList<CourseBean>();
		
		StringBuffer sql = new StringBuffer("select * from st_course");
		
		if(pageSize>0){
			pageNo= (pageNo-1)*pageSize;
			sql.append(" limit "+pageNo+" ,"+pageSize);
		}
		
		Connection conn=null;
		
		try{
			conn= JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			CourseBean bean1;
			while(rs.next()){
				bean1 = new CourseBean();
				
				bean1.setId(rs.getLong(1));
				bean1.setcName(rs.getString(2));
				bean1.setDuration(rs.getString(3));
				bean1.setDescription(rs.getString(4));
				bean1.setCreatedBy(rs.getString(5));
				bean1.setModifiedBy(rs.getString(6));
				bean1.setCreatedDateTime(rs.getTimestamp(7));
				bean1.setModifiedDateTime(rs.getTimestamp(8));
				
				list.add(bean1);
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
		return list;
	}
	
	
	
	public List list() throws Exception{
		return list(0,0);
	}
	
}
