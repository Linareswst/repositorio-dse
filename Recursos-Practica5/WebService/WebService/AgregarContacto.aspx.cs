using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Script.Serialization;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebService
{
    public partial class AgregarContacto : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["usuario"] == null)
            {
                Response.Redirect("Login.aspx");
            }
            Label2.Text = "AGENDA " + (string)Session["usuario"];
        }

        protected void BtnGuardar_Click(object sender, EventArgs e)
        {
            try
            {
                var httpWebRequest =
               (HttpWebRequest)WebRequest.Create("https://localhost:44344/api/Contactos");
                httpWebRequest.ContentType = "application/json";
                httpWebRequest.Method = "POST";
                using (var streamWriter = new
               StreamWriter(httpWebRequest.GetRequestStream()))
                {
                    string json = new JavaScriptSerializer().Serialize(new
                    {
                        Nombre = inputNombre.Text,
                        Apellido1 = inputApellido.Text,
                        Correo = inputCorreo.Text,
                        Telefono = inputTel.Text,
                        Direcion = inputDireccion.Text,
                        //define campo de relacion del nuevo Contacto hacia registro de tabla Login
                    Usuario = (string)Session["usuario"]
                    });
                    streamWriter.Write(json);
                }
                var response = (HttpWebResponse)httpWebRequest.GetResponse();
                using (var streamReader = new StreamReader(response.GetResponseStream()))
                {
                    var result = streamReader.ReadToEnd();
                    inputNombre.Text = "";
                    inputApellido.Text = "";
                    inputCorreo.Text = "";
                    inputDireccion.Text = "";
                    inputTel.Text = "";
                }
            }
            catch (Exception ex)
            { }
        }
    }
}