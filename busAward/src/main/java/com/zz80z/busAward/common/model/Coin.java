package com.zz80z.busAward.common.model;

public class Coin {
    @Override
	public String toString() {
		return "Coin [coinId=" + coinId + ", stuId=" + stuId + ", teamCoin=" + teamCoin + ", levelCoin=" + levelCoin
				+ ", flexibleCoin=" + flexibleCoin + ", firstCoin=" + firstCoin + ", promoteCoin=" + promoteCoin
				+ ", advanCoin=" + advanCoin + ", activityCoin=" + activityCoin + ", reserve=" + reserve + "]";
	}

	private Integer coinId;

    private Integer stuId;

    private Integer teamCoin;

    private Integer levelCoin;

    private Integer flexibleCoin;

    private Integer firstCoin;

    private Integer promoteCoin;

    private Integer advanCoin;

    private Integer activityCoin;

    private String reserve;

    public Integer getCoinId() {
        return coinId;
    }

    public void setCoinId(Integer coinId) {
        this.coinId = coinId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getTeamCoin() {
        return teamCoin;
    }

    public void setTeamCoin(Integer teamCoin) {
        this.teamCoin = teamCoin;
    }

    public Integer getLevelCoin() {
        return levelCoin;
    }

    public void setLevelCoin(Integer levelCoin) {
        this.levelCoin = levelCoin;
    }

    public Integer getFlexibleCoin() {
        return flexibleCoin;
    }

    public void setFlexibleCoin(Integer flexibleCoin) {
        this.flexibleCoin = flexibleCoin;
    }

    public Integer getFirstCoin() {
        return firstCoin;
    }

    public void setFirstCoin(Integer firstCoin) {
        this.firstCoin = firstCoin;
    }

    public Integer getPromoteCoin() {
        return promoteCoin;
    }

    public void setPromoteCoin(Integer promoteCoin) {
        this.promoteCoin = promoteCoin;
    }

    public Integer getAdvanCoin() {
        return advanCoin;
    }

    public void setAdvanCoin(Integer advanCoin) {
        this.advanCoin = advanCoin;
    }

    public Integer getActivityCoin() {
        return activityCoin;
    }

    public void setActivityCoin(Integer activityCoin) {
        this.activityCoin = activityCoin;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve == null ? null : reserve.trim();
    }
}