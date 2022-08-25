package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder data = new StringBuilder();
        try(FileInputStream inStream = new FileInputStream(file)) {
            int ch;
            while ((ch=inStream.read())!=-1)
                data.append((char) ch);

        } catch (FileNotFoundException e1) {

        } catch (IOException e2) {

        }

        String[] dataArray = data.toString().split("\n");
        String name = dataArray[0].split(":")[1].trim();
        Integer age = Integer.parseInt(dataArray[1].split(":")[1].trim());
        String email = dataArray[2].split(":")[1].trim();
        Long phone = Long.parseLong(dataArray[3].split(":")[1].trim());

        return new Profile(name, age, email, phone);
    }
}
