<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Index.aspx.cs" Inherits="WebService.Index" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
  <title>AGENDA</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body class="homepage">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Index.aspx">
          <asp:Label ID="Label1" runat="server" Text=""></asp:Label></a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="dropdown">
            <asp:HyperLink ID="HyperLink1" runat="server" class="dropdown-toggle" data-toggle="dropdown" href="#">Contactos<span class="caret"></span></asp:HyperLink>
          <ul class="dropdown-menu">
            <li><a href="AgregarContacto.aspx">Agregar</a></li>
            <li><a href="VerContacto.aspx">Mostrar</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
          <li><a href="Salir.aspx"><span class="glyphiconglyphicon-user"></span> Salir</a></li>
        <li><a href="Login.aspx"><span class="glyphicon glyphicon-log-in" ></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
    <!-- Contenido de index-->
            <asp:Image ID="Image1" runat="server" Height="95%" ImageUrl="~/img/banner.png" Width="100%" CssClass=".splash" />
</body>
</html>
