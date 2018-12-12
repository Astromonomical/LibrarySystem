package system;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Stores information on the active user
 * @author Scott Simmons
 * @version 1.0
 */
public class ActiveUser {
        // Account of the active user
        private static Account account;
        // User profile of the account
        private static User user;

        /**
         * Returns the active account
         * @return account
         */
        public static Account getAcc() {
                return account;
        }

        public static User getUser() {
                return user;
        }

        /**
         * Sets the active account
         * @param activeAccount The active account
         */
        public static void setAcc(Account activeAccount) {
                account = activeAccount;
        }

        public static void constructAccount(ResultSet rs) {
                try {
                        // Setup account
                        account = new Account(rs.getString(1), rs.getString(2),
                                String.valueOf(rs.getInt(3)), rs.getDouble(4),
                                rs.getString(5));

                        // Retrieve associated user profile
                        ResultSet details = DatabaseHandle.performQuery(
                                "SELECT User.userID, User.fname, User.sname " +
                                "FROM Account, User WHERE Account.userID = " +
                                "User.userID AND User.userID=" + rs.getString(3));

                        user = new User(String.valueOf(details.getInt(1)),
                                details.getString(2), details.getString(3));
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
