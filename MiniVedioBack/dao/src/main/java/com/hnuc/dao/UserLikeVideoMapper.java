package com.hnuc.dao;

import com.hnuc.pojo.UserLikeVideo;
import org.apache.ibatis.annotations.Param;

public interface UserLikeVideoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    int insert(UserLikeVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    int insertSelective(UserLikeVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    UserLikeVideo selectByPrimaryKey(String id);

    /**
     * 查询是否添加喜爱属性
     * @param userID
     * @param videoID
     * @return
     */
    UserLikeVideo selectByUserIDAndVideoID(@Param("userID") String userID, @Param("videoID") String videoID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    int updateByPrimaryKeySelective(UserLikeVideo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_like_videos
     *
     * @mbg.generated Sun Jan 27 15:09:46 CST 2019
     */
    int updateByPrimaryKey(UserLikeVideo record);
}