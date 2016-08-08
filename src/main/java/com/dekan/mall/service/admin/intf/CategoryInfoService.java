package com.dekan.mall.service.admin.intf;

import java.util.List;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.CategoryInfoDto;
import com.dekan.mall.bean.entity.CategoryInfo;

/**
 * @ClassName CategoryInfoService
 * @Description TODO【分类信息Service接口】
 * @Author Shiyz
 * @Date 2016-08-07 上午10:04:07
 */
public interface CategoryInfoService extends BaseService<CategoryInfo, String> {
	
	/**
	* @Title findByParent
	* @Description TODO【获取子】
	* @param entity
	* @return 
	* @Return List<PurviewInfo> 返回类型
	* @Throws 
	*/ 
	public List<CategoryInfo> findListByParent(CategoryInfo parent);

	/**
	 * 分页
	 * 
	 * @param purviewInfoDto
	 * @param pager
	 * @return
	 */
	public Pager findPagerBy(CategoryInfoDto categoryInfoDto, Pager pager);
	
	/**
	 * 不分页
	 * @param search
	 * @param pager
	 * @return
	 */
	public Pager findNoPagerBy(CategoryInfoDto search, Pager pager);

	/**
	 * 根据code查找
	 * 
	 * @param substring
	 * @return
	 */
	public CategoryInfo findByCode(String substring);

}
