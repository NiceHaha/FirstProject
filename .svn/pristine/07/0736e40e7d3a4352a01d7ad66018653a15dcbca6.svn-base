package entity.depa_reciew;

import org.hibernate.validator.constraints.NotEmpty;

public class DepaReciewEntity {
	private int id;
	private String code;//编号
	@NotEmpty
	private String name;//姓名
	private int yesNo;//状态(审核是否通过)
	private String descride;//描述
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "DepaReciew [id=" + id + ", code=" + code + ", name=" + name + ", yesNo=" + yesNo + ", descride="
				+ descride + "]";
	}
}
