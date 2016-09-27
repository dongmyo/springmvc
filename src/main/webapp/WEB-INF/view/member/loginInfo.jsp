<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="member" scope="session" class="com.nhnent.springmvc.model.Member" />

<div style="background-color:#00008b;color:#ffffff;height:20px;padding: 5px;">
    <% if (member != null) { %>
        <span style="float:right;">
            <%= member.getId() %>
            <a style="color:white;" href="/logout">로그아웃</a>
        </span>
    <% } %>
</div>
