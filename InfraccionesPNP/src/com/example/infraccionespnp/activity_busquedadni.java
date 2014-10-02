package com.example.infraccionespnp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
//import android.widget.Toast;

public class activity_busquedadni extends Activity {

	LinearLayout layoutResultados;
	EditText etNroDNI;
	ProgressBar progBarBuscarDNI; 
	RadioGroup radioGroupEscogerOpcion;
	RadioButton rbIngresarPapeleta;
	RadioButton rbConsultarHistorial;
	
	//llamar al segundo activity
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busquedadni);
        
        //haciendo invisible el layout resultados hasta que se valide el DNI     
        layoutResultados = (LinearLayout)this.findViewById(R.id.linearlayoutResultados);
        layoutResultados.setVisibility(LinearLayout.GONE);
    }
	
	public void eventoBuscarDNI(View v){
		
		etNroDNI = (EditText)findViewById(R.id.etNumeroDNI);
		String numeroDNI = etNroDNI.getText().toString();
		
		//visibilidad del progressbar
		progBarBuscarDNI = (ProgressBar)this.findViewById(R.id.progressBarBuscarDNI);
		progBarBuscarDNI.setVisibility(ProgressBar.VISIBLE);
		
		//validar que el numero de DNI sea un numero de 8 digitos y no este en blanco
//		if(numeroDNI.trim().length() > 0){		
//			layoutResultados.setVisibility(LinearLayout.VISIBLE);
//		}
//		else{
//			Toast.makeText(getBaseContext(), "El número de DNI ", Toast.LENGTH_SHORT).show();
//		}
		
		if(!TextUtils.isEmpty(numeroDNI)){
			layoutResultados.setVisibility(LinearLayout.VISIBLE);
			//txtUserName.setError("Your message");			
		}
		//contar el numero de digitos
//		else if (){
//		}
		else{
			etNroDNI.setError("Por favor ingrese el número de DNI");
			//Toast.makeText(getBaseContext(), "Por favor ingrese el número de DNI", Toast.LENGTH_SHORT).show();
		}
	}

	public void eventoNuevaOhistorial(View v){		
		
		//rbIngresarPapeleta = (RadioButton)this.findViewById(R.id.radioIngresarPapeleta);
		radioGroupEscogerOpcion = (RadioGroup)findViewById(R.id.radioGroupOpciones);
			
		int id = radioGroupEscogerOpcion.getCheckedRadioButtonId();
		if (id == -1){
		    //no item selected
		}
		else{
		    if (id == R.id.radioIngresarPapeleta){
		    	Intent intent = new Intent(this, activity_ingresarnueva.class);
				startActivity(intent);
		    }					
			if (id == R.id.radioConsultarHistorial){				
			}				
		}
		
	}

}
