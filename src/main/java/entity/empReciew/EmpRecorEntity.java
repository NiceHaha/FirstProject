package entity.empReciew;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class EmpRecorEntity {
	private int id;
	@NotEmpty
	private String name;//姓名
	private int sex;//性别
	@Max(value = 120,message = "最大只能输入120")
	private int age;//年龄
	@Length(max = 11,min = 11)
	private String tel;//电话
	private String addr;//地址
	private String position;//职位
	private int state;//状态
	private String depaCode;//部门编号
	@NotEmpty
	private String account;//账号
	private String password;//密码
	private int yesNo;//是否通过
	private String descride;//描述
	private String auditor;//审核员
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getDepaCode() {
		return depaCode;
	}
	public void setDepaCode(String depaCode) {
		this.depaCode = depaCode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getYesNo() {
		return yesNo;
	}
	public void setYesNo(int yesNo) {
		this.yesNo = yesNo;
	}
	public String getDescride() {
		return descride;
	}
	public void setDescride(String descride) {
		this.descride = descride;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	@Override
	public String toString() {
		return "EmpRecorEntity [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", tel=" + tel
				+ ", addr=" + addr + ", position=" + position + ", state=" + state + ", depaCode=" + depaCode
				+ ", account=" + account + ", password=" + password + ", yesNo=" + yesNo + ", descride=" + descride
				+ ", auditor=" + auditor + "]";
	}
	
}
