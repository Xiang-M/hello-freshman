<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.DisplayObject, com.example.model.NumberStringObject" %>
<%
    DisplayObject displayObject = (DisplayObject) request.getAttribute("displayObject");
    NumberStringObject numberStringObject = (NumberStringObject) request.getAttribute("numberStringObject");
    Integer displayedCount = (Integer) request.getAttribute("displayedCount");
    Integer remainingCount = (Integer) request.getAttribute("remainingCount");

    if (displayedCount == null) displayedCount = 0;
    if (remainingCount == null) remainingCount = 33;
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JS1251班头像盲盒</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>JS1251班头像盲盒</h1>

        <div class="stats">
            <p>已抽取: <span id="displayedCount"><%= displayedCount %></span> / 33</p>
            <p>剩余: <span id="remainingCount"><%= remainingCount %></span></p>
        </div>

        <div class="display-area">
            <% if (displayObject != null) { %>
                <div class="object-display">
                    <img src="<%= displayObject.getImagePath() %>" alt="展示图片">
                    <div class="strings">
                        <p><%= displayObject.getString1() %></p>
                    </div>
                </div>

                <div class="number-string-object">
                    <h3>TA来开盲盒</h3>
                    <p>学号: <%= numberStringObject.getNumber() %></p>
                    <p>姓名: <%= numberStringObject.getText() %></p>
                </div>
            <% } else { %>
                <p>点击下方按钮开始游戏吧!</p>
            <% } %>
        </div>

        <div class="controls">
            <form action="display" method="get">
                <input type="hidden" name="action" value="next">
                <button type="submit" <%= remainingCount == 0 ? "disabled" : "" %>>抽盲盒</button>
            </form>

            <form action="display" method="get">
                <input type="hidden" name="action" value="reset">
                <button type="submit">重新来</button>
            </form>
        </div>

        <audio id="soundEffect" src="sounds/display-sound.mp3" preload="auto"></audio>
    </div>

    <script src="js/script.js"></script>
</body>
</html>