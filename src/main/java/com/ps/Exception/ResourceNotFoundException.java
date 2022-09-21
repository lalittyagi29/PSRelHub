package com.ps.Exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	String fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, String eventId) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, eventId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = eventId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

}
