/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPC.opr.model;

import java.util.Date;


public class cls_sysMTReportjob {

    String reportjob_id;
    String reportjob_ref;
    String reportjob_type;
    String reportjob_status;
    Date reportjob_fromdate;
    Date reportjob_todate;
    String created_by;
    Date created_date;
    String flag;

    String user_id;
    String job_code;

    public String getReportjob_id() {
        return reportjob_id;
    }

    public void setReportjob_id(String reportjob_id) {
        this.reportjob_id = reportjob_id;
    }

    public String getReportjob_ref() {
        return reportjob_ref;
    }

    public void setReportjob_ref(String reportjob_ref) {
        this.reportjob_ref = reportjob_ref;
    }

    public String getReportjob_type() {
        return reportjob_type;
    }

    public void setReportjob_type(String reportjob_type) {
        this.reportjob_type = reportjob_type;
    }

    public String getReportjob_status() {
        return reportjob_status;
    }

    public void setReportjob_status(String reportjob_status) {
        this.reportjob_status = reportjob_status;
    }

    public Date getReportjob_fromdate() {
        return reportjob_fromdate;
    }

    public void setReportjob_fromdate(Date reportjob_fromdate) {
        this.reportjob_fromdate = reportjob_fromdate;
    }

    public Date getReportjob_todate() {
        return reportjob_todate;
    }

    public void setReportjob_todate(Date reportjob_todate) {
        this.reportjob_todate = reportjob_todate;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    
    public String getJob_code() {
        return job_code;
    }

    public void setJob_code(String job_code) {
        this.job_code = job_code;
    }
}
