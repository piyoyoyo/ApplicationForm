package com.techscore.springboot;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ConfirmationForm {

    @NotBlank(message = "必須項目です")
    private String lastName;

    @NotBlank(message = "必須項目です")
    private String firstName;

    @NotBlank(message = "必須項目です")
    private String lastNameKana;

    @NotBlank(message = "必須項目です")
    private String firstNameKana;

    @NotBlank(message = "必須項目です")
    private String zipcode;

    @NotBlank(message = "必須項目です")
    private String pref_id;

    @NotBlank(message = "必須項目です")
    private String city;

    @NotBlank(message = "必須項目です")
    private String town;

    @NotBlank(message = "必須項目です")
    private String house_num;

    private String building;

    @NotBlank(message = "必須項目です")
    @Pattern(regexp = "^0\\d{9,10}$|^0\\d{1,3}-\\d{2,4}-\\d{4}$", message = "10桁か11桁の数字を入力してください")
    private String phone;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNameKana() {
		return lastNameKana;
	}

	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPref_id() {
		return pref_id;
	}

	public void setPref_id(String pref_id) {
		this.pref_id = pref_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getHouse_num() {
		return house_num;
	}

	public void setHouse_num(String house_num) {
		this.house_num = house_num;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
