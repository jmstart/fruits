package com.jiaming.povos;

public class RegistMsgPovo {

	private boolean res;

	private boolean email_status = true;
	private boolean tel_status = true;
//	private  boolean   email_tel_status=true ; 
	private boolean insert_status = true;

	public RegistMsgPovo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistMsgPovo(boolean res, boolean email_status, boolean tel_status, boolean insert_status) {
		super();
		this.res = res;
		this.email_status = email_status;
		this.tel_status = tel_status;
		this.insert_status = insert_status;
	}

	public boolean isRes() {
		return res;
	}

	public void setRes(boolean res) {
		this.res = res;
	}

	public boolean isEmail_status() {
		return email_status;
	}

	public void setEmail_status(boolean email_status) {
		this.email_status = email_status;
	}

	public boolean isTel_status() {
		return tel_status;
	}

	public void setTel_status(boolean tel_status) {
		this.tel_status = tel_status;
	}

	public boolean isInsert_status() {
		return insert_status;
	}

	public void setInsert_status(boolean insert_status) {
		this.insert_status = insert_status;
	}

	@Override
	public String toString() {
		return "RegistMsgPovo [res=" + res + ", email_status=" + email_status + ", tel_status=" + tel_status
				+ ", insert_status=" + insert_status + "]";
	}

}
