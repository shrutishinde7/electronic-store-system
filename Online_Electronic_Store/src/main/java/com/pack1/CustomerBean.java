package com.pack1;

import java.io.Serializable;

public class CustomerBean implements Serializable
{
   private String cUserName,cPassword,cFname,cLname,cAddress,cMailId,cPhoneNo;

public String getcUserName() {
	return cUserName;
}

public void setcUserName(String cUserName) {
	this.cUserName = cUserName;
}

public String getcPassword() {
	return cPassword;
}

public void setcPassword(String cPassword) {
	this.cPassword = cPassword;
}

public String getcFname() {
	return cFname;
}

public void setcFname(String cFname) {
	this.cFname = cFname;
}

public String getcLname() {
	return cLname;
}

public void setcLname(String cLname) {
	this.cLname = cLname;
}

public String getcAddress() {
	return cAddress;
}

public void setcAddress(String cAddress) {
	this.cAddress = cAddress;
}

public String getcMailId() {
	return cMailId;
}

public void setcMailId(String cMailId) {
	this.cMailId = cMailId;
}

public String getcPhoneNo() {
	return cPhoneNo;
}

public void setcPhoneNo(String cPhoneNo) {
	this.cPhoneNo = cPhoneNo;
}

public CustomerBean() {}
}
