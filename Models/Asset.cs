using System.ComponentModel.DataAnnotations;
using System.Data.Entity;

namespace AngularDemo.Models
{
    public class Asset
    {
        public int AssetId { get; set; }

        [Required]
        [StringLength(20)]
        public string AssetName { get; set; }

        public string RoomId { get; set; }

        public Room Room { get; set; }
    }

    public class AssetDbContext : DbContext
    {
        public DbSet<Asset> Assets { get; set; }
    }
}