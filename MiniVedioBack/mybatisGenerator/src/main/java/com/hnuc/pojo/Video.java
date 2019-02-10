package com.hnuc.pojo;

import java.util.Date;

public class Video {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.user_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.audio_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private String audioId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.video_desc
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private String videoDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.video_path
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private String videoPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.video_seconds
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private Float videoSeconds;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.video_width
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private Integer videoWidth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.video_height
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private Integer videoHeight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.cover_path
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private String coverPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.like_counts
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private Long likeCounts;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.status
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column videos.create_time
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.id
     *
     * @return the value of videos.id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.id
     *
     * @param id the value for videos.id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.user_id
     *
     * @return the value of videos.user_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.user_id
     *
     * @param userId the value for videos.user_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.audio_id
     *
     * @return the value of videos.audio_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public String getAudioId() {
        return audioId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.audio_id
     *
     * @param audioId the value for videos.audio_id
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setAudioId(String audioId) {
        this.audioId = audioId == null ? null : audioId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.video_desc
     *
     * @return the value of videos.video_desc
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public String getVideoDesc() {
        return videoDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.video_desc
     *
     * @param videoDesc the value for videos.video_desc
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc == null ? null : videoDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.video_path
     *
     * @return the value of videos.video_path
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public String getVideoPath() {
        return videoPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.video_path
     *
     * @param videoPath the value for videos.video_path
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath == null ? null : videoPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.video_seconds
     *
     * @return the value of videos.video_seconds
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public Float getVideoSeconds() {
        return videoSeconds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.video_seconds
     *
     * @param videoSeconds the value for videos.video_seconds
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setVideoSeconds(Float videoSeconds) {
        this.videoSeconds = videoSeconds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.video_width
     *
     * @return the value of videos.video_width
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public Integer getVideoWidth() {
        return videoWidth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.video_width
     *
     * @param videoWidth the value for videos.video_width
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setVideoWidth(Integer videoWidth) {
        this.videoWidth = videoWidth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.video_height
     *
     * @return the value of videos.video_height
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public Integer getVideoHeight() {
        return videoHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.video_height
     *
     * @param videoHeight the value for videos.video_height
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setVideoHeight(Integer videoHeight) {
        this.videoHeight = videoHeight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.cover_path
     *
     * @return the value of videos.cover_path
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public String getCoverPath() {
        return coverPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.cover_path
     *
     * @param coverPath the value for videos.cover_path
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath == null ? null : coverPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.like_counts
     *
     * @return the value of videos.like_counts
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public Long getLikeCounts() {
        return likeCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.like_counts
     *
     * @param likeCounts the value for videos.like_counts
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setLikeCounts(Long likeCounts) {
        this.likeCounts = likeCounts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.status
     *
     * @return the value of videos.status
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.status
     *
     * @param status the value for videos.status
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column videos.create_time
     *
     * @return the value of videos.create_time
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column videos.create_time
     *
     * @param createTime the value for videos.create_time
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}