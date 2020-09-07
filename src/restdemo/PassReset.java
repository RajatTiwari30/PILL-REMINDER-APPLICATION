package restdemo;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PassReset {
 @FormParam("email")
 private String email;
 @FormParam("password")
 private String password;
 @FormParam("newpassword")
 private String newpassword;
 public PassReset() {
	// TODO Auto-generated constructor stub
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
public String getNewpassword() {
	return newpassword;
}
public void setNewpassword(String newpassword) {
	this.newpassword = newpassword;
}
@Override
public String toString() {
	return "passreset [email=" + email + ", password=" + password + ", newpassword=" + newpassword + "]";
}
 
}
