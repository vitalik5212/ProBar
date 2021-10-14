package com.lessons.home.springsecurity.logic;
import java.io.*;

/**
 * This class copies files in other path
 * @author Vitalik Skuratovskyj
 */
public class FileCopier {

    /**
     * Path that has all files for copy
     */
    private static final String resources = "C:\\Users\\Vitalik\\Desktop\\Project\\Resources\\";
    /**
     * Phat in root's project, for temp save files
     */
    private static final String tempFiles = "src\\main\\resources\\static\\temp_images";

    /**
     * Method for copies files
     * @param fileName
     * @return path copied temp file
     */
    public static String copy(String fileName) {

        File from = new File(resources + fileName);
        File to = new File(tempFiles + "\\" + fileName);
        InputStream is = null;
        OutputStream os = null;

        try {
            to.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            is = new FileInputStream(from);
            os = new FileOutputStream(to);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "/temp_images\\" + to.getName();
    }
}
