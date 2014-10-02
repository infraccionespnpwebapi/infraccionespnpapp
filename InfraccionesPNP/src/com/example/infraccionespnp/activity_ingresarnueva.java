package com.example.infraccionespnp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

//import android.widget.TextView;

public class activity_ingresarnueva extends Activity {

	//Date now = new Date();
	//TextView tvFecha = (TextView)this.findViewById(R.id.tvFechaInfraccion);
	Spinner spinnerCodigoInfracc;
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresarnueva);
        
        //tvFecha.setText(now.toString()); //sin formato
        //tvFecha.setText(obtenerFechaActual());
        llenarSpinnerCodInfrac();
    }
	
//	private String obtenerFechaActual(){
//		Date d = Calendar.getInstance().getTime(); // Current time
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // Set your date format        
//        return sdf.format(d); // Get Date String according to date format
//	}
	
	//llenar el spinner con el codigo de las infracciones
	private void llenarSpinnerCodInfrac(){
		
		spinnerCodigoInfracc = (Spinner)this.findViewById(R.id.spinnerCategInfraccion);		
		List<String> lista = new ArrayList<String>();
		ArrayList<String> listaMuyGraves = new ArrayList<String>();
		ArrayList<String> listaGraves = new ArrayList<String>();
		ArrayList<String> listaLeves = new ArrayList<String>();
		ArrayList<ArrayList<String>> lista1 = new ArrayList<ArrayList<String>>();
		
				
		//List<SomeBean> newList = new ArrayList<SomeBean>(otherList);
		
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

		lista1.add(listaLeves);
		
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
		//dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerCodigoInfracc.setAdapter(dataAdapter);
	}
	
}
