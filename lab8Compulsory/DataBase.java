import java.sql.*;
import java.sql.DriverManager;
public class DataBase {

    static Connection conn=null;
    private DataBase(){
    }
    public static Connection getDBConnectio(){
        try{
            if(conn==null){
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/musicalbums?useSSL=false","dba","sql");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;

    }
}
