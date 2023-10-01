<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="VerContacto.aspx.cs" Inherits="WebService.VerContacto" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
  <title>AGENDA</title>
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script>
 $(window).ready(function ( ) {
 var usu = document.getElementById('Label2').innerHTML;
 $.ajax({
 type: "GET",
url: "https://localhost:44344/api/Logins/" + usu,
 dataType: "json",
success: function (responseString) {
 for (i = 0; i < responseString.Contactoes.length; i++) {
 var table = document.getElementById("tblContactos");
 {
 var row = table.insertRow(i + 1);
var cell1 = row.insertCell(0);
var cell2 = row.insertCell(1);
var cell3 = row.insertCell(2);
var cell4 = row.insertCell(3);
var cell5 = row.insertCell(4);
var cell6 = row.insertCell(5);
cell1.innerHTML = i + 1;
cell2.innerHTML = responseString.Contactoes[i].Nombre;
cell3.innerHTML = responseString.Contactoes[i].Apellido1;
cell4.innerHTML = responseString.Contactoes[i].Correo;
cell5.innerHTML = responseString.Contactoes[i].Telefono;
cell6.innerHTML = responseString.Contactoes[i].Direcion;
 }
 }
 if (i > 0) //usuario tiene al menos un contacto registrado
 document.getElementById('Mensaje').innerHTML = usu + ' tiene ' +
 i + ' contactos registrados';
 else
 document.getElementById('Mensaje').innerHTML = usu +
 ' aun no tiene contactos registrados';
 },
error: function (xhr, errorType, exception) {
 var errorMessage = exception || xhr.statusText;
alert(errorMessage);
 }
 })
document.getElementById('Label2').innerHTML = 'AGENDA ' + usu;
 });
  </script>
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
    <nav>
 <form runat="server" style="margin:5%">
 <p>
 <asp:Label ID="Mensaje" runat="server" CssClass="h2"></asp:Label>
 </p>
 <p>
 <asp:Table ID="tblContactos" runat="server" CssClass ="table-bordered" Width="90%">
 <asp:TableHeaderRow BackColor="Yellow">
 <asp:TableHeaderCell Text="Id_Contacto"></asp:TableHeaderCell>
 <asp:TableHeaderCell Text="Nombre"></asp:TableHeaderCell>
 <asp:TableHeaderCell Text="Apellido 1"></asp:TableHeaderCell>
 <asp:TableHeaderCell Text="Correo"></asp:TableHeaderCell>
 <asp:TableHeaderCell Text="Telefono"></asp:TableHeaderCell>
 <asp:TableHeaderCell Text="Direccion"></asp:TableHeaderCell>
 </asp:TableHeaderRow>
 </asp:Table>
 </p>
 </form>
</nav>
</body>
</html>
