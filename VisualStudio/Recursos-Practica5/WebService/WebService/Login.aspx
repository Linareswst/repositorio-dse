<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="WebService.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Login</title>
    <link href="http://localhost:55773/cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link href="js/login.js" rel="stylesheet"/>
</head>
<body>
    <form id="form1" runat="server">
    <div>
      <h2><span class="entypo-login"></span>Login</h2>
        <br />
            <span class="entypo-user inputUserIcon"></span>
          <asp:TextBox ID="TxtUsuario" runat="server" class="user" placeholder="Usuario"></asp:TextBox>
            <span class="entypo-key inputPassIcon"></span>
          <asp:TextBox ID="TxtPassword" runat="server" class="pass" placeholder="password" TextMode="Password"></asp:TextBox>
            <span class="entypo-lock inputLockIcon"></span>
    </div>
        <asp:Label ID="LblError" runat="server" Font-Bold="True" Font-Size="Large" ForeColor="Red"></asp:Label>
          <asp:Button ID="BtnEntrar" runat="server"  class="submit" OnClick="BtnEntrar_Click" Width="350px"/>
    </form>
</body>
</html>
