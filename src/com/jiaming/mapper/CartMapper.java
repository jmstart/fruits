package com.jiaming.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiaming.entity.Cart;
import com.jiaming.povos.CartFruitPovo;

public interface CartMapper {
	
	List<CartFruitPovo> selectCartFruitPovoByUid(String uid);
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    int deleteByPrimaryKey(String cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    int insert(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    Cart selectByPrimaryKey(String cid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    List<Cart> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cart
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    int updateByPrimaryKey(Cart record);

	List<Cart> selectCartByUid(String uid);

	boolean updateCartByCidForCcount(@Param("cid")String cid, @Param("value")int value);

	Cart selectCartByUidAndFid(Cart cart);

}