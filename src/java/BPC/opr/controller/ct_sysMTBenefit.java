/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BPC.opr.controller;

import BPC.opr.model.cls_sysMTBenefit;
import BPC.opr.utility.cls_DBConnector;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author witco
 */
public class ct_sysMTBenefit {
    String Message;

    public String getMessage() {
        return Message;
    }

    private String getCommand(String fns_condition) {
        StringBuilder Oj_sb = new StringBuilder();

        Oj_sb.append(" SELECT BENEFIT_ID");
        Oj_sb.append(", BENEFIT_TEXT");
        Oj_sb.append(", BENEFIT_FROM");
        Oj_sb.append(", BENEFIT_TO");
        Oj_sb.append(", ISNULL(EDIT_BY, CREATE_BY) AS EDIT_BY");
        Oj_sb.append(", ISNULL(EDIT_DATE, CREATE_DATE) AS EDIT_DATE");
        Oj_sb.append(" FROM WEL_TRX_BENEFIT");
        Oj_sb.append(" ").append(fns_condition);

        return Oj_sb.toString();
    }

    private List<cls_sysMTBenefit> getData(cls_DBConnector fnOj_conn, String fns_condition) {

        List<cls_sysMTBenefit> Ojarr_model = new ArrayList<>();
        ResultSet Oj_rs;
        String ls_temp;

        try {
            ls_temp = " WHERE 1=1 " + fns_condition;
            ls_temp += " ORDER BY BENEFIT_ID";

            Oj_rs = (ResultSet) fnOj_conn.getQuery(this.getCommand(ls_temp));

            while (Oj_rs.next()) {
                Date benefit_from = Oj_rs.getTimestamp("BENEFIT_FROM");
                Date benefit_to = Oj_rs.getTimestamp("BENEFIT_TO");
                Date edit_date = Oj_rs.getTimestamp("EDIT_DATE");

                Ojarr_model.add(new cls_sysMTBenefit(
                        Oj_rs.getString("BENEFIT_ID"),
                        Oj_rs.getString("BENEFIT_TEXT"),
                        benefit_from,
                        benefit_to,
                        Oj_rs.getString("EDIT_BY"),
                        edit_date
                ));
            }
            Oj_rs.close();

        } catch (Exception ex) {
            Message = "ERROR(" + ct_sysMTBenefit.class.getName() + ".getData)::" + ex.getMessage();
        }
        return Ojarr_model;
    }

    public List<cls_sysMTBenefit> getData(cls_DBConnector fnOj_conn) {
        return getData(fnOj_conn, "");
    }

    public List<cls_sysMTBenefit> getDataByFillter(cls_DBConnector fnOj_conn, String fns_code) {

        String ls_fillter = "";

        if (!fns_code.equals("")) {
            ls_fillter += " AND BENEFIT_ID='" + fns_code + "'";
        }

        return getData(fnOj_conn, ls_fillter);
    }
}
