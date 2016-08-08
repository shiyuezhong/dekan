package com.dekan.mall.ws.intf;

import java.util.HashMap;
import java.util.List;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.PurviewInfoDto;
import com.dekan.mall.bean.entity.PurviewInfo;

/**
 * @ClassName PurviewWs
 * @Description TODO【菜单功能Ws接口】
 * @Author Shiyz
 * @Date 2016-08-06 下午5:02:58
 */
public interface PurviewWs extends BaseWs<PurviewInfo, String> {
	
	/**
	 * 
	 * @Title findRoot
	 * @Description TODO【获取主一级菜单】
	 * @return 
	 * @Return List<PurviewInfo> 返回类型
	 * @Throws 
	*/ 
	public List<PurviewInfo> findMenuRoot(int userId);
	
	/**
	 * 
	 * @Title findMenuChild
	 * @Description TODO【获取子菜单】
	 * @return 
	 * @Return List<PurviewInfo> 返回类型
	 * @Throws 
	*/
	public List<PurviewInfo> findMenuChild(int id, int userId);
	
	/**
	 * 
	 * @Title findRoot
	 * @Description TODO【获取用户功能权限】
	 * @return 
	 * @Return List<PurviewInfo> 返回类型
	 * @Throws 
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
	* @Title savePurviewRoleRef
	* @Description TODO【保存权限角色关系】
	* @param values 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public void savePurviewRoleRef(HashMap values);

	/**
	 * 分页查询
	 * 
	 * @param roleInfoDto
	 * @param pager
	 * @return
	 */
	public Pager findPagerBy(PurviewInfoDto purviewInfoDto, Pager pager);

}
