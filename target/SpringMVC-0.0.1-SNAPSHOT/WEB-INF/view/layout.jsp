<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">    
<html>    
<head>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
</head>    
<body>    
        <div><tiles:insertAttribute name="header"/></div>    
        <tiles:insertAttribute name="home" ignore ="true"/>   
        <tiles:insertAttribute name="register" ignore ="true"/>
        <tiles:insertAttribute name="login" ignore ="true"/>     
        <tiles:insertAttribute name="footer"/>   
    
</body>    
</html>  