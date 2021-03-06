package in.co.rays.ors.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import in.co.rays.ors.bean.RoleBean;
import in.co.rays.ors.bean.UserBean;
import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DataBaseException;
import in.co.rays.ors.exception.DuplicateRecordException;
import in.co.rays.ors.exception.RecordNotFoundException;
import in.co.rays.ors.util.EmailBuilder;
import in.co.rays.ors.util.EmailMessage;
import in.co.rays.ors.util.EmailUtility;
import in.co.rays.ors.util.JDBCDataSource;
import in.co.rays.ors.exception.DataBaseException;

/**
 * JDBC Implement of user model
 * @author AYUSH
 *
 */

public class UserModel {

	private static Logger log = Logger.getLogger(UserModel.class);
	
	
	/**
	 * create id
	 * 
	 * @return pk
	 * @throws DatabaseException
	 */
	public int nextPK() throws DataBaseException {
		log.debug("Model nextpk started");
		int pk = 0;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(ID) from ST_USER");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();

		} catch (Exception e) {
			log.error("Database Exception..", e);

			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk = pk + 1;
	}

	
	
	/**
	 * add user
	 * 
	 * @param bean
	 * @return pk
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public long add(UserBean bean) throws DuplicateRecordException, ApplicationException {
		
		log.debug("Model add started");
		int pk = 0;
		Connection conn = null;

		RoleModel rmodel = new RoleModel();
		RoleBean rolebean = rmodel.findByPk(bean.getRoleId());
		bean.setRoleName(rolebean.getName());
		
		
		UserBean beanexist= findByLogin(bean.getLogin());
		
		if(beanexist!=null){
			throw new DuplicateRecordException("login id already exists");
		}
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("insert into ST_USER values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, nextPK());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getLogin());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6,bean.getAddress());
			pstmt.setDate(7,new java.sql.Date(bean.getDob().getTime()));
			pstmt.setString(8, bean.getMobileNo());
			pstmt.setLong(9, bean.getRoleId());
			pstmt.setString(10,bean.getRoleName());
			pstmt.setString(11, bean.getGender());
			pstmt.setString(12, bean.getCreatedBy());
			pstmt.setString(13, bean.getModifiedBy());
			pstmt.setTimestamp(14, bean.getCreatedDateTime());
			pstmt.setTimestamp(15, bean.getModifiedDateTime());
			pstmt.setString(16, bean.getConfirmPassword());
			pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//log.error("Database Exception..", e);

			 try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new ApplicationException("Exception : Exception in add User" + e.getMessage());
			}
			//e.printStackTrace();
			throw new ApplicationException("Exception : Exception in add User" + e.getMessage());
 
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model end add");
		return pk;
	}

	
	/**
	 * delete user
	 * 
	 * @param bean
	 * @throws ApplicationException
	 */
	
	public void delete(UserBean bean) throws ApplicationException {
		
		log.debug("Model delete started");
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from ST_USER where ID=?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			System.out.println("record deleted");
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			log.error("Database Exception..", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model delete end");
	}

	
	
	
	public List search(UserBean bean) throws ApplicationException {
		return search(bean,0,0);
	}

	
	
	/**
	 * search user
	 * 
	 * @return list
	 * @throws ApplicationException
	 */
	public List search(UserBean bean, int pageNo, int pageSize)
            throws ApplicationException {
       
		log.debug("Model search Started");
        StringBuffer sql = new StringBuffer("SELECT * FROM ST_USER WHERE 1=1");

        if (bean != null) {
            if (bean.getId() > 0) {
                sql.append(" AND id = " + bean.getId());
              }
            if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
                sql.append(" AND FIRST_NAME like '" + bean.getFirstName() + "%'");
            }
            if (bean.getLastName() != null && bean.getLastName().length() > 0) {
                sql.append(" AND LAST_NAME like '" + bean.getLastName() + "%'");
            }
          /*  if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
                sql.append(" AND FIRST_NAME like '" + bean.getFirstName() + "%'");
            }
            if (bean.getLastName() != null && bean.getLastName().length() > 0) {
                sql.append(" AND LAST_NAME like '" + bean.getLastName() + "%'");
            }*/
            if (bean.getLogin() != null && bean.getLogin().length() > 0) {
                sql.append(" AND LOGIN like '" + bean.getLogin() + "%'");
            }
           /* if (bean.getPassword() != null && bean.getPassword().length() > 0) {
                sql.append(" AND PASSWORD like '" + bean.getPassword() + "%'");
            }
            if (bean.getDob() != null && bean.getDob().getDate() > 0) {
                sql.append(" AND DOB = '" + bean.getDob()+"'");
            }
            if (bean.getMobileNo() != null && bean.getMobileNo().length() > 0) {
                sql.append(" AND MOBILE_NO = " + bean.getMobileNo());
            }
            if (bean.getRoleId() > 0) {
                sql.append(" AND ROLL_ID = " + bean.getRoleId());
            }
            if(bean.getRoleName()!=null && bean.getRoleName().length()>0){
            	sql.append(" AND ROLL_NAME like '"+ bean.getRoleName() +"%'");
            }
           
            if (bean.getGender() != null && bean.getGender().length() > 0) {
                sql.append(" AND GENDER like '" + bean.getGender() + "%'");
            }
            
            if (bean.getConfirmPassword() != null && bean.getConfirmPassword().length() > 0) {
                sql.append(" AND CONFIRM PASSWORD like '" + bean.getConfirmPassword() + "%'");
            }*/
        }

        // if page size is greater than zero then apply pagination
        if (pageSize > 0) {
            // Calculate start record index
            pageNo = (pageNo - 1) * pageSize;

            sql.append(" Limit " + pageNo + ", " + pageSize);
            // sql.append(" limit " + pageNo + "," + pageSize);
        }

        System.out.println(sql);
        
        
        ArrayList list = new ArrayList();
        Connection conn = null;
        try {
            conn = JDBCDataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                bean = new UserBean();
                bean.setId(rs.getLong(1));
                bean.setFirstName(rs.getString(2));
                bean.setLastName(rs.getString(3));
                bean.setLogin(rs.getString(4));
                bean.setPassword(rs.getString(5));
                bean.setAddress(rs.getString(6));
                bean.setDob(rs.getDate(7));
                bean.setMobileNo(rs.getString(8));
                bean.setRoleId(rs.getLong(9));
                bean.setRoleName(rs.getString(10));
                bean.setGender(rs.getString(11));
                bean.setCreatedBy(rs.getString(12));
                bean.setModifiedBy(rs.getString(13));
                bean.setCreatedDateTime(rs.getTimestamp(14));
                bean.setModifiedDateTime(rs.getTimestamp(15));
                bean.setConfirmPassword(rs.getString(16));

                list.add(bean);
            }
            rs.close();
        } catch (Exception e) {
            log.error("Database Exception..", e);
            throw new ApplicationException(
                    "Exception : Exception in search user");
        } finally {
            JDBCDataSource.closeConnection(conn);
        }

        log.debug("Model search End");
        return list;
    }

	
	
	
	/**
	 * find user by login
	 * 
	 * @param login
	 * @return bean
	 * @throws ApplicationException
	 */
	public UserBean findByLogin(String login) throws ApplicationException {
		
		log.debug("Model findByLogin Begin");
		Connection conn = null;
		UserBean bean = null;

		StringBuffer sql = new StringBuffer("select * from ST_USER where LOGIN=?");
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, login);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("rs" + rs);
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setMobileNo(rs.getString(8));
				bean.setRoleId(rs.getLong(9));
                bean.setRoleName(rs.getString(10));
                bean.setGender(rs.getString(11));
                bean.setCreatedBy(rs.getString(12));
                bean.setModifiedBy(rs.getString(13));
                bean.setCreatedDateTime(rs.getTimestamp(14));
                bean.setModifiedDateTime(rs.getTimestamp(15));
                bean.setConfirmPassword(rs.getString(16));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting User by login" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByLogin End");
		return bean;
	}

	
	
	/**
	 * find user by pk
	 * 
	 * @param pk
	 * @return bean
	 * @throws ApplicationException
	 */
	public UserBean findByPK(long pk) throws ApplicationException {
		
		log.debug("Model findByPK Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_USER WHERE ID=?");
		UserBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setConfirmPassword(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setMobileNo(rs.getString(8));
				bean.setRoleId(rs.getLong(9));
                bean.setRoleName(rs.getString(10));
                bean.setGender(rs.getString(11));
                bean.setCreatedBy(rs.getString(12));
                bean.setModifiedBy(rs.getString(13));
                bean.setCreatedDateTime(rs.getTimestamp(14));
                bean.setModifiedDateTime(rs.getTimestamp(15));
                bean.setConfirmPassword(rs.getString(16));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in getting User by pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model findByPK End");
		return bean;
	}

	
	
	/**
	 * update user
	 * 
	 * @param bean
	 * @throws ApplicationException
	 * @throws DuplicateRecordException
	 */
	public void update(UserBean bean) throws ApplicationException, DuplicateRecordException {
		
		log.debug("model update started");
		Connection conn = null;

		UserBean beanexist = findByPK(bean.getId());
		System.out.println("bean exist" + beanexist);

		RoleModel rmodel = new RoleModel();
		RoleBean rolebean = rmodel.findByPk(bean.getRoleId());
		bean.setRoleName(rolebean.getName());
		
		//&& !(beanexist.getId() == bean.getId())
		/*if (beanexist != null ) {
			throw new DuplicateRecordException("Loginid already exist");
		}*/
		System.out.println(bean.getLogin());
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_USER SET FIRST_NAME=?,LAST_NAME=?,LOGIN=?,PASSWORD=?,ADDRESS=?,DOB=?,MOBILE_NO=?,ROLE_ID=?,ROLE_NAME=?,GENDER=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=?,CONFIRM_PASSWORD=? WHERE ID=?");
			pstmt.setString(1, bean.getFirstName());
			System.out.println("first name is"+bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setString(3, bean.getLogin());
			pstmt.setString(4, bean.getPassword());
			pstmt.setString(5,bean.getAddress());
			pstmt.setDate(6, new Date(bean.getDob().getTime()));
			pstmt.setString(7, bean.getMobileNo());
			pstmt.setLong(8, bean.getRoleId());
			pstmt.setString(9,bean.getRoleName());
			pstmt.setString(10, bean.getGender());
			pstmt.setString(11, bean.getCreatedBy());
			pstmt.setString(12, bean.getModifiedBy());
			pstmt.setTimestamp(13, bean.getCreatedDateTime());
			pstmt.setTimestamp(14, bean.getModifiedDateTime());
			pstmt.setString(15, bean.getConfirmPassword());
			pstmt.setLong(16, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Database Exception..", e.printStackTrace());
			// conn.rollback();

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update end");
	}

	
	
	
	public List list() throws ApplicationException {
		return list(0,0);
	}

	
	 /**
	 * list of user
	 * 
	 * @return list
	 * @throws ApplicationException
	 */
	
	public List list(int pageNo, int pageSize) throws ApplicationException {
		
		log.debug("model list started");
		ArrayList list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from ST_USER");
		// if page size is greater than zero then apply pagination
		
		
		if (pageSize > 0) {
			// Calculate start record index
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit "+pageNo+","+pageSize);
		}
		
		
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				UserBean bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setMobileNo(rs.getString(8));
				bean.setRoleId(rs.getLong(9));
				bean.setRoleName(rs.getString(10));
				bean.setGender(rs.getString(11));
	            bean.setCreatedBy(rs.getString(12));
	            bean.setModifiedBy(rs.getString(13));
	            bean.setCreatedDateTime(rs.getTimestamp(14));
	            bean.setModifiedDateTime(rs.getTimestamp(15));
	            bean.setConfirmPassword(rs.getString(16));
				list.add(bean);
				System.out.println("outside rs");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception..", e);
			throw new ApplicationException("" + e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("model list end");
		return list;
	}

	
	
	 /**
	 * authenticate user
	 * 
	 * @param login
	 * @param password
	 * @return bean
	 * @throws ApplicationException
	 */
	public UserBean authenticate(String login, String password) throws ApplicationException {
		
		System.out.println("authenticate DONE");
		log.debug("Model authenticate begin");
		UserBean bean = null;
		Connection conn = null;
		StringBuffer sql = new StringBuffer("select * from ST_USER where LOGIN=? AND PASSWORD=?");

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			conn.setAutoCommit(false);
			pstmt.setString(1, login);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("dATA IS AVAILABLE");
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setMobileNo(rs.getString(8));
				bean.setRoleId(rs.getLong(9));
				bean.setRoleName(rs.getString(10));
				    bean.setGender(rs.getString(11));
	                bean.setCreatedBy(rs.getString(12));
	                bean.setModifiedBy(rs.getString(13));
	                bean.setCreatedDateTime(rs.getTimestamp(14));
	                bean.setModifiedDateTime(rs.getTimestamp(15));
	                bean.setConfirmPassword(rs.getString(16));
			}
			conn.commit();
			pstmt.close();
			

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Database Exception.." + e.getMessage());
			//throw new ApplicationException("Exception : Exception in get roles");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model authenticate end");
		return bean;

	}

	
	
	
	/*public boolean lock(String login) throws ApplicationException, DuplicateRecordException, RecordNotFoundException {
		log.debug("service lock  begin");
		boolean flag = false;
		UserBean beanexist = null;
		try {
			beanexist = findByLogin(login);

			if (beanexist != null) {
				beanexist.setLock(UserBean.ACTIVE);
				update(beanexist);
				flag = true;
			} else {
				throw new RecordNotFoundException("LoginId not exist");
			}
		} catch (DuplicateRecordException e) {
			log.error("Application Exception..", e);
			throw new ApplicationException("Database Exception");
		}
		log.debug("service lock end");
		return flag;
	}*/

	
	 /**
	 * get role
	 * 
	 * @param bean
	 * @return list
	 * @throws ApplicationException
	 */
	
	public List getRoles(UserBean bean) throws ApplicationException {
		
		log.debug("Model roles started");
		ArrayList<UserBean> list = new ArrayList();
		Connection conn = null;
		StringBuffer sql = new StringBuffer("select * from ST_USER where ROLE_ID=?");
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, bean.getRoleId());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();

				bean.setId(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setDob(rs.getDate(7));
				bean.setMobileNo(rs.getString(8));
				bean.setRoleId(rs.getLong(9));
				bean.setRoleName(rs.getString(10));
				    bean.setGender(rs.getString(11));
	                bean.setCreatedBy(rs.getString(12));
	                bean.setModifiedBy(rs.getString(13));
	                bean.setCreatedDateTime(rs.getTimestamp(14));
	                bean.setModifiedDateTime(rs.getTimestamp(15));
	                bean.setConfirmPassword(rs.getString(16));
				    list.add(bean);
			}
		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new ApplicationException("Exception : Exception in get roles");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model Role end");
		return list;
	}

	
	 /**
	 * change password
	 * 
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @return true and false
	 * @throws RecordNotFoundException
	 * @throws ApplicationException
	 */  
	
	public boolean changePassword(Long id, String oldPassword, String newPassword)
			throws ApplicationException, RecordNotFoundException {
		
		log.debug("model changePassword begin");
		
		System.out.println("cg pass");
		UserBean beanexist = new UserBean();
		boolean flag = false;

		beanexist = findByPK(id);
		
		System.out.println("bean id "+beanexist.getId());
		
		if (beanexist != null && beanexist.getPassword().equals(oldPassword)) {
			beanexist.setPassword(newPassword);

			try {
				update(beanexist);
			} catch (DuplicateRecordException e) {
				e.printStackTrace();
			}
			flag = true;
		} else {
			throw new RecordNotFoundException("Login not exist");
		}

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("login", beanexist.getLogin());
		map.put("password", beanexist.getPassword());
		map.put("firstName", beanexist.getFirstName());
		map.put("lastName", beanexist.getLastName());

		 String message = EmailBuilder.getChangePasswordMessage(map);
		
		 EmailMessage msg = new EmailMessage();
		
		 msg.setTo(beanexist.getLogin());
		 msg.setSubject("AYUSH ORS Password has been changed Successfully.");
		 msg.setMessage(message);
		 msg.setMessageType(EmailMessage.HTML_MSG);
		
		 EmailUtility.sendMail(msg);

		log.debug("model changePassword end");
		return flag;
	}

	
	
	
	/*  public UserBean updateAccess(UserBean bean) throws ApplicationException {
		return null;
	}
*/
	
	   /**
			 * register user
			 * 
			 * @param bean
			 * @return pk
			 * @throws Exception
			 */
	
	public long registerUser(UserBean bean) throws Exception {
		
		log.debug("");
		long pk = add(bean);
		System.out.println("pk value"+pk); //value is 0 why?
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("login", bean.getLogin());
		map.put("password", bean.getPassword());

		 System.out.println("login id "+bean.getLogin());
		 System.out.println("pass is "+bean.getPassword());
		 
		 String message = EmailBuilder.getUserRegistrationMessage(map);
		
		 EmailMessage msg = new EmailMessage();
		
		 msg.setTo(bean.getLogin());
		 msg.setSubject("Registration is successful for ORS Project SunilOS");
		 msg.setMessage(message);
		 msg.setMessageType(EmailMessage.HTML_MSG);
		
		 EmailUtility.sendMail(msg);

		return pk;
	}

	
	
	
	/*public boolean resetPassword(UserBean bean) throws ApplicationException {
		
		log.debug("");
		boolean flag = false;
		// changed
		String newPassword = String.valueOf(new java.util.Date().getTime()).substring(9,13); //changed
		UserBean userData = findByPK(bean.getId());
		
		userData.setPassword(newPassword);
		System.out.println("new pass is"+userData);
		try {
			update(userData);
		
			
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
		
		flag=true;
		// If I use userData then what?
			
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", bean.getLogin());
		map.put("password", bean.getPassword());
		map.put("firstName", bean.getFirstName());
		map.put("lastName", bean.getLastName());

		String message = EmailBuilder.getForgetPasswordMessage(map);
		
		 EmailMessage msg = new EmailMessage();
		
		 msg.setTo(bean.getLogin());
		 msg.setSubject("Password has been reset");
		 msg.setMessage(message);
		 msg.setMessageType(EmailMessage.HTML_MSG);
		
		 EmailUtility.sendMail(msg);

		return flag;
	}
*/
	
	 /**
	 * forgetpassword
	 * 
	 * @param login
	 * @return true and false
	 * @throws RecordNotFoundException
	 * @throws ApplicationException
	 */
	
	public boolean forgetPassword(String login) throws RecordNotFoundException, ApplicationException {
		
		System.out.println("inside forget password model");
		
		log.debug("");
		boolean flag = false;
		UserBean userData = findByLogin(login);

		if (userData == null) {
			throw new RecordNotFoundException("Emailid does not exist");
		}

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("login", userData.getLogin());
		map.put("password", userData.getPassword());
		map.put("firstName", userData.getFirstName());
		map.put("lastName", userData.getLastName());

		 String message = EmailBuilder.getForgetPasswordMessage(map);
		 EmailMessage msg = new EmailMessage();
		 msg.setTo(login);
		 msg.setSubject("AYUSH ORS Password reset");
		 msg.setMessage(message);
		 msg.setMessageType(EmailMessage.HTML_MSG);
		 EmailUtility.sendMail(msg);
		flag = true;

		return flag;

	}

}
