package com.hnuc.pojo;

public class UserLikeVideo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_like_videos.id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_like_videos.user_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users_like_videos.video_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private String videoId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_like_videos.id
     *
     * @return the value of users_like_videos.id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_like_videos.id
     *
     * @param id the value for users_like_videos.id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_like_videos.user_id
     *
     * @return the value of users_like_videos.user_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_like_videos.user_id
     *
     * @param userId the value for users_like_videos.user_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users_like_videos.video_id
     *
     * @return the value of users_like_videos.video_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users_like_videos.video_id
     *
     * @param videoId the value for users_like_videos.video_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }
}