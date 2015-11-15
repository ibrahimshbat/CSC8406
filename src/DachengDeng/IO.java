package DachengDeng;

import java.util.*;
import java.io.*;

/**
 * This class is used for handle files by called different methods
 * 
 * @author Dacheng Deng
 * @version 2015.10.29
 */
public class IO
{
    //define the path of file
    String path;

    /**
     * Delete files
     * @param fileName   name of file 
     */
    public void delFile(String fileName)
    {
         path="D:"+File.separator+"blueJ"+File.separator+fileName;
         File file=new File(path);
         try{
            file.delete();
        }catch (Exception e) {
            System.out.println("Not found file!");
        }
    }
    
    /**
     * Create documents to save players' data
     * @param fileName   name of file 
     */
    public void createFile(String fileName)
    {
        try{
            path="D:"+File.separator+"blueJ"+File.separator+fileName;
            File file=new File(path);
            file.createNewFile();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Rewrite *.txt file 
     * @param fileName   name of file 
     * @param array   the arraylist will be wrote
     * @param index   the index of data saved in arraylist 
     */
    public void rewrite(String fileName,ArrayList<String> array,int index) throws IOException
    {
        array.remove(index);
        delFile(fileName);
        createFile(fileName);
        for(int i=0;i<array.size();i++){
            writeData(fileName,array.get(i));
        }
    }
    
    /**
     * Read data and save to ArrayList
     * @param txtName   name of file 
     * @param ifo   the arraylist will be wrote
     */
    public void readData(String txtName,ArrayList<String> ifo) throws IOException
    {
        ifo.clear();
        try{
             String path="D:"+File.separator+"blueJ"+File.separator+txtName;
             BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
             for (String line = br.readLine(); line != null; line = br.readLine()) {
                 ifo.add(line);
                }
                br.close();
            }catch (FileNotFoundException e) {
            System.out.println("Not found file! ");
        }
    }
    
    /**
     * Write data to *.txt document
     * @param txtName   name of file 
     * @param data   the data will be wrote to file
     */
    public void writeData(String txtName, String data) throws IOException
    {
        String path="D:"+File.separator+"blueJ"+File.separator+txtName;
        File file=new File(path);
        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(new FileWriter(file,true));
            outFile.println(data);
            outFile.flush();
        }catch (IOException e) {
            System.out.println("Cannot found the file!");
        }
    }
}
