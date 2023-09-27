<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="AgregarContacto.aspx.cs" Inherits="WebService.AgregarContacto" %>

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
      <a class="navbar-brand" href="Index.aspx"><asp:Label ID="Label2" runat="server" Text=""></asp:Label></a>
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
<form id="Form1" class="form-horizontal" runat="server" style="width:85%">
    <div class="page-header">
        <h1><small>Agregar Contacto</small> </h1>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3">Nombre:</label>
        <div class="col-xs-9">
            <asp:TextBox class="form-control" id="inputNombre" placeholder="Nombre"  runat="server"></asp:TextBox>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3">Apellido:</label>
        <div class="col-xs-9">
            <asp:TextBox runat="server" class="form-control" id="inputApellido" placeholder="Apellido"></asp:TextBox>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3">Correo:</label>
        <div class="col-xs-9">
            <asp:TextBox ID="inputCorreo" runat="server" class="form-control" placeholder="Correo"></asp:TextBox>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-xs-3" >Telefono:</label>
        <div class="col-xs-9">
            <asp:TextBox ID="inputTel" runat="server" class="form-control" placeholder="Telefono"></asp:TextBox>
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-xs-3">Dirección:</label>
        <div class="col-xs-9">
            <asp:TextBox ID="inputDireccion" runat="server" class="form-control" placeholder="Dirección" Rows="5" TextMode="MultiLine"></asp:TextBox>
        </div>
    </div>
    <asp:Label ID="LblError" runat="server" Font-Size="Large" ForeColor="Red"></asp:Label>
    <br/>
    <div class="form-group">
        <div class="col-xs-offset-3 col-xs-9">
            <asp:Button ID="BtnGuardar" runat="server" class="btn btn-primary" Text="Guardar" OnClick="BtnGuardar_Click" />
        </div>
    </div>
</form>
</body>
</html>
