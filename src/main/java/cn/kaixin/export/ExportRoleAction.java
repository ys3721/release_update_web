package cn.kaixin.export;

import cn.kaixin.export.dao.CharacterDao;
import cn.kaixin.export.dao.ExportDaoService;
import cn.kaixin.export.model.TCharacterEntity;
import cn.kaixin.probe.constants.ProbeConstants;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yao Shuai
 * 阶级斗争
 *
 */
public class ExportRoleAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        CharacterDao characterDao = ((ExportDaoService) request.getServletContext().getAttribute(ProbeConstants.SERVER_DAO_INIT_NAME)).getCharacterDao();
        TCharacterEntity _entity = characterDao.queryCharacterById(1688005435333807448L);
        return new ActionForward("success");
    }

}
