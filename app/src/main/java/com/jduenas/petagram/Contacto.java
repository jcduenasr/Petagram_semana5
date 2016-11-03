package com.jduenas.petagram;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity implements View.OnClickListener {
    private TextView edt_nombres;
    private TextView edt_email;
    private TextView edt_mensaje;
    private Button btn_enviar_comentario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_contacto);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.toolbar);
        if (miActionBar!=null){
            setSupportActionBar(miActionBar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        edt_nombres = (TextView) findViewById(R.id.edt_nombres);
        edt_email = (TextView) findViewById(R.id.edt_email);
        edt_mensaje = (TextView) findViewById(R.id.edt_mensaje);
        btn_enviar_comentario = (Button)findViewById(R.id.btn_enviar_comentario);
        btn_enviar_comentario.setOnClickListener(this);
    }
    private void sendMail(){
        Toast.makeText(Contacto.this,"Enviando Mail",Toast.LENGTH_SHORT).show();
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(edt_email.getText().toString());
            msg.setRecipients(Message.RecipientType.TO,edt_email.getText().toString());
            msg.setSubject("Contacto desde App Petagram");
            msg.setSentDate(new Date());
            msg.setText(edt_mensaje.getText().toString()+"\n"+"Cordialmente: "+edt_nombres.getText().toString());
            Transport.send(msg, edt_email.getText().toString(), "password");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_enviar_comentario:
                sendMail();
                break;
        }
    }
}
