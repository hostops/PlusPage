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
 * @author Hostnik
 */
@WebServlet(name = "domov", urlPatterns = {"/domov"})
public class domov extends HttpServlet {

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
            out.println("<title>PLUSPAGE Domov</title>"
                    + "<style>#footer {\n" +
" height: 50px;\n" +
"position: fixed;\n" +
"width: 100%;\n" +
"margin-left: 0;\n" +
"margin-right: 0;\n" +
"background: none;\n" +
"background: rgba(255, 255, 255, .4);\n" +
"box-shadow: 0px 0px 4px #000000;\n" +
"bottom: 0;\n" +
"right: 0;\n" +
"left: 0;" +
"}"
                    + "#jeziki {\n" +
"    height: 25px;\n" +
"    width: 84px;\n" +
"    background: white;\n" +
"    position: relative;\n" +
"    float: right;\n" +
"    margin-right: 0px;\n" +
"    margin-top: 5px;}\n" +
                    
"#Gumb1 {\n" +
"    font-family: \"Trebuchet MS\", Helvetica, sans-serif;\n" +
"    font-size: medium;\n" +
"    color: white;\n" +
"    background: #999999;\n" +
"    border-color: #bbbbbb;\n" +
"    border-top-left-radius: 2em;\n" +
"    border-bottom-left-radius: 2em;\n" +
"    border-top-right-radius: 2em;\n" +
"    border-bottom-right-radius: 2em;\n" +
"    border-radius: 5px;\n"
                    + "top:10px;" + 
"}"+
"#Gumb2 {\n" +
"    font-family: \"Trebuchet MS\", Helvetica, sans-serif;\n" +
"    font-size: medium;\n" +
"    color: white;\n" +
"    background: #999999;\n" +
"    border-color: #bbbbbb;\n" +
"    border-top-left-radius: 2em;\n" +
"    border-bottom-left-radius: 2em;\n" +
"    border-top-right-radius: 2em;\n" +
"    border-bottom-right-radius: 2em;\n" +
"    border-radius: 5px;\n"
                    + "top:10px;" +
"}"
   
                    + "</style>");            
            out.println("</head>");
                  //send cookie
        
//read cookie
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
String piskotpodatek [] = null;
try{
piskotpodatek = piskot.split("%");
}catch(Exception e){
    out.println("<body id ='body' onload='preusmeri();'><script>function preusmeri(){"
            + "window.location.href='/';\n"
        + "}</script></body>");
    return ;
}



//delo z bazo
            try {
            Class.forName("com.mysql.jdbc.Driver");

        int idstevec = 0;
            
           
    Connection conn = DriverManager.getConnection("jdbc:mysql://plus-page:3306/plus-page","jakob","pass1234");
        Statement statement = conn.createStatement();
        ResultSet cursor = statement.executeQuery("SELECT ID, IME, PRIIMEK, EMAIL, UPORABNIK, GESLO, DATUMROJSTVA, SPOL, NASLOV, X, Y, XN, YN,VISINA,SIRINA,NOVOOKNO, SCROLLING, POVECAVA FROM UPORABNIKI");
       int gg=0;
        int prvisina =0;
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
                  int povecava = cursor.getInt(18);
                  
                  if(naslov.equals("-")==false){
                  if(scrolling ==false){
                  if (ime.equals(piskotpodatek[0]) && priimek.equals(piskotpodatek[1]) && email.equals(piskotpodatek[2])  && uporabnik.equals(piskotpodatek[3]) && geslo.equals(piskotpodatek[4])){
                      
                      if(naslov.contains("#")&&naslov.length()==7&&gg==0){
                      out.println("<body id ='body' style=\"background-color: "+naslov+";\" "+naslov+"  background='/ozadje.png' onload='preusmeri();'>"
                    + "");
                      gg++;
                      }else if(gg==0){
                          gg++;
                          out.println("<body id ='body' style=\"background-color: #FFFFFF;\"   background='/ozadje.png' onload='preusmeri();'>"
                    + "");}
                      else{
                      
                      out.println("<div id=\"outerdiv"+idstevec+"\">      \n" +
"    <iframe id=\"innerdiv"+idstevec+"\" width=\"500\" height=\"560\" src=\""+naslov+"\" scrolling=\"no\" frameborder=\"3\"></iframe>\n" +
"</div>\n");
 
                  out.println("<script>"
                          + "                var a = "+povecava+";\n" +
"		\n" +
"    a= (a/100);\n" +
"window.a = a;\n" +
"	var v1 = "+(visina+yn)+";\n" +
"	var s1 = "+(sirina+xn)+";" +
"        var x = document.createElement(\"STYLE\");\n" +
"        var visina= v1/a;\n" +
"	var sirina = s1/a;\n" +
"       \n" +
"    var t = document.createTextNode(\"#innerdiv"+idstevec+" { width: \"+sirina+\"px; height: \"+visina+\"px ;  border: 0;    -ms-transform: scale(\"+a+\");    -moz-transform: scale(\"+a+\");    -o-transform: scale(0.25);    -webkit-transform: scale(\"+a+\");    transform: scale(\"+a+\");     -ms-transform-origin: 0 0;   -moz-transform-origin: 0 0;    -o-transform-origin: 0 0;   -webkit-transform-origin: 0 0;    transform-origin: 0 0;    transform-origin: right bottom ; transform-origin: left top ;}\");\n" +
"    x.appendChild(t);\n" +
"    document.head.appendChild(x);\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.width= \"\"+sirina+'px';\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.height= \"\"+visina+'px';</script>");
                  out.println("<style>#outerdiv"+idstevec+" {\n" +
"width:"+sirina+"px;\n" +
"height:"+visina+"px;\n" +
"overflow:hidden;\n" +
"position:absolute;\n" +
"top: "+(y)+"px;\n" +
"left: "+x+"px;\n"
+ "border: 2px solid #a1a1a1;\n" +

"    background: #dddddd;\n" +
"    border-radius:5px;"+
"}\n" +
"#innerdiv"+idstevec+" {\n" +
"position:absolute;\n" +
"top:-"+yn+"px;\n" +
"left:-"+xn+"px;\n" +
"width:"+(sirina +xn)+"px;\n" +
"height:"+(visina+yn)+"px;\n" +
"}</style>");
                  if(novookno==true){
                     out.println(""
 + "<a href ='"+naslov+"' target=\"_blank\"><div id=\"prozoren"+idstevec+"\">\n" +
 
"</div></a>\n");
 
                  
                  out.println("<style>#prozoren"+idstevec+" {\n" +
"width:"+sirina+"px;\n" +
"height:"+visina+"px;\n" +
"overflow:hidden;\n" +
"position:absolute;\n" +
"top: "+y+"px;\n" +
"left: "+x+"px;"+
"}\n" +
"</style>"); 
                  }
                 idstevec ++;
                  
                  }}
                  }else{
                  if (ime.equals(piskotpodatek[0]) && priimek.equals(piskotpodatek[1]) && email.equals(piskotpodatek[2])  && uporabnik.equals(piskotpodatek[3]) && geslo.equals(piskotpodatek[4])){
                                        if(naslov.contains("#")&&naslov.length()==7&&gg==0){
                      out.println("<body id ='body' style=\"background-color: "+naslov+";\" "+naslov+"  background='/ozadje.png' onload='preusmeri();'>"
                    + "");
                      gg++;
                      }else if(gg==0){
                          gg++;
                          out.println("<body id ='body' style=\"background-color: #FFFFFF;\" "+naslov+"  background='/ozadje.png' onload='preusmeri();'>"
                    + "");}
                      else{
                      out.println("<div id=\"outerdiv"+idstevec+"\">      \n" +
"    <iframe id=\"innerdiv"+idstevec+"\" width=\"500\" height=\"560\" src=\""+naslov+"\"  frameborder=\"3\"></iframe>\n" +
"</div>\n");
 
                   out.println("<script>"
                          + "                var a = "+povecava+";\n" +
"		\n" +
"    a= (a/100);\n" +
"window.a = a;\n" +
"	var v1 = "+(visina+yn)+";\n" +
"	var s1 = "+(sirina+xn)+";" +
"        var x = document.createElement(\"STYLE\");\n" +
"        var visina= v1/a;\n" +
"	var sirina = s1/a;\n" +
"       \n" +
"    var t = document.createTextNode(\"#innerdiv"+idstevec+" { width: \"+sirina+\"px; height: \"+visina+\"px ;  border: 0;    -ms-transform: scale(\"+a+\");    -moz-transform: scale(\"+a+\");    -o-transform: scale(0.25);    -webkit-transform: scale(\"+a+\");    transform: scale(\"+a+\");     -ms-transform-origin: 0 0;   -moz-transform-origin: 0 0;    -o-transform-origin: 0 0;   -webkit-transform-origin: 0 0;    transform-origin: 0 0;    transform-origin: right bottom ; transform-origin: left top ;}\");\n" +
"    x.appendChild(t);\n" +
"    document.head.appendChild(x);\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.width= \"\"+sirina+'px';\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.height= \"\"+visina+'px';</script>");
                  out.println("<style>#outerdiv"+idstevec+" {\n" +
"width:"+sirina+"px;\n" +
"height:"+visina+"px;\n" +
"overflow:hidden;\n" +
"position:absolute;\n" +
"top: "+(y)+"px;\n" +
"left: "+x+"px;\n"
+ "border: 2px solid #a1a1a1;\n" +

"    background: #dddddd;\n" +
"    border-radius:5px;"+
"}\n" +
"#innerdiv"+idstevec+" {\n" +
"position:absolute;\n" +

"width:"+(sirina)+"px;\n" +
"height:"+(visina)+"px;\n" +
"}</style>");
                 if(novookno==true){
                     out.println(""
 + "<a href ='"+naslov+"' target=\"_blank\"><div id=\"prozoren"+idstevec+"\">\n" +
 
"</div></a>\n");
 
                  
                  out.println("<style>#prozoren"+idstevec+" {\n" +
"width:"+(sirina-15)+"px;\n" +
"height:"+(visina-15)+"px;\n" +
"overflow:hidden;\n" +
"position:absolute;\n" +
"top: "+y+"px;\n" +
"left: "+x+"px;"+
"}\n" +
"</style>"); 
                  }
                 idstevec ++;
                  
                      }}}
                  }
                  
                  
                  
                  
      }
              
  cursor.close();
  statement.close();
  conn.close();

            
            
            
            
            
            } catch (Exception e) {
             out.println("<script>function preusmeri(){"
            + "window.location.href='/';\n"
        + "}</script>");
        }
            

           
            out.println("<script>function odjava(){"
                 + "document.cookie = \"login=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
                    + "document.cookie = \"ozadje=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
                    + "document.cookie = \"uporabnik=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
                    + "document.cookie = \"uredi0=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
                    + "document.cookie = \"uredi1=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
                    + "document.cookie = \"uredi2=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
                    + "document.cookie = \"uredi3=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
                    + "document.cookie = \"uredi10=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
                    + "document.cookie = \"uredi12=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
                    + "document.cookie = \"uredi13=; expires=Thu, 01 Jan 1970 00:00:00 UTC\";\n"
            + "window.location.href='/';\n"
        + "}</script>");
out.println("<div style='visibility: hidden; height: 150px; position: absolute;  width: 100%;margin-left: 0;margin-right: 0;bottom:-300px;'><br/>\n" +
"<br/>\n" +
"<br/>\n" +
"<br/><br/>\n" +
"<br/>\n" +
"<br/>\n" +
"<br/><br/>\n" +
"<br/>\n" +
"<br/>\n" +
"<br/>\n" +
"<br/>\n" +
"<br/>\n" +
"<br/>\n" +
"<br/><br/>\n" +
"<br/>\n" +
"<br/>\n" +
"<br/><br/>\n" +
"<br/>\n" +
"<br/>\n" +
"<br/></div>"
                    + "<div id=\"footer\"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
        + "<button id=\"Gumb1\" onclick=\"window.location.href='/uredi'\">Uredi postavitev</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
        "<button id=\"Gumb2\" onclick=\"odjava();\">Odjavi se</button>\n" +
"<div id=\"jeziki\" ><a><img src=\"nemska.jpg\"></a><a><img src=\"britanska.jpg\"></a></div>\n" +
"</div>");
            
            
             //oglsi
            
            int a = (int)(Math.random()*(20-1+1)+1);
            switch(a){
                case 1:
                     out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/avto.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                  out.println("<script>function reklama(){document.cookie='OGLAS=avto';window.location.href='/oglas';}</script>");
                    break;
                case 2:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/avtoZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=avtoZosebo';window.location.href='/oglas';}</script>");
                    break;
                case 3:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/cevli.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=cevlji';window.location.href='/oglas';}</script>");
                    
                    break;
                case 4:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/cevliZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                       out.println("<script>function reklama(){document.cookie='OGLAS=cevljiZosebo';window.location.href='/oglas';}</script>");
                    break;
                case 5:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/delnice.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=delnice';window.location.href='/oglas';}</script>");
                    break;
                case 6:
                     out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/delniceZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                     out.println("<script>function reklama(){document.cookie='OGLAS=delniceZosebo';window.location.href='/oglas';}</script>");
                    break;
                case 7:
                     out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/film.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                     out.println("<script>function reklama(){document.cookie='OGLAS=film';window.location.href='/oglas';}</script>");
                    break;
                case 8:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/filmZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=filmZosebo';window.location.href='/oglas';}</script>");
                    break;
                case 9:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/hisa.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=gradbenistvo';window.location.href='/oglas';}</script>");
                    break;
                case 10:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/hisaZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=gradbenistvoZosebo';window.location.href='/oglas';}</script>");
                    break;
                case 11:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/maskara.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=nega';window.location.href='/oglas';}</script>");
                    break;
                case 12:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/maskaraZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=negaZosebo';window.location.href='/oglas';}</script>");
                    break;
                case 13:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/potovanje.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=potovanja';window.location.href='/oglas';}</script>");
                    break;
                case 14:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/potovanjeZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=potovanjaZosebo';window.location.href='/oglas';}</script>");
                    break;
                case 15:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/racunalnik.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=racunalniki';window.location.href='/oglas';}</script>");
                    break;
                case 16: 
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/racunalnikZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=racunalnikiZosebo';window.location.href='/oglas';}</script>");
                    break;
                case 17:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/server.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=splet';window.location.href='/oglas';}</script>");
                    break;
                case 18:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/serverZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=spletZosebo';window.location.href='/oglas';}</script>");
                    break;
                case 19:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/tablete.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=zdravje';window.location.href='/oglas';}</script>");
                    break;
                case 20:
                    out.println("<a href='#' onClick='reklama();'><img src='/OGLASI/tableteZosebo.jpg' style='position: fixed;  right: 100px; bottom: 0px; height: 45px; width: 400px;'></a>");
                    out.println("<script>function reklama(){document.cookie='OGLAS=zdravjeZosebo';window.location.href='/oglas';}</script>");
                    break;
            
            }
            
            
            
                       
            //
            
            
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
