package BPC.opr.controller;

import BPC.opr.model.cls_sysMTReportjob;
import BPC.opr.model.cls_sysTRReportjobwhose;
import BPC.opr.utility.cls_DBConnector;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ct_sysMTReportjob {
    String Message;

    public String getMessage() {
        return Message;
    }

    private String getCommand(String fns_condition) {
        StringBuilder Oj_sb = new StringBuilder();

        Oj_sb.append(" SELECT REPORTJOB_ID");
        Oj_sb.append(", REPORTJOB_REF");  
        Oj_sb.append(", ISNULL(REPORTJOB_TYPE, '') AS REPORTJOB_TYPE"); 
        Oj_sb.append(", ISNULL(REPORTJOB_STATUS, '') AS REPORTJOB_STATUS"); 
        Oj_sb.append(", ISNULL(REPORTJOB_FROMDATE, '') AS REPORTJOB_FROMDATE"); 
        Oj_sb.append(", ISNULL(REPORTJOB_TODATE, '') AS REPORTJOB_TODATE"); 
        Oj_sb.append(", ISNULL(USER_ID, '') AS USER_ID");
        Oj_sb.append(", ISNULL(JOB_CODE, '') AS JOB_CODE");
        Oj_sb.append(", ISNULL(WORKTYPE_ID, '') AS WORKTYPE_ID");
        Oj_sb.append(", ISNULL(MODIFIED_BY, CREATED_BY) AS MODIFIED_BY"); 
        Oj_sb.append(", ISNULL(MODIFIED_DATE, CREATED_DATE) AS MODIFIED_DATE"); 
        Oj_sb.append(" FROM SYS_MT_REPORTJOB");
        Oj_sb.append(" ").append(fns_condition);

        return Oj_sb.toString();
    }

    private List<cls_sysMTReportjob> getData(cls_DBConnector fnOj_conn, String fns_condition) {
        List<cls_sysMTReportjob> Ojarr_model = new ArrayList<>();
        ResultSet Oj_rs;
        String ls_temp;

        try {
            ls_temp = " WHERE 1=1 " + fns_condition;
            ls_temp += " ORDER BY REPORTJOB_ID";

            Oj_rs = (ResultSet) fnOj_conn.getQuery(this.getCommand(ls_temp));

            Timestamp timestamp;

            while (Oj_rs.next()) {
                timestamp = Oj_rs.getTimestamp("MODIFIED_DATE");

                cls_sysMTReportjob model = new cls_sysMTReportjob();
                model.setReportjob_id(String.valueOf(Oj_rs.getInt("REPORTJOB_ID")));
                model.setReportjob_ref(Oj_rs.getString("REPORTJOB_REF"));
                model.setReportjob_type(Oj_rs.getString("REPORTJOB_TYPE"));
                model.setReportjob_status(Oj_rs.getString("REPORTJOB_STATUS"));
                model.setReportjob_fromdate(Oj_rs.getDate("REPORTJOB_FROMDATE"));
                model.setReportjob_todate(Oj_rs.getDate("REPORTJOB_TODATE"));
                model.setUser_id(Oj_rs.getString("USER_ID"));
                model.setJob_code(Oj_rs.getString("JOB_CODE"));
                model.setCreated_by(Oj_rs.getString("MODIFIED_BY"));
                model.setCreated_date(timestamp);
                model.setWorktype_id(Oj_rs.getString("WORKTYPE_ID"));

                Ojarr_model.add(model);
            }
            Oj_rs.close();

        } catch (Exception ex) {
            Message = "ERROR(" + ct_sysMTReportjob.class.getName() + ".getData)::" + ex.getMessage();
        }
        return Ojarr_model;
    }

    public List<cls_sysMTReportjob> getData(cls_DBConnector fnOj_conn) {
        return getData(fnOj_conn, "");
    }

    public cls_sysMTReportjob getDataByRef(cls_DBConnector fnOj_conn, String fns_ref) {
        String ls_filter = " AND REPORTJOB_REF='" + fns_ref + "'";
        List<cls_sysMTReportjob> Ojarr_model = this.getData(fnOj_conn, ls_filter);
        if (Ojarr_model.size() > 0)
            return Ojarr_model.get(0);
        else
            return null;
    }

    public List<cls_sysTRReportjobwhose> getDataWhose(cls_DBConnector fnOj_conn, String fns_id) {
        List<cls_sysTRReportjobwhose> Ojarr_model = new ArrayList<>();
        ResultSet Oj_rs;
        String ls_temp;

        try {
            ls_temp = "SELECT REPORTJOB_ID, WORKER_CODE FROM SYS_TR_REPORTJOBWHOSE";
            ls_temp += " WHERE REPORTJOB_ID ='" + fns_id + "' ";
            ls_temp += " ORDER BY WORKER_CODE";

            Oj_rs = (ResultSet) fnOj_conn.getQuery(ls_temp);

            while (Oj_rs.next()) {
                Ojarr_model.add(new cls_sysTRReportjobwhose(
                    Oj_rs.getInt("REPORTJOB_ID"),
                    Oj_rs.getString("WORKER_CODE")
                ));
            }
            Oj_rs.close();

        } catch (Exception ex) {
            Message = "ERROR(" + ct_sysMTReportjob.class.getName() + ".getDataWhose)::" + ex.getMessage();
        }
        return Ojarr_model;
    }
}
