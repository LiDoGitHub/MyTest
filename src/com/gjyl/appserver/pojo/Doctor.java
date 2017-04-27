package com.gjyl.appserver.pojo;

import java.util.UUID;

public class Doctor {
    private String doctorid;

    private String name;

    private String username;

    private String password;

    private String icon;

    private String title;

    private String sectionid;

    private String section;

    private String hospital;

    private String chatcost;

    private String callcost;

    private String seniority;

    private Integer commentcount;

    private String city;

    private String titleid;
    
    private Integer isexpert;

    private Integer canonline;

    private String bio;

    private String adept;

    private DocArrangement arrangement;

    public DocArrangement getArrangement() {
        return arrangement;
    }

    public void setArrangement(DocArrangement arrangement) {
        this.arrangement = arrangement;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAdept() {
        return adept;
    }

    public void setAdept(String adept) {
        this.adept = adept;
    }

    public Integer getCanonline() {
        return canonline;
    }

    public void setCanonline(Integer canonline) {
        this.canonline = canonline;
    }

    public Integer getIsexpert() {
		return isexpert;
	}

	public void setIsexpert(Integer isexpert) {
		this.isexpert = isexpert;
	}

	public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid == null ? null : doctorid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSectionid() {
        return sectionid;
    }

    public void setSectionid(String sectionid) {
        this.sectionid = sectionid == null ? null : sectionid.trim();
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section == null ? null : section.trim();
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getChatcost() {
        return chatcost;
    }

    public void setChatcost(String chatcost) {
        this.chatcost = chatcost == null ? null : chatcost.trim();
    }

    public String getCallcost() {
        return callcost;
    }

    public void setCallcost(String callcost) {
        this.callcost = callcost == null ? null : callcost.trim();
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority == null ? null : seniority.trim();
    }

    public Integer getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(Integer commentcount) {
		this.commentcount = commentcount;
	}

	public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getTitleid() {
        return titleid;
    }

    public void setTitleid(String titleid) {
        this.titleid = titleid == null ? null : titleid.trim();
    }

	public Doctor() {
		this.doctorid=UUID.randomUUID().toString().replace("-", "");
	}

	@Override
	public String toString() {
		return "Doctor [doctorid=" + doctorid + ", name=" + name
				+ ", username=" + username + ", password=" + password
				+ ", icon=" + icon + ", title=" + title + ", sectionid="
				+ sectionid + ", section=" + section + ", hospital=" + hospital
				+ ", chatcost=" + chatcost + ", callcost=" + callcost
				+ ", seniority=" + seniority + ", commentcount=" + commentcount
				+ ", city=" + city + ", titleid=" + titleid + "]";
	}
	
	
    
}