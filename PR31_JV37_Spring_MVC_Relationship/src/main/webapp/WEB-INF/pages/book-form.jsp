<%-- 
    Document   : book-form
    Created on : Oct 2, 2020, 7:35:38 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
           prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book</title>
        <link href="<c:url value="/webjars/bootstrap/3.4.1/css/bootstrap.min.css" />" 
              type="text/css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
                     style="text-align: center">
                    <c:if test="${action == 'add'}">
                        <h3>Create Books</h3>
                    </c:if>
                    <c:if test="${action == 'update'}">
                        <h3>Update Books</h3>
                    </c:if>
                </div>
            </div>

            <mvc:form action="${pageContext.request.contextPath}/${action}"
                      method="POST" modelAttribute="book">

                <c:if test="${action == 'update'}">
                    <input value="${book.id}" name="id" hidden />
                </c:if>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name"
                                   name="name" value="${book.name}">
                        </div>
                    </div>

                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="author">Author:</label>
                            <input type="text" class="form-control" id="author"
                                   name="author" value="${book.author}">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label>Category</label>
                            <select name="category.id" class="form-control">
                                <c:forEach items="${categories}" var="c">
                                    <c:if test="${c.id == book.category.id}">
                                        <option value="${c.id}" selected>${c.name}</option>
                                    </c:if>
                                    <c:if test="${c.id != book.category.id}">
                                        <option value="${c.id}">${c.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="isbn">ISBN:</label>
                            <input type="text" class="form-control" id="isbn"
                                   name="bookDetail.isbn"
                                   value="${book.bookDetail.isbn}">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="numberPage">Number Of Page: </label>
                            <input type="number" class="form-control" id="numberPage"
                                   name="bookDetail.numberOfPages"
                                   value="${book.bookDetail.numberOfPages}">
                        </div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="price">Price:</label>
                            <input type="number" class="form-control" id="price"
                                   name="bookDetail.price"
                                   value="${book.bookDetail.price}">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <div class="form-group">
                            <label for="publishDate">Publish Date:</label>
                            <input type="date" class="form-control" id="publishDate"
                                   name="bookDetail.publishDate"
                                   value="${book.bookDetail.publishDate}">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12"
                         style="text-align: center">
                        <c:if test="${action == 'add'}">
                            <button class="btn btn-success" type="submit">Create Book</button>
                        </c:if>
                        <c:if test="${action == 'update'}">
                            <button class="btn btn-warning" type="submit">Update Book</button>
                        </c:if>
                    </div>
                </div>
            </mvc:form>
        </div>
    </body>
</html>
