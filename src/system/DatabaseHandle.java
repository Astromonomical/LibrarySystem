package system;

import java.sql.*;

/**
 * This is a static class that interacts with and manages the system database
 */
public class DatabaseHandle {

        // URL specifying driver to load the database
        private final static String URL = "jdbc:sqlite:database/LibDB.db";

        /**
         * Executes a provided query on the database
         * @param query The SQL query to run on the database
         * @return ResultSet of data from the database
         */
        public static ResultSet dbQuery(String query) {

                try {
                        // Get connection
                        Connection con = connect();
                        PreparedStatement sql = con.prepareStatement(query);
                        // Return results
                        return sql.executeQuery();
                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        return null;
                }
        }

        /**
         * Connect to the database
         */
        private static Connection connect() {
                Connection con = null;

                try {
                        // Create a connection
                        con = DriverManager.getConnection(URL);
                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                }

                return con;
        }

        /**
         * Returns a tuple from the table
         * @param fields SQL after FROM
         * @return Matching tuples
         */
        public static ResultSet getTuple(String fields) {
                String query = "SELECT * FROM " + fields;

                try {
                        // Get connection
                        Connection con = connect();
                        PreparedStatement sql = con.prepareStatement(query);
                        // Return results
                        return sql.executeQuery();
                } catch(SQLException e) {
                        System.out.println(e.getMessage());
                        return null;
                }
        }
}
