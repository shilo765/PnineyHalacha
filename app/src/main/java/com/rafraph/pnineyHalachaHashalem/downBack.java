package com.rafraph.pnineyHalachaHashalem;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class downBack extends Activity {
    downBack(){
        new MyTask().execute("my string parameter");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        // This starts the AsyncTask
        // Doesn't need to be in onCreate()
        new MyTask().execute("my string parameter");
    }

    // Here is the AsyncTask class:
    //
    // AsyncTask<Params, Progress, Result>.
    //    Params – the type (Object/primitive) you pass to the AsyncTask from .execute()
    //    Progress – the type that gets passed to onProgressUpdate()
    //    Result – the type returns from doInBackground()
    // Any of them can be String, Integer, Void, etc.
    public static class MyTask extends AsyncTask<String, Integer, String> {
        private static void unzip(String zipFile, String location) {
            try {
                File f = new File(location);
                if (!f.isDirectory()) {
                    f.mkdirs();
                }
                ZipInputStream zin = new ZipInputStream(new FileInputStream(zipFile));
                try {
                    ZipEntry ze = null;

                    while ((ze = zin.getNextEntry()) != null) {
                        String path = location + File.separator + ze.getName();

                        if(true){
                            if (ze.isDirectory()) {
                                File unzipFile = new File(path);
                                if (!unzipFile.isDirectory()) {
                                    unzipFile.mkdirs();
                                }
                            } else {
                                FileOutputStream fout = new FileOutputStream(path, false);

                                try {
                                    for (int c = zin.read(); c != -1; c = zin.read()) {
                                        fout.write(c);
                                    }
                                    zin.closeEntry();
                                } finally {
                                    fout.close();
                                }
                            }
                        }
                    }
                } finally {
                    zin.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Runs in UI before background thread is called
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Do something like display a progress bar
        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {
            // get the string from params, which is an array
            int i=0;
            while (i<1000) {
                System.out.println("hi"+i);
                i++;
            }
            File tempFile = new File(Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/EnglishBooks");
            if( tempFile.exists());
                unzip(Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/EnglishBooks/en.zip", Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/EnglishBooks");
            tempFile = new File(Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/SpanishBooks");
            if( tempFile.exists());
                unzip(Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/SpanishBooks/es.zip", Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/SpanishBooks");
            tempFile = new File(Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/RussianBooks");
            if( tempFile.exists());
                unzip(Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/RussianBooks/ru.zip", Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/RussianBooks");
            tempFile = new File(Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/FrenchBooks");
            if( tempFile.exists());
                unzip(Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/FrenchBooks/fr.zip", Environment.getExternalStorageDirectory().getPath() + "/DCIM/pnineyHalacha/FrenchBooks");


            // Do something that takes a long time, for example:

            return "this string is passed to onPostExecute";
        }

        // This is called from background thread but runs in UI
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            // Do things like update the progress bar
        }

        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            // Do things like hide the progress bar or change a TextView
        }
    }
}
