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

        /**
         * Returns the active account
         * @return account
         */
        public static Account getAcc() {
                return account;
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
                        account = new Account(rs.getString(1), rs.getString(2),
                                String.valueOf(rs.getInt(3)), rs.getDouble(4),
                                rs.getString(5));
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
