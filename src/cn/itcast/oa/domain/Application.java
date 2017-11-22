package cn.itcast.oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * @Title: Application
 * @Description: 申请实体
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: itcast_OA
 * @author fupengpeng
 * @date 2017年11月21日 上午9:55:26
 */
public class Application {
	
	public static final String STATUS_RUNNING = "审批中";
	public static final String STATUS_APPROVED = "已通过";
	public static final String STATUS_UNAPPROVED = "未通过";
	
	private Long id;
	private String title;    //申请标题
	private User applicant;    //申请用户
	private Date applyTime;    //申请时间
	private String status;    //申请状态： 审批中   未通过    已通过
	private String filePath;    //申请文档保存路径
	private Template template;    //申请模板
	private Set<ApproveInfo> approveInfos = new HashSet<ApproveInfo>();  //审批集合
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public Set<ApproveInfo> getApproveInfos() {
		return approveInfos;
	}
	public void setApproveInfos(Set<ApproveInfo> approveInfos) {
		this.approveInfos = approveInfos;
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", title=" + title + ", applicant="
				+ applicant + ", applyTime=" + applyTime + ", status=" + status
				+ ", filePath=" + filePath + ", template=" + template
				+ ", approveInfos=" + approveInfos + "]";
	}
	
	
	
}
