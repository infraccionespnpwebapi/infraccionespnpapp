package com.example.infraccionespnp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class activity_ingresarnueva extends Activity {

	Spinner spinnerCodigoInfracc;
	TextView tvFechaActual;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresarnueva);
        llenarSpinnerCodInfrac();
        setearFechaActual();        
    }	
	
	private void setearFechaActual(){
		final Calendar c = Calendar.getInstance();
        int anio = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        
        tvFechaActual = (TextView)this.findViewById(R.id.tvFechaInfraccion);
        tvFechaActual.setText(Integer.toString(dia) + "/" + Integer.toString(mes) + "/" + Integer.toString(anio));
	}
	
	//llenar el spinner con el codigo de las infracciones
	private void llenarSpinnerCodInfrac(){
		
		spinnerCodigoInfracc = (Spinner)this.findViewById(R.id.spinnerCategInfraccion);		
		List<String> lista = new ArrayList<String>();
		List<String> listaMuyGraves = new ArrayList<String>();
		List<String> listaGraves = new ArrayList<String>();
		List<String> listaLeves = new ArrayList<String>();		
				
		for(int x = 1; x < 71; x++) 
		{
			if( x<40 )
			{
				if( x < 10 ) 
				{
					if( x<9 ) {
						listaLeves.add("L0" + x + " - Leve");
					}
					listaGraves.add("G0" + x + " - Grave");
					listaMuyGraves.add("M0" + x + " - Muy Grave");
				}
				else listaMuyGraves.add("M" + x + " - Muy Grave");
			}			
			else {
				if( x>66 && x<70)
					continue;
				else listaGraves.add("G" + x + " - Grave");
			}	
	    }
		
		llenarListaConOtrasListas(listaGraves, lista);
		llenarListaConOtrasListas(listaMuyGraves, lista);
		llenarListaConOtrasListas(listaLeves, lista);
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerCodigoInfracc.setAdapter(dataAdapter);
	}
	
	private List<String> llenarListaConOtrasListas(List<String> lista_contenido, List<String> lista_para_llenar){		
		for (int i = 0; i < lista_contenido.size(); ++i) {
			lista_para_llenar.add(lista_contenido.get(i));
		    }
		return lista_para_llenar;
	}
	
}
