package com.dekan.mall.ws.intf;

import java.util.List;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.CategoryInfoDto;
import com.dekan.mall.bean.entity.CategoryInfo;

/**
 * @ClassName CategoryInfoWs
 * @Description TODO【分类信息Ws接口】
 * @Author Shiyz
 * @Date 2016-08-07 下午5:02:58
 */
public interface CategoryInfoWs extends BaseWs<CategoryInfo, String> {
	 
	/**
	 * 分页查询
	 * 
	 * @param roleInfoDto
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
	public Pager findNoPagerBy(CategoryInfoDto categoryInfoDto, Pager pager);
	
	/**
	 * 根据父id查找子节点
	 * 
	 * @param parent
	 * @return
	 */
	public List<CategoryInfo> findListByParent(CategoryInfo parent);

	/**
	 * 根据code查找
	 * 
	 * @param code
	 * @return
	 */
	public CategoryInfo findByCode(String code);

	

}
