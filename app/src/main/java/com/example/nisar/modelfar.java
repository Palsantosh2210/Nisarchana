package com.example.nisar;

public class modelfar {
    String age, district, education, email, engineeringLabour,experience,image,name, phone,state;
    public  modelfar(){

    }
    public modelfar(String age, String district, String education, String email, String engineeringLabour, String experience,String image, String name, String phone, String state ){
        this.age = age;
        this.district = district;
        this.education = education;
        this.email = email;
        this.engineeringLabour = engineeringLabour;
        this.experience = experience;
        this.image=image;
        this.name = name;
        this.phone = phone;
        this.state = state;


    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEngineeringLabour() {
        return engineeringLabour;
    }

    public void setEngineeringLabour(String engineeringLabour) {
        this.engineeringLabour = engineeringLabour;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
