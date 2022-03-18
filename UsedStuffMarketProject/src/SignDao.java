import java.sql.*;

public class SignDao {
    private final static String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String USER = "mystudy";
    private final String PASSWORD = "mystudypw";

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //로그인
    public boolean signIn(String id) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder signInSQL = new StringBuilder();
            signInSQL.append("SELECT ID");
            signInSQL.append(" FROM CLIENT");
            signInSQL.append(" WHERE ID = ?");
            //파라미터로 디비 조회후 있다면 true 없다면 false
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return true;
    }

    private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection connection, PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
