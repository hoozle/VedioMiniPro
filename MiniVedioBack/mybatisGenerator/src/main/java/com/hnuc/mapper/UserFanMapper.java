package com.hnuc.mapper;

import com.hnuc.pojo.UserFan;

public interface UserFanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    int insert(UserFan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    int insertSelective(UserFan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    UserFan selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    int updateByPrimaryKeySelective(UserFan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_fans
     *
     * @mbg.generated Tue Jan 29 14:40:24 CST 2019
     */
    int updateByPrimaryKey(UserFan record);
}