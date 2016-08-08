package com.dekan.mall.service.admin.intf;

import java.util.List;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.PurviewInfoDto;
import com.dekan.mall.bean.entity.PurviewInfo;

/**
 * @ClassName PurviewService
 * @Description TODO【菜单功能Service接口】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public interface PurviewService extends BaseService<PurviewInfo, String> {
	
	/**
	* @Title save
	* @Description TODO【保存记录】
	* @param id
	* @param entity
	* @param properties 
	* @Return void 返回类型
	* @Throws 
	*/ 
	public void save(String id,PurviewInfo entity, String[] properties);
	
	/**
	 * @Title findMenuRoot
	 * @Description TODO【获取主菜单】
	 * @param userId
	 * @return
	 */
	public List<PurviewInfo> findMenuRoot(int userId);
	
	/**
	 * 获取子菜单
	 * 
	 * @param id 父id
	 * @param userId
	 * @return
	 */
	public List<PurviewInfo> findMenuChild(int id, int userId);
	
	/**
	 * @Title findFunction
	 * @Description TODO【获取用户功能权限】
	 * @param userId
	 * @return
	 */
	public List<PurviewInfo> findFunction(int userId);
	
	/**
	* @Title findByParent
	* @Description TODO【获取子菜单】
	* @param entity
	* @return 
	* @Return List<PurviewInfo> 返回类型
	* @Throws 
	*/ 
	public List<PurviewInfo> findMenuListByParent(PurviewInfo parent);

	/**
	 * 分页
	 * 
	 * @param purviewInfoDto
	 * @param pager
	 * @return
	 */
	public Pager findPagerBy(PurviewInfoDto purviewInfoDto, Pager pager);

}
