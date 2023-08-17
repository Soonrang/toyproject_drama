<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>등록페이지</title>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <!-- 기존의 <h1>Header</h1> -->
        <div class="row">
            <div class="col">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">투두리스트</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <a class="nav-link active" aria-current="page" href="#">홈</a>
                                <a class="nav-link" href="#">룰루</a>
                                <a class="nav-link" href="#">가격</a>
                                <a class="nav-link disabled">-</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- header end -->
        <!-- 기존의 <h1>Header</h1>끝 -->

        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        룰루
                    </div>
                    <div class="card-body">
                        <form action="/todo/register" method="post">
                            <div class="input-group mb-3">
                                <span class="input-group-text">제목</span>
                                <input type="text" name="title" class="form-control" placeholder="제목을 입력해주세요.">
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">기한</span>
                                <input type="date" name="dueDate" class="form-control" placeholder="Writer">
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">작성자</span>
                                <input type="text" name="writer" class="form-control" placeholder="Writer">
                            </div>

                            <div class="my-4">
                                <div class="float-end">
                                    <button type="submit" class="btn btn-primary">제출</button>
                                    <button type="result" class="btn btn-secondary">초기화</button>
                                </div>
                            </div>
                        </form>

                        <script>

                            const serverValidResult = {}

                            <c:forEach items="${errors}" var="error">

                            serverValidResult['${error.getField()}'] = '${error.defaultMessage}'

                            </c:forEach>

                            console.log(serverValidResult)

                        </script>

                    </div>

                </div>
            </div>
        </div>

    </div>
    <div class="row content">
        <h1>Content</h1>
    </div>
    <div class="row footer">
        <!--<h1>Footer</h1>-->

        <div class="row   fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1 ">
                <p class="text-center text-muted">Footer</p>
            </footer>
        </div>

    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>