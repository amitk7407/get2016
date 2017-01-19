using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AngularDemo.Models
{
    public class RoomDTO
    {
        public int RoomId { get; set; }

        public string RoomName { get; set; }

        public bool IsActive { get; set; }

        public string BuildingName { get; set; }

        public string SiteName { get; set; }
    }
}