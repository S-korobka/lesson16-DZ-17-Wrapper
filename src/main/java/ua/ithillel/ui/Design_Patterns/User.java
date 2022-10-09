package ua.ithillel.ui.Design_Patterns;

public class User
{
    private final String userName; // required
    private final String firstName; // required
    private final String lastName; // required
    private final String email; // optional
    private final String password; // optional

    private User(UserBuilder builder) {
        this.userName = builder.userName;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getUserName() {
        return userName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User: "+this.userName+", "+this.firstName+", "+this.lastName+", "+this.email+", "+this.password;
    }

    public static class UserBuilder
    {
        private final String userName;
        private final String firstName;
        private final String lastName;
        private String email;
        private String password;

        public UserBuilder(String firstName, String lastName,String userName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.userName = userName;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }
        public User build() {
            User user =  new User(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(User user) {
        }
    }


    public static void main(String[] args)
    {
        User user1 = new User.UserBuilder( "Gupta","Lokesh", "Visla")
                .email("1234567@gmail.com")
                .password("forty thousand paws shoved a banana up their ass")
                .build();

        System.out.println(user1);

        User user2 = new User.UserBuilder("Jack", "Reacher", "Cemion")
                .email("1234567@gmail.com")
                .password("forty thousand paws shoved a banana up their ass")
                .build();

        System.out.println(user2);

        User user3 = new User.UserBuilder("Super", "Man", "Rugaro")

                .build();

        System.out.println(user3);
    }
}
