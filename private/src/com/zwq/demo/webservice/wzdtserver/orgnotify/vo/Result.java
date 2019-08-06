package com.zwq.demo.webservice.wzdtserver.orgnotify.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织机构
 * 
 * @author wqf
 *
 */

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7467763313426374308L;

	// 组织编码
	private String orgCode;

	// 组织名称
	private String orgName;

	// 组织层级
	private String orgLevel;

	// 业务板块
	private String busiSector;

	// 组织简称
	private String orgShortName;

	// 组织职能
	private String orgFunction;

	// 登记注册类型
	private String registerType;

	// 法人代表
	private String legalRepre;

	// 成立日期
	private Date establishDate;

	// 营业有效期
	private Date busiValidDate;

	// 组织机构类型
	private String orgType;

	// 记录状态
	private String status;

	// 上级机构编码
	private String parentOrgCode;

	// 上级机构名称
	private String parentOrgName;

	// 负责人工号
	private String chargeEmpCode;

	// 负责人姓名
	private String chargeEmpName;

	// 旧机构编码
	private String oldOrgCode;

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}

	public String getBusiSector() {
		return busiSector;
	}

	public void setBusiSector(String busiSector) {
		this.busiSector = busiSector;
	}

	public String getOrgShortName() {
		return orgShortName;
	}

	public void setOrgShortName(String orgShortName) {
		this.orgShortName = orgShortName;
	}

	public String getOrgFunction() {
		return orgFunction;
	}

	public void setOrgFunction(String orgFunction) {
		this.orgFunction = orgFunction;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public String getLegalRepre() {
		return legalRepre;
	}

	public void setLegalRepre(String legalRepre) {
		this.legalRepre = legalRepre;
	}

	public Date getEstablishDate() {
		return establishDate;
	}

	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	public Date getBusiValidDate() {
		return busiValidDate;
	}

	public void setBusiValidDate(Date busiValidDate) {
		this.busiValidDate = busiValidDate;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getParentOrgCode() {
		return parentOrgCode;
	}

	public void setParentOrgCode(String parentOrgCode) {
		this.parentOrgCode = parentOrgCode;
	}

	public String getParentOrgName() {
		return parentOrgName;
	}

	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}

	public String getChargeEmpCode() {
		return chargeEmpCode;
	}

	public void setChargeEmpCode(String chargeEmpCode) {
		this.chargeEmpCode = chargeEmpCode;
	}

	public String getChargeEmpName() {
		return chargeEmpName;
	}

	public void setChargeEmpName(String chargeEmpName) {
		this.chargeEmpName = chargeEmpName;
	}

	public String getOldOrgCode() {
		return oldOrgCode;
	}

	public void setOldOrgCode(String oldOrgCode) {
		this.oldOrgCode = oldOrgCode;
	}

	

}
