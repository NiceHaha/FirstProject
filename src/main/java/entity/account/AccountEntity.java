package entity.account;

public class AccountEntity {
	private int id;
	private String code;//编码
	private String account;//账号
	private String password;//密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	@Override
	public String toString() {
		return "AccountEnitty [id=" + id + ", code=" + code + ", account=" + account + ", password=" + password + "]";
	}
	
}
