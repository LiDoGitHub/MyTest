package com.gjyl.appserver.pojo;

public class DoctorWithBLOBs extends Doctor {
    private String bio;

    private String adept;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    public String getAdept() {
        return adept;
    }

    public void setAdept(String adept) {
        this.adept = adept == null ? null : adept.trim();
    }

	public DoctorWithBLOBs() {
		super();
	}

	@Override
	public String toString() {
		return "DoctorWithBLOBs [bio=" + bio + ", adept=" + adept + "]";
	}
    
    
}