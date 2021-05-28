<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Login page
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <h3>Du er logget ind som rolle: ${sessionScope.role}</h3>
        <h3>Sælger ID: ${sessionScope.id}</h3>

        <table class="table mt-5">
            <thead>
            <tr>
                <th scope="col">Ordre ID</th>
                <th scope="col">Længde</th>
                <th scope="col">Bredde</th>
                <th scope="col">Tag Type</th>
                <th scope="col">Kunde ID</th>
                <th>Se Stykliste</th>
                <th>Se tegning</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="orders" items="${requestScope.orders}">
                <tr>
                    <td>${orders.order_id}</td>
                    <td>${orders.length}</td>
                    <td>${orders.width}</td>
                    <td>${orders.roof_type}</td>
                    <td>${orders.customer_id}</td>
                    <td><a href="${pageContext.request.contextPath}/fc/seeonepieceslistpage" class="btn btn-primary">Se stykliste</a></td>
                    <td><a href="${pageContext.request.contextPath}/fc/showsvg" type="button" class="btn btn-primary">Se tegning</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="employeepage" type="button" class="btn btn-danger btn-lg ms-5">Go back</a>
        </div>


    </jsp:body>
</t:genericpage>

