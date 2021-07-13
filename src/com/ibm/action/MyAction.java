package com.ibm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import org.apache.struts.action.Action;
import org.apache.struts.action.DynaActionForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class MyAction extends Action
{
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception
{

	DynaActionForm loginForm = (DynaActionForm) form;
        String un = loginForm.get("userName").toString();
        String pw = loginForm.get("password").toString();
					System.out.println("u="+un);
					System.out.println("pw="+pw);
              if(un.equals("") || pw.equals(""))
                       {
            	 return mapping.findForward("failure");
          
				}
				else
				{
					 HttpSession session=request.getSession(true);
                            session.setAttribute("un",un);

					return mapping.findForward("success");
				}
	}
}




