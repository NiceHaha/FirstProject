package entity.user;

import javax.validation.constraints.Max;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户
 * @author Administrator
 *
 */
public class UserEntity {
	private int id;// id
	@NotEmpty
	private String name; // 姓名
	private String code;// 编号
	@Length(max = 11,min = 11)
	private String tel;// 电话
	@NotEmpty
	private String account;// 账号
	private String password;// 密码
	private String addr;// 地址
	private int sex;// 性别
	@Max(120)
	private int age;// 年龄
	private int root;// 权限
	private int black;// 黑名单
	
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public int getBlack() {
		return black;
	}
	public void setBlack(int black) {
		this.black = black;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", code=" + code + ", tel=" + tel + ", account=" + account
				+ ", password=" + password + ", addr=" + addr + ", sex=" + sex + ", age=" + age + ", root=" + root
				+ ", black=" + black + "]";
	}
	

}
