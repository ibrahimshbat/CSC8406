package YiweiJing;


import java.io.*;

/**
 * CSC8406 2015/2016: Object Oriented Programming
 * Module Coursework
 * Created by Yiwei Jing on 22/10/2015 15:22
 * This is my assessment
 * Project name is league
 */
public class Base {
    /**
     * Define some useful params to be invoked from external methods
     * */
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String FILE_SUFFIX = ".txt";


    /**
     * judge if the file exists
     * @param name file name
     * @param filepath file path
     *  @return true:file not exist ; false:file exists
    * */
    public boolean exists(String name, String filepath) throws IOException {
        String note = "";
        boolean flag = false;
        File folder = new File(filepath);
        if (!folder.exists()) {
            note += "File folder " + filepath + " not exists!";
            flag = true;
        }
        File file = new File(filepath+"\\"+name+ this.FILE_SUFFIX);
        if (!file.exists()) {
            note += "File " + name + " not exists!";
            flag = true;
        }
        return flag;
    }

    /**
     *  create a file if it does not exist
     *  @param name file name
     * @param filepath file path
     *  @return file itself
     * */
    public File create(String name, String filepath) throws IOException {
        String note = "";
        boolean flag = true;
        File folder = new File(filepath);
        if (!folder.exists()) {
            folder.mkdirs();
            note += "File folder " + filepath + " not exists!Create!";
            flag = false;
        }
        File file = new File(filepath+"\\"+name+this.FILE_SUFFIX);
        if (!file.exists()) {
            file.createNewFile();
            note += "File " + name + " not exists!Create!";
            flag = false;
        }
        return file;
    }

    /**
     * read content from a file
     * @param file
     * @return the content of the file
     */
    public String read(File file) throws Exception {
        String rs = null;
        String nextLine = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            try {
                while ((nextLine = br.readLine()) != null) {
                    rs = nextLine;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
                if (fr != null) {
                    fr.close();
                }
            }
        }
        return rs;
    }

    /**
     * write the content into a file
     * @param file
     * @param content
     * @return true:write successfully ; false something wrong with writing
     */
    public boolean write(File file, String content) throws IOException {
        boolean flag = false;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(content.getBytes("UTF-8"));
            fos.close();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
