/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domov.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.Cookie;
/**
 *
 * @author Matej
 */
@WebServlet(name = "oglas", urlPatterns = {"/oglas"})
public class oglas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int a=0;
        int steveczaid=0;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");   
            
                        out.println("<html>");
            out.println("<head>");
            out.println("<title>PLUSPAGE Oglas</title>");            
            out.println("</head>");
            out.println("<body onload='preusmeri();'>");
                    
        

//read cookie za oglas
String oglas =null;

String cookieName1 = "OGLAS";
Cookie[] cookies1 = request.getCookies();
if (cookies1 != null){
    for(int i=0; i<cookies1.length; i++){
        Cookie cookie = cookies1[i];
        if (cookieName1.equals(cookie.getName())){
            oglas = cookie.getValue();
            break;
        }
    }
}
else{}  
// read cookie  za uporabnisok ime
String piskot =null;

String cookieName = "uporabnik";
Cookie[] cookies = request.getCookies();
if (cookies != null){
    for(int i=0; i<cookies.length; i++){
        Cookie cookie = cookies[i];
        if (cookieName.equals(cookie.getName())){
            piskot = cookie.getValue();
            break;
        }
    }
}
else{}  
String piskotpodatek []= piskot.split("%");
String uporabniskoime = piskotpodatek[3];


//delo z bazo
String seznamstrani[] = new String[500];
            try {
            Class.forName("com.mysql.jdbc.Driver");

        int idstevec = 0;
            
           
    Connection conn = DriverManager.getConnection("jdbc:mysql://plus-page:3306/plus-page","jakob","pass1234");
        Statement statement = conn.createStatement();
         ResultSet cursor = statement.executeQuery("SELECT ID, IME, PRIIMEK, EMAIL, UPORABNIK, GESLO, DATUMROJSTVA, SPOL, NASLOV, X, Y, XN, YN,VISINA,SIRINA,NOVOOKNO, SCROLLING FROM UPORABNIKI");
       
        
              while (cursor.next()) {
                  int id =cursor.getInt(1);
                  String ime = cursor.getString(2);
                  String priimek =  cursor.getString(3);
                  String email = cursor.getString(4);
                  String uporabnik =cursor.getString(5);
                  String geslo = cursor.getString(6);
                  String datumrojstva = cursor.getString(7);
                  String spol = cursor.getString(8);
                  String naslov = cursor.getString(9);
                  int x =cursor.getInt(10);
                  int y = cursor.getInt(11);
                  int xn = cursor.getInt(12);
                  int yn = cursor.getInt(13);
                  int visina = cursor.getInt(14);
                  int sirina = cursor.getInt(15);
                  boolean novookno = cursor.getBoolean(16);
                  boolean scrolling = cursor.getBoolean(17);
                  
                  
                  if (uporabnik.equals(uporabniskoime)){
                      seznamstrani[a] = naslov;
                      a++;
                   
                  
                  
                  }
                  steveczaid++;
                  
                  
                  
                  
      }
              //branje iz OGLASOV
              Statement statement1 = conn.createStatement();
        
              cursor = statement.executeQuery("SELECT NASLOV, AVTO, AVTOZOSEBO, CEVLJI, CEVLJIZOSEBO, DELNICE, DELNICEZOSEBO, FILM, FILMZOSEBO, GRADBENISTVO, GRADBENISTVOZOSEBO, NEGA, NEGAZOSEBO, POTOVANJA, POTOVANJAZOSEBO, RACUNALNIKI, RACUNALNIKIZOSEBO, SPLET, SPLETZOSEBO, ZDRAVJE, ZDRAVJEZOSEBO FROM OGLASI");
              a=0;
              int x1=0;
              while (cursor.next()) {
                  
                  String naslov1 = cursor.getString(1);

                  int AVTO, AVTOZOSEBO, CEVLJI, CEVLJIZOSEBO, DELNICE, DELNICEZOSEBO, FILM, FILMZOSEBO, GRADBENISTVO, GRADBENISTVOZOSEBO, NEGA, NEGAZOSEBO, POTOVANJA, POTOVANJAZOSEBO, RACUNALNIKI, RACUNALNIKIZOSEBO, SPLET, SPLETZOSEBO, ZDRAVJE, ZDRAVJEZOSEBO;
                  AVTO = cursor.getInt(2);
                  AVTOZOSEBO = cursor.getInt(3);
                  CEVLJI = cursor.getInt(4);
                  CEVLJIZOSEBO = cursor.getInt(5);
                  DELNICE = cursor.getInt(6);
                  DELNICEZOSEBO = cursor.getInt(7);
                  FILM = cursor.getInt(8);
                  FILMZOSEBO = cursor.getInt(9);
                  GRADBENISTVO = cursor.getInt(10);
                  GRADBENISTVOZOSEBO = cursor.getInt(11);
                  NEGA = cursor.getInt(12);
                  NEGAZOSEBO = cursor.getInt(13);
                  POTOVANJA = cursor.getInt(14);
                  POTOVANJAZOSEBO = cursor.getInt(15);
                  RACUNALNIKI = cursor.getInt(16);
                  RACUNALNIKIZOSEBO = cursor.getInt(17);
                  SPLET = cursor.getInt(18);
                  SPLETZOSEBO = cursor.getInt(19);
                  ZDRAVJE = cursor.getInt(20);
                  ZDRAVJEZOSEBO = cursor.getInt(21);
                  
                  if(oglas.equalsIgnoreCase("avto")){x1=AVTO;
                  }else if(oglas.equalsIgnoreCase("avtoZosebo")){x1=AVTOZOSEBO;
                  }else if(oglas.equalsIgnoreCase("cevlji")){x1=CEVLJI;
                  }else if(oglas.equalsIgnoreCase("cevljiZosebo")){x1=CEVLJIZOSEBO;
                  }else if(oglas.equalsIgnoreCase("delnice")){x1=DELNICE;
                  }else if(oglas.equalsIgnoreCase("delniceZosebo")){x1=DELNICEZOSEBO;
                  }else if(oglas.equalsIgnoreCase("FILM")){x1=FILM;
                  }else if(oglas.equalsIgnoreCase("FILMZOSEBO")){x1=FILMZOSEBO;
                  }else if(oglas.equalsIgnoreCase("GRADBENISTVO")){x1=GRADBENISTVO;
                  }else if(oglas.equalsIgnoreCase("GRADBENISTVOZOSEBO")){x1=GRADBENISTVOZOSEBO;
                  }else if(oglas.equalsIgnoreCase("NEGA")){x1=NEGA;
                  }else if(oglas.equalsIgnoreCase("NEGAZOSEBO")){x1=NEGAZOSEBO;
                  }else if(oglas.equalsIgnoreCase("POTOVANJA")){x1=POTOVANJA;
                  }else if(oglas.equalsIgnoreCase("RACUNALNIKI")){x1=RACUNALNIKI;
                  }else if(oglas.equalsIgnoreCase("SPLET")){x1=SPLET;
                  }else if(oglas.equalsIgnoreCase("SPLETZOSEBO")){x1=SPLETZOSEBO;
                  }else if(oglas.equalsIgnoreCase("ZDRAVJE")){x1=ZDRAVJE;
                  }else if(oglas.equalsIgnoreCase("ZDRAVJEZOSEBO")){x1=ZDRAVJEZOSEBO;
                  }
                  
                  
                  
                  
                  
                  for(int i=0; i<seznamstrani.length;i++){
                  if(naslov1.equals(seznamstrani[i])){
                      statement1.executeUpdate("UPDATE OGLASI\n" + " SET "+oglas.toUpperCase()+"='"+(x1+1)+"' WHERE NASLOV='"+naslov1+"';");
                      seznamstrani[i]="";
                  }
                  }
                  steveczaid++;
                  
                  
                  
                  
      }
            for(int i=0; i<seznamstrani.length;i++){
                if(seznamstrani[i]!=null){
                  if(!seznamstrani[i].equals("-")&&!seznamstrani[i].equals("")&&seznamstrani[i]!=null){
                      if(seznamstrani[i].contains("#")&&seznamstrani[i].length()==7){}else{
                      statement1.executeUpdate("INSERT INTO jackyyes_pluspage.OGLASI (NASLOV, AVTO, AVTOZOSEBO, CEVLJI, CEVLJIZOSEBO, DELNICE, DELNICEZOSEBO, FILM, FILMZOSEBO, GRADBENISTVO, GRADBENISTVOZOSEBO, NEGA, NEGAZOSEBO, POTOVANJA, POTOVANJAZOSEBO, RACUNALNIKI, RACUNALNIKIZOSEBO, SPLET, SPLETZOSEBO, ZDRAVJE, ZDRAVJEZOSEBO) \n" +
"VALUES ('"+seznamstrani[i]+"', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);\n");
                      statement1.executeUpdate("UPDATE OGLASI\n" + " SET "+oglas.toUpperCase()+"='1'"+ " WHERE NASLOV='"+seznamstrani[i]+"';");
                      seznamstrani[i]="";
                  
                      }}
                  
                }    
            } 


  cursor.close();
  statement.close();
  conn.close();
  statement1.close();
            
            out.println("<h1>Hvala za vaš klik na oglas in pomoč pri raziskovalni nalogi</h1><a href='/domov'>Vrnite se nazaj na domačo stran.</a>");
            
            } catch (Exception e) {
            
            out.println("Prijava neuspešna!"+e+
"<script>function preusmeri(){\n"
          
        + "}</script>");
        }
            

           
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}