package com.umudugudu.Model;






import javax.persistence.*;

@Entity
	public class Umudugudu{


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String firstname;
		private String lastname;
		private Integer national;
		private String District;
		private String country;
		private String Gender;
		private Integer Age;

	public Umudugudu(String firstname, String lastname, Integer national, String district, String country, String gender, Integer age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.national = national;
		District = district;
		this.country = country;
		Gender = gender;
		Age = age;
	}

	public Umudugudu() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getNational() {
		return national;
	}

	public void setNational(Integer national) {
		this.national = national;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}
}
