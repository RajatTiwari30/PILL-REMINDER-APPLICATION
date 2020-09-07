package restdemo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DependentInfo implements Serializable {
public DependentInfo() {
	// TODO Auto-generated constructor stub
}
@FormParam("umail")
String umail;
@FormParam("depname")
String depname;
@FormParam("depemail")
String depemail;
@FormParam("depcontact")
String depcontact;
@FormParam("depheight")
String depheight;
@FormParam("depweight")
String depweight;
@FormParam("depbldgrp")
String depbldgrp;
@FormParam("depdob")
String depdob;
@FormParam("relation")
String relation;

public MedicalHistory[] medicalHistory;

public String getUmail() {
	return umail;
}
public void setUmail(String umail) {
	this.umail = umail;
}
public String getDepname() {
	return depname;
}
public void setDepname(String depname) {
	this.depname = depname;
}
public String getDepemail() {
	return depemail;
}
public void setDepemail(String depemail) {
	this.depemail = depemail;
}
public String getDepcontact() {
	return depcontact;
}
public void setDepcontact(String depcontact) {
	this.depcontact = depcontact;
}
public String getDepheight() {
	return depheight;
}
public void setDepheight(String depheight) {
	this.depheight = depheight;
}
public String getDepweight() {
	return depweight;
}
public void setDepweight(String depweight) {
	this.depweight = depweight;
}
public String getDepbldgrp() {
	return depbldgrp;
}
public void setDepbldgrp(String depbldgrp) {
	this.depbldgrp = depbldgrp;
}
public String getDepdob() {
	return depdob;
}
public void setDepdob(String depdob) {
	this.depdob = depdob;
}

public String getRelation() {
	return relation;
}
public void setRelation(String relation) {
	this.relation = relation;
}

public MedicalHistory[] getMedicalHistory() {
	return medicalHistory;
}
public void setMedicalHistory(MedicalHistory[] medicalHistory) {
	this.medicalHistory = medicalHistory;
}

@Override
public String toString() {
	return "DependentInfo [umail=" + umail + ", depname=" + depname + ", depemail=" + depemail + ", depcontact="
			+ depcontact + ", depheight=" + depheight + ", depweight=" + depweight + ", depbldgrp=" + depbldgrp
			+ ", depdob=" + depdob + ", relation=" + relation + ", medicalHistory=" + Arrays.toString(medicalHistory)
			+ "]";
}



}
