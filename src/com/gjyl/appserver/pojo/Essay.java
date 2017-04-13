package com.gjyl.appserver.pojo;

import java.util.UUID;

public class Essay {
    private String eid;

    private String econtent;

    private String eimages;

    private Integer etimes;

    private Integer eagrees;

    private Integer ecommontcount;

    private String ememo;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public String getEcontent() {
        return econtent;
    }

    public void setEcontent(String econtent) {
        this.econtent = econtent == null ? null : econtent.trim();
    }

    public String getEimages() {
        return eimages;
    }

    public void setEimages(String eimages) {
        this.eimages = eimages == null ? null : eimages.trim();
    }

    public Integer getEtimes() {
        return etimes;
    }

    public void setEtimes(Integer etimes) {
        this.etimes = etimes;
    }

    public Integer getEagrees() {
        return eagrees;
    }

    public void setEagrees(Integer eagrees) {
        this.eagrees = eagrees;
    }

    public Integer getEcommontcount() {
        return ecommontcount;
    }

    public void setEcommontcount(Integer ecommontcount) {
        this.ecommontcount = ecommontcount;
    }

    public String getEmemo() {
        return ememo;
    }

    public void setEmemo(String ememo) {
        this.ememo = ememo == null ? null : ememo.trim();
    }

	public Essay() {
		this.eid=UUID.randomUUID().toString().replace("-", "");
	}
    
    
    
    
}