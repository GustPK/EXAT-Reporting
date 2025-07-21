/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPC.opr.model;

import java.util.Date;
import java.sql.Time;

/**
 *
 * @author witco
 */
public class cls_sysMTWorklog {
    Date work_date;
    Time time_start;
    Time time_end;
    String job_code;
    String task_detail;
    String location_name;
    String user_id;
    String user_name;
    String position;
    String phonenumber;
    String email;
    String department_name;

    public cls_sysMTWorklog(Date work_date, Time time_start, Time time_end, String job_code, String task_detail, String location_name, String user_id, String user_name, String position, String phonenumber, String email, String department_name) {
        this.work_date = work_date;
        this.time_start = time_start;
        this.time_end = time_end;
        this.job_code = job_code;
        this.task_detail = task_detail;
        this.location_name = location_name;
        this.user_id = user_id;
        this.user_name = user_name;
        this.position = position;
        this.phonenumber = phonenumber;
        this.email = email;
        this.department_name = department_name;
    }

    public Date getWork_date() {
        return work_date;
    }

    public void setWork_date(Date work_date) {
        this.work_date = work_date;
    }

    public Time getTime_start() {
        return time_start;
    }

    public void setTime_start(Time time_start) {
        this.time_start = time_start;
    }
    
    public Time getTime_end() {
        return time_end;
    }

    public void setTime_end(Time time_end) {
        this.time_end = time_end;
    }

    public String getJob_code() {
        return job_code;
    }

    public void setJob_code(String job_code) {
        this.job_code = job_code;
    }

    public String getTask_detail() {
        return task_detail;
    }

    public void setTask_detail(String task_detail) {
        this.task_detail = task_detail;
    }
    
    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }
    
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
    
}
