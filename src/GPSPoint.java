public class GPSPoint {
    private double lat;
    private double lon;
    private ZoneID zoneID;

    public GPSPoint(double lat, double lon){
        this.lat = lat;
        this.lon = lon;
    }

    public ZoneID GetZoneID(){
        if(zoneID == null){
            int x = getTileX(18);
            int y = getTileY(18);
            zoneID = new ZoneID(x, y);
        }
        return zoneID;
    }

    private int getTileX(int zoom){
        return (int)Math.floor( (lon + 180) / 360 * (1 << zoom));
    }

    private int getTileY(int zoom){
        return (int)Math.floor( (1 - Math.log(Math.tan(Math.toRadians(lat)) + 1 / Math.cos(Math.toRadians(lat))) / Math.PI) / 2 * (1<<zoom) ) ;
    }
}
