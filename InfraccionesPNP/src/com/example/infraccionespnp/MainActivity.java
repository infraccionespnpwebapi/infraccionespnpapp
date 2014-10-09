package com.example.infraccionespnp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //activity_busquedadni list = new activity_busquedadni();
        //list.eventoNuevaOhistorial(v)
    }
    
    public void eventoValidarLogin(View v){
    	EditText txtUser = (EditText)findViewById(R.id.etUsuario);
    	EditText txtPass = (EditText)findViewById(R.id.etClave);
    	
    	if(txtUser.getText().toString().equals("victor") && txtPass.getText().toString().equals("12345")) 
    	{
    		//llamar a la segunda actividad
    		Intent intent = new Intent(this, activity_busquedadni.class);
    		//enviar dato a la segunda vista
    		intent.putExtra("resultado", txtUser.getText().toString());
    		startActivity(intent);
    	}
    	else {
    		LoginIncorrecto();
    	}
    }
    
    private void LoginIncorrecto() {
		Toast.makeText(getBaseContext(), "usuario incorrecto!", Toast.LENGTH_SHORT).show();		
	}
}
