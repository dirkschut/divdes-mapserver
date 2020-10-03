import java.awt.*;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageManager {
    public ImageManager(){

    }

    public void downloadZoneImage(ZoneID zoneID){
        try{
            File output = new File("map\\images\\18\\" + zoneID.getX() + "_" + zoneID.getY() + ".png");
            System.out.println("-- Downloading image: " + output.toPath().toString());

            if(output.exists()){
                System.out.println("---- Image already exists.");
                return;
            }

            URL url = new URL("http://tile.openstreetmap.org/" + 18 + "/" + zoneID.getX() + "/" + zoneID.getY() + ".png");
            System.setProperty("http.agent", "Divine Desolation Map server contact support@dirkschut.nl");
            URLConnection connection = url.openConnection();
            Files.createDirectories(Paths.get(output.getParent()));
            Files.copy(connection.getInputStream(), output.toPath());

            System.out.println("---- Image downloaded.");
        }catch(Exception e){
            System.out.println("---- ERROR WHILE DOWNLOADING IMAGE");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
