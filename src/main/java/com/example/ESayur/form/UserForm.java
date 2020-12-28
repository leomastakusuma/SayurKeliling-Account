package com.example.ESayur.form;

import javax.validation.constraints.NotBlank;

public class UserForm {


  private String phoneNumber;
  private String fullName;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  public String getPhoneNumber(){
    return phoneNumber;
  }
  public void  setPhoneNumber(String phoneNumber){

    this.phoneNumber = phoneNumber;
  }
}
