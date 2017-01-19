using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AngularDemo.Models
{
    public class AssetDTO
    {
        public int AssetId { get; set; }

        public string AssetName { get; set; }

        public string RoomName { get; set; }

        public string BuildingName { get; set; }

        public string SiteName { get; set; }
    }
}