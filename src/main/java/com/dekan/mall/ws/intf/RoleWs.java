package com.dekan.mall.ws.intf;

import java.util.List;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.RoleInfoDto;
import com.dekan.mall.bean.entity.RoleInfo;

/**
 * @ClassName RoleWs
 * @Description TODO【角色】
 * @Author Shiyz
 * @Date 2016-08-04 下午5:02:58
 */
public interface RoleWs extends BaseWs<RoleInfo, String> {
	/**
	 * 查询系统内置角色列表
	 * 
	 * @return
	 */
	public List<RoleInfo> findSystemList();

	/**
	 * 分页查询
	 * 
	 * @param roleInfoDto
	 * @param pager
	 * @return
	 */
	public Pager findPagerBy(RoleInfoDto roleInfoDto, Pager pager);

	/**
	 * 根据name查询
	 * 
	 * @param name
	 * @return
	 */
	public RoleInfo findByName(String name);

}
