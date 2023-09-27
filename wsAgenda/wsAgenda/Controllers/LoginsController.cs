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
    public class LoginsController : ApiController
    {
        private AgendaEntities db = new AgendaEntities();

        // GET: api/Logins
        public IQueryable<Login> GetLogins()
        {
            return db.Logins;
        }

        // GET: api/Logins/5
        [ResponseType(typeof(Login))]
        public async Task<IHttpActionResult> GetLogin(string id)
        {
            Login login = await db.Logins.FindAsync(id);
            if (login == null)
            {
                return NotFound();
            }

            return Ok(login);
        }

        // PUT: api/Logins/5
        [ResponseType(typeof(void))]
        public async Task<IHttpActionResult> PutLogin(string id, Login login)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != login.Usuario)
            {
                return BadRequest();
            }

            db.Entry(login).State = EntityState.Modified;

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!LoginExists(id))
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

        // POST: api/Logins
        [ResponseType(typeof(Login))]
        public async Task<IHttpActionResult> PostLogin(Login login)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Logins.Add(login);

            try
            {
                await db.SaveChangesAsync();
            }
            catch (DbUpdateException)
            {
                if (LoginExists(login.Usuario))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = login.Usuario }, login);
        }

        // DELETE: api/Logins/5
        [ResponseType(typeof(Login))]
        public async Task<IHttpActionResult> DeleteLogin(string id)
        {
            Login login = await db.Logins.FindAsync(id);
            if (login == null)
            {
                return NotFound();
            }

            db.Logins.Remove(login);
            await db.SaveChangesAsync();

            return Ok(login);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool LoginExists(string id)
        {
            return db.Logins.Count(e => e.Usuario == id) > 0;
        }
    }
}