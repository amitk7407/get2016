using AngularDemo.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace AngularDemo.Models
{
    public class AssetRequest
    {
        public int AssetRequestId { get; set; }

        [Required]
        [StringLength(20)]
        public string RequestorName { get; set; }

        public DateTime StartDate { get; set; }

        public DateTime EndDate { get; set; }

        public bool IsActive { get; set; }

        public string AssetId { get; set; }

        public Asset Asset { get; set; }
    }

    public class AssetRequestDbContext : DbContext
    {
        public DbSet<AssetRequest> AssetRequests { get; set; }
    }
}