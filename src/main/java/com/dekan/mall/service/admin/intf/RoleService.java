package com.dekan.mall.service.admin.intf;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.RoleInfoDto;
import com.dekan.mall.bean.entity.RoleInfo;

/**
 * @ClassName RoleService
 * @Description TODO【角色】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public interface RoleService extends BaseService<RoleInfo, String> {
	/**
	 * 分页
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
