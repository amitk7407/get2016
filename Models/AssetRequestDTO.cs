using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AngularDemo.Models
{
    public class AssetRequestDTO
    {
        public int AssetRequestId { get; set; }

        public string RequestorName { get; set; }

        public DateTime StartDate { get; set; }

        public DateTime EndDate { get; set; }

        public bool IsActive { get; set; }

        public string AssetName { get; set; }

        public string RoomName { get; set; }

        public string BuildingName { get; set; }

        public string SiteName { get; set; }
    }
}