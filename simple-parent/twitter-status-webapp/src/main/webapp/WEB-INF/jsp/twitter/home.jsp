<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:set var="title" value="\"searched for:\""/>
    <title><spring:message code="twitter.search.title" arguments="${title}, ${model.searchTerm}"
                           argumentSeparator=","/></title>
</head>
<body>

<form:form modelAttribute="model" method="post" cssClass="">
    <fieldset>
        <form:label path="searchTerm">Search For: </form:label><form:input path="searchTerm" cssErrorClass="error"/>
        <form:errors path="searchTerm" cssClass="error" element="span"/>
    </fieldset>
    <input type="submit" value="Search"/>
</form:form>

<c:choose>
    <c:when test="${empty model.results && not empty model.searchTerm}">
        No Results
    </c:when>
    <c:otherwise>
        <c:forEach items="${model.results}" var="result" varStatus="status">
            <c:if test="${status.first}"><div id="twitter-result"></c:if>
            <c:if test="${status.last}"></div></c:if>
            <div class="result">
                <img src="${result.profile_image_url}" alt="Profile URL" class="span-2 first"/>
                <span class="span-18 last">Tweetted message: ${result.text}</span>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>