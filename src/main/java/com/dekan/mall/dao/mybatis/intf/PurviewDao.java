package com.dekan.mall.dao.mybatis.intf;

import java.util.HashMap;
import java.util.List;

import com.dekan.mall.bean.entity.PurviewInfo;

/**
 * @ClassName PurviewDao
 * @Description TODO【菜单资源权限表】
 * @Author Shiyz
 * @Date 2016-08-04 上午10:04:07
 */
public interface PurviewDao extends BaseDao<PurviewInfo, String> {
	
	/**
	* @Title findRoot
	* @Description TODO【获取主一级菜单】
	* @return 
	* @Return List<PurviewInfo> 返回类型
	* @Throws 
	*/ 
	public List<PurviewInfo> findMenuRoot(int userId);
	
	/**
	 * 获取子菜单
	 * @param values
	 */
	@SuppressWarnings("rawtypes")
	public  List<PurviewInfo> findMenuChild(HashMap values);
	
	/**
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
	* @Title findByParent
	* @Description TODO【获取子功能】
	* @param entity
	* @return 
	* @Return List<PurviewInfo> 返回类型
	* @Throws 
	*/ 
	public List<PurviewInfo> findFunctionListByParent(PurviewInfo parent);
	
	/**
	* @Title savePurviewRoleRef
	* @Description TODO【保存权限角色关系】
	* @param values 
	* @Return void 返回类型
	* @Throws 
	*/ 
	@SuppressWarnings("rawtypes")
	public void savePurviewRoleRef(HashMap values);

}
