/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPC.opr.model;

import java.util.Date;

/**
 *
 * @author witco
 */
public class cls_sysMTBenefit {
    String benefit_id;
    String benefit_text;
    Date benefit_from;
    Date benefit_to;
    String edit_by;
    Date edit_date;

    public cls_sysMTBenefit(String benefit_id, String benefit_text, Date benefit_from, Date benefit_to, String edit_by, Date edit_date) {
        this.benefit_id = benefit_id;
        this.benefit_text = benefit_text;
        this.benefit_from = benefit_from;
        this.benefit_to = benefit_to;
        this.edit_by = edit_by;
        this.edit_date = edit_date;
    }

    public String getBenefit_id() {
        return benefit_id;
    }

    public void setBenefit_id(String benefit_id) {
        this.benefit_id = benefit_id;
    }

    public String getBenefit_text() {
        return benefit_text;
    }

    public void setBenefit_text(String benefit_text) {
        this.benefit_text = benefit_text;
    }

    public Date getBenefit_from() {
        return benefit_from;
    }

    public void setBenefit_from(Date benefit_from) {
        this.benefit_from = benefit_from;
    }

    public Date getBenefit_to() {
        return benefit_to;
    }

    public void setBenefit_to(Date benefit_to) {
        this.benefit_to = benefit_to;
    }

    public String getEdit_by() {
        return edit_by;
    }

    public void setEdit_by(String edit_by) {
        this.edit_by = edit_by;
    }

    public Date getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(Date edit_date) {
        this.edit_date = edit_date;
    }
    
    
}