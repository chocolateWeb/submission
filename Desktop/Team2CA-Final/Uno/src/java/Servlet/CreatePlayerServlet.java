package Servlet;

import Entities.Player;
import Exceptions.PlayerException;
import Manager.CreatePlayerBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Hariharan
 */
@WebServlet(name = "CreatePlayerServlet", urlPatterns = {"/createplayerservlet"})
public class CreatePlayerServlet extends HttpServlet {
    
    @Resource(lookup = "jdbc/team2_adv_web_uno") private DataSource ds;
    
    String UserEmail,Password;  
    
   
    @EJB private CreatePlayerBean playerBean;

    @Override
    public void init() throws ServletException {
       // @PostConstruct
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }   
    

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
      
        
    
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UnsupportedEncodingException {
       
    }  */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserEmail = req.getParameter("emailaddr");
        Password = req.getParameter("password1");
        
        RequestDispatcher rd = null;

        try{               
            try {         
                playerBean.createPlayer(UserEmail,Password);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CreatePlayerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(SQLException | PlayerException ex){
            System.out.println(">>> Error, Not inserted");
            //resp.sendRedirect("http://localhost:8080/HariUNO/register.jsp");
            
            //resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,ex.getMessage());
            String ErrorMsg = "User already Exist";
            req.setAttribute("ErrorMsg",ErrorMsg);
            rd=req.getRequestDispatcher("/register.jsp");
            
            rd.forward(req, resp);
            return;
        }
        
        resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        //resp.setContentType("text/Plain");
        try (PrintWriter pw = resp.getWriter()) {
			pw.println(UserEmail + " has been created");
            String SuccessMsg = UserEmail + " has been created";
            req.setAttribute("SuccessMsg",SuccessMsg);
            //
            //rd=req.getRequestDispatcher("/login.jsp");
             rd=req.getRequestDispatcher("/login1.jsp");
            //rd=req.getRequestDispatcher("secret/floor.jsp");
	    rd.forward(req, resp);

                        
        }
        
    }
    
    
   

}
