package myapp.user.example.com.sikika;

public class UserHelperClass {
    public String fullname;
    public String email;

    public UserHelperClass() {

    }

    public UserHelperClass(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
