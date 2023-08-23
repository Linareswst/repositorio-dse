using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using System.ComponentModel.DataAnnotations;

namespace MvcPelicula.Models
{
    public class Pelicula
    {
        public int ID { get; set; }

        [StringLength(60, MinimumLength = 3)]
        public string Title { get; set; }

        [Display(Name = "Fecha de Lanzamiento")]
        [DataType(DataType.Date)]
        public DateTime FechaLanzamiento { get; set; }

        [RegularExpression(@"^[A-Z]+[a-zA-Z]*$")]
        [Required]
        [StringLength(30)]
        public string Genero { get; set; }

        [DataType(DataType.Currency)]
        public decimal Precio { get; set; }

        [RegularExpression(@"^[A-Z]+[a-zA-Z]*$")]
        [StringLength(5)]
        public string Clasificacion { get; set; }
    }

    public class PeliculaDBContext : DbContext
    {
        public DbSet<Pelicula> Peliculas { get; set;}
    }
}