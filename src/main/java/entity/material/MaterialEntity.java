package entity.material;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class MaterialEntity {
	/**
	 *  素材实体类
	 * 
	 */	
	private int materialId;
	private String materialUrl;
	private String materialCode;
	@NotEmpty
	private String materialName;
	
	
	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialUrl() {
		return materialUrl;
	}

	public void setMaterialUrl(String materialUrl) {
		this.materialUrl = materialUrl;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	@Override
	public String toString() {
		return "MaterialEntity [materialUrl=" + materialUrl + ", materialCode=" + materialCode + ", materialName="
				+ materialName + "]";
	}
	
	
}
