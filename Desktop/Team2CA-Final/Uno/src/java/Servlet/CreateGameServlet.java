package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KeljinChow
 */
@WebServlet("/secret/creategame")
public class CreateGameServlet extends HttpServlet {
    
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                        
        int numberofplayers = Integer.parseInt(request.getParameter("numberofplayers"));
        int numberofrounds = Integer.parseInt(request.getParameter("numberofrounds"));
        String nameofgameroom = request.getParameter("nameofgameroom");
        
        System.out.println(">>number of players: " + Integer.toString(numberofplayers));
        System.out.println(">>number of rounds: " + Integer.toString(numberofrounds));
        System.out.println(">>name of game room: " + nameofgameroom);
                
        request.setAttribute("numberofplayers",numberofplayers);
        request.setAttribute("numberofrounds",numberofrounds);
        request.setAttribute("nameofgameroom",nameofgameroom);
        
        request.getRequestDispatcher("/secret/commonview.jsp").forward(request, response);
    }
}
