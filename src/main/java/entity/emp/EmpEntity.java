package entity.emp;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class EmpEntity {
	private int id;
	@NotEmpty
	private String name;//姓名
	private int sex;//性别
	@Max(120)
	private int age;//年龄
	@Length(max = 11,min = 11)
	private String tel;//电话
	private int root;//权限
	private String addr;//地址
	@NotEmpty
	private String account;//账号
	private String password;//密码
	private String position;//职位
	private int state;//状态
	private String depaName;//部门名字
	private String empCode;//编号
	private String depaCode;//部门编号
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
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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
	public String getDepaName() {
		return depaName;
	}
	public void setDepaName(String depaName) {
		this.depaName = depaName;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getDepaCode() {
		return depaCode;
	}
	public void setDepaCode(String depaCode) {
		this.depaCode = depaCode;
	}
	@Override
	public String toString() {
		return "EmpEntity [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", tel=" + tel + ", root="
				+ root + ", addr=" + addr + ", account=" + account + ", password=" + password + ", position=" + position
				+ ", state=" + state + ", depaName=" + depaName + ", empCode=" + empCode + ", depaCode=" + depaCode
				+ "]";
	}
	

}
