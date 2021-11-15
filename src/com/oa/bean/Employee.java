package com.oa.bean;

import java.util.Date;

//员工模块的Java实体类
public class Employee {

    // 根据数据库表定义属性
    private int id;
    private String password;
    private int dept_id;
    private int job_id;
    private String username;
    private String sex;
    private String email;
    private String education;
    private String phone;
    private String card_id;
    private String party;
    private String race;
    private String imgname;
    private String createDate;
    //对象数据关系引用--依赖[一对一]
    private String deptName;
    private String jobName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    //
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    //
    public Employee(int id, String password, int dept_id, int job_id, String username, String sex, String email, String education, String phone, String card_id, String party, String race, String imgname, String createDate, String deptName, String jobName) {
        this.id = id;
        this.password = password;
        this.dept_id = dept_id;
        this.job_id = job_id;
        this.username = username;
        this.sex = sex;
        this.email = email;
        this.education = education;
        this.phone = phone;
        this.card_id = card_id;
        this.party = party;
        this.race = race;
        this.imgname = imgname;
        this.createDate = createDate;
        this.deptName = deptName;
        this.jobName = jobName;
    }

    public Employee(String password, int dept_id, int job_id, String username, String sex, String email, String phone, String card_id) {
        this.password = password;
        this.dept_id = dept_id;
        this.job_id = job_id;
        this.username = username;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.card_id = card_id;
    }

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", password=" + password + ", dept_id=" + dept_id + ", job_id=" + job_id
                + ", username=" + username + ", sex=" + sex + ", email=" + email + ", education=" + education
                + ", phone=" + phone + ", card_id=" + card_id + ", party=" + party + ", race=" + race + ", imgname="
                + imgname + ", createDate=" + createDate + "]";
    }

}
