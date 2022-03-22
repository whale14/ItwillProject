import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class USMDao {
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

    //·Î±×ÀÎ
    public boolean selectIDWhereID(int id) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CLIENT_ID ");
            sql.append("FROM CLIENT_INFO ");
            sql.append("WHERE CLIENT_ID = ?");
            preparedStatement = connection.prepareStatement(sql.toString());
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

    public boolean selectPWWhereID(int id, String pw) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT CLIENT_PW ");
            sql.append("FROM CLIENT_INFO ");
            sql.append("WHERE CLIENT_ID = ?");
            preparedStatement = connection.prepareStatement(sql.toString());
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

    public int insertClient(ClientVO vo) {
        int result = 0;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO CLIENT_INFO");
            sql.append("(CLIENT_ID, CLIENT_PW, CLIENT_NAME, REGION_ID, RELIABILITY)");
            sql.append(" VALUES (?, ?, ?, ?, ?)");
            preparedStatement = connection.prepareStatement(sql.toString());
            int i = 1;
            preparedStatement.setInt(i++, vo.getClientID());
            preparedStatement.setString(i++, vo.getClientPW());
            preparedStatement.setString(i++, vo.getClientName());
            preparedStatement.setString(i++, vo.getRegionID());
            preparedStatement.setInt(i, vo.getReliable());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement);
        }
        return result;
    }

    public List<SearchVO> selectProductWithKeyword(String searchKeyword) {
        List<SearchVO> searchLists = null;
        searchLists = new ArrayList<SearchVO>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c.CLIENT_NAME, p.PRODUCT_NAME, p.PRICE, c.RELIABILITY ");
            sql.append(" FROM CLIENT_INFO C JOIN PRODUCT P ");
            sql.append(" ON c.CLIENT_ID = p.CLIENT_ID ");
            sql.append(" AND p.PRODUCT_NAME LIKE '%" + searchKeyword +"%'");
            preparedStatement = connection.prepareStatement(sql.toString());
//            preparedStatement.setString(1, searchKeyword);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SearchVO vo = new SearchVO(resultSet.getString("CLIENT_NAME"),
                        resultSet.getString("PRODUCT_NAME"),
                        resultSet.getInt("PRICE"),
                        resultSet.getInt("RELIABILITY")
                );
                searchLists.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return searchLists;
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
