package restdemo;

import java.io.Serializable;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ViewDependent implements Serializable{
public ViewDependent() {
	// TODO Auto-generated constructor stub
}
@FormParam("umail")
String umail;
@FormParam("relation")
String relation;
public ViewDependent(String umail,String relation){
	this.umail=umail;
	this.relation=relation;
}

public String getUmail() {
	return umail;
}
public void setUmail(String umail) {
	this.umail = umail;
}
public String getRelation() {
	return relation;
}
public void setRelation(String relation) {
	this.relation = relation;
}
@Override
public String toString() {
	return "ViewDependent [umail=" + umail + ", relation=" + relation + "]";
}

}
