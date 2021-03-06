package com.jiaming.entity;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.uid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private String uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.tel
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private String tel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    private String email;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.uid
     *
     * @return the value of user.uid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.uid
     *
     * @param uid the value for user.uid
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.tel
     *
     * @return the value of user.tel
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.tel
     *
     * @param tel the value for user.tel
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbggenerated Mon Dec 02 16:01:14 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", tel=" + tel + ", email="
				+ email + "]";
	}

	public User(String uid, String username, String password, String tel, String email) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}