package com.example.branoidass.models;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class JsonParsing extends AsyncTask<Void,Void,Void> {

    private static final String data1_url="http://13.235.223.51/bookletapp/public/api/test_api/get-all-menu";

    private static final String data2_url="http://13.235.223.51/bookletapp/public/api/test_api/get-all-announcements";

    private static final String data3_url="http://13.235.223.51/bookletapp/public/api/test_api/get-all-books";


    private String bufferData1= "";
    private String bufferData2= "";
    private String bufferData3= "";

    private ArrayList<String> names= new ArrayList<>();
    private ArrayList<String> imageUrls= new ArrayList<>();

    private ArrayList<String> ids= new ArrayList<>();
    private ArrayList<String> titles= new ArrayList<>();
    private ArrayList<String> images= new ArrayList<>();
    private ArrayList<String> image_captions= new ArrayList<>();
    private ArrayList<String> created_dates= new ArrayList<>();
    private ArrayList<String> last_updateds= new ArrayList<>();

    private ArrayList<String> ids1= new ArrayList<>();
    private ArrayList<String> book_names= new ArrayList<>();
    private ArrayList<String> book_images= new ArrayList<>();
    private ArrayList<String> subtitles= new ArrayList<>();
    private ArrayList<String> full_book_images= new ArrayList<>();

    private String title="";
    private String imageUrl="";

    private int id=0;
    private String title1="";
    private String image="";
    private String image_caption="";
    private String created_date="";
    private String last_updated="";

    private int id1 =0;
    private String book_name="";
    private String book_image="";
    private String subtitle="";
    private String full_book_image="";

    @Override
    protected Void doInBackground(Void... voids) {

        URL url=null;
        URL url1=null;
        URL urlPage2=null;

        try {
            url=new URL(data1_url);
            url1=new URL(data3_url);
            urlPage2=new URL(data2_url);

            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            HttpURLConnection httpURLConnection2=(HttpURLConnection) urlPage2.openConnection();
            HttpURLConnection httpURLConnection3=(HttpURLConnection) urlPage2.openConnection();

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection2.setRequestMethod("GET");
            httpURLConnection3.setRequestMethod("GET");

            httpURLConnection.connect();
            httpURLConnection2.connect();
            httpURLConnection3.connect();

            InputStream inputStream=httpURLConnection.getInputStream();
            InputStream inputStream2=httpURLConnection.getInputStream();
            InputStream inputStream3=httpURLConnection.getInputStream();

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            BufferedReader bufferedReader2=new BufferedReader(new InputStreamReader(inputStream2));
            BufferedReader bufferedReader3=new BufferedReader(new InputStreamReader(inputStream3));



            String line="";
            String line2="";
            String line3="";

            while (line!=null){
                line=bufferedReader.readLine();

                bufferData1=bufferData1+line;
            }

            while (line2!=null){
                line2=bufferedReader2.readLine();
                bufferData2=bufferData2+line2;

            }

            while (line3!=null){
                line3=bufferedReader3.readLine();
                bufferData3=bufferData3+line3;

            }

            JSONObject jsonObject=new JSONObject(bufferData1);
            JSONObject jsonObject2=new JSONObject(bufferData2);
            JSONObject jsonObject3=new JSONObject(bufferData3);

            JSONArray jsonArray=jsonObject.getJSONArray("menu");
            JSONArray jsonArray2=jsonObject2.getJSONArray("announcement");
            JSONArray jsonArray3=jsonObject3.getJSONArray("books");


            for(int i=0;i<jsonArray3.length();i++){
                JSONObject jsonObject31=jsonArray.getJSONObject(i);

                id1=jsonObject31.getInt("id");
                book_name=book_name+jsonObject31.get("title");
                book_image=book_image+jsonObject31.get("image");
                subtitle=subtitle+jsonObject31.get("image_caption");
                full_book_image=full_book_image+jsonObject31.get("created_date");

                ids1.add("id");
                book_names.add("title1");
                book_images.add("image");
                subtitles.add("image_caption");
                full_book_images.add("created_date");


            }

            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1=jsonArray.getJSONObject(i);

                title=title+jsonObject1.get("title");
                imageUrl=imageUrl+jsonObject1.get("image");

                names.add(title);
                imageUrls.add(imageUrl);
            }

            for(int i=0;i<jsonArray2.length();i++){
                JSONObject jsonObject21=jsonArray2.getJSONObject(i);

                 id=jsonObject21.getInt("id");
                 title1=title1+jsonObject21.get("title");
                 image=image+jsonObject21.get("image");
                 image_caption=image_caption+jsonObject21.get("image_caption");
                 created_date=created_date+jsonObject21.get("created_date");
                 last_updated=last_updated+jsonObject21.get("last_updated");

                 ids1.add("id");
                 titles.add("title1");
                 images.add("image");
                 image_captions.add("image_caption");
                 created_dates.add("created_date");
                 last_updateds.add("last_updated");


            }



        }


        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);




    }
}
