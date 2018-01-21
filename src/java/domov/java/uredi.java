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
@WebServlet(name = "uredi", urlPatterns = {"/uredi"})
public class uredi extends HttpServlet {

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
            
                        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
"      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n" +
"      lang=\"en\">");
            out.println("<head>"); 
            out.println("<meta charset=\"utf-8\"></meta>\n" +
"  <title>PLUSPAGE Uredi postavitev</title>\n" +
"  <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css\"></link>\n" +
"  <script src=\"//code.jquery.com/jquery-1.10.2.js\"></script>\n" +
"  <script src=\"//code.jquery.com/ui/1.11.2/jquery-ui.js\"></script>\n"
                    + "<script src=\"/javascript/jquery.ui.touch-punch.js\"></script>"
                    + "<script src=\"/javascript/skript.js\"></script>"+
                    
"  \n");            
            out.println(""
                    + "<style>#footer {\n" +
"    height: 150px;\n"
+ "position: fixed;\n" +
"width: 100%;\n" +
"margin-left: 0;\n" +
"margin-right: 0;\n" +
"background: none;\n" +
"background: rgba(77, 77, 77, .6);\n" +
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
"    margin-top: 85px;\n" +
"}"+
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
"    border-radius: 5px;\n" +
"}"
                    +
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
"    border-radius: 5px;\n" +
"}"
                    +
                    "#Gumb3 {\n" +
"    font-family: \"Trebuchet MS\", Helvetica, sans-serif;\n" +
"    font-size: medium;\n" +
"    color: white;\n" +
"    background: #999999;\n" +
"    border-color: #bbbbbb;\n" +
"    border-top-left-radius: 2em;\n" +
"    border-bottom-left-radius: 2em;\n" +
"    border-top-right-radius: 2em;\n" +
"    border-bottom-right-radius: 2em;\n" +
"    border-radius: 5px;\n" +
"}"
                    + "</style></head>");

                    //send cookie
         
//read cookie
String piskot =null;

String cookieName = "uporabnik";
Cookie[] cookies = request.getCookies();
if (cookies != null){
    for (int i=0; i<cookies.length; i++){
        Cookie cookie = cookies[i];
        if (cookieName.equals(cookie.getName())){
            piskot  = cookie.getValue();
            break;
        }
    }
}
else{}  
String piskotpodatek []= piskot.split("%");




//delo z bazo
            try {
 Class.forName("com.mysql.jdbc.Driver");

        int idstevec = 0;
            
           int gg=0;
    Connection conn = DriverManager.getConnection("jdbc:mysql://pluspage.heliohost.org:3306/jackyyes_pluspage","jackyyes_yes","geslo123");
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
                  int povecava = cursor.getInt(18);
                  if(naslov.equals("-")==false){
                  if (ime.equals(piskotpodatek[0]) && priimek.equals(piskotpodatek[1]) && email.equals(piskotpodatek[2])  && uporabnik.equals(piskotpodatek[3]) && geslo.equals(piskotpodatek[4])){
                     
                      
                      
                      
                      if(naslov.contains("#")&&naslov.length()==7&&gg==0){
                          Cookie userCookie = new Cookie("ozadje",naslov);
userCookie.setMaxAge(60*60*24*365); 
response.addCookie(userCookie);
                      out.println("<body id ='body' style=\"background-color: "+naslov+";\" "+naslov+" onload='prvo();' background='/ozadje.png'><script type=\"text/javascript\" src=\"jscolor/jscolor.js\"></script>");
            out.println(""
                    + "<script>\n"
                    + "window.greeting = 1000;"
                    
                    + "</script>"
                    + "<script>\n"
                    + ""
                    + "function dodaj(){"
                    + "if(window.greeting==1030){alert('Hkrati lahko dodaš le 30 elementov. Če jih želiš dodati več shrani trenutno razporeditev in kasneje dodaj nove elemente.');"
                    + "\n }else{\n"
                    + "document.getElementById('draggable'+window.greeting).setAttribute('style','visibility: visible');\n"
                    + "window.greeting++;\n"
                    + "}} \n"
                    + "</script>"
                    + "<script>\n" +
"function shrani(){\n" +
"var napaka=0;\n" +
"var i=0;\n" +
"var j=0;\n" +
"var piskotek=\"\";\n" +
"	while (i<5000) {\n" +
"	try {\n" +
"		var vidno =  document.getElementById('draggable'+i);\n" +
"		\n" +
"			if(vidno.style.visibility != 'hidden'){\n" +
"		\n" +
"		var naslov = document.getElementById(\"naslov\"+i).value;\n"
             + "var naslov = naslov.replace(/:/g, \"dvopicjeeee\");\n" +
"		var a = document.getElementById(\"draggable\"+i).offsetHeight;\n" +
"		var b = document.getElementById(\"draggable\"+i).offsetWidth;\n" +
"		var c = dobiNotranjiOdmikY(i);\n" +
"		var d = dobiNotranjiOdmikX(i);\n" +
"\n" +
"		var top =document.getElementById('draggable'+i).offsetTop;\n" +
"		var left =document.getElementById('draggable'+i).offsetLeft;\n" +
"	\n" +
"		var novo = document.getElementById(\"novocheck\"+i).checked;\n" +
"		var scroll = document.getElementById(\"scrollcheck\"+i).checked;\n"
             + "var povecava = (document.getElementById(\"aa\"+i).value)*2;" +
"\n" +
"		piskotek += naslov+\"%\"+a+\"%\"+b+\"%\"+c+\"%\"+d+\"%\"+top+\"%\"+left+\"%\"+novo+\"%\"+scroll+\"%\"+povecava+\"%%\";\n" +
"		i++;\n" +
"\n" +
"\n" +
"	if(naslov.indexOf('%')!==-1){\n" +
"            	alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(naslov.indexOf('http')==-1){\n" +
"		alert (\"Niste pravilno vnesli naslova spletne strani: \"+naslov+\". spletni naslov mora biti oblike: http://primer.com\");\n" +
"		napaka=1;\n" +
"        }else if(a.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"        }else if(isNaN(a)==true){\n" +
"		alert (\"V polje višina lahko vnesete samo števila: \"+a);\n" +
"		napaka=1;\n" +
"	}else if(b.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(b)==true){\n" +
"		alert (\"V polje širina lahko vnesete samo števila: \"+b);\n" +
"		napaka=1;\n" +
"\n" +
"	}else if(c.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(c)==true){\n" +
"		alert (\"V polje notranji odmik zgoraj lahko vnesete samo števila: \"+c);\n" +
"		napaka=1;\n" +
"\n" +
"	}else if(d.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(d)==true){\n" +
"		alert (\"V polje notranji odmik spodaj lahko vnesete samo števila: \"+d);\n" +
"		napaka=1;\n" +
"\n" +
"\n" +
"		\n" +
"\n" +
"        }else{\n" +
"\n" +
"\n" +
"					if(i%15==0){\n" +
"					document.cookie= \"uredi\"+j+\"=\"+piskotek;\n" +
"					j++;\n" +
"					piskotek=\"\";\n" +
"					}\n" +
"		}\n" +
"\n" +
"		}else{i++;}\n" +
"	}catch(err) {\n" +
"    	i=6000;\n" +
"		if(napaka!=1){\n" +
"		document.cookie= \"uredi\"+j+\"=\"+piskotek;\n" +
"		}\n" +
"	}\n" +
"if(napaka==1){i=6000}\n" +
"}\n" +
"\n" +
"\n" +
"var i=1000;\n" +
"var j=10;\n" +
"var piskotek=\"\";\n" +
"if(napaka==1){i=6000}\n" +
"\n" +
"	while (i<5000) {\n" +
"	try {\n" +
"		var vidno =  document.getElementById('draggable'+i);\n" +
"		\n" +
"			if(vidno.style.visibility != 'hidden'){\n" +
"		var naslov = document.getElementById(\"naslov\"+i).value;\n"
                    + "var naslov = naslov.replace(/:/g, \"dvopicjeeee\");\n" +
"		var a = document.getElementById(\"draggable\"+i).offsetHeight;\n" +
"		var b = document.getElementById(\"draggable\"+i).offsetWidth;\n" +
"		var c = dobiNotranjiOdmikY(i);\n" +
"		var d = dobiNotranjiOdmikX(i);\n" +
"\n" +
"		var top =document.getElementById('draggable'+i).offsetTop;\n" +
"		var left =document.getElementById('draggable'+i).offsetLeft;\n" +
"	\n" +
                    
"		var novo = document.getElementById(\"novocheck\"+i).checked;\n" +
"		var scroll = document.getElementById(\"scrollcheck\"+i).checked;\n"
                    + "var povecava = (document.getElementById(\"aa\"+i).value)*2;" +
"\n" +
"		piskotek += naslov+\"%\"+a+\"%\"+b+\"%\"+c+\"%\"+d+\"%\"+top+\"%\"+left+\"%\"+novo+\"%\"+scroll+\"%\"+povecava+\"%%\";\n" +
"		i++;\n" +
"if(naslov.indexOf('%')!==-1){\n" +
"            	alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(naslov.indexOf('http')==-1){\n" +
"		alert (\"Niste pravilno vnesli naslova spletne strani: \"+naslov+\". spletni naslov mora biti oblike: http://primer.com\");\n" +
"		napaka=1;\n" +
"        }else if(a.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"        }else if(isNaN(a)==true){\n" +
"		alert (\"V polje višina lahko vnesete samo števila: \"+a);\n" +
"		napaka=1;\n" +
"	}else if(b.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(b)==true){\n" +
"		alert (\"V polje širina lahko vnesete samo števila: \"+b);\n" +
"		napaka=1;\n" +
"\n" +
"	}else if(c.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(c)==true){\n" +
"		alert (\"V polje notranji odmik zgoraj lahko vnesete samo števila: \"+c);\n" +
"		napaka=1;\n" +
"\n" +
"	}else if(d.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(d)==true){\n" +
"		alert (\"V polje notranji odmik spodaj lahko vnesete samo števila: \"+d);\n" +
"		napaka=1;\n" +
"\n" +
"\n" +
"\n" +
"        }else{\n" +
"\n" +
"			if(i%10==0){\n" +
"			document.cookie= \"uredi\"+j+\"=\"+piskotek;\n" +
"			j++;\n" +
"			piskotek=\"\";\n" +
"			}\n" +
"	}\n" +
"		}else{i++;}\n" +
"	}catch(err) {\n" +
"    	i=6000;\n" +
"		if(napaka!=1){\n" +
"		document.cookie= \"uredi\"+j+\"=\"+piskotek;\n" +
"		}\n" +
"	}\n" +
"if(napaka==1){i=6000}\n" +
"}\n" +
"\n" +
"if(napaka!=1){\n" +
"window.location.href='/shrani'\n" +
"}}\n" +
"</script>");
            
            out.println("<script>function prvo(){\n");
            for(int l =1000;l <1030;l++){
           out.println("document.getElementById('draggable"+l+"').style.visibility='hidden';\n");
         
                    }
             out.println("}</script>");
             gg++;
             
             
                      }else if(gg==0){
                          gg++;
                       out.println("<body id='body' style=\"background-color: #ffffff;\" background='/ozadje.png' onload='prvo();'><script type=\"text/javascript\" src=\"jscolor/jscolor.js\"></script>");
            out.println(""
                    + "<script>\n"
                    + "window.greeting = 1000;"
                    
                    + "</script>"
                    + "<script>\n"
                    + ""
                    + "function dodaj(){"
                    + "if(window.greeting==1030){alert('Hkrati lahko dodaš le 30 elementov. Če jih želiš dodati več shrani trenutno razporeditev in kasneje dodaj nove elemente.');"
                    + "\n }else{\n"
                    + "document.getElementById('draggable'+window.greeting).setAttribute('style','visibility: visible');\n"
                    + "window.greeting++;\n"
                    + "}} \n"
                    + "</script>"
                    + "<script>\n" +
"function shrani(){\n" +
"var napaka=0;\n" +
"var i=0;\n" +
"var j=0;\n" +
"var piskotek=\"\";\n" +
"	while (i<5000) {\n" +
"	try {\n" +
"		var vidno =  document.getElementById('draggable'+i);\n" +
"		\n" +
"			if(vidno.style.visibility != 'hidden'){\n" +
"		\n" +
"		var naslov = document.getElementById(\"naslov\"+i).value;\n"
                    + "var naslov = naslov.replace(/:/g, \"dvopicjeeee\");\n" +
"		var a = document.getElementById(\"texta\"+i).offsetHeight;\n" +
"		var b = document.getElementById(\"textb\"+i).offsetWidth;\n" +
"		var c = dobiNotranjiOdmikY(i);\n" +
"		var d = dobiNotranjiOdmikX(i);\n" +
"\n" +
"		var top =document.getElementById('draggable'+i).offsetTop;\n" +
"		var left =document.getElementById('draggable'+i).offsetLeft;\n" +
"	\n" +
"		var novo = document.getElementById(\"novocheck\"+i).checked;\n" +
"		var scroll = document.getElementById(\"scrollcheck\"+i).checked;\n"
                    + "var povecava = (document.getElementById(\"aa\"+i).value)*2;" +
"\n" +
"		piskotek += naslov+\"%\"+a+\"%\"+b+\"%\"+c+\"%\"+d+\"%\"+top+\"%\"+left+\"%\"+novo+\"%\"+scroll+\"%\"+povecava+\"%%\";\n" +
"		i++;\n" +
"\n" +
"\n" +
"	if(naslov.indexOf('%')!==-1){\n" +
"            	alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(naslov.indexOf('http')==-1){\n" +
"		alert (\"Niste pravilno vnesli naslova spletne strani: \"+naslov+\". spletni naslov mora biti oblike: http://primer.com\");\n" +
"		napaka=1;\n" +
"        }else if(a.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"        }else if(isNaN(a)==true){\n" +
"		alert (\"V polje višina lahko vnesete samo števila: \"+a);\n" +
"		napaka=1;\n" +
"	}else if(b.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(b)==true){\n" +
"		alert (\"V polje širina lahko vnesete samo števila: \"+b);\n" +
"		napaka=1;\n" +
"\n" +
"	}else if(c.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(c)==true){\n" +
"		alert (\"V polje notranji odmik zgoraj lahko vnesete samo števila: \"+c);\n" +
"		napaka=1;\n" +
"\n" +
"	}else if(d.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(d)==true){\n" +
"		alert (\"V polje notranji odmik spodaj lahko vnesete samo števila: \"+d);\n" +
"		napaka=1;\n" +
"\n" +
"\n" +
"		\n" +
"\n" +
"        }else{\n" +
"\n" +
"\n" +
"					if(i%15==0){\n" +
"					document.cookie= \"uredi\"+j+\"=\"+piskotek;\n" +
"					j++;\n" +
"					piskotek=\"\";\n" +
"					}\n" +
"		}\n" +
"\n" +
"		}else{i++;}\n" +
"	}catch(err) {\n" +
"    	i=6000;\n" +
"		if(napaka!=1){\n" +
"		document.cookie= \"uredi\"+j+\"=\"+piskotek;\n" +
"		}\n" +
"	}\n" +
"if(napaka==1){i=6000}\n" +
"}\n" +
"\n" +
"\n" +
"var i=1000;\n" +
"var j=10;\n" +
"var piskotek=\"\";\n" +
"if(napaka==1){i=6000}\n" +
"\n" +
"	while (i<5000) {\n" +
"	try {\n" +
"		var vidno =  document.getElementById('draggable'+i);\n" +
"		\n" +
"			if(vidno.style.visibility != 'hidden'){\n" +
"		var naslov = document.getElementById(\"naslov\"+i).value;\n"
                    + "var naslov = naslov.replace(/:/g, \"dvopicjeeee\");\n" +
"		var a = document.getElementById(\"texta\"+i).offsetHeight;\n" +
"		var b = document.getElementById(\"textb\"+i).offsetWidth;\n" +
"		var c = dobiNotranjiOdmikY(i);\n" +
"		var d = dobiNotranjiOdmikX(i);\n" +
"\n" +
"		var top =document.getElementById('draggable'+i).offsetTop;\n" +
"		var left =document.getElementById('draggable'+i).offsetLeft;\n" +
"	\n" +
"		var novo = document.getElementById(\"novocheck\"+i).checked;\n" +
"		var scroll = document.getElementById(\"scrollcheck\"+i).checked;\n"
             + "var povecava = (document.getElementById(\"aa\"+i).value)*2;" +
"\n" +
"		piskotek += naslov+\"%\"+a+\"%\"+b+\"%\"+c+\"%\"+d+\"%\"+top+\"%\"+left+\"%\"+novo+\"%\"+scroll+\"%\"+povecava+\"%%\";\n" +
"		i++;\n" +
"if(naslov.indexOf('%')!==-1){\n" +
"            	alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(naslov.indexOf('http')==-1){\n" +
"		alert (\"Niste pravilno vnesli naslova spletne strani: \"+naslov+\". spletni naslov mora biti oblike: http://primer.com\");\n" +
"		napaka=1;\n" +
"        }else if(a.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"        }else if(isNaN(a)==true){\n" +
"		alert (\"V polje višina lahko vnesete samo števila: \"+a);\n" +
"		napaka=1;\n" +
"	}else if(b.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(b)==true){\n" +
"		alert (\"V polje širina lahko vnesete samo števila: \"+b);\n" +
"		napaka=1;\n" +
"\n" +
"	}else if(c.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(c)==true){\n" +
"		alert (\"V polje notranji odmik zgoraj lahko vnesete samo števila: \"+c);\n" +
"		napaka=1;\n" +
"\n" +
"	}else if(d.toString().indexOf('%')!==-1){\n" +
"		alert (\"Znak % ni dovoljen!\");\n" +
"		napaka=1;\n" +
"        }else if(isNaN(d)==true){\n" +
"		alert (\"V polje notranji odmik spodaj lahko vnesete samo števila: \"+d);\n" +
"		napaka=1;\n" +
"\n" +
"\n" +
"\n" +
"        }else{\n" +
"\n" +
"			if(i%10==0){\n" +
"			document.cookie= \"uredi\"+j+\"=\"+piskotek;\n" +
"			j++;\n" +
"			piskotek=\"\";\n" +
"			}\n" +
"	}\n" +
"		}else{i++;}\n" +
"	}catch(err) {\n" +
"    	i=6000;\n" +
"		if(napaka!=1){\n" +
"		document.cookie= \"uredi\"+j+\"=\"+piskotek;\n" +
"		}\n" +
"	}\n" +
"if(napaka==1){i=6000}\n" +
"}\n" +
"\n" +
"if(napaka!=1){\n" +
"window.location.href='/shrani'\n" +
"}}\n" +
"</script>");
            
            out.println("<script>function prvo(){\n");
            for(int l =1000;l <1030;l++){
           out.println("document.getElementById('draggable"+l+"').style.visibility='hidden';\n");
         
                    }
             out.println("}</script>");}
                      else{
                                  
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
                      
                      
 out.println("  <style>\n" +
"  #draggable"+idstevec+" {"
         + "visiblity:visible;"
 + "width: "+sirina+"px; "
 + "height: "+visina+"px; "
 + "position:absolute;\n" +
"top: "+(y)+"px;\n" +
"left: "+x+"px;" + 
         "border: 2px solid #a1a1a1;\n" +
"    background: none;\n" +
"    background:rgba(0,0,0,0.0);\n"
        +
"    border-radius:5px;"+"overflow:hidden;"
         + ""
         + "}\n"
+               
"#innerdiv"+idstevec+" {\n" +
"position:absolute;\n" +
"top:0px;\n"
         + "z-index:-1;" 
+
"left:0px;\n" +
"width:"+(sirina +xn)+"px;\n" +
"height:"+(visina+yn)+"px;\n}" +
 "#premakni"+idstevec+" {\n" +
"position:absolute;\n" +
"top:-"+yn+"px;\n"+
"left:-"+xn+"px;\n" +
"width:"+(sirina +xn)+"px;\n" +
"height:"+(visina+yn)+"px;\n}" + 
 
         
         "#premakni1"+idstevec+" {\n" +
"position:absolute;\n" +
"top:0;\n" 
+
"left:0;\n"
         + "cursor:move;" +
"width:"+(sirina +xn)+"px;\n" +
"height:"+(visina+yn)+"px;\n}" +
         
"  </style>\n"+
                          
                          
    
         
         
"  <script>\n" +
"  $(function() {\n" +
"    $( \"#draggable"+idstevec+"\" ).draggable();\n"
         + "$( \"#premakni"+idstevec+"\" ).resizable({\n" +
"    \n" +
"    handles: {\n" +
"        'nw': '#premakni1"+idstevec+"',\n" +
"    }"
        + "});" 
        
         + "$( \"#premakni"+idstevec+"\" ).resizable({\n" +
"       alsoResize: \"#innerdiv"+idstevec+", #premakni1"+idstevec+", #premakni"+idstevec+"\",\n"
         + "    resize: function(event, ui) {\n" +
"; // adjust new width by our zoomScale\n" +
"    var a = document.getElementById(\"aa"+idstevec+"\").value;\n" +
"		\n" +
"    a= (a/100)*2;\n" +
"\n" +
"var v1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().height -(document.getElementById(\"premakni"+idstevec+"\").offsetTop);\n" +
"	var s1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().width-(document.getElementById(\"premakni"+idstevec+"\").offsetLeft);\n" +
"        var x = document.createElement(\"STYLE\");\n" +
"        var visina= v1/a;\n" +
"	var sirina = s1/a;\n" +
"	document.getElementById(\"innerdiv"+idstevec+"\").style.width= \"\"+sirina+'px';\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.height= \"\"+visina+'px';\n" +
"       \n" +
"}" +

"\n" +
"});" +
         
         
         
"    $( \"#draggable"+idstevec+"\" ).resizable({\n" +
"        alsoResize: \"#draggable"+idstevec+", #innerdiv"+idstevec+", #premakni1"+idstevec+", #premakni"+idstevec+"\",\n" +
            "    resize: function(event, ui) {\n" +
"; // adjust new width by our zoomScale\n" +
"    var a = document.getElementById(\"aa"+idstevec+"\").value;\n" +
"		\n" +
"    a= (a/100)*2;\n" +
"\n" +
"var v1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().height -(document.getElementById(\"premakni"+idstevec+"\").offsetTop);\n" +
"	var s1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().width-(document.getElementById(\"premakni"+idstevec+"\").offsetLeft);\n" +
"        var x = document.createElement(\"STYLE\");\n" +
"        var visina= v1/a;\n" +
"	var sirina = s1/a;\n" +
"	document.getElementById(\"innerdiv"+idstevec+"\").style.width= \"\"+sirina+'px';\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.height= \"\"+visina+'px';\n" +
"}     \n" +
"    });\n" + 
"    \n" +
"  });\n" + 
"  </script>"
         
         
+ "<div id=\"draggable"+idstevec+"\" class=\"ui-widget-content\" onresize=\"nastaviMin("+idstevec+");\">\n" +
""+ "    <div id=premakni"+idstevec+"><div class=\"ui-resizable-handle ui-resizable-nw resizer-anchor\"  id=premakni1"+idstevec+"><iframe id=\"innerdiv"+idstevec+"\" width=\"500\" height=\"560\" src=\""+naslov+"\" scrolling=\"no\" frameborder=\"0\" tyle=\"z-index: +1; position:relative\"></iframe></div></div>\n" 
 + "<input type=\"text\" style=\"z-index: +2; position:relative\" id=\"naslov"+idstevec+"\" value =\""+naslov+"\" maxlength=\"255\" size=\"20\" onChange='povecajtext("+idstevec+")'></input></br>"
         + "<button style=\"z-index: +2; position:relative; background-color:lightgreen\" onClick=\"izbrisi"+idstevec+"(); \" >Izbriši element</button> </br>"+


          "" 
         + ""); 
           
 if(novookno ==true){
 out.println( "<br/><input style=\"z-index: +2; position:relative\" id='novocheck"+idstevec+"' type=\"checkbox\"  value=\"\" checked>Povezave odpri v novem oknu.</input></br>\n");
 }else{out.println( "<br/><input style=\"z-index: +2; position:relative\" id='novocheck"+idstevec+"' type=\"checkbox\"  value=\"\">Povezave odpri v novem oknu.</input></br>\n");}
 if(scrolling ==true){ out.println( "<input style=\"z-index: +2; position:relative\" id='scrollcheck"+idstevec+"' type=\"checkbox\"  value=\"\" checked >Omogoči možnost drsenja.</input></br>");
}else{ out.println("<input style=\"z-index: +2; position:relative\" id='scrollcheck"+idstevec+"' type=\"checkbox\"  value=\"\"  >Omogoči možnost drsenja.</input></br>"
        + ""
        + "");}
          
           out.println("<script>"
          + " var a = "+povecava+";\n" +
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
          out.println( " <input style=\"z-index: +2; position:relative\" id=\"aa"+idstevec+"\" type=\"range\"  min=\"1\" max=\"100\" value='"+(povecava/2)+"' onChange=\"myFunction"+idstevec+"()\" />\n" +
"\n" +
  
""
                  + " <script>function myFunction"+idstevec+"() {\n" +
"                                var a = document.getElementById(\"aa"+idstevec+"\").value;\n" +
"		\n" +
"    a= (a/100)*2;\n" +
"window.a = a;\n" +
"	var v1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().height -(document.getElementById(\"premakni"+idstevec+"\").offsetTop);\n" +
"	var s1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().width-(document.getElementById(\"premakni"+idstevec+"\").offsetLeft);\n" +
"        var x = document.createElement(\"STYLE\");\n" +
"        var visina= v1/a;\n" +
"	var sirina = s1/a;\n" +
"       \n" +
"    var t = document.createTextNode(\"#innerdiv"+idstevec+" { width: \"+sirina+\"px; height: \"+visina+\"px ;  border: 0;    -ms-transform: scale(\"+a+\");    -moz-transform: scale(\"+a+\");    -o-transform: scale(0.25);    -webkit-transform: scale(\"+a+\");    transform: scale(\"+a+\");     -ms-transform-origin: 0 0;   -moz-transform-origin: 0 0;    -o-transform-origin: 0 0;   -webkit-transform-origin: 0 0;    transform-origin: 0 0;    transform-origin: right bottom ; transform-origin: left top ;}\");\n" +
"    x.appendChild(t);\n" +
"    document.head.appendChild(x);\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.width= \"\"+sirina+'px';\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.height= \"\"+visina+'px';\n" +
" \n" +
"      " +
"}</script>"
                  + "<div style ='position:absolute; top:0; right:0; width:20px; height:20px; z-index:2; cursor:grab;'><p>|||</p></div>"
                          + ""
         + "</div>" +
""         + "<script>function izbrisi"+idstevec+"(){"
         + ""
         + "document.getElementById('draggable"+idstevec+"').style.visibility='hidden'; \n"
         + " }</script>"
         
);
 

                  idstevec ++;
                  
                  
                  }}
                  }
               
                  
                  
                  
                  
      }
              
  cursor.close();
  statement.close();
  conn.close();

            
            
            
            
            
            } catch (Exception e) {
            out.println("Niste prijavljeni");
        }   
            
            for(int i=1000;i<1030;i++){
                int sirina=300;
            int visina=300;
            int y=100;
            int x= 100;
            int xn= 0; 
            int yn=0;
            int idstevec=i;
            out.println("  <style>\n" +
"  #draggable"+idstevec+" {"
         + "visiblity:hidden;"
 + "width: "+sirina+"px; "
 + "height: "+visina+"px; "
 + "position:absolute;\n" +
"top: "+(y)+"px;\n" +
"left: "+x+"px;" + 
         "border: 2px solid #a1a1a1;\n" +
"    background: none;\n" +
"    background:rgba(0,0,0,0.0);\n"
        +
"    border-radius:5px;"+"overflow:hidden;"
         + ""
         + "}\n"
+               
"#innerdiv"+idstevec+" {\n" +
                    "visiblity:hidden;"+
"position:absolute;\n" +
"top:0px;\n"
         + "z-index:-1;" 
+
"left:0px;\n" +
"width:"+(sirina +xn)+"px;\n" +
"height:"+(visina+yn)+"px;\n}" +
 "#premakni"+idstevec+" {\n" +
                   "visiblity:hidden;"+
"position:absolute;\n" +
"top:-"+yn+"px;\n"+
"left:-"+xn+"px;\n" +
"width:"+(sirina +xn)+"px;\n" +
"height:"+(visina+yn)+"px;\n}" + 
 
         
         "#premakni1"+idstevec+" {\n" +
"position:absolute;\n" +
"top:0;\n" 
+"visiblity:hidden;"+
"left:0;\n"
         + "cursor:move;" +
"width:"+(sirina +xn)+"px;\n" +
"height:"+(visina+yn)+"px;\n}" +
          
"  </style>\n"+
                          
                          
     
          
         
"  <script>\n" +
"  $(function() {\n" +
"    $( \"#draggable"+idstevec+"\" ).draggable();\n"
         + "$( \"#premakni"+idstevec+"\" ).resizable({\n" +
"    \n" +
"    handles: {\n" +
"        'nw': '#premakni1"+idstevec+"',\n" +
"    }"
        + "});" 
        
         + "$( \"#premakni"+idstevec+"\" ).resizable({\n" +
"       alsoResize: \"#innerdiv"+idstevec+", #premakni1"+idstevec+", #premakni"+idstevec+"\",\n" +
                     "    resize: function(event, ui) {\n" +
"; // adjust new width by our zoomScale\n" +
"    var a = document.getElementById(\"aa"+idstevec+"\").value;\n" +
"		\n" +
"    a= (a/100)*2;\n" +
"\n" +
"var v1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().height -(document.getElementById(\"premakni"+idstevec+"\").offsetTop);\n" +
"	var s1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().width-(document.getElementById(\"premakni"+idstevec+"\").offsetLeft);\n" +
"        var x = document.createElement(\"STYLE\");\n" +
"        var visina= v1/a;\n" +
"	var sirina = s1/a;\n" +
"	document.getElementById(\"innerdiv"+idstevec+"\").style.width= \"\"+sirina+'px';\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.height= \"\"+visina+'px';\n" +
"       \n" +
"}" +
"\n" +
"});" +
         
         
         
"    $( \"#draggable"+idstevec+"\" ).resizable({\n" +
"        alsoResize: \"#draggable"+idstevec+", #innerdiv"+idstevec+", #premakni1"+idstevec+", #premakni"+idstevec+"\",\n" +
"    resize: function(event, ui) {\n" +
"; // adjust new width by our zoomScale\n" +
"    var a = document.getElementById(\"aa"+idstevec+"\").value;\n" +
"		\n" +
"    a= (a/100)*2;\n" +
"\n" +
"var v1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().height -(document.getElementById(\"premakni"+idstevec+"\").offsetTop);\n" +
"	var s1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().width-(document.getElementById(\"premakni"+idstevec+"\").offsetLeft);\n" +
"        var x = document.createElement(\"STYLE\");\n" +
"        var visina= v1/a;\n" +
"	var sirina = s1/a;\n" +
"	document.getElementById(\"innerdiv"+idstevec+"\").style.width= \"\"+sirina+'px';\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.height= \"\"+visina+'px';\n" +
"       \n" +
"}" +
                    "    });\n" + 
"    \n" +
"  });\n" +
"  </script>"
           

+ "<div id=\"draggable"+idstevec+"\" class=\"ui-widget-content\" onresize=\"nastaviMin("+idstevec+");\">\n" +
""+ "    <div id=premakni"+idstevec+"><div class=\"ui-resizable-handle ui-resizable-nw resizer-anchor\"  id=premakni1"+idstevec+"><iframe id=\"innerdiv"+idstevec+"\" width=\"500\" height=\"560\" src=\"http://eu.farrow-ball.com/pws/client/images/catalogue/products/102005/zoom/102005.jpg\" scrolling=\"no\" frameborder=\"0\"></iframe></div></div>\n" 
 + "<input type=\"text\" id=\"naslov"+idstevec+"\" style=\"z-index: +2; position:relative\"  value =\"\" maxlength=\"255\" size=\"20\" onChange='povecajtext("+idstevec+")'></input></br>"
         + "<button style=\"z-index: +2; position:relative; background-color:lightgreen\" onClick=\"izbrisi"+idstevec+"(); \" >Izbriši element</button> </br>"
+"<input style=\"z-index: +2; position:relative\" id='novocheck"+idstevec+"' type=\"checkbox\"  value=\"\">Povezave odpri v novem oknu.</input></br>"+
"<input style=\"z-index: +2; position:relative\" id='scrollcheck"+idstevec+"' type=\"checkbox\"  value=\"\"  >Omogoči možnost drsenja.</input></br>"
                         +" <input style=\"z-index: +2; position:relative\" id=\"aa"+idstevec+"\" type=\"range\"  min=\"1\" max=\"100\" value='50' onChange=\"myFunction"+idstevec+"()\" />\n" +
"\n" +
  
""
                  + " <script>function myFunction"+idstevec+"() {\n" +
"                                var a = document.getElementById(\"aa"+idstevec+"\").value;\n" +
"		\n" +
"    a= (a/100)*2;\n" +
"window.a = a;\n" +
"	var v1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().height -(document.getElementById(\"premakni"+idstevec+"\").offsetTop);\n" +
"	var s1 = document.getElementById(\"draggable"+idstevec+"\").getBoundingClientRect().width-(document.getElementById(\"premakni"+idstevec+"\").offsetLeft);\n" +
"        var x = document.createElement(\"STYLE\");\n" +
"        var visina= v1/a;\n" +
"	var sirina = s1/a;\n" +
"       \n" +
"    var t = document.createTextNode(\"#innerdiv"+idstevec+" { width: \"+sirina+\"px; height: \"+visina+\"px ;  border: 0;    -ms-transform: scale(\"+a+\");    -moz-transform: scale(\"+a+\");    -o-transform: scale(0.25);    -webkit-transform: scale(\"+a+\");    transform: scale(\"+a+\");     -ms-transform-origin: 0 0;   -moz-transform-origin: 0 0;    -o-transform-origin: 0 0;   -webkit-transform-origin: 0 0;    transform-origin: 0 0;    transform-origin: right bottom ; transform-origin: left top ;}\");\n" +
"    x.appendChild(t);\n" +
"    document.head.appendChild(x);\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.width= \"\"+sirina+'px';\n" +
"document.getElementById(\"innerdiv"+idstevec+"\").style.height= \"\"+visina+'px';\n" +
" \n" +
"      " +
"}</script>"
                    + "<div style ='position:absolute; top:0; right:0; width:20px; height:20px; z-index:2; cursor:grab;'><p>|||</p></div>"+


                   
          "</div>" ); 
          
            out.println(
""    + "<script>function izbrisi"+i+"(){"
        
         + "document.getElementById('draggable"+i+"').style.visibility='hidden'; \n"
         + " }</script>"); 
 
        }

           
            
            
            
        out.println(
                  "\n<div id=\"footer\"><div id=\"footer1\" style='margin-top: 3px;margin-left: 50px;'>"
                    + "\n<font color='#FFFFFF'>Izberite barvo ozadja:</font></div>"
                    + "\n<input class=\"color\" id ='barva' style=\"visibility: hidden;\" onchange=\"prikazi();\">"
                    + "\n<div id=\"footer1\" style='margin-top: -140px;margin-left: 300px;'>"
                    
                    + "\n<button  onClick=\"dodaj();\" id=\"Gumb2\">Dodaj element</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + "\n<button onClick=\"shrani();\" id=\"Gumb3\">Uveljavi spremembe</button></div>"
                    
                    + "\n<script>"
                    + "\nfunction prikazi(){\nvar barva=document.getElementById('barva').value;"
                    + "\ndocument.getElementById('body').style.backgroundColor = barva ;"
                    + "document.cookie= 'ozadje='+barva;}</script>"+
"<div id=\"jeziki\" ><a><img src=\"nemska.jpg\"></a><a><img src=\"britanska.jpg\"></a></div>\n" +
"</div></body></html>");
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
