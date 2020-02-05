<%--
  Created by IntelliJ IDEA.
  User: Yao Shuai
  Date: 2020/1/15
  Time: 15:33
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html:html xhtml="true" lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Simple form using ActionForm</title>
        <html:base/>
        <link rel="stylesheet" type="text/css" href="../css/main.css" />
    </head>
    <body>
    <h1>改一个激活码</h1>
    <hr noshade="noshade"/>

    <p>Enter information into the fields below. Your entries will be displayed when you Submit the form.<br />
        This is just to demonstrate the Struts html tags. The information that you enter is discarded.</p>
    <p>* = required field</p>
    <hr noshade="noshade" />
    <html:errors/>
    <html:form action="/editWeeklyCode">
        <p>IOS:<br/><html:radio property="iosOrAndroid" value="ios"/></p>
        <p>Android:<br/><html:radio property="iosOrAndroid" value="android"/></p>
        <p>上面先选好，然后在这里面写:格式：1月20日-2月2日周礼包一个。礼包内容：元宝*50 银币*2W 初级经验书*2。礼包码：3800dz0bjxqe或3800ftmyh86q<br/><html:text
                property="code" size="200" maxlength="500"/></p>
        <p>
            <html:submit>
            </html:submit>
            <html:cancel/>
        </p>
    </html:form>
    </body>
</html:html>