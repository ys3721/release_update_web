<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html xhtml="true" lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Simple form using ActionForm</title>
        <html:base/>
        <link rel="stylesheet" type="text/css" href="../../css/example.css" />
    </head>
    <body>
    <h1>查个订单</h1>
    <hr noshade="noshade"/>

    <p>Enter information into the fields below. Your entries will be displayed when you Submit the form.<br />
        This is just to demonstrate the Struts html tags. The information that you enter is discarded.</p>
    <p>* = required field</p>
    <hr noshade="noshade" />
    <html:errors/>
    <html:form action="/queryOrderById">
        <p>* What's your first roleId?:<br/><html:text property="roleId" size="40" maxlength="50"/></p>
        <p>
            <html:submit>
            </html:submit>
            <html:cancel/>
        </p>
    </html:form>
    </body>
</html:html>