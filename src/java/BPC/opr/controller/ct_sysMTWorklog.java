package BPC.opr.controller;

import BPC.opr.model.cls_sysMTWorklog;
import BPC.opr.utility.cls_DBConnector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author witco
 */
public class ct_sysMTWorklog {

    String Message;

    public String getMessage() {
        return Message;
    }

    private String getCommand(String fns_condition) {
        StringBuilder Oj_sb = new StringBuilder();

        Oj_sb.append(" SELECT W.WORK_DATE");
        Oj_sb.append(", W.TIME_START");
        Oj_sb.append(", W.TIME_END");
        Oj_sb.append(", W.JOB_CODE");
        Oj_sb.append(", W.TASK_DETAIL");
        Oj_sb.append(", L.LOCATION_NAME");
        Oj_sb.append(", W.USER_ID");
        Oj_sb.append(", U.USER_NAME");
        Oj_sb.append(", U.POSITION");
        Oj_sb.append(", U.PHONENUMBER");
        Oj_sb.append(", U.EMAIL");
        Oj_sb.append(", D.DEPARTMENT_NAME");
        Oj_sb.append(", W.WORKTYPE_ID");

        Oj_sb.append(" FROM WORKLOG W");
        Oj_sb.append(" LEFT JOIN LOCATION L ON W.LOCATION_ID = L.LOCATION_ID");
        Oj_sb.append(" LEFT JOIN [USER] U ON W.USER_ID = U.USER_ID");
        Oj_sb.append(" LEFT JOIN [DEPARTMENT] D ON U.DEPARTMENT_ID = D.DEPARTMENT_ID");
        Oj_sb.append(" ").append(fns_condition);

        return Oj_sb.toString();
    }

    public List<cls_sysMTWorklog> getData(cls_DBConnector fnOj_conn, String fns_condition) {
        List<cls_sysMTWorklog> Ojarr_model = new ArrayList<>();
        ResultSet Oj_rs;
        String ls_temp;

        try {
            ls_temp = " WHERE 1=1 " + fns_condition;
            ls_temp += " ORDER BY W.WORK_DATE, W.TIME_START ";

            Oj_rs = fnOj_conn.getQuery(this.getCommand(ls_temp));

            while (Oj_rs.next()) {
                cls_sysMTWorklog model = new cls_sysMTWorklog(
                        Oj_rs.getDate("WORK_DATE"),
                        Oj_rs.getTime("TIME_START"),
                        Oj_rs.getTime("TIME_END"),
                        Oj_rs.getString("JOB_CODE"),
                        Oj_rs.getString("TASK_DETAIL"),
                        Oj_rs.getString("LOCATION_NAME"),
                        Oj_rs.getString("USER_ID"),
                        Oj_rs.getString("USER_NAME"),
                        Oj_rs.getString("POSITION"),
                        Oj_rs.getString("PHONENUMBER"),
                        Oj_rs.getString("EMAIL"),
                        Oj_rs.getString("DEPARTMENT_NAME"),
                        Oj_rs.getString("WORKTYPE_ID")
                );
                Ojarr_model.add(model);
            }
            Oj_rs.close();

        } catch (Exception ex) {
            Message = "ERROR(" + ct_sysMTWorklog.class.getName() + ".getData)::" + ex.getMessage();
        }

        return Ojarr_model;
    }

    public List<cls_sysMTWorklog> getData(cls_DBConnector fnOj_conn) {
        return getData(fnOj_conn, "");
    }
}
