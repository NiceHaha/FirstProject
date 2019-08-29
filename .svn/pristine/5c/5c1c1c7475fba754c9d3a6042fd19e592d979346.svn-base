package entity.csr;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 
 *	客服实体类
 * @author :lyy
 * @date :上午9:33:42 2019年5月9日
 */
public class CsrEntity {
	
	private int id;//客服id
	@NotEmpty//名字不能为空
	private String csrName;//客服名字
	private int csrSex;//客服性别
//	@Max(value = 120,message = "年龄限制120以内")
	private int csrAge;//客服年龄
	private String csrTel;//客服电话
	private String csrPath;//客服头像
	private int csrStatus;//客服是否在线状态
	private String empCode;//客服编号
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCsrName() {
		return csrName;
	}
	public void setCsrName(String csrName) {
		this.csrName = csrName;
	}
	public int getCsrSex() {
		return csrSex;
	}
	public void setCsrSex(int csrSex) {
		this.csrSex = csrSex;
	}
	public int getCsrAge() {
		return csrAge;
	}
	public void setCsrAge(int csrAge) {
		this.csrAge = csrAge;
	}
	public String getCsrTel() {
		return csrTel;
	}
	public void setCsrTel(String csrTel) {
		this.csrTel = csrTel;
	}
	public String getCsrPath() {
		return csrPath;
	}
	public void setCsrPath(String csrPath) {
		this.csrPath = csrPath;
	}
	public int getCsrStatus() {
		return csrStatus;
	}
	public void setCsrStatus(int csrStatus) {
		this.csrStatus = csrStatus;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	@Override
	public String toString() {
		return "CsrEntity [id=" + id + ", csrName=" + csrName + ", csrSex=" + csrSex + ", csrAge=" + csrAge
				+ ", csrTel=" + csrTel + ", csrPath=" + csrPath + ", csrStatus=" + csrStatus + ", empCode=" + empCode
				+ "]";
	}
}
