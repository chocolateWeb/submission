
package Manager;

import Entities.Player;
import Exceptions.PlayerException;
import Utility.hashedPasswordGenerator;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Hariharan
 */
@Stateless
public class CreatePlayerBean {
    
    private static final String INSERT_GROUP = "insert into player_group (Player_Email) values (?)";
    private static final String INSERT_PLAYER = "insert into player values (?, ?)";
    
    @Resource(lookup = "jdbc/team2_adv_web_uno") DataSource ds;
    
    @PostConstruct
	private void init() {
		System.out.println(">>> PlayerBean created");
	}

	@PreDestroy
	private void cleanup() {
		System.out.println(">>> clean up");
	}
        
        public void createPlayer(String UserEmail, String Password)throws SQLException, PlayerException, NoSuchAlgorithmException, UnsupportedEncodingException  {
        
            try (Connection conn = ds.getConnection()) {
			
			try {
				//Create Player in group Table
				PreparedStatement ps = conn.prepareStatement(INSERT_GROUP);
				ps.setString(1, UserEmail);
				ps.executeUpdate();
                                
                                //Create Player in Player Table                                
                                // need to call the  password hasher
                                hashedPasswordGenerator PG = new hashedPasswordGenerator();
                                String Passwd = PG.generatehash(Password);                                
                                ps = conn.prepareStatement(INSERT_PLAYER);
                                ps.setString(1, UserEmail);
                                ps.setString(2, Passwd);
                                ps.executeUpdate();    
                                
                                //to get the return result after insert
                                ResultSet s = ps.getResultSet();
                                
                                if (null == s)
                                    System.out.println(">>> Error, Not inserted");
                                else
                                    System.out.println(s);
                                                            
                                                            
                                					
			     }catch(NoSuchAlgorithmException | UnsupportedEncodingException Excep ){
                             
                                System.out.println(">>> Hasshing is not working");
                             
                             }
				//conn.commit(); //NOt necessary
			} catch (SQLException ex) {
				
				
				throw new PlayerException(ex.getMessage());
                                
				//conn.rollback();
				//throw ex;
			}

		}
        
        }
    
