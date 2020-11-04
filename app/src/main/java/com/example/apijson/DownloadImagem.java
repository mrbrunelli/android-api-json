package com.example.apijson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class DownloadImagem extends AsyncTask<String, Void, Bitmap> {

    ImageView imageView;
    public DownloadImagem(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String link = strings[0];
        Bitmap imgRetorno = null;
        try {
            InputStream inputStream = new URL(link).openStream();
            imgRetorno = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgRetorno;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }
}
