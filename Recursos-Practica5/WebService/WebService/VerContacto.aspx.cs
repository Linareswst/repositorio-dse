using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebService
{
    public partial class VerContacto : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
              if(Session["usuario"]==null){
                Response.Redirect("Login.aspx");
            }
              Label2.Text = (string)Session["usuario"];
        }
    }
}