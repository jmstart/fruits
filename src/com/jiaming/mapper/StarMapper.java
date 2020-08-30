package com.jiaming.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaming.entity.Star;
import com.jiaming.povos.StarFruitPovo;

public interface StarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    int deleteByPrimaryKey(String sid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    int insert(Star record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    Star selectByPrimaryKey(String sid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    List<Star> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table star
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    int updateByPrimaryKey(Star record);

	List<StarFruitPovo> selectStarFruitPovosByUid(String uid);

	Star selectStarByUidAndFid(@Param("uid")String uid, @Param("fid")String fid);

	boolean updateStarBySidForScount(@Param("sid")String sid,@Param("value")int value);

}