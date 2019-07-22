package com.visa.prj.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final String answer= "ARRAYLIST";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession ses = request.getSession(true);
		ses.setAttribute("life", 5);
		String currentAnswer = "*********";
		ses.setAttribute("currentAnswer", currentAnswer);
		ses.setAttribute("answer", "ARRAYLIST");
		response.sendRedirect("game.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses = req.getSession(false);
		int life = (int) ses.getAttribute("life");
		String guess = (String) req.getParameter("guess");
		String answer = (String)ses.getAttribute("answer");
		//System.out.println(guess);

		//System.out.println(answer.indexOf(guess.charAt(0)));
		String currentAnswer = (String) ses.getAttribute("currentAnswer");
		char[] ans = currentAnswer.toCharArray();
		//System.out.println(ans[0]);
		if(answer.indexOf(guess.charAt(0))== -1) {
			ses.setAttribute("life", life-1);
		}else {
			for (int i = 0; i < answer.length(); i++) {
				if(answer.charAt(i) == guess.charAt(0) ) {
					ans[i] = guess.charAt(0);
				}
			}
		}
		currentAnswer = new String(ans);
		ses.setAttribute("currentAnswer", currentAnswer);
		resp.sendRedirect("game.jsp");
	}
}
