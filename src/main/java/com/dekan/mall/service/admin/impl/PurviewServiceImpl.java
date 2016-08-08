package com.dekan.mall.service.admin.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.dekan.mall.bean.common.Pager;
import com.dekan.mall.bean.dto.PurviewInfoDto;
import com.dekan.mall.bean.entity.PurviewInfo;
import com.dekan.mall.service.admin.intf.PurviewService;
import com.dekan.mall.ws.intf.PurviewWs;

/**
 * @ClassName PurviewServiceImpl
 * @Description TODO【菜单功能Service接口实现】
 * @Author Shiyz
 * @Date 2016-08-05 上午10:19:30
 */
@Service("purviewServiceImpl")
public class PurviewServiceImpl extends BaseServiceImpl<PurviewInfo, String> implements
		PurviewService {
	
	@Resource(name = "purviewWsImpl")
	private PurviewWs purviewWs;
	
	@Resource(name = "purviewWsImpl")
	public void setBaseWs(PurviewWs purviewWs) {
		super.setBaseWs(purviewWs);
	}
 
	@Override
	public Pager findPagerBy(PurviewInfoDto purviewInfoDto, Pager pager) {
		return purviewWs.findPagerBy(purviewInfoDto, pager);
	}
	
	@Override
	public void save(String id, PurviewInfo entity, String[] ignoreProperties) {
		if(StringUtils.isNotBlank(id)){
			PurviewInfo purview = purviewWs.find(id);
			if(purview != null){
				BeanUtils.copyProperties(entity, purview, ignoreProperties);
				purviewWs.update(purview);
			}else{
				purviewWs.insert(entity);
			}
		}
	}
	
	@Override
	public List<PurviewInfo> findMenuChild(int id, int userId) {
		return purviewWs.findMenuChild(id,userId);
	}
	
	@Override
	public List<PurviewInfo> findMenuRoot(int userId) {
		return purviewWs.findMenuRoot(userId);
	}
	
	@Override
	public List<PurviewInfo> findMenuListByParent(PurviewInfo parent) {
		return purviewWs.findMenuListByParent(parent);
	}

	@Override
	public List<PurviewInfo> findFunction(int userId) {
		return purviewWs.findFunction(userId);
	}

}
