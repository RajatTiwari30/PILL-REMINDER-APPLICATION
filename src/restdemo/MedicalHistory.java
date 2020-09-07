package restdemo;

import java.io.Serializable;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MedicalHistory implements Serializable {
public MedicalHistory() {
	// TODO Auto-generated constructor stub
}
@FormParam("umail")
String umail;
@FormParam("relation")
String relation;
@FormParam("illness")
String illness;
@FormParam("doctorDetails")
String doctorDetails;
@FormParam("medicine")
String medicine;
@FormParam("startDate")
String startDate;
@FormParam("endDate")
String endDate;
@FormParam("dosageAmount")
String dosageAmount;
@FormParam("dosageFrequency")
String dosageFrequency;
@FormParam("dosageTime")
String dosageTime;
MedicalHistory(String illness,String doctorDetails, String medicine,String startDate, String endDate, String dosageAmount, String dosageFrequency, String dosageTime){
	this.illness=illness;
	this.doctorDetails=doctorDetails;
	this.medicine=medicine;
	this.startDate=startDate;
	this.endDate=endDate;
	this.dosageAmount=dosageAmount;
	this.dosageFrequency=dosageFrequency;
	this.dosageTime=dosageTime;
}

public String getIllness() {
	return illness;
}
public void setIllness(String illness) {
	this.illness = illness;
}
public String getDoctorDetails() {
	return doctorDetails;
}
public void setDoctorDetails(String doctorDetails) {
	this.doctorDetails = doctorDetails;
}
public String getMedicine() {
	return medicine;
}
public void setMedicine(String medicine) {
	this.medicine = medicine;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getDosageAmount() {
	return dosageAmount;
}
public void setDosageAmount(String dosageAmount) {
	this.dosageAmount = dosageAmount;
}
public String getDosageFrequency() {
	return dosageFrequency;
}
public void setDosageFrequency(String dosageFrequency) {
	this.dosageFrequency = dosageFrequency;
}
public String getDosageTime() {
	return dosageTime;
}
public void setDosageTime(String dosageTime) {
	this.dosageTime = dosageTime;
}

public String getumail() {
	return umail;
}

public void setuMail(String umail) {
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
	return "MedicalHistory [illness=" + illness + ", doctorDetails=" + doctorDetails + ", medicine=" + medicine
			+ ", startDate=" + startDate + ", endDate=" + endDate + ", dosageAmount=" + dosageAmount
			+ ", dosageFrequency=" + dosageFrequency + ", dosageTime=" + dosageTime + "]";
}


}
