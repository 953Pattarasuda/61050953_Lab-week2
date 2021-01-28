import java.util.*;
import java.io.*;

class SOLID_S{
	
    public static void main(String[] args) throws Exception    
    {
     Journal j = new Journal();
     j.addEntry("I cried today");
     j.addEntry("I ate a bug");
     j.addEntry("God Knows");
     
     System.out.println(j);
     
     Persistence p = new Persistence();
     String filename = "journal.txt";
     p.saveToFile(j,filename,true);
     
     Runtime.getRuntime().exec("notepad.exe "+filename);
    }
    
}
class Journal{
	
    private ArrayList<String> entries = new ArrayList<>(); //เน€เธ�เน�เธ�เธซเธฑเธงเธ�เน�เธญเธ�เธดเธ•เธขเธฒเธชเธฒเธฃ
    private static int count = 0 ;

    public void addEntry (String text)
    {
        entries.add((++count)+": "+text);
    }

    public void removeEntry(int index)
    {
        entries.remove(index);
    }

    @Override
    public String toString()
    {
        return String.join(System.lineSeparator(), entries); 
    }
    
}

class Persistence
{
	 public void saveToFile(Journal journal,
			 				String filename,
			 				boolean overwrite) throws FileNotFoundException
	    {
	    	if(overwrite || new File(filename).exists())
	    	{
	    		try (PrintStream out = new PrintStream(filename))
	    		{
	    			out.println(journal.toString());
	    		}
	    	}
	    }
}
