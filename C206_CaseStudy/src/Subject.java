public class Subject {
	private int subjectId;
	private String subjectName;
	private String subDescription;
	private int subjectCredit;
	
	public Subject(int subjectId, String subjectName, String subDescription, int subjectCredit) {
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subDescription = subDescription;
		this.subjectCredit = subjectCredit;
	}
	
	public int getSubjectId() {
		return subjectId;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public String getSubDescription() {
		return subDescription;
	}
	
	public int getSubCredit() {
		return subjectCredit;
	}

}