import java.io.*;
import java.util.ArrayList;
public class IO {
	{
		ArrayList<String> dungeontxt = new ArrayList<String>();
	try (FileInputStream is = new FileInputStream("/Resources/Dungeon.txt")){
		InputStreamReader ir = new InputStreamReader(is);
		BufferedReader rdr = new BufferedReader(ir);
		String line;
		
		while ((line = rdr.readLine())!= null){
			dungeontxt.add(line);
			System.out.printf("%s\n", line);
		}
		
	}catch(Exception ex) {System.out.printf("Failed for %s\n", "Dungeon.txt");}

	
}
}
