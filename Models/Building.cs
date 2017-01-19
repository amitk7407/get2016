using AngularDemo.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace AngularDemo.Models
{
    public class Building
    {
        public int BuildingId { get; set; }

        [Required]
        [StringLength(50)]
        public string BuildingName { get; set; }

        public bool IsActive { get; set; }

        public int SiteId { get; set; }

        public Site Site { get; set; }
    }

    public class BuildingDbContext : DbContext
    {
        public DbSet<Building> Buildings { get; set; }

        public System.Data.Entity.DbSet<AngularDemo.Models.Site> Sites { get; set; }
    }
}