package ysy.service.user.dao.impl;

import org.springframework.stereotype.Repository;

import ysy.common.dao.core.impl.BaseDaoImpl;
import ysy.facade.user.entity.PmsUser;
import ysy.service.user.dao.PmsUserDao;


/**
 * @描述: 用户表数据访问层接口实现类.
 */
@Repository("pmsUserDao")
public class PmsUserDaoImpl extends BaseDaoImpl<PmsUser> implements PmsUserDao {

    /**
     * 根据用户登录名获取用户信息.
     *
     * @param loginName .
     * @return user .
     */

    public PmsUser findByUserNo(String userNo) {
        return super.getSqlSession().selectOne(getStatement("findByUserNo"), userNo);
    }

}
