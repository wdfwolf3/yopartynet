package com.yoparty.bean;

import java.io.Serializable;

public class LeaderActivity implements Serializable {
    private Integer id;

    private Integer leaderId;

    private Integer activityId;

    private Boolean ismasterleader;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Boolean getIsmasterleader() {
        return ismasterleader;
    }

    public void setIsmasterleader(Boolean ismasterleader) {
        this.ismasterleader = ismasterleader;
    }
}