package com.zz80z.busAward.common.model;

public class StuWeek {
    private Integer stuweekId;

    private Integer stuId;

    private String week;

    private String advanGroup;

    private String progressGroup;

    private String care;

    private String service;

    private String just;

    private String integrity;

    private String progress;

    private String stimulate;

    private String reserve;

    public Integer getStuweekId() {
        return stuweekId;
    }

    public void setStuweekId(Integer stuweekId) {
        this.stuweekId = stuweekId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public String getAdvanGroup() {
        return advanGroup;
    }

    public void setAdvanGroup(String advanGroup) {
        this.advanGroup = advanGroup == null ? null : advanGroup.trim();
    }

    public String getProgressGroup() {
        return progressGroup;
    }

    public void setProgressGroup(String progressGroup) {
        this.progressGroup = progressGroup == null ? null : progressGroup.trim();
    }

    public String getCare() {
        return care;
    }

    public void setCare(String care) {
        this.care = care == null ? null : care.trim();
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
    }

    public String getJust() {
        return just;
    }

    public void setJust(String just) {
        this.just = just == null ? null : just.trim();
    }

    public String getIntegrity() {
        return integrity;
    }

    public void setIntegrity(String integrity) {
        this.integrity = integrity == null ? null : integrity.trim();
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress == null ? null : progress.trim();
    }

    public String getStimulate() {
        return stimulate;
    }

    public void setStimulate(String stimulate) {
        this.stimulate = stimulate == null ? null : stimulate.trim();
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }
}