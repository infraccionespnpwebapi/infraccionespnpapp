package com.example.infraccionespnp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
//import android.widget.Toast;

public class activity_busquedadni extends Activity {

	LinearLayout layoutResultados;
	EditText etNroDNI;
	RadioGroup radioGroupEscogerOpcion;
	ProgressBar progBarBuscarDNI = (ProgressBar)this.findViewById(R.id.progressBarBuscarDNI);	
	
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
		int n = numeroDNI.length();
		
		//validando el número de DNI
		if (TextUtils.isEmpty(numeroDNI)){
			etNroDNI.setError("Por favor ingrese el número de DNI");		
		}
		else{
			if(n==8){				
				progBarBuscarDNI.setVisibility(ProgressBar.VISIBLE);
				
				//enviar el número para consultar la base de datos
				//...si devuelve resultados, muestra el layout:
				
				progBarBuscarDNI.setVisibility(ProgressBar.GONE);
				layoutResultados.setVisibility(LinearLayout.VISIBLE);
			}
			else if(n<8 || n>8) etNroDNI.setError("El número de DNI debe tener 8 dígitos");
		}
	}

	public void eventoNuevaOhistorial(View v){		
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
