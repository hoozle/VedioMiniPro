package com.hnuc.pojo;

import java.util.Date;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.father_comment_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    private String fatherCommentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.to_user_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    private String toUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.video_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    private String videoId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.from_user_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    private String fromUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.create_time
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comments.comment
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    private String comment;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.id
     *
     * @return the value of comments.id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.id
     *
     * @param id the value for comments.id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.father_comment_id
     *
     * @return the value of comments.father_comment_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public String getFatherCommentId() {
        return fatherCommentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.father_comment_id
     *
     * @param fatherCommentId the value for comments.father_comment_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public void setFatherCommentId(String fatherCommentId) {
        this.fatherCommentId = fatherCommentId == null ? null : fatherCommentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.to_user_id
     *
     * @return the value of comments.to_user_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public String getToUserId() {
        return toUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.to_user_id
     *
     * @param toUserId the value for comments.to_user_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId == null ? null : toUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.video_id
     *
     * @return the value of comments.video_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public String getVideoId() {
        return videoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.video_id
     *
     * @param videoId the value for comments.video_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.from_user_id
     *
     * @return the value of comments.from_user_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public String getFromUserId() {
        return fromUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.from_user_id
     *
     * @param fromUserId the value for comments.from_user_id
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId == null ? null : fromUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.create_time
     *
     * @return the value of comments.create_time
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.create_time
     *
     * @param createTime the value for comments.create_time
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comments.comment
     *
     * @return the value of comments.comment
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comments.comment
     *
     * @param comment the value for comments.comment
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}