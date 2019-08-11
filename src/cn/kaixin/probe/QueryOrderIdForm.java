package cn.kaixin.probe;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author Yao Shuai
 * 这个框架真的很老了
 *
 */
public class QueryOrderIdForm extends ActionForm {

    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
