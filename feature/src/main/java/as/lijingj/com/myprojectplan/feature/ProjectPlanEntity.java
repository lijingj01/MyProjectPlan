package as.lijingj.com.myprojectplan.feature;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

///工作计划实体类
public class ProjectPlanEntity {
    //region 内部属性
    private int PlanId;
    private String PlanTitle;
    private String PlanContent;
    private Date BeginDate;
    private Date EndDate;
    private int EndIndex;

    public int getPlanId() {
        return PlanId;
    }

    public void setPlanId(int planId) {
        PlanId = planId;
    }

    public String getPlanTitle() {
        return PlanTitle;
    }

    public void setPlanTitle(String planTitle) {
        PlanTitle = planTitle;
    }

    public String getPlanContent() {
        return PlanContent;
    }

    public void setPlanContent(String planContent) {
        PlanContent = planContent;
    }

    public Date getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(Date beginDate) {
        BeginDate = beginDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public int getEndIndex() {
        return EndIndex;
    }

    public void setEndIndex(int endIndex) {
        EndIndex = endIndex;
    }
    //endregion

    /** 显示日期组合
     *
     * @return 开始结束日期的组合展示
     */
    public String GetPublishDate() {
        Format f = new SimpleDateFormat("yyyy年MM月dd日");
        StringBuilder strText = new StringBuilder();

        strText.append("计划开始：" + f.format(BeginDate) + "  计划完成：" + f.format(EndDate));

        return strText.toString();
    }

    public String GetBeginDateString(){
        Format f = new SimpleDateFormat("yyyy年MM月dd日");
        return f.format(BeginDate).toString();
    }

    public String GetEndDateString(){
        Format f = new SimpleDateFormat("yyyy年MM月dd日");
        return f.format(EndDate).toString();
    }
}
