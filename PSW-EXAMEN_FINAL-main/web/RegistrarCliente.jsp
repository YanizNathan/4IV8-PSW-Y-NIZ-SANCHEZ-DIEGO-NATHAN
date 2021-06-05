

<%@page contentType="text/html" import="java.util.*" session="true" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
  <meta charset='UTF-8'>
  <title>CodePen Demo</title>

  <meta name="robots" content="noindex">

  <link rel="shortcut icon" type="image/x-icon" href="https://cpwebassets.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico">
  <link rel="mask-icon" type="" href="https://cpwebassets.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg" color="#111">
  <link rel="canonical" href="https://codepen.io/andytran/pen/RPBdgM/">

  
  
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <style class="INLINE_PEN_STYLESHEET_ID">
   

/* Keyframes */
@-webkit-keyframes buttonFadeInUp {
  0% {
    bottom: 30px;
    opacity: 0;
  }
}
@keyframes buttonFadeInUp {
  0% {
    bottom: 30px;
    opacity: 0;
  }
}
  </style>

  
<script src="https://cpwebassets.codepen.io/assets/editor/iframe/iframeConsoleRunner-d8236034cc3508e70b0763f2575a8bb5850f9aea541206ce56704c013047d712.js"></script>
<script src="https://cpwebassets.codepen.io/assets/editor/iframe/iframeRefreshCSS-4793b73c6332f7f14a9b6bba5d5e62748e9d1bd0b5c52d7af6376f3d1c625d7e.js"></script>
<script src="https://cpwebassets.codepen.io/assets/editor/iframe/iframeRuntimeErrors-4f205f2c14e769b448bcf477de2938c681660d5038bc464e3700256713ebe261.js"></script>
<script src="./JS/Pruebas.js"></script>
<link rel="stylesheet" href="./CSS/IniciarSesion.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="pen-title">
  <h1>Inicio de sesion de heladeria</h1><span>Hecho <i class='fa fa-code'></i> por <a href='https://www.instagram.com/nathan_yaniz/'>Diego Yániz</a></span>
</div>

<div class="container">
  <div class="card"></div>       
        <div class="card">
    <h1 class="title">Inicio de Sesión</h1>
    <form method="post" name="IniciarSesionCliente" action="VerificarUsuario">
      <div class="input-container">
        <input type="text" name="usuario_cli" required="required"/>
        <label>Nombre de Usuario</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" name="contra_cli"  required="required"/>
        <label>Contraseña</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <input class="continuar" type="submit" value="Iniciar sesión">
     
      </div>
      
    </form>
  </div>
        
    </body>
</html>
