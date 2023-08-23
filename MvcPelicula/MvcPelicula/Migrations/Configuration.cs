namespace MvcPelicula.Migrations
{
    using MvcPelicula.Models;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<MvcPelicula.Models.PeliculaDBContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(MvcPelicula.Models.PeliculaDBContext context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method
            //  to avoid creating duplicate seed data.
            context.Peliculas.AddOrUpdate(i => i.Title,
            new Pelicula
            {
                Title = "Harry Potter y las reliquias de la muerte 2",
                FechaLanzamiento = DateTime.Parse("2011-3-15"),
                Genero = "Ficción",
                Precio = 8.99M,
                Clasificacion = "B"
            },
            new Pelicula
            {
                Title = "Harry Potter y la pieda filosofal",
                FechaLanzamiento = DateTime.Parse("2001-11-16"),
                Genero = "Ficción",
                Precio = 10.99M,
                Clasificacion = "B"
            },
            new Pelicula
            {
                Title = "Salvando al soldado Ryan",
                FechaLanzamiento = DateTime.Parse("1998-07-24"),
                Genero = "Guerra",
                Precio = 3.99M,
                Clasificacion = "D"
            },
            new Pelicula
            {
                Title = "ET",
                FechaLanzamiento = DateTime.Parse("1982-06-11"),
                Genero = "Fantasía",
                Precio = 2.99M,
                Clasificacion = "TP"
            }
            );
        }
    }
}
