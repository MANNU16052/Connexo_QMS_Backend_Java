package QMS.QMS_Project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DataField {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String FieldName;
    private String FieldType;
    private String AuditTrailActivityTypeTriggered;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public String getFieldType() {
		return FieldType;
	}
	public void setFieldType(String fieldType) {
		FieldType = fieldType;
	}
	public String getAuditTrailActivityTypeTriggered() {
		return AuditTrailActivityTypeTriggered;
	}
	public void setAuditTrailActivityTypeTriggered(String auditTrailActivityTypeTriggered) {
		AuditTrailActivityTypeTriggered = auditTrailActivityTypeTriggered;
	}
	
	
	@Override
	public String toString() {
		return "DataField [id=" + id + ", FieldName=" + FieldName + ", FieldType=" + FieldType
				+ ", AuditTrailActivityTypeTriggered=" + AuditTrailActivityTypeTriggered + "]";
	}

}
