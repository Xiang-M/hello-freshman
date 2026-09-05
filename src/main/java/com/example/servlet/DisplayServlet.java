package com.example.servlet;

import com.example.model.DisplayObject;
import com.example.model.NumberStringObject;
import com.example.model.ObjectManager;
import com.example.util.SoundPlayer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/display")//处理HTTP请求的Servlet类，当用户访问 http://你的网站/display 时，由这个Servlet来处理请求
public class DisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();//获取或创建用户的会话
        ObjectManager objectManager = (ObjectManager) session.getAttribute("objectManager");
        // 从Session中获取之前存储的ObjectManager对象

        if (objectManager == null) {
            objectManager = new ObjectManager();
            session.setAttribute("objectManager", objectManager);
        }

        String action = request.getParameter("action");// 从HTTP请求中获取名为"action"的参数值

        if ("next".equals(action)) {
            // 播放音效
            SoundPlayer.playSound();

            // 获取随机对象
            DisplayObject displayObject = objectManager.getRandomDisplayObject();
            NumberStringObject numberStringObject = objectManager.getRandomNumberStringObject();

            request.setAttribute("displayObject", displayObject);//将数据从Servlet传递到JSP页面,JSP是前端？
            request.setAttribute("numberStringObject", numberStringObject);
        } else if ("reset".equals(action)) {
            objectManager.resetAll();
        }

        request.setAttribute("displayedCount", objectManager.getDisplayedCount());
        request.setAttribute("remainingCount", objectManager.getRemainingCount());

        request.getRequestDispatcher("/index.jsp").forward(request, response);
        // 用户请求 → Servlet处理 → 转发到JSP → JSP生成HTML → 返回给用户
    }
}