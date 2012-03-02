<%@include file="/WEB-INF/jsp/common/jsp-includes.jspf" %>
<html>
<head>
    <title><spring:message code="home.browser.title" arguments=""/></title>
    <%@include file="/WEB-INF/jsp/common/common-head-elements.jspf" %>
</head>
<body>
<h2><spring:message code="home.paragraph.header"/></h2>

<p>
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vitae felis libero. Praesent ultrices porttitor magna,
    sed fringilla metus pharetra vitae. Vestibulum gravida volutpat nunc eu pretium. Donec eget est erat, vitae luctus
    diam.
    Aliquam laoreet laoreet dui mollis interdum. Donec lobortis, sapien ac bibendum suscipit, turpis nibh laoreet felis,
    non tempus sem ipsum nec magna. Quisque vehicula, massa in mattis volutpat, elit leo congue metus, eget pellentesque
    nunc
    turpis
    vel nisl. Mauris eros nisl, convallis tempor tristique sed, tempor eget libero. Suspendisse ac nulla sed nisi mattis
    volutpat accumsan id elit.
</p>

<h2><spring:message code="home.twitter.section.header"/></h2>

<h3><spring:message code="home.twitter.section.subheader"/></h3>

<p>
    <a href="${pageContext.request.contextPath}/twitter/home"><spring:message code="home.twitter.search.link"/></a>
</p>

</body>
</html>