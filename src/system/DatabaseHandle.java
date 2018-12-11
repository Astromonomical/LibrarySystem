package system;

import java.sql.*;

/**
 * This is a static class that interacts with and manages the system database
 */
public class DatabaseHandle {

        /**
         * Executes a provided query on the database
         * @param query The SQL query to run on the database
         * @return ResultSet of data from the database
         */
        public ResultSet dbQuery(String query) {

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
                        // DB Parameters
                        String url = "jdbc:sqlite:database/LibDB.db";

                        // Create a connection
                        con = DriverManager.getConnection(url);

                        System.out.println("Connection Established!");
                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                }

                return con;
        }

        public static void main(String[] args) {
                connect();
        }


}
