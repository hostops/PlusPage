/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template  file, choose Tools | Templates
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
 * @author Hostnik
 */
@WebServlet(name = "shrani", urlPatterns = {"/shrani"})
public class shrani extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");   
            
                        out.println("<html>");
            out.println("<head>");
            out.println("<title>PLUSPAGE Shrani podatke</title>");            
            out.println("</head>");
            out.println("<body onload=\"window.location.href='/domov'\">");
                    //send cookie
        
//read cookie
            String barva=null;

String imekukija = "ozadje";
Cookie[] vsikukiji = request.getCookies();
if (vsikukiji != null){
    for(int i=0; i<vsikukiji.length; i++){
        Cookie cookie = vsikukiji[i];
        if (imekukija.equals(cookie.getName())){
            barva = cookie.getValue();
            break;
        }
    }
}
else{}  
            
            
            
            
            
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





//bere vse cookije in jih razvrsti v podatke
String podatki[][]=new String [100][10];
int k = 0;


    for(int h=0;h<50;h++){
        try{
        String prebranpiskot =null;

        String naslovpiskotka = "uredi"+h;
        Cookie[] vsipiskotki = request.getCookies();
            if (cookies != null){
                 for(int i=0; i<cookies.length; i++){
                  Cookie cookie = cookies[i];
                     if (naslovpiskotka.equals(cookie.getName())){
                         prebranpiskot = cookie.getValue();
                             break;
                         }
                 }
            }else{}  
        String stavki []= prebranpiskot.split("%%");
        
            for(int nona =0; nona<stavki.length;nona++){
                if (stavki[nona].equals("")==false){
                 podatki[k][0]=stavki[nona]; 
                 k++;}
            }
          }catch(Exception e){}
       }
   
    for(int o=0;o<=100;o++){
        try{
    String besede[] = podatki[o][0].split("%");
    podatki[o][0]=besede[0];
    podatki[o][1]=besede[1];
    podatki[o][2]=besede[2];
    podatki[o][3]=besede[3];
    podatki[o][4]=besede[4];
    podatki[o][5]=besede[5];
    podatki[o][6]=besede[6];
    podatki[o][7]=besede[7];
    podatki[o][8]=besede[8];
    podatki[o][9]=besede[9];
        }catch(Exception e){
        
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//delo z bazo
            try {
            Class.forName("com.mysql.pass1234.Driver");
int idklobasa=0;
        int idstevec = 0;
            int idid[]=new int[1000];
         String updatezabarvo="";
         
    Connection conn = DriverManager.getConnection("pass1234:mysql://plus-page:3306/plus-page","jakob","geslo123");
        Statement statement = conn.createStatement();
        
        ResultSet cursor = statement.executeQuery("SELECT ID, IME, PRIIMEK, EMAIL, UPORABNIK, GESLO, DATUMROJSTVA, SPOL, NASLOV, X, Y, XN, YN,VISINA,SIRINA,NOVOOKNO, SCROLLING, POVECAVA FROM UPORABNIKI");
       
    
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
                  int povecava =cursor.getInt(18);
                  
                 
                  idklobasa++;
                  if (ime.equals(piskotpodatek[0]) && priimek.equals(piskotpodatek[1]) && email.equals(piskotpodatek[2])  && uporabnik.equals(piskotpodatek[3]) && geslo.equals(piskotpodatek[4])){
                 if(naslov.contains("#")&&naslov.length()==7){
                  updatezabarvo="UPDATE UPORABNIKI\n" + " SET NASLOV='"+barva+"' WHERE ID="+id+";" ;
                      }else{
                      idid[idstevec]=id; 
                      idstevec ++;
                 }
                 
                 
                   
                  }
                 
                  
                  
                  
                  
      }
              statement.executeUpdate(updatezabarvo);
              int r1=0;
              for(int r=0;r<=idstevec;r++){
                  
                  if(podatki[r][0]!=null){
                      String[] Naslovvvv = podatki[r][0].split("dvopicjeeee");
        statement.executeUpdate("UPDATE UPORABNIKI\n" + " SET NASLOV='"+Naslovvvv[0]+":"+Naslovvvv[1]+"', VISINA='"+podatki[r][1]+"', SIRINA='"+podatki[r][2]+"', YN='"+podatki[r][3]+"', XN='"+podatki[r][4]+"', Y='"+podatki[r][5]+"', X='"+podatki[r][6]+"', NOVOOKNO="+podatki[r][7]+", SCROLLING="+podatki[r][8]+", POVECAVA='"+podatki[r][9]+"'"+ " WHERE ID="+idid[r]+";");  
                  }else{statement.executeUpdate("UPDATE UPORABNIKI\n" + " SET NASLOV='-'"+ " WHERE ID="+idid[r]+";");  }
              r1=r;
              }
             
                 for(int r=0;r<=150;r++){
                     
                     if(podatki[r1][0]!=null){
                 String[] Naslovvvv = podatki[r1][0].split("dvopicjeeee");
        statement.executeUpdate("INSERT INTO jackyyes_pluspage.UPORABNIKI (ID, IME, PRIIMEK, EMAIL, UPORABNIK, GESLO, DATUMROJSTVA, SPOL, NASLOV, X, Y, XN, YN, VISINA, SIRINA, NOVOOKNO, SCROLLING, POVECAVA) "
                                                 + "VALUES ('"+(idklobasa+1)+"', '"+piskotpodatek[0]+"', '"+piskotpodatek[1]+"', '"+piskotpodatek[2]+"', '"+piskotpodatek[3]+"','"+piskotpodatek[4]+"', '', '', '"+Naslovvvv[0]+":"+Naslovvvv[1]+"', "+podatki[r1][6]+", "+podatki[r1][5]+", "+podatki[r1][4]+", "+podatki[r1][3]+", "+podatki[r1][1]+", "+podatki[r1][2]+", "+podatki[r1][7]+", "+podatki[r1][8]+", "+podatki[r1][9]+");");
                   r1++;
                   idstevec++;
                   idklobasa++;
              }
             }
              
              
              
              
  cursor.close();                                 
  statement.close();
  conn.close();

            
           
            
            
            
            } catch (Exception e) {
            out.println("ne dela!");
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
