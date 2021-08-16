package in.co.rays.ors.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import in.co.rays.ors.exception.ApplicationException;
import in.co.rays.ors.exception.DataBaseException;
import in.co.rays.ors.util.DataUtility;
import in.co.rays.ors.util.JDBCDataSource;


public abstract class BaseModel implements Comparable<BaseModel> {

	private static Logger log = Logger.getLogger(BaseModel.class);
	
	protected long id;
	
	protected String createdBy;
	
	protected String modifiedBy;
	
	protected Timestamp createdDateTime;
	

	protected Timestamp modifiedDateTime;

	

	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	
	public Timestamp getCreatedDateTime() {
		return createdDateTime;
	}

	
	public void setCreatedDateTime(Timestamp createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	
	public Timestamp getModifiedDateTime() {
		return modifiedDateTime;
	}

	
	public void setModifiedDateTime(Timestamp modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	
	public String getCreatedBy() {
		return createdBy;
	}

	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	public String getModifiedBy() {
		return modifiedBy;
	}

	
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

		public int compareTo(BaseModel next) {

		int n = (int) (id - next.getId());
		return n;

	}


	public long nextPK() throws DataBaseException {

		log.debug("Model nextPK Started");
		long pk = 0;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(id) from" + getTableName());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {
			log.error("Database Exception..", e);
			throw new DataBaseException("Exception : Exception in getting PK");
		}

		log.debug("Model nextPK end");
		return pk = pk + 1;
	}

	
	public abstract String getTableName();

	
	public void updateCreatedInfo() throws ApplicationException {

		log.debug("model update info started" + createdBy);
		Connection conn = null;
		String sql = "update" + getTableName() + "set created_By=? ,created_DateTime=? where id=?";

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, createdBy);
			pstmt.setTimestamp(2, DataUtility.getCurrentTimestamp());
			pstmt.setLong(2, id);

			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			log.error("Database Exception..", e);
			JDBCDataSource.trnRollback(conn);
			throw new ApplicationException(e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Model update info end");
	}

	
	
	public void updateModifiedInfo() throws ApplicationException {

		log.debug("Update modified info started");
		Connection conn = null;
		String sql = "update" + getTableName() + "set modified_by =?,modified_DateTime=? where id=?";

		log.debug(sql);

		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifiedBy);
			pstmt.setTimestamp(2, DataUtility.getCurrentTimestamp());
			pstmt.setLong(3, id);

			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();

		} catch (Exception e) {
			log.error("Database Exception " + e);
			JDBCDataSource.trnRollback(conn);
			throw new ApplicationException(e.getMessage());
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.debug("Update modified info end");
	}



	protected <T extends BaseModel> T populateModel(ResultSet rs, T model) throws SQLException {

		model.setId(rs.getLong("ID"));
		model.setCreatedBy(rs.getString("CREATED_BY"));
		model.setModifiedBy(rs.getString("MODIFIED_BY"));
		model.setCreatedDateTime(rs.getTimestamp("CREATED_DATETIME"));
		model.setModifiedDateTime(rs.getTimestamp("MODIFIED_DATETIME"));
		return model;
	}
}
