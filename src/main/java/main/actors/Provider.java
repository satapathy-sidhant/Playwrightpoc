package main.actors;

public class Provider {

    private final String firstname;
    private final String lastName;
    private final String userName;

    public Provider(Builder b) {
        super();
        this.firstname = b.firstname;
        this.lastName = b.lastName;
        this.userName = b.userName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    @Override public String toString() {
        return "Provider{" +
            "firstname='" + firstname + '\'' +
            ", lastName='" + lastName + '\'' +
            ", userName='" + userName + '\'' +
            '}';
    }

    public static class Builder {

        public Builder(String firstname, String lastName) {
            this.firstname = firstname;
            this.lastName = lastName;
        }

        private final String firstname;
        private final String lastName;
        private String userName;

        public static Builder withName(String fName, String lName) {
            return new Builder(fName, lName);
        }

        public Builder withUsername(String userName) {
            this.userName = userName;
            return this;
        }

        public Provider build() {
            return new Provider(this);
        }
    }
}
