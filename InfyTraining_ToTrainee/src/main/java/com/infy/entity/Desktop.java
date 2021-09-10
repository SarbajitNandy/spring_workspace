package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.infy.dto.DesktopStatus;

@Entity
public class Desktop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String desktopId;
	private String desktopMake;
	private String desktopModel;
	@Enumerated(EnumType.STRING)
	private DesktopStatus desktopStatus;
	public String getDesktopId() {
		return desktopId;
	}
	public void setDesktopId(String desktopId) {
		this.desktopId = desktopId;
	}
	public String getDesktopMake() {
		return desktopMake;
	}
	public void setDesktopMake(String desktopMake) {
		this.desktopMake = desktopMake;
	}
	public String getDesktopModel() {
		return desktopModel;
	}
	public void setDesktopModel(String desktopModel) {
		this.desktopModel = desktopModel;
	}
	public DesktopStatus getDesktopStatus() {
		return desktopStatus;
	}
	public void setDesktopStatus(DesktopStatus desktopStatus) {
		this.desktopStatus = desktopStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desktopId == null) ? 0 : desktopId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desktop other = (Desktop) obj;
		if (desktopId == null) {
			if (other.desktopId != null)
				return false;
		} else if (!desktopId.equals(other.desktopId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Desktop [desktopId=" + desktopId + ", desktopMake=" + desktopMake + ", desktopModel=" + desktopModel
				+ ", desktopStatus=" + desktopStatus + "]";
	}
}
