package com.jiaming.entity;

public class Cart {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.cid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private String cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.fid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private Integer fid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.uid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private String uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cart.ccount
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private Integer ccount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.cid
     *
     * @return the value of cart.cid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.cid
     *
     * @param cid the value for cart.cid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.fid
     *
     * @return the value of cart.fid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public Integer getFid() {
        return fid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.fid
     *
     * @param fid the value for cart.fid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setFid(Integer fid) {
        this.fid = fid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.uid
     *
     * @return the value of cart.uid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.uid
     *
     * @param uid the value for cart.uid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cart.ccount
     *
     * @return the value of cart.ccount
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public Integer getCcount() {
        return ccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cart.ccount
     *
     * @param ccount the value for cart.ccount
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setCcount(Integer ccount) {
        this.ccount = ccount;
    }
}