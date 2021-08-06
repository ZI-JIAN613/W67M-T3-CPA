public class User {

  private int Userid;
  private String name;
  private String role;
  private String email;
  private String password;
  
  public User(int Userid, String name, String role, String email, String password) {
    super();
    this.Userid = Userid;
    this.name = name;
    this.role = role;
    this.email = email;
    this.password = password;
  }

  public int getUserid() {
    return Userid;
  }

  public void setUserid(int userid) {
    Userid = userid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }  
  
}