package za.co.sqldb.db;

import javax.sql.DataSource;

public abstract class ConnectionPool {

	  protected ConnectionPoolParameters poolParams;

	  public ConnectionPool(ConnectionPoolParameters params)  {
	    poolParams = params;
	  }

	  public abstract DataSource getDataSource();
}
