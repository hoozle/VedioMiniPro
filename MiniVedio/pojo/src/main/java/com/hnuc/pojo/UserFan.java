package com.hnuc.pojo;

public class UserFan {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_fans.id
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_fans.user_id
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_fans.fan_id
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    private String fanId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_fans.id
     *
     * @return the value of users_fans.id
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_fans.id
     *
     * @param id the value for users_fans.id
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_fans.user_id
     *
     * @return the value of users_fans.user_id
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_fans.user_id
     *
     * @param userId the value for users_fans.user_id
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_fans.fan_id
     *
     * @return the value of users_fans.fan_id
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    public String getFanId() {
        return fanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_fans.fan_id
     *
     * @param fanId the value for users_fans.fan_id
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    public void setFanId(String fanId) {
        this.fanId = fanId == null ? null : fanId.trim();
    }
}