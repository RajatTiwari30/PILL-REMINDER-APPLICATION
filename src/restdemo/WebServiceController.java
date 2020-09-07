package restdemo;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("pillreminderpath")
public class WebServiceController {
public WebServiceController() {
	// TODO Auto-generated constructor stub
}
	@POST
	@Path("saveinfo")
	public String saveUserInformation(@BeanParam UserInfo userinfo) {
		PillReminderService service=new PillReminderService();
		boolean res=service.addUserInfo(userinfo);
		if(res) {
		return "ALREADY EXISTS.";
	}
		return "DETAILS SAVED.";
	}
	
	@POST
	@Path("checkinfo")
	public String checkLogIn(@BeanParam UserLogin userlogin) {
		PillReminderService service=new PillReminderService();
		String res=service.verifyUser(userlogin);
		return res;
	}
	
	@POST
	@Path("resetpass")
	public String resetPassword(@BeanParam PassReset passreset) {
		PillReminderService service=new PillReminderService();
		String res=service.resetOldPass(passreset);
		return res;
	}
	
	@POST
	@Path("savedepinfo")
	public String saveDep(@BeanParam DependentInfo dependentinfo) {
		PillReminderService service=new PillReminderService();
		String res=service.addDependentInfo(dependentinfo);
		return res;
	}
	
	@POST
	@Path("viewdepinfo")
	@Produces(MediaType.APPLICATION_JSON)
	public DependentInfo viewDep(@BeanParam ViewDependent viewDependent) {
		PillReminderService service=new PillReminderService();
		DependentInfo res=service.viewDependentInfo(viewDependent);
		return res;
	 }
	
	@POST
	@Path("updatedepinfo")
	public String saveUpdatedDepInfo(@BeanParam DependentInfo dependentinfo) {
		PillReminderService service=new PillReminderService();
		String res=service.updateDependentInfo(dependentinfo);
		return res;
	}
	
	@POST
	@Path("savemedinfo")
	public String saveDep(@BeanParam MedicalHistory medicalhistory) {
		PillReminderService service=new PillReminderService();
		String res=service.addMedicalHistory(medicalhistory);
		return res;
	}
	
	@POST
	@Path("gethistory")
	@Produces(MediaType.APPLICATION_JSON)
	public MedicalHistory[] getUser(@BeanParam ViewDependent viewDependent) {
		String emailid = viewDependent.getUmail(); 
		System.out.println(emailid);
		System.out.println(viewDependent);
		String relation = viewDependent.getRelation();
		PillReminderService service=new PillReminderService();
		MedicalHistory[] profile = service.viewhistory(emailid,relation);
		System.out.println(profile + " controller");
		return profile;
	 }
	 
}