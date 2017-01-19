using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using AngularDemo.Models;

namespace AngularDemo.Controllers
{
    public class AssetRequestsController : ApiController
    {
        private AssetRequestDbContext db = new AssetRequestDbContext();

        // GET: api/AssetRequests
        public IQueryable<AssetRequest> GetAssetRequests()
        {
            return db.AssetRequests;
        }

        // GET: api/AssetRequests/5
        [ResponseType(typeof(AssetRequest))]
        public IHttpActionResult GetAssetRequest(int id)
        {
            AssetRequest assetRequest = db.AssetRequests.Find(id);
            if (assetRequest == null)
            {
                return NotFound();
            }

            return Ok(assetRequest);
        }

        // PUT: api/AssetRequests/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutAssetRequest(int id, AssetRequest assetRequest)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != assetRequest.AssetRequestId)
            {
                return BadRequest();
            }

            db.Entry(assetRequest).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AssetRequestExists(id))
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

        // POST: api/AssetRequests
        [ResponseType(typeof(AssetRequest))]
        public IHttpActionResult PostAssetRequest(AssetRequest assetRequest)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.AssetRequests.Add(assetRequest);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = assetRequest.AssetRequestId }, assetRequest);
        }

        // DELETE: api/AssetRequests/5
        [ResponseType(typeof(AssetRequest))]
        public IHttpActionResult DeleteAssetRequest(int id)
        {
            AssetRequest assetRequest = db.AssetRequests.Find(id);
            if (assetRequest == null)
            {
                return NotFound();
            }

            db.AssetRequests.Remove(assetRequest);
            db.SaveChanges();

            return Ok(assetRequest);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool AssetRequestExists(int id)
        {
            return db.AssetRequests.Count(e => e.AssetRequestId == id) > 0;
        }
    }
}