package entity.project;

public class ProjectReport {
	private int id;
	private String articletcode;
	private String articletitle;
	private String reporting;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArticletcode() {
		return articletcode;
	}
	public void setArticletcode(String articletcode) {
		this.articletcode = articletcode;
	}
	public String getArticletitle() {
		return articletitle;
	}
	public void setArticletitle(String articletitle) {
		this.articletitle = articletitle;
	}
	public String getReporting() {
		return reporting;
	}
	public void setReporting(String reporting) {
		this.reporting = reporting;
	}
	@Override
	public String toString() {
		return "ProjectReport [articletcode=" + articletcode + ", articletitle=" + articletitle + ", reporting="
				+ reporting + "]";
	}
	
	
}
