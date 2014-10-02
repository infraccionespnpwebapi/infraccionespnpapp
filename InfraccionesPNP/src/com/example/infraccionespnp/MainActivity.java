package com.example.infraccionespnp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
    
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
