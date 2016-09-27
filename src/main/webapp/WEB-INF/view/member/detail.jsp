<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>회원 상세</title>
</head>
<body>
<jsp:include page="loginInfo.jsp" />
<h1>회원 상세</h1>

    ${detail.id},
    ${detail.password}
    <br />

</body>
</html>
