package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.print("İndirilecek dosyanın URL : ");
        String FILE_url = myObj.next();
        System.out.print("İndirilecek dosyanın kaydedilme ismi : ");
        String FILE_name = myObj.next();
        URL website = new URL(FILE_url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(FILE_name);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        System.out.print("İndirme tamamlandı!");
    }
}
