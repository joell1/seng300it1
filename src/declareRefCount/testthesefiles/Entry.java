package declareRefCount;
import java.io.*;

public class Entry {
	public static void main(String[] args) {
		EntryRun(args);
	}
	public static int EntryRun(String[] args) {
        if (args.length != 2) {
            System.err.println(
                    "This program accepts exactly 2 command line arguments. 1.The pathname of the directory of interest 2.The fully qualified name of a Java type");
            return 0;
        } else{
        try{File dir = new File(args[0]);
        File[] Files = dir.listFiles();
        int[] counter = {0,0};
        String output = (args[1].split("\\."))[(args[1].split("\\.")).length-1];
        for (File file : Files) {
            if (file.isFile()) {
                if(file.getName().matches("(.*).java")) {
                	counter = count(output,args[0],file.getName(),counter);	
                }
            }
        }
        System.out.println(args[1]+". Declarations found: "+counter[0]+"; References found: "+counter[1]+".");
        return 1;
        }
        catch (NullPointerException e) {
        	System.err.println("An error was encountered trying to find the directory.");
        	return 0;
        }
        }
	}
	public static int[] count(String type,String dir,String name,int[] counter) {
	if (dir.charAt(dir.length() - 1) != '\\'){
	dir = dir + '\\';
	}
	dir = dir + name;
	try (BufferedReader br = new BufferedReader(new FileReader(dir))) {
	    String line;
	    while ((line = br.readLine()) != null) {
	    if(line.contains("class "+type)){
	    	counter[0]++;
	    	}
	    else if(line.contains(type+" ")) {
	    	counter[1]+=line.split(type, -1).length-1;
	    	}
	    }
	} catch (IOException e) {
        System.err.println("An error was encountered trying to read a file with the name: " + dir);
        System.exit(0);
	}
	return counter;
	}	
}

