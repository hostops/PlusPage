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
@WebServlet(name = "registracija1", urlPatterns = {"/registracija1"})
public class registracija1 extends HttpServlet {

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
            out.println("<title>PLUSPAGE Registracija</title>");            
            out.println("</head>");
            out.println("<body onload='preusmeri();'>");
                    
        

//read cookie
String piskot =request.getParameter("Podatki");
String piskotpodatek []= piskot.split("%");




//delo z bazo
            try {
            Class.forName("com.mysql.pass1234.Driver");

        int idstevec = 0;
            
           
    Connection conn = DriverManager.getConnection("pass1234:mysql://plus-page:3306/plus-page","jakob","geslo123");
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
                  
                  
                  if (uporabnik.equals(piskotpodatek[3])){
                   a++;
                   
                  
                  
                  }
                  steveczaid++;
                  
                  
                  
                  
      }
              

if (a==0){
out.println("Registracija uspešna!"+
"<script>function preusmeri(){\n"
          + "window.location.href='/RegUspela.html';\n"
        + "}</script>");


  statement.executeUpdate("INSERT INTO jackyyes_pluspage.UPORABNIKI (ID, IME, PRIIMEK, EMAIL, UPORABNIK, GESLO, DATUMROJSTVA, SPOL, NASLOV, X, Y, XN, YN, VISINA, SIRINA, NOVOOKNO, SCROLLING) "
                                                 + "VALUES ('"+(steveczaid+1)+"', '"+piskotpodatek[0]+"', '"+piskotpodatek[1]+"', '"+piskotpodatek[2]+"', '"+piskotpodatek[3]+"','"+piskotpodatek[4]+"', '"+piskotpodatek[5]+"', '"+piskotpodatek[6]+"', '#FFFFFF', 50, 50, 30, 30, 700, 700, true, true);");
                                                            
                    
}else{
    out.println("Registracija neuspešna! Uporabnik s tem uporabniškim imenom že obstaja!"+
"<script>function preusmeri(){"
            + "window.location.href='/RegNiUspela.html';\n"
        + "}</script>");
}
  cursor.close();
  statement.close();
  conn.close();
            
            
            
            
            } catch (Exception e) {
            
            out.println("Prijava neuspešna! Napaka: "+e+
"<script>function preusmeri(){\n"
           + "window.location.href='/RegNiUspela.html';\n"
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