
public class PrerequisiteInfo {
//	private String PrerequisiteInfoID;
	private String PrerequisiteInfoName;

	public PrerequisiteInfo(String academicClusterName) {
		// TODO Auto-generated constructor stub
//		PrerequisiteInfoID = prerequisiteInfoID;
		PrerequisiteInfoName = academicClusterName;
	}

//	public void setPrerequisiteInfoID(String pRIID) {
//		this.PrerequisiteInfoID = pRIID;
//	}

//	public String getPrerequisiteInfoID() {
//		return PrerequisiteInfoID;
//	}

	public void setPrerequisiteInfoName(String academicClusterName) {
		this.PrerequisiteInfoName = academicClusterName;
	}

	public String getPrerequisiteInfoName() {
		return PrerequisiteInfoName;
	}

}
