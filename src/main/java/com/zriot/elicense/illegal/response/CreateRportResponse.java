package com.zriot.elicense.illegal.response;

import java.util.List;

import com.zriot.elicense.illegal.vo.CreateRportVo;

public class CreateRportResponse {
	private List<CreateRportVo> createRportVos;
	private Integer totalProductNumber;		//  总件数
	private Double totalKiloCount;		//总公斤数
	private Double totalTransportFee;		//总运费
	private Double totalCollectionFee;		//总代收货款
	private Double totalDeliverFee;		//总送货费
	public List<CreateRportVo> getCreateRportVos() {
		return createRportVos;
	}
	public void setCreateRportVos(List<CreateRportVo> createRportVos) {
		this.createRportVos = createRportVos;
	}
	public Integer getTotalProductNumber() {
		return totalProductNumber;
	}
	public void setTotalProductNumber(Integer totalProductNumber) {
		this.totalProductNumber = totalProductNumber;
	}
	public Double getTotalKiloCount() {
		return totalKiloCount;
	}
	public void setTotalKiloCount(Double totalKiloCount) {
		this.totalKiloCount = totalKiloCount;
	}
	public Double getTotalTransportFee() {
		return totalTransportFee;
	}
	public void setTotalTransportFee(Double totalTransportFee) {
		this.totalTransportFee = totalTransportFee;
	}
	public Double getTotalCollectionFee() {
		return totalCollectionFee;
	}
	public void setTotalCollectionFee(Double totalCollectionFee) {
		this.totalCollectionFee = totalCollectionFee;
	}
	public Double getTotalDeliverFee() {
		return totalDeliverFee;
	}
	public void setTotalDeliverFee(Double totalDeliverFee) {
		this.totalDeliverFee = totalDeliverFee;
	}
}
