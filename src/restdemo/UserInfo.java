package restdemo;

import java.io.Serializable;
import java.util.Arrays;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class UserInfo implements Serializable{
	@FormParam("name")
	private String name;
	@FormParam("email")
	private String email;
	@FormParam("contact")
	private String contact;
	@FormParam("country")
	private String country;
	@FormParam("dob")
	private String dob;
	@FormParam("password")
	private String password;
	
	public DependentInfo[] userdependentrelation;

	public UserInfo() {
	}
	

	public UserInfo(String name,String email,String contact,String country,String dob,String password, DependentInfo[] userdependentrelation) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.country = country;
		this.dob = dob;
		this.password = password;
		this.userdependentrelation = userdependentrelation;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public DependentInfo[] getUserdependentrelation() {
		return userdependentrelation;
	}


	public void setUserdependentrelation(DependentInfo[] userdependentrelation) {
		this.userdependentrelation = userdependentrelation;
	}


	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", email=" + email + ", contact=" + contact + ", country=" + country
				+ ", dob=" + dob + ", password=" + password + ", userdependentrelation="
				+ Arrays.toString(userdependentrelation) + "]";
	}

	


}
