package daolibrary;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Connects to MySQL database using the jdbc URI (i.e. jdbc:mysql://localhost:3306/flights_testdata),
 * retrieves data using a standard query then reads the data into a 2d array format so it can be
 * interpreted by @DataProvider
 */

public interface MysqlDao{

    String DB_DRIVER = "com.mysql.jdbc.Driver";


    default Connection connectToMysql(String dbUrl, String user, String password) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {

        Class.forName(DB_DRIVER).newInstance();
        return  DriverManager.getConnection(dbUrl, user, password);
    }

    default ResultSet getMysqlData(Connection connect, String queryString) throws SQLException {

        Statement statement = connect.createStatement();

        //adding.... Don't know if it will work yet.
        connect.close();

        return statement.executeQuery(queryString);
    }

    default String[][] readMysqlData(ResultSet results, int offSet) throws SQLException {

        int colNum = offSet;
        if(colNum <=0)
            colNum = 1;

        List<List<String>> dataList = new ArrayList<>();
        List<String> listData = new ArrayList<>();
        ResultSetMetaData metaData = results.getMetaData();
        int colCount =  metaData.getColumnCount();
        int i = 0;

        while (results.next()) {
            while(colNum <=colCount) {
                if (colNum <= colCount) {
                    String name = results.getString(metaData.getColumnName(colNum));
                    listData.add(name);
                    colNum++;
                }
            }

            dataList.add(listData);
            listData = new ArrayList<>();
            colNum = offSet;
        }

        String[][] dataArray = new String[dataList.size()][];

        for(List<String> list: dataList) {
            dataArray[i++] = list.toArray(new String[list.size()]);
        }


        return dataArray;
    }

}
