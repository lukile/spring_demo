public class main{
	public static void main(String[] args){
		Class.forName("org.hsqldb.jdbcDriver").newInstance();

Connection connexion = DriverManager.getConnection("jdbc:hsql:file:database", "sa", "");
	}
}