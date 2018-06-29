package be.gfi.academy.model;

public class UserVO {

    protected Integer id;
    protected String firstName;
    protected String lasttName;
    protected String email;

    public UserVO(){}

    public UserVO(String name, String email){
        String[] names =name.split(" ");
        setFirstName(names[0]);
        setLasttName(names[1]);
        setEmail(email);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
