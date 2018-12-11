package system;

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
}
