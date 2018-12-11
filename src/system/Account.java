package system;

public class Account {
        // The username of the account
        private String username;
        // The account's password
        private String password;
        // The userID assocaited with this account (1 to 1)
        private String userID;
        // The balance of this account
        private String balance;
        // The filepath to this account's avatar
        private String avatar;
        // The filepath to the avatars folder
        private static final String FILE_PATH = "Database/avatars/";
        // The extension of every image
        private static final String EXT = ".png";

        /**
         * Account constructor
         * @param username Username
         * @param password Password
         * @param userID Assocaited userID
         * @param balance Balance
         * @param avatar Avatar filepath
         */
        public Account(String username, String password, String userID,
                       String balance, String avatar) {
                this.username = username;
                this.password = password;
                this.userID = userID;
                this.balance = balance;
                this.avatar = FILE_PATH + avatar + EXT;
        }

        /**
         * Returns the username
         * @return Username
         */
        public String getUsername() {
                return username;
        }

        /**
         * Returns the associated userID
         * @return userID
         */
        public String getUserID() {
                return userID;
        }

        /**
         * Returns the balance
         * @return balance
         */
        public String getBalance() {
                return balance;
        }

        /**
         * Returns the avatar filepath
         * @return avatar filepath
         */
        public String getAvatar() {
                return avatar;
        }
}