package com.hnuc.dao;


import com.hnuc.pojo.UserFan;
import org.apache.ibatis.annotations.Param;

public interface UserFanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int deleteByPrimaryKey(String id);

    int deleteByUserAndFanID(@Param("userID")String userID, @Param("fanID")String fanID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int insert(UserFan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int insertSelective(UserFan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    UserFan selectByPrimaryKey(String id);


    /**
     * 手动添加
     * 通过用户和粉丝ID查询数据
     */
    Integer selectByUserAndFanID(@Param("userID") String userID, @Param("fanID")String FanID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int updateByPrimaryKeySelective(UserFan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int updateByPrimaryKey(UserFan record);
}