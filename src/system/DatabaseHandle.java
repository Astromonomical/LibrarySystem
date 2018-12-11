package system;

import java.sql.*;

/**
 * This is a static class that interacts with and manages the system database
 */
public class DatabaseHandle {

        /**
         * Connect to the database
         */
        private static void connect() {
                Connection con = null;

                try {
                        String url = "jdbc:sqlite:database/LibDB.db";

                        // Create a connection
                        con = DriverManager.getConnection(url);

                        System.out.println("Connection Established!");
                } catch (SQLException e) {
                        System.out.println(e.getMessage());
                } finally {
                        try {
                                if (con == null) {
                                        con.close();
                                }
                        } catch (SQLException ex) {
                                System.out.println(ex.getMessage());
                        }
                }
        }

        public static void main(String[] args) {
                connect();
        }


}
