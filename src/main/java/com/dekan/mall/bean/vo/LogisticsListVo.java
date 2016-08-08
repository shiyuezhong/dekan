package com.dekan.mall.bean.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName LogisticsListVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public class LogisticsListVo implements Serializable {
	private static final long serialVersionUID = -4897809996216970526L;
	@XStreamAlias("lid")
	private String deliverySn;
	@XStreamAlias("lname")
	private String deliveryCorpName;
	@XStreamAlias("logs")
	private List<LogisticsVo> logisticsVos = new ArrayList<LogisticsVo>();
	
	/**
	 * @return the deliverySn
	 */
	public String getDeliverySn() {
		return deliverySn;
	}
	/**
	 * @param deliverySn the deliverySn to set
	 */
	public void setDeliverySn(String deliverySn) {
		this.deliverySn = deliverySn;
	}
	/**
	 * @return the deliveryCorpName
	 */
	public String getDeliveryCorpName() {
		return deliveryCorpName;
	}
	/**
	 * @param deliveryCorpName the deliveryCorpName to set
	 */
	public void setDeliveryCorpName(String deliveryCorpName) {
		this.deliveryCorpName = deliveryCorpName;
	}
	/**
	 * @return the logisticsVos
	 */
	public List<LogisticsVo> getLogisticsVos() {
		return logisticsVos;
	}
	/**
	 * @param logisticsVos the logisticsVos to set
	 */
	public void setLogisticsVos(List<LogisticsVo> logisticsVos) {
		this.logisticsVos = logisticsVos;
	}
	
	

}
