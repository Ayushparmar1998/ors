package in.co.rays.ors.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mchange.util.DuplicateElementException;

import in.co.rays.ors.bean.CollegeBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DataBaseException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.util.JDBCDataSource;
import in.co.rays.ors.exception.DataBaseException;

/**
 * JDBC implements of college model
 * @author AYUSH
 *
 */
/**
 * @author AYUSH
 *
 */
public class CollegeModel {

	private static Logger log = Logger.getLogger(CollegeModel.class);

	/**
	 * find pk
	 * @return pk
	 * @throws DatabaseException
	 */
	public Integer nextPK() throws DataBaseException {
		log.debug("Model nextpK() started");
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM ST_COLLEGE");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Database Exception..", e);
			e.printStackTrace();
			throw new DataBaseException("Exception : Exception in getting PK");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model nextPK End");
		return pk = pk + 1;
	}

	

	/**
	 * find the infromation with the help of college name
	 * @return bean
	 * @throws ApplicationException
	 */
	public CollegeBean findByName(String name) throws ApplicationException {
		log.debug("Model findByName Begin");
		StringBuffer sql = new StringBuffer("select * from st_college where name=?");
		CollegeBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			//System.out.println("find by name========>"+sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				bean = new CollegeBean();

				bean.setId(rs.getLong(1));
				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setState(rs.getString(4));
				bean.setCity(rs.getString(5));
				bean.setPhoneNo(rs.getString(6));
				bean.setCreatedBy(rs.getString(7));
				bean.setModifiedBy(rs.getString(8));
				bean.setCreatedDateTime(rs.getTimestamp(9));
				bean.setModifiedDateTime(rs.getTimestamp(10));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("DataBase Exception" + e.getMessage());
			throw new ApplicationException("Exception : Exception in getting College by Name");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByName End");
		return bean;

	}
	
	
	/**
	 * find the information with the help of pk
	 * @return bean
	 * @throws ApplicationException
	 */
	public CollegeBean findByPK(long pk) throws ApplicationException {
        
		log.debug("Model findByPK Started");
        
		System.out.println("Model findByPK Started");
        
        StringBuffer sql = new StringBuffer("SELECT * FROM ST_COLLEGE WHERE ID=?");
        
        CollegeBean bean = null;
        Connection conn = null;
        
        System.out.println("sql value="+sql);
        try {

            conn = JDBCDataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            pstmt.setLong(1, pk);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                bean = new CollegeBean();
                bean.setId(rs.getLong(1));
                bean.setName(rs.getString(2));
                bean.setAddress(rs.getString(3));
                bean.setState(rs.getString(4));
                bean.setCity(rs.getString(5));
                bean.setPhoneNo(rs.getString(6));
                bean.setCreatedBy(rs.getString(7));
                bean.setModifiedBy(rs.getString(8));
                bean.setCreatedDateTime(rs.getTimestamp(9));
                bean.setModifiedDateTime(rs.getTimestamp(10));

            }
            rs.close();
        } catch (Exception e) {
        	e.printStackTrace();
            //log.error("Database Exception..", e);
            //throw new ApplicationException(
              //      "Exception : Exception in getting College by pk");
        } finally {
            JDBCDataSource.closeConnection(conn);
        }
        log.debug("Model findByPK End");
        return bean;
    }

	/**
	 * add new college
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	
	public long add(CollegeBean bean) throws ApplicationException, DuplicateRecordException {
		log.debug("Model add Started");
		Connection conn = null;
		int pk = 0;
		CollegeBean duplicateRecord = findByName(bean.getName());

		System.out.println("check for duplicate" + duplicateRecord);
		if (duplicateRecord != null) {
			throw new DuplicateRecordException("College Name already exists");
		}
		try {
			pk = nextPK();
			// Get auto-generated next primary key

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("insert into st_college values(?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getAddress());
			pstmt.setString(4, bean.getState());
			pstmt.setString(5, bean.getCity());
			pstmt.setString(6, bean.getPhoneNo());
			pstmt.setString(7, bean.getCreatedBy());
			pstmt.setString(8, bean.getModifiedBy());
			pstmt.setTimestamp(9, bean.getCreatedDateTime());
			pstmt.setTimestamp(10, bean.getModifiedDateTime());

			pstmt.executeUpdate();
			conn.commit(); // end transaction
			System.out.println("1 record inserted");
			pstmt.close();
		} catch (Exception e) {
			log.error("Database Exception.."+e);
			try{
			conn.rollback();
			}catch(Exception ex){
				ex.printStackTrace();	
			}
			
			throw new ApplicationException("Exception : add rollback exception " + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model add End");
		return pk;
	}

	
	/**
	 * delete college information
	 * @param bean
	 */
	public void delete(CollegeBean bean) throws ApplicationException, SQLException {
		log.debug("Model delete Started");
		Connection conn = null;

		try {
			//bean = new CollegeBean();
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from st_college where id =?");
			pstmt.setLong(1, bean.getId());

			pstmt.executeUpdate();
			conn.commit();
			System.out.println("1 record deleted");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in delete college");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model delete end");
	}
	
	/**
	 * update college detail
	 * @param bean
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 * @throws SQLException
	 */
	
	public void update(CollegeBean bean) throws DuplicateRecordException, ApplicationException, SQLException{
		
		log.debug("Model update Started");
		Connection conn= null;
		
		try{
			conn= JDBCDataSource.getConnection();
            conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("update st_college set NAME=?,ADDRESS=?,STATE=?,CITY=?,PHONE_NO=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? where ID=?");
			
			    pstmt.setString(1,bean.getName());
			    pstmt.setString(2, bean.getAddress());
	            pstmt.setString(3, bean.getState());
	            pstmt.setString(4, bean.getCity());
	            pstmt.setString(5, bean.getPhoneNo());
	            pstmt.setString(6, bean.getCreatedBy());
	            pstmt.setString(7, bean.getModifiedBy());
	            pstmt.setTimestamp(8, bean.getCreatedDateTime());
	            pstmt.setTimestamp(9, bean.getModifiedDateTime());
	            pstmt.setLong(10, bean.getId());
			    
	            pstmt.executeUpdate();
	            conn.commit();
	            pstmt.close();
	           
		}
		catch(Exception e){
			e.printStackTrace();
			conn.rollback();
			throw new ApplicationException("Exception in updating College ");
		}
		finally{
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update end");
	}
	
	
	
	public List search(CollegeBean bean) throws ApplicationException{
		return search(bean,0,0);
	}
	
	
	/**
	 * search college information 
	 * @return list
	 * @throws ApplicationException
	 */
	public List search(CollegeBean bean,int pageNo,int pageSize) throws ApplicationException{
		
		
		log.debug("Model search Begin");
		
		StringBuffer sql = new StringBuffer("select * from st_college where 1=1");
		
		if(bean!=null){
			if(bean.getId()>0){
			sql.append("And id "+bean.getId());
			}
			if(bean.getName()!=null && bean.getName().length()>0){
				sql.append(" AND NAME like '" + bean.getName() + "%'");
			}
			if(bean.getAddress()!=null && bean.getAddress().length()>0){
				sql.append(" And Address like '"+bean.getAddress()+"%'");
			}
			if(bean.getCity()!=null && bean.getCity().length()>0){
				sql.append(" And city like '"+bean.getCity()+"%'");
			}
			if(bean.getState()!=null && bean.getState().length()>0){
				sql.append(" And state like '"+bean.getState()+"%'");
			}
			if(bean.getPhoneNo()!=null && bean.getPhoneNo().length()>0){
				sql.append(" And phone_no like "+bean.getPhoneNo());
			}
			
		}
		
		if(pageSize>0){
			pageNo= (pageNo-1)*pageSize;
			sql.append(" Limit " + pageNo + ", " + pageSize);
		}
		ArrayList<CollegeBean> list = new ArrayList<CollegeBean>();
		Connection conn= null;
		try{
			
			conn= JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		    ResultSet rs=pstmt.executeQuery();
		    CollegeBean bean1;
		    while(rs.next()){
		    	bean1= new CollegeBean();
		    	bean1.setId(rs.getLong(1));
		    	bean1.setName(rs.getString(2));
		    	bean1.setAddress(rs.getString(3));
		    	bean1.setCity(rs.getString(4));
		    	bean1.setState(rs.getString(5));
		    	bean1.setPhoneNo(rs.getString(6));
		    	bean1.setCreatedBy(rs.getString(7));
		    	bean1.setModifiedBy(rs.getString(8));
		    	bean1.setCreatedDateTime(rs.getTimestamp(9));
		    	bean1.setModifiedDateTime(rs.getTimestamp(10));
		    	list.add(bean1);
		    }
		    pstmt.close();
		}
		catch(Exception e){
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException
			    ("Exception : Exception in search college");
		}
		finally{
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model search End");
		return list;
	}
	
	
	/**
	 * to show list of college
	 * @return list
	 */
	public List list(int pageNo,int pageSize){
		
		log.debug("");
		
		List<CollegeBean> list = new ArrayList<CollegeBean>();
		StringBuffer sql = new StringBuffer
				 ("select * from st_college");
		//System.out.println("test query "+sql);
		Connection conn= null;
		
		if(pageSize>0){
			pageNo= (pageNo-1)*pageSize;
			sql.append(" limit " +pageNo+ ","+pageSize);
			//sql.append(" limit " + pageNo + "," + pageSize);
		}
		System.out.println("sql is"+sql);
		CollegeBean bean;
		try{
			conn = JDBCDataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                bean = new CollegeBean();
                bean.setId(rs.getLong(1));
                bean.setName(rs.getString(2));
                bean.setAddress(rs.getString(3));
                bean.setState(rs.getString(4));
                bean.setCity(rs.getString(5));
                bean.setPhoneNo(rs.getString(6));
                bean.setCreatedBy(rs.getString(7));
                bean.setModifiedBy(rs.getString(8));
                bean.setCreatedDateTime(rs.getTimestamp(9));
                bean.setModifiedDateTime(rs.getTimestamp(10));
                list.add(bean);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			JDBCDataSource.closeConnection(conn);
		}
		
		return list;
	}
	
	
	
	public List list()throws ApplicationException{
		return list(0,0);
	}
}
