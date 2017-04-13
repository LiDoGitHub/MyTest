package com.gjyl.appserver.pojo;

import java.util.UUID;

public class Banner {
    private String id;

    private String cover;

    private String site;

    private Integer categorycode;

    private String cyclopediaid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }


    public Integer getCategorycode() {
		return categorycode;
	}

	public void setCategorycode(Integer categorycode) {
		this.categorycode = categorycode;
	}

	public String getCyclopediaid() {
        return cyclopediaid;
    }

    public void setCyclopediaid(String cyclopediaid) {
        this.cyclopediaid = cyclopediaid == null ? null : cyclopediaid.trim();
    }

	public Banner() {
		this.id=UUID.randomUUID().toString().replace("-", "");
	}
    
}