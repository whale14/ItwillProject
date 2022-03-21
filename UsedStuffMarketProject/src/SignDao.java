import java.sql.*;

public class SignDao {
    private final static String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String USER = "USM";
    private final String PASSWORD = "usmpw";

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
    public boolean selectID(int id) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder signInSQL = new StringBuilder();
            signInSQL.append("SELECT CLIENT_ID ");
            signInSQL.append("FROM CLIENT_INFO ");
            signInSQL.append("WHERE CLIENT_ID = ?");
            preparedStatement = connection.prepareStatement(signInSQL.toString());
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getString("CLIENT_ID"));
                return true;
            } else return false;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return true;
    }
    public boolean matchPW(int id, String pw) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder signInSQL = new StringBuilder();
            signInSQL.append("SELECT CLIENT_PW ");
            signInSQL.append("FROM CLIENT_INFO ");
            signInSQL.append("WHERE CLIENT_ID = ?");
            preparedStatement = connection.prepareStatement(signInSQL.toString());
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (pw.equals(resultSet.getString("CLIENT_PW"))) return true;
                else return false;
            }

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
