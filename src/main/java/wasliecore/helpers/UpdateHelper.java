package wasliecore.helpers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UpdateHelper {
	
	@SideOnly(Side.CLIENT)
	public static Double getVersion(String modName){
		String urlString = "https://dl.dropboxusercontent.com/u/46500170/Site/Builds/" + modName + "_UPDATE" + ".wasliecore";
		try{
			URL url = new URL(urlString);
			Scanner scanner = new Scanner(url.openStream());
			
			while(scanner.hasNext()){
				String[] total = scanner.nextLine().split(":");
				double version = Double.parseDouble(total[0]);	
				return version;
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println("WaslieCore could not get file "+urlString);
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
	public static String getText(String modName){
		String urlString = "https://dl.dropboxusercontent.com/u/46500170/Site/Builds/" + modName + "_UPDATE" + ".wasliecore";
		try{
			URL url = new URL(urlString);

			Scanner scanner = new Scanner(url.openStream());
			
			while(scanner.hasNext()){
				String[] total = scanner.nextLine().split(":");
				String text = total[1];
				return text;
			}
			scanner.close();
		} catch (IOException e) {
			System.out.println("WaslieCore could not get file "+urlString);
		}
		return null;
	}
	
	
	@SideOnly(Side.CLIENT)
	public static HashMap<Double, String> getUpdate(String modName){
		String urlString = "https://dl.dropboxusercontent.com/u/46500170/Site/Builds/" + modName + "_UPDATE" + ".wasliecore";
		try{
			HashMap<Double, String> update = new HashMap<Double, String>();
			URL url = new URL(urlString);

			Scanner scanner = new Scanner(url.openStream());
			
			while(scanner.hasNext()){
				String[] total = scanner.nextLine().split(":");
				double version = Double.parseDouble(total[0]);	
				String text = total[1];
				update.put(version, text);
			}
			scanner.close();
			return update;
		} catch (IOException e) {
			System.out.println("WaslieCore could not get file "+urlString);
		}
		return null;
	}
	
}
