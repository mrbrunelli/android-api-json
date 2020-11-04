package com.example.apijson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhesActivity extends AppCompatActivity {

    TextView lblNome;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        lblNome = findViewById(R.id.lblNome);
        imgLogo = findViewById(R.id.imgLogo);
        Intent tela = getIntent();
        if (tela != null) {
            Bundle parametros = tela.getExtras();
            if (parametros != null) {
                String nome = parametros.getString("nome");
                String linkImagem = parametros.getString("imagem");
                linkImagem = linkImagem.replace("~/", "http://controle.mdvsistemas.com.br/");
                lblNome.setText(nome);
                new DownloadImagem(imgLogo).execute(linkImagem);
            }
        }
    }
}