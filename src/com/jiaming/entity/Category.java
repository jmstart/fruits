package com.jiaming.entity;

public class Category {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.c_id
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private String cId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.c_name
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private String cName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.c_id
     *
     * @return the value of category.c_id
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public String getcId() {
        return cId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.c_id
     *
     * @param cId the value for category.c_id
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.c_name
     *
     * @return the value of category.c_name
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public String getcName() {
        return cName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.c_name
     *
     * @param cName the value for category.c_name
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }
}