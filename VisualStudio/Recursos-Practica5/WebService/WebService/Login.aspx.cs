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
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void BtnEntrar_Click(object sender, EventArgs e)
        {
            try
            {
                //Variable que guardar URL de acceso a los recursos del API
                string sURL;
                sURL = "https://localhost:44344/api/Logins";
                //variable para acceso a datos a traves de HTTP
                WebRequest wrGETURL;
                wrGETURL = WebRequest.Create(sURL);
                //Variable para almacenar los valores de lectura del REST
                Stream objStream;
                objStream = wrGETURL.GetResponse().GetResponseStream();
                //Objeto para realizar lectura de los datos obtenidos
                StreamReader objReader = new StreamReader(objStream);
                //Variable para almacenar la respuesta
                string jsonText = "";
                int i = 0;//contador
                int errordatos = 0;//bandera de error
                                   //almacenamiento de datos JSON
                jsonText = objReader.ReadLine();
                if (jsonText != null)
                {
                    //parseo de String a objeto json
                    var jss = new JavaScriptSerializer();
                    dynamic result = jss.DeserializeObject(jsonText);
                    //Recorre al conjunto de datos devueltos de tabla Login
                    for (i = 0; i < result.Length; i++)
                    {
                        //verificacion de crendenciales
                        if (result[i]["Usuario"] == TxtUsuario.Text &&
                        result[i]["contrasenia"] == TxtPassword.Text)
                        {
                            int cant;
                            //de consulta, retorna cantidad de contactos del usuario
                            cant = result[i]["Contactoes"].Length;
                            //si usuario y contraseña son correctos permitir ingreso
                            Session.Add("usuario", TxtUsuario.Text);
                            Session.Add("cant", cant);
                            Response.Redirect("Index.aspx");
                            errordatos = 0;
                            break;
                        }
                        else
                        {
                            errordatos++;
                        }
                    }
                    if (errordatos > 0)
                    {
                        LblError.Text = "Usuario o Contraseña incorrecta, verifique sus datos";
 }
                }
                else
                {
                    LblError.Text = "La respuesta del Servidor de Datos ya tardo mucho, Lamentamos el inconveniente";
                }
            }
            catch (Exception ex)
            {
                LblError.Text = "Error con Servicio de Datos, Lamentamos el inconveniente";
            }
        }
    }
}