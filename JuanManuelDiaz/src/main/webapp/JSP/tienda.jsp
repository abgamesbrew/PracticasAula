<%-- 
    Document   : tienda
    Author     : shirone
--%>

<%@page import="java.lang.NumberFormatException"%>
<%@page import="java.util.Iterator"%>
<%@page import="es.albarregas.models.Robot"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/PracticasAula/CSS/conjunto.css"/>
        <title>i-Animals</title>
    </head>
    <body>
        <% 
        if(request.getParameter("finalizar") != null){//** Si hemos llegado por el boton finalizar **//
            HttpSession sesion = request.getSession(false);
            if(!request.isRequestedSessionIdValid()){//** Si con la sesion invalidada el cliente accede a nuestro jsp por finalizar le creamos la sesion con el atributo animales **//
             sesion =request.getSession(true);
             ArrayList<Robot> animaless = new ArrayList<Robot>();
             sesion.setAttribute("animales", animaless);   
            }
        %>
        
        <div id="tiendajspfinalizado">
        <h1>iAnimals On-Line <img class="tiendajspimagen" src="../HTML/IMG/robot.jpg"/></h1>
        <%
            ArrayList<Robot> robots = (ArrayList<Robot>) sesion.getAttribute("animales"); //** Creamos un ArrayList que contendrá el ArrayList del atributo animales de la sesion **// 
            if(robots.size() < 1 || sesion == null){//** si la sesion es nula o no hay ni tan siquiera un animal mostramos un mensaje e invalidamos la sesion **// %>
        <p>No ha saleccionado ningún producto<p>
            <a href="../index.html">Gracias por confiar en nosotros</a><br/>
          <%sesion.invalidate();}else{//** si el ArrayList robots contiene mas de 1 animal y la sesion es vaida lo mostraremos en una tabla //**%>
        <p>Este es el detalle de su pedido</p>
        <table>
            <tr>
                <td><strong>Cantidad</strong></td>
                <td><strong>Nombre</strong></td>
            </tr>
            <%
                for(int i=0;i<=robots.size()-1;i++){%>
                <tr>
                    <td><%= robots.get(i).getCantidad()%></td>
                    <td><%= robots.get(i).getTitulo()%></td>
                </tr>  
                <%}%>
        </table><br/>
        <%sesion.invalidate();%>
        <a href="../index.html">Gracias por confiar en nosotros</a><br/>
        <%}%>
        
        </div>
        <% }else{ 
           HttpSession sesionok = request.getSession(false);//** si la sesion no es valida no la crearemos por ahora **//
           ArrayList<Robot> animales = null;//** contendra el ArrayList del atributo animales de la sesion **//
           Robot robot = null; //** Contendra el Item con el que operaremos y añadiremos a nuestro ArrayList **//
           String aniadido = null;//**contendrá el mensaje que vera el usuario al añadirse correctamente un item **//

           if(sesionok != null && request.isRequestedSessionIdValid()){//** si la sesion es valida cargamos el ArrayList de la sesion en el ArrayList mas arriba comentado **//
             animales = (ArrayList<Robot>) sesionok.getAttribute("animales");
           }

           else if(sesionok == null || !request.isRequestedSessionIdValid()){//** si la sesion es nula o esta invalidada creamos una nueva sesion **//
            HttpSession sesion =request.getSession(true);//** creamos la sesion **//
            ArrayList<Robot> animaless = new ArrayList<Robot>(); //** Inicializamos un ArrayList que usaremos para añadirlo a la sesion **//
            sesion.setAttribute("animales", animaless);//** añadimos a la sesion el atributo animales y un ArrayList inicializado **//
            animales = (ArrayList<Robot>) sesion.getAttribute("animales"); //** Para continuar con nuestro programa dejamos el ArrayList actual de la sesion en el ArrayList de trabajo **//
           }
           if( request.getParameter("articulo") != null && request.getParameter("animales") == null){ //** si no hemos seleccionado ningun animal y hemos venido por el boton de añadir un articulo **//
               response.sendRedirect("tienda.jsp?error=1");//** enviamos como parametro el error 1 **//
           }else if(request.getParameter("articulo") != null && request.getParameter("cantidad") != null){ //** si no hemos seleccionado una cantidad y venimos del boton de añadir un articulo **//
               try{//** comprobamos los distintos errores que nos puede dar la entrada de cantidad **//
                 int cantidad=Integer.parseInt(request.getParameter("cantidad"));
                 boolean cantidadpositiva=true;
                 if(cantidad <= 0){//** si la cantidad es menor o igual a cero y no hay una excepcion volvemos al fichero jsp con el parametro error 3 **//
                 cantidadpositiva=false;
                 }
                 if(cantidadpositiva == true){
                  robot = new Robot(request.getParameter("animales"), Integer.parseInt(request.getParameter("cantidad")));//** creamos un objeto robot con lo que hemos recibido por nuestro formulario **//

                    if(animales.size()>=1){//** si ya hay un animal o mas hay que comprobar que animal es **//
                    boolean encontrado=false; //** almacenamos si se ha encontrado el animal en la coleccion **//
                     for(int i=0;i<=animales.size()-1;i++){//** recorremos el ArrayList local animales, que viene dado de la sesion **//
                        if(animales.get(i).getTitulo().equals(robot.getTitulo())){//** si encontramos el titulo del robot dentro del arraylist **//
                            animales.get(i).setCantidad(animales.get(i).getCantidad() + Integer.parseInt(request.getParameter("cantidad"))); //** actualizamos la cantidad actualizada para asignarselo a un objeto nuevo **//
                            robot.setCantidad(animales.get(i).getCantidad());//** Se añade la cantidad cantidad actualizada al objeto actual **//
                            animales.remove(i);//** se elimina ESTE objeto del ArrayList para añadirselo posteriormente actualizado **//
                        }
                    }

                    animales.add(robot);//** Se añade el robot tanto si lo hemos encontrado como si no **//
                    sesionok.setAttribute("animales", animales); //** Se añade a la sesion el ArrayList modificado de animales de nuevo **//

                    }//** if animales size>=1 **//
                    else{//** si hay menos de un animal, no hay que buscar nada y se añade el nuevo **//
                        // TANTO EN EL IF COMO EN EL ELSE REALIZAS LA MISMA INSTRUCCIÓN. MEJOR PONLA FUERA
                        animales.add(robot);
                        sesionok.setAttribute("animales", animales);
                    }
                 
                 aniadido="Añadido a la cesta "+request.getParameter("cantidad")+" unidades del i-Animal "+request.getParameter("animales");
               }//** fin if cantidadpositiva **//
                else{//** si la cantidad no es positiva lanzamos el error 3 **//
                 response.sendRedirect("tienda.jsp?error=3");
                }
               }//** fin try **//
               catch(NumberFormatException e){//** si  hay una excepcion al convertir el numero enviamos el error 2**//
                response.sendRedirect("tienda.jsp?error=2");
               }
            }
           
            %>
        <div id="tiendajsp">
            <h1>iAnimals On-Line <img class="tiendajspimagen" src="../HTML/IMG/robot.jpg"/></h1>
            <% if(request.getParameter("error") != null){//** leeremos el parametro error y dependiendo del error mostraremos un mensaje u otro siempre y cuando el libro no se haya añadido correctamente **//
               if(request.getParameter("error").equals("1") && aniadido == null){ //** si el error es 1 y el libro no esta correctamente añadido **//
                   %><h3>Seleccione un animal por favor...</h3>     
                   <%}else if(request.getParameter("error").equals("2") && aniadido == null){%>       
               <h3>La cantidad de entrada no es un numero válido</h3>
                <%}else if(request.getParameter("error").equals("3") && aniadido == null){%>
                <h3>La cantidad de entrada no puede ser 0 o negativa</h3>
                <%}}
                if(aniadido != null){//** Si se ha añadido otro item al ArrayList de la sesion mostraremos este mensaje **//%>
                <h4><strong><%= aniadido %></strong></h4>
                <%}%>
                <%-- EL ATRIBUTO ES ACTION --%>
            <form method="post" action="tienda.jsp"/>
            <label><strong>Selecciona un animal robótico</strong></label> <br/>
                <select name="animales" size="6">
                    <option value="iDino3.0">iDino 3.0</option>
                    <option value="iCangoroo2.0">iCangoroo 2.0</option>
                    <option value="iDog3.0">iDog 3.0</option>
                    <option value="iCat2.0">iCat 2.0</option>
                    <option value="iKoala1.0">iKoala 1.0</option>
                    <option value="iMonstruo1.0">iMonstruo 1.0</option>
                </select><br/><br/>
                <label>Cantidad: </label><input type="text" name="cantidad"/><br/><br/>
                <input type="submit" name="articulo" value="Añadir artículo"/>
                <input type="reset" value="Limpiar"/>
                <input type="submit" name="finalizar" value="Finalizar Compra"/>
            </form> 
        </div>
      <%}%>
    </body>
</html>
