package ysy.web.boss.base;

import ysy.common.web.constants.SessionConstant;
import ysy.common.web.struts.Struts2ActionSupport;
import ysy.facade.user.entity.PmsUser;


/**
 * @描述: Web系统权限模块基础支撑Action.
 */
@SuppressWarnings("serial")
public class BaseAction extends Struts2ActionSupport implements UserLoginedAware {

    /**
     * 取出当前登录用户对象
     */
    @Override
    public PmsUser getLoginedUser() {
        PmsUser user = (PmsUser) this.getSessionMap().get(SessionConstant.USER_SESSION_KEY);
        return user;
    }

}
