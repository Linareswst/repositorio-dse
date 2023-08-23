namespace MvcPelicula.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Clasificacion : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Peliculas", "Clasificacion", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Peliculas", "Clasificacion");
        }
    }
}
