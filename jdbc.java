import java.sql.*;

public class jdbc {
  /*
1. import --> java.sql
2. load and register the driver
3. create connection
4. create statement
5. execute query
6. process the result
7. close
 */

//javac -cp .;E:\sqljdbc_12.8.1.0_enu\sqljdbc_12.8\enu\jars\mssql-jdbc-12.8.1.jre11.jar Main.java DatabaseUtil.java DbOperations.java CleanUpTimeTask.java
//java -cp .;E:\sqljdbc_12.8.1.0_enu\sqljdbc_12.8\enu\jars\mssql-jdbc-12.8.1.jre11.jar Main
    //set CLASSPATH=.;mssql-jdbc-12.8.1.jre11.jar
    //DAO --> Data Access Object
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            String DB_URL = "jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=test";
            String USER = "USER";
            String PASSWORD = "Password@123";

            String Query ="CREATE TABLE Student ( StudentId INT PRIMARY KEY, FirstName VARCHAR(50) NOT NULL, LastName VARCHAR(50) NOT NULL, Age INT, Email VARCHAR(100) UNIQUE, EnrollmentDate DATE);";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(DB_URL,USER,PASSWORD);

            //Statement st =con.createStatement();
            //Prepare statement


            //st.execute(Query);
            String firstName = "Kranthi";
            String lastName = "Kranthi";
            int id = 3;
            String email ="gk@g.com";
            Date enroll =null;
            String InsertQuery = "insert into Student values (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(InsertQuery);
            st.setInt(1,id);
            st.setString(2,firstName);
            st.setString(3,lastName);
            st.setInt(4,58);
             st.setString(5,email);
           st.setDate(6,enroll);

            int resyl = st.executeUpdate();
            //DML,DDL,DQL

            System.out.println(resyl);
            st.close();
            con.close();


        }
    }

// forName
// -- >to Load the Class without creating instance