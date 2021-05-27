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
                <th scope="col">ID</th>
                <th scope="col">Længde</th>
                <th scope="col">Price Per Unit</th>
                <th scope="col">Name</th>
                <th scope="col">Unit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="materials" items="${requestScope.materials}">
            <tr>
                <td>${materials.id}</td>
                <td>${materials.price_per_unit}</td>
                <td>${materials.length}</td>
                <td>${materials.name}</td>
                <td>${materials.unit}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="d-flex justify-content-center mt-5">
            <br>
            <a href="adminpage" type="button" class="btn btn-danger btn-lg ms-5">Go back</a>
        </div>


    </jsp:body>
</t:genericpage>

