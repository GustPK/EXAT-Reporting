package BPC.opr.service;

import BPC.opr.controller.ct_sysMTBank;
import BPC.opr.controller.ct_sysMTBenefit;
import BPC.opr.controller.ct_sysMTReportjob;
import BPC.opr.controller.ct_sysMTWorklog;
import BPC.opr.model.cls_sysMTBank;
import BPC.opr.model.cls_sysMTBenefit;
import BPC.opr.model.cls_sysMTReportjob;
import BPC.opr.model.cls_sysMTWorklog;
import BPC.opr.utility.cls_DBConnector;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class cls_srvGenReport implements srvGenReport {

    String _message = "";

    @Override
    public String getMessage() {
        return this._message;
    }

    @Override
    public List<Map<String, Object>> getReportSYS(cls_sysMTReportjob Job) {
        cls_DBConnector Oj_conn = new cls_DBConnector();
        List<Map<String, Object>> Ojarr_output = new ArrayList<>();

        SimpleDateFormat sdf_date = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

        try {
            Oj_conn.openSQLServer();

            switch (Job.getReportjob_type()) {

                case "SYS001":
                    ct_sysMTBank ct_bank = new ct_sysMTBank();
                    List<cls_sysMTBank> arr_bank = ct_bank.getData(Oj_conn);

                    for (cls_sysMTBank model : arr_bank) {
                        Map m = new HashMap();
                        m.put("bank_code", model.getBank_code());
                        m.put("bank_name_th", model.getBank_name_th());
                        m.put("bank_name_en", model.getBank_name_en());
                        m.put("modified_by", model.getMoified_by());
                        m.put("modified_date", sdf_date.format(model.getMoified_date()));
                        Ojarr_output.add(m);
                    }
                    break;

                case "SYS002":
                    ct_sysMTBenefit ct_benefit = new ct_sysMTBenefit();
                    List<cls_sysMTBenefit> arr_benefit = ct_benefit.getData(Oj_conn);

                    for (cls_sysMTBenefit model : arr_benefit) {
                        Map m = new HashMap();
                        m.put("benefit_id", model.getBenefit_id());
                        m.put("benefit_text", model.getBenefit_text());
                        m.put("benefit_from", sdf_date.format(model.getBenefit_from()));
                        m.put("benefit_to", sdf_date.format(model.getBenefit_to()));
                        m.put("edit_by", model.getEdit_by());
                        m.put("edit_date", sdf_date.format(model.getEdit_date()));
                        Ojarr_output.add(m);
                    }
                    break;

                case "SYS003":
                    ct_sysMTWorklog ct_worklog = new ct_sysMTWorklog();
                    StringBuilder condition = new StringBuilder();

                    if (Job.getUser_id() != null && !Job.getUser_id().isEmpty()) {
                        condition.append(" AND W.USER_ID = '").append(Job.getUser_id()).append("'");
                    }
                    if (Job.getJob_code() != null && !Job.getJob_code().isEmpty()) {
                        condition.append(" AND W.JOB_CODE LIKE '%").append(Job.getJob_code()).append("%'");
                    }
                    if (Job.getReportjob_fromdate() != null) {
                        java.sql.Date sqlFrom = new java.sql.Date(Job.getReportjob_fromdate().getTime());
                        condition.append(" AND W.WORK_DATE >= '").append(sqlFrom).append("'");
                    }
                    if (Job.getReportjob_todate() != null) {
                        java.sql.Date sqlTo = new java.sql.Date(Job.getReportjob_todate().getTime());
                        condition.append(" AND W.WORK_DATE <= '").append(sqlTo).append("'");
                    }

                    List<cls_sysMTWorklog> arr_worklog = ct_worklog.getData(Oj_conn, condition.toString());

                    SimpleDateFormat sdf_ddmmyyyy = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

                    for (cls_sysMTWorklog model : arr_worklog) {
                        Map m = new HashMap();
                        m.put("work_date", sdf_ddmmyyyy.format(model.getWork_date()));
                        m.put("time_start", model.getTime_start());
                        m.put("time_end", model.getTime_end());
                        m.put("job_code", model.getJob_code());
                        m.put("task_detail", model.getTask_detail());
                        m.put("location_name", model.getLocation_name());
                        m.put("user_name", model.getUser_name());
                        m.put("user_id", model.getUser_id());
                        m.put("position", model.getPosition());
                        m.put("phonenumber", model.getPhonenumber());
                        m.put("email", model.getEmail());
                        m.put("department_name", model.getDepartment_name());
                        Ojarr_output.add(m);
                    }
                    break;

            }
        } catch (Exception ex) {
            this._message = "ERROR(" + cls_srvGenReport.class.getName() + ".getReportSYS)::" + ex.getMessage();
        } finally {
            Oj_conn.close();
        }

        return Ojarr_output;
    }

    @Override
    public cls_sysMTReportjob getReportDetail(String Ref) {
        cls_sysMTReportjob result = null;
        cls_DBConnector Oj_conn = new cls_DBConnector();

        try {
            Oj_conn.openSQLServer();
            ct_sysMTReportjob ct_reportjob = new ct_sysMTReportjob();
            result = ct_reportjob.getDataByRef(Oj_conn, Ref);
        } catch (Exception ex) {
            this._message = "ERROR(" + cls_srvGenReport.class.getName() + ".getReportDetail)::" + ex.getMessage();
        } finally {
            Oj_conn.close();
        }

        return result;
    }
}
