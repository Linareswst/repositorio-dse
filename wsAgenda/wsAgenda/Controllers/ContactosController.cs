using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.Description;
using wsAgenda;

namespace wsAgenda.Controllers
{
    public class ContactosController : ApiController
    {
        private AgendaEntities db = new AgendaEntities();

        // GET: api/Contactos
        public IQueryable<Contacto> GetContactoes()
        {
            return db.Contactoes;
        }

        // GET: api/Contactos/5
        [ResponseType(typeof(Contacto))]
        public async Task<IHttpActionResult> GetContacto(int id)
        {
            Contacto contacto = await db.Contactoes.FindAsync(id);
            if (contacto == null)
            {
                return NotFound();
            }

            return Ok(contacto);
        }

        // PUT: api/Contactos/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutContacto(int id, Contacto contacto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != contacto.Id_Contacto)
            {
                return BadRequest();
            }

            db.Entry(contacto).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!ContactoExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/Contactos
        [ResponseType(typeof(Contacto))]
        public async Task<IHttpActionResult> PostContacto(Contacto contacto)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Contactoes.Add(contacto);
            await db.SaveChangesAsync();

            return CreatedAtRoute("DefaultApi", new { id = contacto.Id_Contacto }, contacto);
        }

        // DELETE: api/Contactos/5
        [ResponseType(typeof(Contacto))]
        public async Task<IHttpActionResult> DeleteContacto(int id)
        {
            Contacto contacto = await db.Contactoes.FindAsync(id);
            if (contacto == null)
            {
                return NotFound();
            }

            db.Contactoes.Remove(contacto);
            await db.SaveChangesAsync();

            return Ok(contacto);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool ContactoExists(int id)
        {
            return db.Contactoes.Count(e => e.Id_Contacto == id) > 0;
        }
    }
}