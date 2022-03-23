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

    //로그인
    public ClientVO selectAllFromClientWhereID(int id) {
        ClientVO client = new ClientVO();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * ");
            sql.append("FROM CLIENT_INFO ");
            sql.append("WHERE CLIENT_ID = ?");
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client.setClientID(resultSet.getInt("CLIENT_ID"));
                client.setClientName(resultSet.getString("CLIENT_NAME"));
                client.setClientPW(resultSet.getString("CLIENT_PW"));
                client.setRegionID(resultSet.getString("REGION_ID"));
                client.setReliable(resultSet.getInt("RELIABILITY"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return client;
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
        List<SearchVO> searchLists;
        searchLists = new ArrayList<SearchVO>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p.PRODUCT_ID, c.CLIENT_NAME, p.PRODUCT_NAME, p.PRICE, c.RELIABILITY ");
            sql.append(" FROM CLIENT_INFO C JOIN PRODUCT P ");
            sql.append(" ON c.CLIENT_ID = p.CLIENT_ID ");
            sql.append(" AND p.PRODUCT_NAME LIKE '%" + searchKeyword + "%'");
            preparedStatement = connection.prepareStatement(sql.toString());
//            preparedStatement.setString(1, searchKeyword);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SearchVO vo = new SearchVO(resultSet.getInt("PRODUCT_ID"),
                        resultSet.getString("CLIENT_NAME"),
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

    public ProductVO selectAllProductWhereProductID(int productID) {
        ProductVO product = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * ");
            sql.append(" FROM PRODUCT ");
            sql.append(" WHERE PRODUCT_ID = ?");
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, productID);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                product = new ProductVO(resultSet.getInt("PRODUCT_ID"),
                        resultSet.getString("PRODUCT_NAME"),
                        resultSet.getString("PRODUCT_DESCRIPTION"),
                        resultSet.getString("REGION_ID"),
                        resultSet.getInt("CLIENT_ID"),
                        resultSet.getInt("PRICE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return product;
    }

    public List<SearchVO> selectProductJoinRegionWithKeyword(String keyword, String regionID) {
        List<SearchVO> searchLists;
        searchLists = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p.PRODUCT_ID, c.CLIENT_NAME, p.PRODUCT_NAME, p.PRICE, c.RELIABILITY ");
            sql.append(" FROM CLIENT_INFO c JOIN PRODUCT p ");
            sql.append(" ON c.CLIENT_ID = p.CLIENT_ID");
            sql.append(" AND p.REGION_ID = '").append(regionID).append("' ");
            sql.append(" AND p.PRODUCT_NAME LIKE '%" + keyword + "%'");
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SearchVO vo = new SearchVO(resultSet.getInt("PRODUCT_ID"),
                        resultSet.getString("CLIENT_NAME"),
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

    public List<SearchVO> selectProductJoinRegion(String regionID) {
        List<SearchVO> searchLists;
        searchLists = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p.PRODUCT_ID, c.CLIENT_NAME, p.PRODUCT_NAME, p.PRICE, c.RELIABILITY ");
            sql.append(" FROM CLIENT_INFO c JOIN PRODUCT p ");
            sql.append(" ON c.CLIENT_ID = p.CLIENT_ID");
            sql.append(" AND p.REGION_ID = '" + regionID +"'");
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SearchVO vo = new SearchVO(resultSet.getInt("PRODUCT_ID"),
                        resultSet.getString("CLIENT_NAME"),
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

    public void insertProduct(String productName, String productDescription, int clientID, String regionID, int price) {
        int result = 0;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO PRODUCT ");
            sql.append(" VALUES ((select max(product_id)+1 from product)" + ", '");
            sql.append(productName).append("', '");
            sql.append(productDescription).append("', ");
            sql.append(price).append(", ");
            sql.append(clientID).append(", '");
            sql.append(regionID).append("')");
            preparedStatement = connection.prepareStatement(sql.toString());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement);
        }
    }

    public List<ProductVO> selectAllProductWhereClientID(int clientID) {
        List<ProductVO> products;
        products = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT *");
            sql.append(" FROM PRODUCT");
            sql.append(" WHERE CLIENT_ID = ").append(clientID);
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProductVO vo = new ProductVO(resultSet.getInt("PRODUCT_ID"),
                        resultSet.getString("PRODUCT_NAME"),
                        resultSet.getString("PRODUCT_DESCRIPTION"),
                        resultSet.getString("REGION_ID"),
                        resultSet.getInt("CLIENT_ID"),
                        resultSet.getInt("PRICE")
                );
                products.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement, resultSet);
        }
        return products;
    }

    public void updateProductSetProductNameWhereProductID(int productID, String newProductName) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PRODUCT ");
            sql.append(" SET PRODUCT_NAME = '").append(newProductName).append("' ");
            sql.append(" WHERE PRODUCT_ID = ").append(productID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("수정완료");
            close(connection, preparedStatement);
        }
    }

    public void updateProductSetProductDescriptionWhereProductID(int productID, String newProductDescription) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PRODUCT ");
            sql.append(" SET PRODUCT_DESCRIPTION = '").append(newProductDescription).append("' ");
            sql.append(" WHERE PRODUCT_ID = ").append(productID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("수정완료");
            close(connection, preparedStatement);
        }
    }

    public void updateProductSetPriceWhereProductID(int productID, int newPrice) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PRODUCT ");
            sql.append(" SET PRICE = ").append(newPrice);
            sql.append(" WHERE PRODUCT_ID = ").append(productID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("수정완료");
            close(connection, preparedStatement);
        }
    }

    public void deleteProductWhereProductID(int productID) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE PRODUCT ");
            sql.append(" WHERE PRODUCT_ID = ").append(productID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("삭제완료");
            close(connection, preparedStatement);
        }
    }

    public void deleteClientWhereClientID(int clientID) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE CLIENT_INFO ");
            sql.append(" WHERE CLIENT_ID = ").append(clientID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("계정삭제완료");
            close(connection, preparedStatement);
        }
    }

    public int updateClientInfoSetClientIDWhereClientID(int clientID, int newClientID) {
        int result = 0;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CLIENT_INFO ");
            sql.append(" SET CLIENT_ID = ").append(newClientID);
            sql.append(" WHERE CLIENT_ID = ").append(clientID);
            preparedStatement = connection.prepareStatement(sql.toString());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement);
        }
        return result;
    }

    public void updateClientInfoSetClientNameWhereClientID(int clientID, String newClientName) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CLIENT_INFO ");
            sql.append(" SET CLIENT_NAME = '").append(newClientName).append("' ");
            sql.append(" WHERE CLIENT_ID = ").append(clientID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement);
        }
    }

    public int updateClientInfoSetClientPWWhereClientID(int clientID, String newClientPW) {
        int result = 0;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CLIENT_INFO ");
            sql.append(" SET CLIENT_PW = '").append(newClientPW).append("' ");
            sql.append(" WHERE CLIENT_ID = ").append(clientID);
            preparedStatement = connection.prepareStatement(sql.toString());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement);
        }
        return result;
    }

    public void deleteProductWhereClientID(int clientID) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE PRODUCT ");
            sql.append(" WHERE CLIENT_ID = ").append(clientID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("계정삭제완료");
            close(connection, preparedStatement);
        }
    }

    public void updateProductSetClientIDWhereClientID(int clientID, int newClientID) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PRODUCT ");
            sql.append(" SET CLIENT_ID = ").append(newClientID);
            sql.append(" WHERE CLIENT_ID = ").append(clientID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement);
        }
    }

    public void updateProductSetRegionIDWhereClientID(int clientID, String newRegion) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE PRODUCT ");
            sql.append(" SET REGION_ID = '").append(newRegion).append("'");
            sql.append(" WHERE CLIENT_ID = ").append(clientID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement);
        }
    }

    public void updateClientInfoSetRegionIDWhereClientID(int clientID, String newRegion) {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CLIENT_INFO ");
            sql.append(" SET REGION_ID = '").append(newRegion).append("'");
            sql.append(" WHERE CLIENT_ID = ").append(clientID);
            preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement);
        }
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
