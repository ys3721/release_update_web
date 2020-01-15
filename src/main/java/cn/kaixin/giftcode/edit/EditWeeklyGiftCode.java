package cn.kaixin.giftcode.edit;

import cn.kaixin.model.EditWeeklyCodeForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Used by operators to configure weekly gift codes.
 *
 * @author: Yao Shuai
 * @date: 2020/1/15 12:23
 */
public class EditWeeklyGiftCode extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        EditWeeklyCodeForm codeForm = (EditWeeklyCodeForm) form;
        String code = codeForm.getCode();
        String iosOrAndroid = codeForm.getIosOrAndroid();
        /*if (iosOrAndroid.equals("ios")) {
            FileChannel fc = new FileOutputStream("/data0/wx_www/game-server-robot/ios_week_code.txt", false).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.wrap(code.getBytes());
            fc.write(byteBuffer);
            fc.close();
        } else {
            FileChannel fc = new FileOutputStream("/data0/wx_www/game-server-robot/ios_week_code.txt", false).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.wrap(code.getBytes());
            fc.write(byteBuffer);
            fc.close();
        }*/
        if (iosOrAndroid.equals("ios")) {
            Runtime.getRuntime().exec("ssh root@10.10.6.107 echo " + code +" > /data0/wx_www/game-server-robot/ios_week_code.txt");
        } else {
            Runtime.getRuntime().exec("ssh root@10.10.6.107 echo " + code +" > /data0/wx_www/game-server-robot/android_week_code.txt");
        }
        Runtime.getRuntime().exec("ssh root@10.10.6.107 cd /data0/wx_www/game-server-robot && sh run.sh");
        return mapping.findForward("success");
    }

}
