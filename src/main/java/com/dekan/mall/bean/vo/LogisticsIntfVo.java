package com.dekan.mall.bean.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @ClassName LogisticsIntfVo
 * @Description TODO【这里用一句话描述这个类的作用】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
@XStreamAlias("intf")
public class LogisticsIntfVo extends CommonIntfVo{
	private static final long serialVersionUID = 811817677520414248L;
	@XStreamAlias("d")
	private LogisticsListVo logisticsListVo;
	/**
	 * @return the logisticsListVo
	 */
	public LogisticsListVo getLogisticsListVo() {
		return logisticsListVo;
	}
	/**
	 * @param logisticsListVo the logisticsListVo to set
	 */
	public void setLogisticsListVo(LogisticsListVo logisticsListVo) {
		this.logisticsListVo = logisticsListVo;
	}
}
