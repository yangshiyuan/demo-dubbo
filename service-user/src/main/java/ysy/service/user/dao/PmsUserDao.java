package ysy.service.user.dao;

import ysy.common.dao.core.BaseDao;
import ysy.facade.user.entity.PmsUser;


/**
 * @描述: 用户表数据访问层接口.
 */
public interface PmsUserDao extends BaseDao<PmsUser> {

    /**
     * 根据用户登录名获取用户信息.
     *
     * @param loginName .
     * @return user .
     */
    PmsUser findByUserNo(String userNo);

}
