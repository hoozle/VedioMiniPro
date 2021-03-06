package com.hnuc.dao;

import com.hnuc.pojo.SearchRecord;

import java.util.List;

public interface SearchRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_records
     *
     * @mbg.generated Fri Jan 25 18:32:24 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_records
     *
     * @mbg.generated Fri Jan 25 18:32:24 CST 2019
     */
    int insert(SearchRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_records
     *
     * @mbg.generated Fri Jan 25 18:32:24 CST 2019
     */
    int insertSelective(SearchRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_records
     *
     * @mbg.generated Fri Jan 25 18:32:24 CST 2019
     */
    SearchRecord selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_records
     *
     * @mbg.generated Fri Jan 25 18:32:24 CST 2019
     */
    int updateByPrimaryKeySelective(SearchRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table search_records
     *
     * @mbg.generated Fri Jan 25 18:32:24 CST 2019
     */
    int updateByPrimaryKey(SearchRecord record);

    /**
     * 根据内容查询搜索记录
     * @param content
     * @return
     */
    SearchRecord selectByContent(String content);

    List<String> selectContents(int count);
}