<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<body>
    <div id="sloth">
        <div class="pull-left">
            <h1>Hey You <span>Guuuuuuuuuuuuuuuuuys</span></h1>
            <p>The page you want doesn't exist Matey! Go back or walk the plank.</p>
            <p><a onclick="goBack()">...back</a></p>
        </div>
        <div class="pull-right">
            <img src="img/sloth.jpg" class="pull-right" alt="Sloth" />
        </div>
    </div>
    <script>
        function goBack() {
        window.history.back();
    }
</script>
</body>
</html>