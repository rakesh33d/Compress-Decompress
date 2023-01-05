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
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Rakesh
 */
public class Decompress {
    
    public static void DecompressFile(File file) throws FileNotFoundException, IOException{
         String filePath = file.getParent();
       //  System.out.print(filePath);
// create object to read compressed data of file
FileInputStream fis = new FileInputStream(file);
// create object to decompress file     
GZIPInputStream gzipIS = new GZIPInputStream(fis);
// create object to store decompressed data
FileOutputStream fos = new FileOutputStream(filePath + "/Decompressed.txt");

// create an array to store and decompress file data
byte[] buffer = new byte[2048];
int len;

while((len=gzipIS.read(buffer))!=-1){
    fos.write(buffer, 0, len);
}
// close all file objects
gzipIS.close();
fis.close();
fos.close();
    }
    
    public static void main(String[] args) throws IOException{
        
//        create file object to store path of compressed file
File path = new File("C:\\Users\\Rakesh\\OneDrive\\Desktop\\CompressedFile.gz");

DecompressFile(path);
    }
    
}
