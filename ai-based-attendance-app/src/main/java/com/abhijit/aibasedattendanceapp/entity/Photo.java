package com.abhijit.aibasedattendanceapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long photoId;
	private String photoLocation;

	public Photo() {
		super();
	}

	public Photo(long photoId, String photoLocation) {
		super();
		this.photoId = photoId;
		this.photoLocation = photoLocation;
	}

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public String getPhotoLocation() {
		return photoLocation;
	}

	public void setPhotoLocation(String photoLocation) {
		this.photoLocation = photoLocation;
	}

}
