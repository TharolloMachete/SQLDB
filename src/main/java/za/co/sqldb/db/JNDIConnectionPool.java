package za.co.sqldb.db;

import javax.sql.DataSource;

public class JNDIConnectionPool extends ConnectionPool {

	public JNDIConnectionPool(ConnectionPoolParameters params) {
		super(params);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DataSource getDataSource() {
		// TODO Auto-generated method stub
		return null;
	}

}
