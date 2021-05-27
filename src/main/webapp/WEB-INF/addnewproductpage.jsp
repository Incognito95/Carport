<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<t:genericpage>
    <jsp:attribute name="header">
         Add New Product
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>

        <form action="${pageContext.request.contextPath}/fc/addnewproductpage" method="post">

        <div class="container mt-2">
            <label class="mt-2">Længde</label>
            <input type="text" name="length" class="form-control mt-2">

            <label class="mt-2">Price Per Unit</label>
            <input type="text" name="price_per_unit" class="form-control mt-2">

            <label class="mt-2">Name</label>
            <input type="text" name="name" class="form-control mt-2">


                <a href="adminpage" type="button" class="mt-3 btn btn-danger float-left">Go back</a>

                <button type="submit" class="mt-3 btn btn-success float-end">Tilføj</button>
            </div>

        </form>




    </jsp:body>

</t:genericpage>