package za.co.sqldb.db.impl;

import za.co.sqldb.db.ConnectionPoolParameters;

public class AppConnectionPoolParameters extends ConnectionPoolParameters{

	
	public AppConnectionPoolParameters(){

	    setConnectionPoolName("application");
	    setUsername("su");
	    setPassword("su");
	    setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    setPort(1433);
	}
	
	@Override
	public String getJDBCUrl() {
		// TODO Auto-generated method stub
		return "jdbc:sqlserver://localhost:1433;DatabaseName=PhoneBook";
	}

}
