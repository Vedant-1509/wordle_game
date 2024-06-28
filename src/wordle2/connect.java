package wordle2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class connect {

    Connection c;
    Statement s;
    connect()
    {
        String username="root";
        String password="1234";
        String url="jdbc:mysql://localhost:3306/wordlegame";
        try{
            c=DriverManager.getConnection(url,username,password);
            s=c.createStatement();
            System.out.println("connection successful");
        }
        catch(Exception e)
        {
            System.out.println("Connection not established");
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new connect();
    }
}