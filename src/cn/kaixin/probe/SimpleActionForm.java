package cn.kaixin.probe;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * A simple ActionForm
 *
 * @version $Rev: 471754 $ $Date: 2006-11-06 08:55:09 -0600 (Mon, 06 Nov 2006) $
 */
public class SimpleActionForm extends ActionForm {

    /** Name */
    private int serverId;

    /** online count */
    private int onlineCount;

    /** used memeony */
    private int memory;

    /** 硬盘使用量 */
    private int diskUse;

    /**
     * Constructor for MultiboxActionForm.
     */
    public SimpleActionForm() {
        super();
    }

    // ---------------------------------------------------------- Public Methods

    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.serverId = 0;
        this.onlineCount = 0;
    }

    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionMessages</code> object that encapsulates any
     * validation errors that have been found.  If no errors are found, return
     * <code>null</code> or an <code>ActionMessages</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     *
     * @return ActionMessages if any validation errors occurred
     */
    @Override
    public ActionErrors validate(
            ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        // Name must be entered
        if ((serverId <= 0) || (onlineCount < 0)) {
            errors.add("serverId", new ActionMessage("errors.serverid.required"));
        }
        return (errors);
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDiskUse() {
        return diskUse;
    }

    public void setDiskUse(int diskUse) {
        this.diskUse = diskUse;
    }
}
