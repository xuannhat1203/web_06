package com.baitap.session06.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
@WebServlet(name = "GameServlet", value = "/GameServlet")
public class GameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("views/game.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String userChoice = request.getParameter("choice");
        String[] options = {"Búa", "Kéo", "Lá"};
        String computerChoice = options[ThreadLocalRandom.current().nextInt(options.length)];
        String result = determineWinner(userChoice, computerChoice);
        request.setAttribute("userChoice", userChoice);
        request.setAttribute("computerChoice", computerChoice);
        request.setAttribute("result", result);
        request.getRequestDispatcher("views/resultGame.jsp").forward(request, response);
    }

    private String determineWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Hòa!";
        } else if ((user.equals("Búa") && computer.equals("Kéo")) ||
                (user.equals("Kéo") && computer.equals("Lá")) ||
                (user.equals("Lá") && computer.equals("Búa"))) {
            return "Bạn thắng!";
        } else {
            return "Bạn thua!";
        }
    }
}
