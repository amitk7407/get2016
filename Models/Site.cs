using AngularDemo.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace AngularDemo.Models
{
    public class Site
    {
        public int SiteId { get; set; }

        [Required]
        [StringLength(50)]
        public string SiteName { get; set; }

        [Required]
        [StringLength(50)]
        public string Country { get; set; }

        [Required]
        [StringLength(50)]
        public string State { get; set; }

        public bool IsActive { get; set; }
    }

    public class SiteDbContext : DbContext
    {
        public DbSet<Site> Sites { get; set; }
    }
}