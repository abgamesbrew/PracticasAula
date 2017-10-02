package es.albarregas.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Juan Manuel Diaz Rivas
 */
@WebServlet(name = "Registro", urlPatterns = {"/registro"})
public class Registro extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)//** Si la peticion viene por do get.. haremos que salte una página especial **//
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">");
            out.println("<link rel=\"stylesheet\" href=\"CSS/Holamundo.css\"/>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"todo\">");
            out.println("<h1>Datos no introducidso en el formulario</h1>");
            out.println("<p>No se han introducido datos en el formulario</p>");
            out.println("<p><a href=\"index.html\">volver al inicio!</a></p>");
            out.println("<div>");
            out.println("</body>");
         }
    }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)//** Si la petición viene por post mostramos los datos **//
            throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");//** todas las variables podran contener caracteres utf-8 gracias a este método **//
    response.setContentType("text/html;charset=UTF-8");
    
    Map<String,String[]> mapa=request.getParameterMap();
    //**inicio bloque comprobacion de fecha**//
    String[] fechia =mapa.get("Ano");
    String ano=fechia[0];
    fechia = mapa.get("Mes");
    String mes= fechia[0];
    fechia = mapa.get("Dia");
    String dia= fechia[0];
    boolean fechacorrecta=comprobarFecha(ano,mes,dia);//** metodo de validación de fechas **//
    //** fin de la comprobacion de fecha **//          
   
    
    if(request.getParameter("Nombre")== "" || request.getParameter("Usuario") == "" || request.getParameter("Contrasena")== "" || fechacorrecta==false){//** si un campo requerido o la fecha no esta bien pasamos por este if **//
        if(request.getParameter("enviado") != null){//** si venimos del formulario de error de datos nos pasamos de nuevo al formulario principal **//
          formulario(response,request,mapa,fechacorrecta);  
        }
        else{//** salta si hay error en el formulario principal y recoge los datos de nuevo**//
            String[] elementos= null;//** guardamos el array de string de cada elemento del formulario **//
            String elemento=null;//** aqui guardamos el valor de cada uno de los valores del elemento del array **//
           try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">");
            out.println("<link rel=\"stylesheet\" href=\"CSS/Holamundo.css\"/>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"todo\">");
            out.println("<h1>Errores en el registro</h1>");
            out.println("<form action=\"/PracticasAula/registro\" method=\"post\">");//** inicio del formulario
            
            elementos=mapa.get("Nombre");
            out.println("<input type=\"hidden\" name=\"Nombre\" value=\""+elementos[0]+"\" >");
            
            
            elementos=mapa.get("Apellidos");
            out.println("<input type=\"hidden\" name=\"Apellidos\" value=\""+elementos[0]+"\" >");
            
            
            elementos=mapa.get("Sexo");
            if(elementos[0] == null){//** si aqui no tenemos nada, es porque por defecto el valor era hombre y el cliente no lo ha tocado **//
            elemento="Hombre";   
            }
            elemento=elementos[0];
            out.println("<input type=\"hidden\" name=\"Sexo\" value=\""+elemento+"\" >");
            
            
            elementos=mapa.get("Dia");
            out.println("<input type=\"hidden\" name=\"Dia\" value=\""+elementos[0]+"\" >");
            
            
            elementos=mapa.get("Mes");
            out.println("<input type=\"hidden\" name=\"Mes\" value=\""+elementos[0]+"\" >");
            
            
            elementos=mapa.get("Ano");
            out.println("<input type=\"hidden\" name=\"Ano\" value=\""+elementos[0]+"\" >");
            
            
            elementos=mapa.get("Usuario");
            out.println("<input type=\"hidden\" name=\"Usuario\" value=\""+elementos[0]+"\" >");
            
            
            elementos=mapa.get("Contrasena");
            out.println("<input type=\"hidden\" name=\"Contrasena\" value=\""+elementos[0]+"\" >");
            
            
            elementos=mapa.get("Preferencia");
            if (elementos != null){
              for (int i=0;i<=elementos.length-1;i++){//** como "Preferencia" tiene mas de un valor asociado creamos un bucle for para recorrerlo y guardar segun vayamos recibiendo **//
                    elemento=elementos[i];
                    out.println("<input type=\"hidden\" name=\"Preferencia\" value=\""+elemento+"\" >");   
                }   
            }
                  
            
            out.println("<input type=\"hidden\" name=\"Preferencia\" value=\""+elemento+"\" >");
            out.println("<input type=\"submit\" name=\"enviado\" value=\"Volver\" >");
            out.println("</form>");
            out.println("<div>");
            out.println("</body>");
         } 
        }
        
        
        
        
    }
        String valor1="";
        String valor2="";
        String valor3="";
        String[] valores=null; //** contendrá el array de valores asociado a cada input **//
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
            out.println("<link rel=\"stylesheet\" href=\"CSS/Holamundo.css\"/>");
            out.println("<title>Servlet Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"todo\">");
            out.println("<h1>Registro completado con éxito</h1>");
            
            //**inicio asignacion nombre y apellidos **//
            valores=mapa.get("Nombre");
            valor1=valores[0];
            valores=mapa.get("Apellidos");
            valor2=valores[0];
            out.println("<p>Nombre y Apellidos: <strong>"+valor1+"  "+valor2+"</strong></p>");
            
            //** inicio asignacion sexo **//
            valores=mapa.get("Sexo");
            out.println("<p>Sexo: <strong>"+valores[0]+"</strong></p>");
            
            //** inicio asignacion fecha nacimiento **//
            valores=mapa.get("Dia");
            valor1=valores[0];
            valores=mapa.get("Mes");
            valor2=valores[0];
            int numero=Integer.parseInt(valor2)-1;//** contiene el numero del mes y se le resta uno para que seleccione bien en el array de meses **//
            valores=mapa.get("Ano");
            valor3=valores[0];
            String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            out.println("<p>Fecha de nacimiento: <strong>"+valor1+" de "+meses[numero]+" de "+valor3+"</strong></p>");
            
            //** inicio asignacion usuario **//
            valores=mapa.get("Usuario");
            out.println("<p>Usuario: <strong>"+valores[0]+"</strong></p>");
            
            //** inicio asignacion contraseña **//
            valores=mapa.get("Contrasena");
            out.println("<p>Contraseña: <strong>"+valores[0]+"</strong></p>");
            
            //** inicio asignacion aficiones **//
            valores=mapa.get("Preferencia");
            if (valores != null){
                 out.print("<p>Preferencias: <strong>");
              for(int i=0;i<=valores.length-1;i++){
                  if(i==valores.length-1){//** si estamos en la última vuelta añadimos un punto para finalizar **//
                    out.print(valores[i]+".");   
                  }
                  else{
                    out.print(valores[i]+",");   
                  }
              }
              out.print("</strong></p>");
            }
            
            out.println("<p><a href=\"index.html\">volver al inicio!</a></p>");
            out.println("<div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public String getServletInfo() {
        return "Servlet de registro";
    }// </editor-fold>
    
    
    public void formulario(HttpServletResponse response,HttpServletRequest request, Map<String, String[]> mapa,boolean fechacorrecta) throws IOException{
         
         try (PrintWriter out = response.getWriter()) {
            String[] elementos= null;//** guardamos los valores de cada uno de los elementos del formulario **//
            String elemento=null;
             out.print("<html>\n" +
"              <head>\n" +
"                  <title>Formulario complejo</title>\n" +
"                  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"                  <link rel=\"stylesheet\" href=\"/PracticasAula/CSS/form.css\"/>\n" +
"              </head>\n" +
"              <body>\n" +
"                  <div id=\"centro\">\n" +
"                      <h1>Registrate</h1>\n" +
"                      <div id=\"errores\">" +//** en este div iran contenidos los avisos de los errores en la inserccion **//
"                      <h1>Problemas con el registro</h1>" );
                        if(request.getParameter("Nombre") == ""){
                            out.print("<p> El campo nombre es obligatorio</p>");
                        }
                        if(request.getParameter("Usuario") == ""){
                            out.print("<p> El campo usuario es obligatorio</p>");
                        }
                        if(request.getParameter("Contrasena") == ""){
                            out.print("<p> El campo contraseña es obligatorio</p>");
                        }
                        if(fechacorrecta == false){
                            out.print("<p> Fecha de nacimiento incorrecta</p>");
                        }
                        out.print("</div>\n" +
"                      <form action=\"/PracticasAula/registro\" method=\"post\" name=\"registro\">\n" +
"                          <fieldset>\n" +
"                              <legend>Informacion personal</legend>\n" +
"                              <table>\n" +
"                          <tr>\n" +
"                              <td>\n" +
"                                  <label>*Nombre</label>\n" +
"                              </td>\n" +
"                              <td>\n");
                                elementos=mapa.get("Nombre");//** extraemos los string que contenga el input llamado nombre **//
                                out.print("<input type=\"text\" name=\"Nombre\" value=\""+elementos[0]+"\"> \n" +
"                              </td>\n" +
"                          </tr>\n" +
"                          <tr>\n" +
"                              <td>\n" +
"                                  <label>Apellidos</label>\n" +
"                              </td>\n" +
"                              <td>\n");
                                elementos=mapa.get("Apellidos");
                                out.print("<input type=\"text\" name=\"Apellidos\" value=\""+elementos[0]+"\"> \n" +
"                              </td>\n" +
"                          </tr>\n" +
"                          <tr>\n" +
"                              <td>\n" +
"                                  <label>Sexo: </label>\n" +
"                              </td>\n" +
"                               <td>\n");
                                elementos=mapa.get("Sexo");
                                elemento=elementos[0];
                                if(elemento.equals("Hombre")){
                                    out.print("<input type=\"radio\" id=\"estado1\" name=\"Sexo\" value=\"Hombre\" checked=\"checked\">\n" +
"                                  <label for=\"estado1\">Hombre</label>\n" +
"                                  <br/>\n" +
"                                  <input type=\"radio\" id=\"estado2\" name=\"Sexo\" value=\"Mujer\">\n" +
"                                  <label for=\"estado1\">Mujer</label>\n");
                                }
                                else{
                                 out.print("<input type=\"radio\" id=\"estado1\" name=\"Sexo\" value=\"Hombre\">\n" +
"                                  <label for=\"estado1\">Hombre</label>\n" +
"                                  <br/>\n" +
"                                  <input type=\"radio\" id=\"estado2\" name=\"Sexo\" value=\"Mujer\" checked=\"Checked\">\n" +
"                                  <label for=\"estado1\">Mujer</label>\n");   
                                }
                                out.print("</td>\n" +
"                          </tr>\n" +
"                          <tr>\n" +
"                              <td>\n" +
"                                  <label>Fecha de nacimiento: </label>\n" +
"                              </td>\n" +
"                              <td>\n" +
"                                  <select name=\"Dia\"><!-- se crea una lista desplegable -->\n" +
"                                     <optgroup>\n" +
"                                      <option vale=\"01\">01</option>\n" +
"                                      <option vale=\"02\">02</option>\n" +
"                                      <option vale=\"03\">03</option>\n" +
"                                      <option vale=\"04\">04</option>\n" +
"                                      <option vale=\"05\">05</option>\n" +
"                                      <option vale=\"06\">06</option>\n" +
"                                      <option vale=\"07\">07</option>\n" +
"                                      <option vale=\"08\">08</option>\n" +
"                                      <option vale=\"09\">09</option>\n" +
"                                      <option vale=\"10\">10</option>\n" +
"                                      <option vale=\"11\">11</option>\n" +
"                                      <option vale=\"12\">12</option>\n" +
"                                      <option vale=\"13\">13</option>\n" +
"                                      <option vale=\"14\">14</option>\n" +
"                                      <option vale=\"15\">15</option>\n" +
"                                      <option vale=\"16\">16</option>\n" +
"                                      <option vale=\"17\">17</option>\n" +
"                                      <option vale=\"18\">18</option>\n" +
"                                      <option vale=\"19\">19</option>\n" +
"                                      <option vale=\"20\">20</option>\n" +
"                                      <option vale=\"21\">21</option>\n" +
"                                      <option vale=\"22\">22</option>\n" +
"                                      <option vale=\"23\">23</option>\n" +
"                                      <option vale=\"24\">24</option>\n" +
"                                      <option vale=\"25\">25</option>\n" +
"                                      <option vale=\"26\">26</option>\n" +
"                                      <option vale=\"27\">27</option>\n" +
"                                      <option vale=\"28\">28</option>\n" +
"                                      <option vale=\"29\">29</option>\n" +
"                                      <option vale=\"30\">30</option>\n" +
"                                      <option vale=\"31\">31</option>\n" +
"                                     </optgroup> \n" +
"                                  </select>\n" +
"                                  <select name=\"Mes\"><!-- se crea una lista desplegable -->\n" +
"                                     <optgroup>\n" +
"                                      <option vale=\"01\">01</option>\n" +
"                                      <option vale=\"02\">02</option>\n" +
"                                      <option vale=\"03\">03</option>\n" +
"                                      <option vale=\"04\">04</option>\n" +
"                                      <option vale=\"05\">05</option>\n" +
"                                      <option vale=\"06\">06</option>\n" +
"                                      <option vale=\"07\">07</option>\n" +
"                                      <option vale=\"08\">08</option>\n" +
"                                      <option vale=\"09\">09</option>\n" +
"                                      <option vale=\"10\">10</option>\n" +
"                                      <option vale=\"11\">11</option>\n" +
"                                      <option vale=\"12\">12</option>\n" +
"                                     </optgroup> \n" +
"                                  </select>\n" +
"                                  <select name=\"Ano\"><!-- se crea una lista desplegable -->\n" +
"                                     <optgroup>\n" +
"                                      <option vale=\"1950\">1950</option>\n" +
"                                      <option vale=\"1951\">1951</option>\n" +
"                                      <option vale=\"1952\">1952</option>\n" +
"                                      <option vale=\"1953\">1953</option>\n" +
"                                      <option vale=\"1954\">1954</option>\n" +
"                                      <option vale=\"1955\">1955</option>\n" +
"                                      <option vale=\"1956\">1956</option>\n" +
"                                      <option vale=\"1957\">1957</option>\n" +
"                                      <option vale=\"1958\">1958</option>\n" +
"                                      <option vale=\"1959\">1959</option>\n" +
"                                      <option vale=\"1960\">1960</option>\n" +
"                                      <option vale=\"1961\">1961</option>\n" +
"                                      <option vale=\"1962\">1962</option>\n" +
"                                      <option vale=\"1963\">1963</option>\n" +
"                                      <option vale=\"1964\">1964</option>\n" +
"                                      <option vale=\"1965\">1965</option>\n" +
"                                      <option vale=\"1966\">1966</option>\n" +
"                                      <option vale=\"1967\">1967</option>\n" +
"                                      <option vale=\"1968\">1968</option>\n" +
"                                      <option vale=\"1969\">1969</option>\n" +
"                                      <option vale=\"1970\">1970</option>\n" +
"                                      <option vale=\"1971\">1971</option>\n" +
"                                      <option vale=\"1972\">1972</option>\n" +
"                                      <option vale=\"1973\">1973</option>\n" +
"                                      <option vale=\"1974\">1974</option>\n" +
"                                      <option vale=\"1975\">1975</option>\n" +
"                                      <option vale=\"1976\">1976</option>\n" +
"                                      <option vale=\"1977\">1977</option>\n" +
"                                      <option vale=\"1978\">1978</option>\n" +
"                                      <option vale=\"1979\">1979</option>\n" +
"                                      <option vale=\"1980\">1980</option>\n" +
"                                      <option vale=\"1981\">1981</option>\n" +
"                                      <option vale=\"1982\">1982</option>\n" +
"                                      <option vale=\"1983\">1983</option>\n" +
"                                      <option vale=\"1984\">1984</option>\n" +
"                                      <option vale=\"1985\">1985</option>\n" +
"                                      <option vale=\"1986\">1986</option>\n" +
"                                      <option vale=\"1987\">1987</option>\n" +
"                                      <option vale=\"1988\">1988</option>\n" +
"                                      <option vale=\"1989\">1989</option>\n" +
"                                      <option vale=\"1990\">1990</option>\n" +
"                                      <option vale=\"1991\">1991</option>\n" +
"                                      <option vale=\"1992\">1992</option>\n" +
"                                      <option vale=\"1993\">1993</option>\n" +
"                                      <option vale=\"1994\">1994</option>\n" +
"                                      <option vale=\"1995\">1995</option>\n" +
"                                      <option vale=\"1996\">1996</option>\n" +
"                                      <option vale=\"1997\">1997</option>\n" +
"                                      <option vale=\"1998\">1998</option>\n" +
"                                      <option vale=\"1999\">1999</option>\n" +
"                                      <option vale=\"2000\">2000</option>\n" +
"                                      <option vale=\"2001\">2001</option>\n" +
"                                      <option vale=\"2002\">2002</option>\n" +
"                                      <option vale=\"2003\">2003</option>\n" +
"                                      <option vale=\"2004\">2004</option>\n" +
"                                      <option vale=\"2005\">2005</option>\n" +
"                                     </optgroup> \n" +
"                                  </select>\n" +
"                          </tr>\n" +
"                              </td>\n" +
"                          </tr>\n" +
"                          </table>\n" +
"                          </fieldset>\n" +
"                          <fieldset>\n" +
"                              <legend>Datos de acceso</legend>\n" +
"                              <table>\n" +
"                          <tr>\n" +
"                              <td>\n" +
"                                  <label>*Usuario</label>\n" +
"                              </td>\n" +
"                              <td>\n");
                                elementos=mapa.get("Usuario");
                                out.print("<input type=\"text\" name=\"Usuario\" value=\""+elementos[0]+"\"> \n" +
"                              </td>\n" +
"                          </tr>\n" +
"                          <tr>\n" +
"                              <td>\n" +
"                                  <label>*Contrase&ntilde;a</label>\n" +
"                              </td>\n" +
"                              <td>\n");
                                elementos=mapa.get("Contrasena");
                                out.print("<input type=\"password\" name=\"Contrasena\" value=\""+elementos[0]+"\"> \n" +
"                              </td>\n" +
"                          </tr>\n" +
"                          </table>\n" +
"                          </fieldset>\n" +
"                          </fieldset>\n" +
"                          <fieldset>\n" +
"                              <legend>Informaci&oacute;n General</legend>\n" +
"                              <table>\n" +
"                          <tr>\n" +
"                              <td>\n" +
"                                  <label>Preferencias</label>\n" +
"                              </td>\n" +
"                               <td>\n ");
                                elementos=mapa.get("Preferencia");
                                if (elementos != null){//** dependiendo de si el cliente ha seleccionado o no una aficion cuando reaparezca irá checkeada o sin checkear **//
                                    boolean deportes=false;
                                    boolean lectura=false;
                                    boolean cine=false;
                                    boolean viajes=false;
                                    for(int i=0;i<=elementos.length-1;i++){
                                      switch(elementos[i]){
                                          case "Deportes":
                                              deportes=true;
                                              break;
                                          case "Lectura":
                                              lectura=true;
                                              break;
                                          case "Cine":
                                              cine=true;
                                              break;
                                          case "Viajes":
                                              viajes=true;
                                              break;
                                      }
                                    }
                                if (deportes==true){
                                  out.print("<input type=\"checkbox\" id=\"prefe3\" name=\"Preferencia\" value=\"Deportes\" checked>\n" +
"                                   <label for=\"prefe2\">Deportes</label>\n" +
"                                   <br/>\n");   
                                }
                                else{
                                  out.print("<input type=\"checkbox\" id=\"prefe3\" name=\"Preferencia\" value=\"Deportes\">\n" +
"                                   <label for=\"prefe2\">Deportes</label>\n" +
"                                   <br/>\n");  
                                }
                                if (lectura==true){
                                  out.print("<input type=\"checkbox\" id=\"prefe3\" name=\"Preferencia\" value=\"Lectura\" checked>\n" +
"                                   <label for=\"prefe2\">Lectura</label>\n" +
"                                   <br/>\n");   
                                }
                                else{
                                  out.print("<input type=\"checkbox\" id=\"prefe3\" name=\"Preferencia\" value=\"Lectura\">\n" +
"                                   <label for=\"prefe2\">Lectura</label>\n" +
"                                   <br/>\n");  
                                }
                                 if (cine==true){
                                  out.print("<input type=\"checkbox\" id=\"prefe3\" name=\"Preferencia\" value=\"Cine\" checked>\n" +
"                                   <label for=\"prefe2\">Cine</label>\n" +
"                                   <br/>\n");   
                                }
                                else{
                                  out.print("<input type=\"checkbox\" id=\"prefe3\" name=\"Preferencia\" value=\"Cine\">\n" +
"                                   <label for=\"prefe2\">Cine</label>\n" +
"                                   <br/>\n");  
                                }
                                 if (viajes==true){
                                  out.print("<input type=\"checkbox\" id=\"prefe3\" name=\"Preferencia\" value=\"Viajes\" checked>\n" +
"                                   <label for=\"prefe2\">Viajes</label>\n" +
"                                   <br/>\n");   
                                }
                                else{
                                  out.print("<input type=\"checkbox\" id=\"prefe3\" name=\"Preferencia\" value=\"Viajes\">\n" +
"                                   <label for=\"prefe2\">Viajes</label>\n" +
"                                   <br/>\n");  
                                }
                                }
                           out.print("</td>\n" +
"                          </tr>\n" +
"                          </table>\n" +
"                          </fieldset>\n" +
"                          <input type=\"submit\" value=\"Enviar\"> <!-- hemos obviado el nombre de este botón para que luego en el servidor no se procese pero deben tener nombre -->\n" +
"                          <a href=\"/PracticasAula/HTML/registro.html\"><input type=\"button\" value=\"Reset\"></a>" +
"                      </form>\n" +
"                  </div>\n" +
"              </body>\n" +
"          </html>");
         }
        
    }//**fin del formulario
    public boolean comprobarFecha(String ano,String mes,String dia){//** devuelven un boolean indicando si la fecha es correcta **//
        try{
        int year = Integer.parseInt(ano);                   // año
        int month = Integer.parseInt(mes);                     // mes [1,...,12]
        int dayOfMonth = Integer.parseInt(dia);                // día [1,...,31]
        LocalDate today = LocalDate.of(year, month, dayOfMonth);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return true;
        }catch(java.time.DateTimeException e){//** al saltar esta excepcion indica que la fecha no es valida, por lo tanto devolvemos false **//
        return false;
        }
    }

}
