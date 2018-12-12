package system;

/**
 * Class models a user profile
 */
public class User {
        // ID of the user
        private String userID;
        // First name
        private String fname;
        // Surname
        private String sname;

        /**
         * Constructs a user
         * @param userID userID
         * @param fname firstname
         * @param sname surname
         */
        public User(String userID, String fname, String sname) {
                this.userID = userID;
                this.fname = fname;
                this.sname = sname;
        }

        /**
         * Gets userID
         * @return userID
         */
        public String getUserID() {
                return userID;
        }

        /**
         * Gets firstname
         * @return firstname
         */
        public String getFName() {
                return fname;
        }

        /**
         * Returns surname
         * @return Surname
         */
        public String getSName() {
                return sname;
        }

}

