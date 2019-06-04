package za.co.sqldb.db;

public abstract class ConnectionPoolParameters {

	  private String server;
	  private int port = 0;
	  private String username ;
	  private String password ;
	  private String driver = "net.sourceforge.jtds.jdbc.Driver";
	  private int maxConnections = 10;
	  private String connectionPoolName = "Generic";
	  private boolean IsJNDIConnection;
	  

	 public abstract String getJDBCUrl();


	public String getServer() {
		return server;
	}


	public void setServer(String server) {
		this.server = server;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public int getMaxConnections() {
		return maxConnections;
	}


	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}


	public String getConnectionPoolName() {
		return connectionPoolName;
	}


	public void setConnectionPoolName(String connectionPoolName) {
		this.connectionPoolName = connectionPoolName;
	}


	public boolean getIsJNDIConnection() {
		return IsJNDIConnection;
	}


	public void setIsJNDIConnection(boolean isJNDIConnection) {
		IsJNDIConnection = isJNDIConnection;
	}
}
