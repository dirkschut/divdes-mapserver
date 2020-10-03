public class Main {
    public static ImageManager imageManager;

    public static void main(String[] args){
        System.out.println("Starting Divine Desolation image server!");
        imageManager = new ImageManager();
        imageManager.downloadZoneImage(new GPSPoint(52.372599, 4.890748).GetZoneID());
    }
}
