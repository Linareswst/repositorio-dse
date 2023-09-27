using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebService
{
    public partial class Salir : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["usuario"] == null)
            {
                Response.Redirect("Login.aspx");
            }
            Label2.Text = "AGENDA " + (string)Session["usuario"];
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            Session.Remove("Usuario");
            Response.Redirect("Login.aspx");
        }

        protected void BtnCancelar_Click(object sender, EventArgs e)
        {
            Response.Redirect("Index.aspx");
        }
    }
}