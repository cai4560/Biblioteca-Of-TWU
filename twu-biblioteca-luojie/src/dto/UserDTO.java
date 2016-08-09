package dto;

public class UserDTO {
    private Integer id;

    private String userName;

    private String password;

    private String libraryNumber;

    private String emailAddress;

    private String telephoneNumber;

    private String userLever;

    public UserDTO(Integer id, String userName, String password, String libraryNumber,
                   String emailAddress, String telephoneNumber, String userLever) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.libraryNumber = libraryNumber;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.userLever = userLever;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getUserLever() {
        return userLever;
    }

    public void setUserLever(String userLever) {
        this.userLever = userLever;
    }
}
