package com.hnuc.mapper;

import com.hnuc.pojo.UserReport;

public interface UserReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int insert(UserReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int insertSelective(UserReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    UserReport selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int updateByPrimaryKeySelective(UserReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users_report
     *
     * @mbg.generated Wed Dec 19 16:38:07 CST 2018
     */
    int updateByPrimaryKey(UserReport record);
}