<%-- 
    Document   : home
    Created on : Oct 2, 2020, 6:22:55 PM
    Author     : ASUS
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="<c:url value="/webjars/bootstrap/3.4.1/css/bootstrap.min.css" />" 
              type="text/css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
                     style="text-align: center">
                    <h3>List Books</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <button class="btn btn-info"
                            onclick="location.href = '<c:url value="/add-book"/>'">Add Book</button>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6"
                     style="text-align: right">
                    <form action="${pageContext.request.contextPath}/search"
                          method="post" class="form-inline">
                        <div class="form-group">
                            <input name="strSearch" class="form-control"/>
                            <input type="submit" value="Search" 
                                   class="btn btn-info" />
                        </div>
                    </form>
                </div>
            </div>

            <c:if test="${message != null && message!= ''}">
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
                         style="padding-top: 10px">
                        <c:if test="${type != null && type!= '' && type == 'error'}">
                            <div class="alert alert-danger">${message}</div>
                        </c:if>
                        <c:if test="${type != null && type!= '' && type == 'success'}">
                            <div class="alert alert-success">${message}</div>
                        </c:if>
                    </div>
                </div>
            </c:if>

            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
                     style="padding-top: 10px">
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover">
                            <tr>
                                <th>Name</th>
                                <th>Author</th>
                                <th>Category</th>
                                <th>ISBN</th>
                                <th>Number Of Page</th>
                                <th>Price</th>
                                <th>Publish Date</th>
                                <th>Action</th>
                            </tr>
                            <c:if test="${books != null && fn:length(books)>0}">
                                <c:forEach items="${books}" var="b">
                                    <tr>
                                        <td>${b.name}</td>
                                        <td>${b.author}</td>
                                        <td>${b.category.name}</td>
                                        <td>${b.bookDetail.isbn}</td>
                                        <td>${b.bookDetail.numberOfPages}</td>
                                        <td>
                                            <fmt:formatNumber value="${b.bookDetail.price}"
                                                              pattern="###,###" type="number"/>
                                            VNĐ
                                        </td>
                                        <td>
                                            <fmt:formatDate value="${b.bookDetail.publishDate}"
                                                            pattern="dd/MM/yyyy" />
                                        </td>
                                        <td>
                                            <button class="btn btn-default"
                                                    onclick="location.href = '<c:url value="/update-book/${b.id}"/>'">Update</button>
                                            <button class="btn btn-danger"
                                                    onclick="location.href = '<c:url value="/delete-book/${b.id}"/>'">Delete</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${books == null || fn:length(books)<=0}">
                                <tr>
                                    <td colspan="8" style="color: red">
                                        Empty List!!!
                                    </td>
                                </tr>
                            </c:if>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
