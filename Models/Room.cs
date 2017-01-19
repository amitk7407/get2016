using AngularDemo.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace AngularDemo.Models
{
    public class Room
    {
        public int RoomId { get; set; }

        [Required]
        [StringLength(50)]
        public string RoomName { get; set; }

        public bool IsActive { get; set; }

        public int BuildingId { get; set; }

        public Building Building { get; set; }
    }

    public class RoomDbContext : DbContext
    {
        public DbSet<Room> Rooms { get; set; }

        public System.Data.Entity.DbSet<AngularDemo.Models.Building> Buildings { get; set; }
    }
}