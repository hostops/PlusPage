# PlusPage
My first web application.
In the second year of high school me and my schoolmates created PlusPage - a personal dashboard page, which was similar to dead iGoogle.
Now I renewed it - Just for fun. 

When I now look at the code it is a real mess and it is highly unsecure. So hacking is not allowed - we were 16.

A few technical details - Just to see how bad it is :) :
- It is made using Java servlets. 
I did not know forms and HTTP requests. The only way to transfer data from a client to the server I knew at the time was using cookies (because the browser automaticly sends them to the server for each request). I saw that in one example.
- So the data is transfered using cookies.
- It uses mySQL - all data is stored in one table. Example: if you add two pages it copies all the user's data to a new row. And it also made me angry because If I removed a row in the table there was an ID missing. So when it adds a new row it first fills the missing ID. 
- All SQL queries are without WHERE clause. It filters the records manually in the servlets.
- Most HTML is given from the servlets in strings. The same goes for JS and CSS.
  Example: out.println("<title>PLUSPAGE Domov</title>"
                    + "<style>#footer {\n" ...
Current available domains for the page:
  pluspage.tk 
  pluspage.ml 
  pluspage.ga 
  pluspage.cf 
  pluspage.gq 
  pluspage-web-plus-page.193b.starter-ca-central-1.openshiftapps.com
  
  PS: If you are going to test this page please use different password than you use on other sites. Because passwords are stored in plain text. 
  And I recommend fake data - email can be fake too, there is no confirmation email.
