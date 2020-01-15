package cn.kaixin.model;

import org.apache.struts.action.ActionForm;

/**
 * A form bean used to configure a gift code .
 *
 * @author: Yao Shuai
 * @date: 2020/1/15 12:39
 */
public class EditWeeklyCodeForm extends ActionForm {

    private String iosOrAndroid;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIosOrAndroid() {
        return iosOrAndroid;
    }

    public void setIosOrAndroid(String iosOrAndroid) {
        this.iosOrAndroid = iosOrAndroid;
    }
}
