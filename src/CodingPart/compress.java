/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodingPart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author rakesh
 */
public class compress {
    public static void compressFunction(File file) throws FileNotFoundException, IOException{
// store file path
        String filePath = file.getParent();
       
// create file objects to read, write and compress file       
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(filePath + "/CompressedFile.gz");
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        
// cteate a array to store and compress file data       
        byte[] buffer = new byte[1024];
        int len;
        
        while((len=fis.read(buffer))!= -1){
// data will be compressed in blocks of array size            
            gzipOS.write(buffer,0, len);
        }
// close all the file        
        gzipOS.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\Rakesh\\OneDrive\\Desktop\\rakesh.txt");
        
        compressFunction(path);
    }
}