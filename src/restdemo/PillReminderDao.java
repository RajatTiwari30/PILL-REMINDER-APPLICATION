package restdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class PillReminderDao {
	public PillReminderDao() {
		// TODO Auto-generated constructor stub
	}
	
	private static HashMap<String, UserInfo> userdata;
	static {
		userdata = new HashMap<>();
	}
	
	
//Only Service for Log In
	public String checkUser(UserLogin userlogin) {
		readFileFromSystem();
		String email=userlogin.getEmail();
		String password = userlogin.getPassword();
			if(userdata.containsKey(email)) {
				UserInfo ui=userdata.get(email);
				String storedPass = ui.getPassword(); //retrieving password from backend
					if(storedPass.equals(password)){
						return ui.getName();
					}
					else {
					return "PASSWORD INCORECT";
					}
		
			}
			else {
			return "USER DOES NOT EXIST";
			}
	}
	
	
//Only service for reset password
	public String resetPass(PassReset passreset) {
		String email=passreset.getEmail();
		String password = passreset.getPassword();
		String newpassword = passreset.getNewpassword();
		if(userdata.containsKey(email)) {
			UserInfo ui=userdata.get(email);
			String em = ui.getPassword();
				if(em.equals(password)){
					ui.setPassword(newpassword);
					userdata.replace(email, ui);
					return "true";
				}
				else {
					return "PASSWORD INCORECT";
				}
		
		}
		else {
			return "USER DOES NOT EXIST";
			}
	}
	
	
//Only Service for Registration
	public boolean saveUserInfo(UserInfo userinfo) {
		readFileFromSystem();
		boolean status=true;
		if(userdata.containsKey(userinfo.getEmail())==false) {
		DependentInfo selfDep= new DependentInfo();
		selfDep.setUmail(userinfo.getEmail());
		selfDep.setDepemail(userinfo.getEmail());
		selfDep.setDepdob(userinfo.getDob());
		selfDep.setDepcontact(userinfo.getContact());
		selfDep.setDepname(userinfo.getName());
		selfDep.setRelation("Self");
		MedicalHistory mh= new MedicalHistory();
		mh.setuMail(userinfo.getEmail());
		mh.setRelation("SELF");
		MedicalHistory mhArray[]=new MedicalHistory[1];
		mhArray[0]=mh;
		selfDep.setMedicalHistory(mhArray);
		DependentInfo userDep[]=new DependentInfo[1];
		userDep[0]=selfDep;
		userinfo.setUserdependentrelation(userDep);
		UserInfo userInfoObject=userdata.put(userinfo.getEmail(), userinfo);
			if(userInfoObject==null) {
			status=false;
			writeFileInSystem();
			}
		}
		return status;
	}

	
//Service for Addition of dependents
	public String saveDependentInfo(DependentInfo dependentinfo) {
		String returnvalue="USER DOES NOT EXIST.";
		String um=dependentinfo.getUmail();
		MedicalHistory mh= new MedicalHistory();
		mh.setuMail(dependentinfo.getUmail());
		mh.setRelation(dependentinfo.getRelation());
		MedicalHistory mhArray[]=new MedicalHistory[1];
		mhArray[0]=mh;
		dependentinfo.setMedicalHistory(mhArray);
			if(userdata.containsKey(um)) {
				UserInfo userinfo=userdata.get(um);
				DependentInfo[] dependentData=userinfo.getUserdependentrelation();
				int length=dependentData.length;
				DependentInfo[] dependentDataUpdated= new DependentInfo[length+1];
					for(int i=0;i<length;i++) {
						dependentDataUpdated[i]=dependentData[i];
					}
					if(dependentinfo!=null) {
						dependentDataUpdated[length]=dependentinfo;
					}
			userinfo.setUserdependentrelation(dependentDataUpdated);
			userdata.replace(um, userinfo);
			writeFileInSystem();
			returnvalue= "DEPENDENT ADDED.";
			}
			return returnvalue;
	}
	
	
//Service for Viewing Dependent Information
		public DependentInfo showDependent(ViewDependent viewDependent) {
			DependentInfo dInToreturn=null;
			String userMail=viewDependent.getUmail();
			String relation=viewDependent.getRelation();
			System.out.println(userdata.containsKey(userMail));
				if(userdata.containsKey(userMail)) {
					UserInfo userinfo= userdata.get(userMail);
					DependentInfo depInfo[]=userinfo.getUserdependentrelation();
					int lengthOfArray=depInfo.length;
					for(int i=1;i<lengthOfArray;i++) {
						DependentInfo dI=depInfo[i];
							if(dI.getRelation().equalsIgnoreCase(relation)) {
								dInToreturn=dI;
								System.out.println(dInToreturn);
							}
					}
				}
			return dInToreturn;
		}

//Service for Update of Dependent Information
		public String updateDependentInfo(DependentInfo dependentinfo) {
			String returnvalue="ERROR IN UPDATING DEPENDENT.";
			String um=dependentinfo.getUmail();
			String toUpdateRelation= dependentinfo.getRelation();
				if(userdata.containsKey(um)) {
					UserInfo userinfo=userdata.get(um);
					DependentInfo[] dependentData=userinfo.getUserdependentrelation();
					int length=dependentData.length;
					DependentInfo[] dependentDataUpdated= new DependentInfo[length+1];
						for(int i=1;i<length;i++) {
							DependentInfo diu = dependentData[i];
								if(diu.getRelation().equalsIgnoreCase(toUpdateRelation)) {
									MedicalHistory toPutmh[]=diu.getMedicalHistory();
									dependentinfo.setMedicalHistory(toPutmh);
									dependentData[i]=dependentinfo;
									userinfo.setUserdependentrelation(dependentData);
									userdata.replace(um, userinfo);
									returnvalue= "DEPENDENT UPDATED.";
								}
						}
				writeFileInSystem();	
				}
				return returnvalue;
		}
		
		
//Service to write file into system
		private void writeFileInSystem() {
			try {
				File file=new File("userinfo.ser");
				FileOutputStream fos=new FileOutputStream(file);
				ObjectOutputStream oos= new ObjectOutputStream(fos);
				oos.reset();
				oos.writeObject(userdata);
				oos.close();
				fos.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}

		
//Service for adding Medical History
		public String saveMedicalHistory(MedicalHistory medicalHistory) {
			String toReturn= "ERROR: MEDICAL HISTORY NOT SAVED.";
			String um=medicalHistory.getumail();
			String relation=medicalHistory.getRelation();
			if(userdata.containsKey(um)) {
				UserInfo userinfo=userdata.get(um);
				DependentInfo[] dependentData=userinfo.getUserdependentrelation();
				int lengthOfArray=dependentData.length;
				for(int i=0;i<lengthOfArray;i++) {
					DependentInfo dI=dependentData[i];
						if(dI.getRelation().equalsIgnoreCase(relation)) {
							MedicalHistory mH[]=dI.getMedicalHistory();
							int length=mH.length;
							MedicalHistory[] mHUpdated= new MedicalHistory[length+1];
								for(int j=0;j<length;j++) {
									mHUpdated[j]=mH[j];
								}
								if(medicalHistory!=null) {
									mHUpdated[length]=medicalHistory;
								}
								dI.setMedicalHistory(mHUpdated);
								dependentData[i]=dI;
								userinfo.setUserdependentrelation(dependentData);
								userdata.replace(um,userinfo);
								writeFileInSystem();
								toReturn= "MEDICAL HISTORY SAVED";
						}
				}
			}
			
			return toReturn;
		}
//Service for viewing medical history
		public MedicalHistory[] viewHistory(String umail,String relation) {
				MedicalHistory mH[] = null;
				System.out.println(umail);
				System.out.println(userdata);
					if(userdata.containsKey(umail)) {
						System.out.println("sss");
						UserInfo userinfo=userdata.get(umail);
						DependentInfo[] dependentData=userinfo.getUserdependentrelation();
						System.out.println(dependentData);
						int lengthOfArray=dependentData.length;
						System.out.println(lengthOfArray);
							for(int  i = 0;i<lengthOfArray;i++) {
						DependentInfo dI=dependentData[i];
								if(dI.getRelation().equalsIgnoreCase(relation)) {
							mH =dI.getMedicalHistory();
								}
							}
					}
					return mH;
				}
		
//Service to read file
		private void readFileFromSystem() {
			try{
				FileInputStream fis=new FileInputStream("userinfo.ser");
				ObjectInputStream ois= new ObjectInputStream(fis);
				userdata=(HashMap<String, UserInfo>) ois.readObject();
				ois.close();
				fis.close();
			} 
			catch(Exception e){
				System.out.println(e);
			}
		}
}
