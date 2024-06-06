package md.webscraper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.Resources;

public class Main {
    public static void main(String[] args) {

//        getAllLinksAndDownload(ListOfLinks.listOfLinks); // downloads all the links


        // below, the code renames the videos to their corresponding number
        File file = new File("/Users/ionel_marcel/Downloads");

        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().substring(files[i].getName().length() - 3).equals("mp4")) {
                String newName = "Topic nr. " + i + ".mp4";

                File fileAdded = new File(files[i].getPath());

                File fileFinalToRecordingsFolder = new File("/Users/ionel_marcel/Desktop/Java Tekwill/Zoom Recordings/" + newName);

                fileAdded.renameTo(fileFinalToRecordingsFolder);

            }
        }
    }


    public static void getAllLinksAndDownload(List<String> list) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {

            for (String link : list) {
                try {
                    desktop.browse(URI.create(link));
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
        }
    }
}