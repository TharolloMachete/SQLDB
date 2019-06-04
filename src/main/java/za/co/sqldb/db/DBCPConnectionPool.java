package za.co.sqldb.db;

import javax.sql.DataSource;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import java.lang.Class;

public class DBCPConnectionPool extends ConnectionPool{
	
	private PoolingDataSource _datasource;
	
	public DBCPConnectionPool(ConnectionPoolParameters params) {
		super(params);


	    // Load JDBC Driver class.

	    try {
			Class.forName(poolParams.getDriver()).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //
	    // Now we'll need a ObjectPool that serves as the
	    // actual pool of connections.
	    //
	    // We'll use a GenericObjectPool instance, although
	    // any ObjectPool implementation will suffice.
	    //
	    GenericObjectPool myPool = new GenericObjectPool();
	    myPool.setMaxActive(poolParams.getMaxConnections());
	    //Test connections when obtained from the pool and when the pool is idle.
		/*
		 * myPool.setTestOnBorrow(true); myPool.setTestWhileIdle(true);
		 */


	    //
	    // First, we'll create a ConnectionFactory that the
	    // pool will use to create Connections.
	    // We'll use the DriverManagerConnectionFactory,
	    // using the connect string passed in the command line
	    // arguments.
	    //
	    DriverManagerConnectionFactory myConnectionFactory = new DriverManagerConnectionFactory(poolParams.getJDBCUrl(), poolParams.getUsername(), poolParams.getPassword());

	    //
	    // Next we'll create the PoolableConnectionFactory, which wraps
	    // the "real" Connections created by the ConnectionFactory with
	    // the classes that implement the pooling functionality. The validation query
	    // is used so that connections can be tested and reobtained if necessary.
	    //
	    String validationQuery = "Select 1";
	    @SuppressWarnings("unused")
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(myConnectionFactory, myPool, null, validationQuery, false, true);

	    //
	    // Finally, we create the PoolingDriver itself,
	    // passing in the object pool we created.
	    //

	    _datasource = new PoolingDataSource(myPool);
	}

	@Override
	public DataSource getDataSource() {
		// TODO Auto-generated method stub
		return _datasource;
	}

}
