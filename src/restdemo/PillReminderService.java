package restdemo;

public class PillReminderService {
	public PillReminderService() {
		// TODO Auto-generated constructor stub
	}

public boolean addUserInfo(UserInfo userinfo) {
	PillReminderDao pillreminderdao= new PillReminderDao();
	boolean userin=pillreminderdao.saveUserInfo(userinfo);
	return userin;
}
	
public String verifyUser(UserLogin userlogin) {
	PillReminderDao pillreminderdao= new PillReminderDao();
	String result = pillreminderdao.checkUser(userlogin);
	return result;
}

public String resetOldPass(PassReset passreset) {
	PillReminderDao pillreminderdao= new PillReminderDao();
	String result = pillreminderdao.resetPass(passreset);
	return result;
}

public String addDependentInfo(DependentInfo dependentinfo) {
	PillReminderDao pillreminderdao= new PillReminderDao();
	String depin=pillreminderdao.saveDependentInfo(dependentinfo);
		return depin;

}

public DependentInfo viewDependentInfo(ViewDependent viewDependent) {
	PillReminderDao pillreminderdao= new PillReminderDao();
	DependentInfo toViewDependent= pillreminderdao.showDependent(viewDependent);
	return toViewDependent;
}

public String addMedicalHistory(MedicalHistory medicalHistory) {
	PillReminderDao pillreminderdao= new PillReminderDao();
	String depin=pillreminderdao.saveMedicalHistory(medicalHistory);
		return depin;

}

public String updateDependentInfo(DependentInfo dependentinfo) {
	PillReminderDao pillreminderdao= new PillReminderDao();
	String depin=pillreminderdao.updateDependentInfo(dependentinfo);
		return depin;

}

public MedicalHistory[] viewhistory(String umail,String relation) {
	 PillReminderDao p = new PillReminderDao();
	 MedicalHistory mH[]=p.viewHistory(umail, relation);
		return mH;
		
	}

}
