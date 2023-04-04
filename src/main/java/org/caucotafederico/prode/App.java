package org.caucotafederico.prode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Resultado> listadoResultados = null;
        List<Pronostico> listadoPronosticos = null;
        String archivoResultados = "C:\\Users\\fcaucota\\eclipse-workspace\\prode\\src\\resources\\resultados.csv";
        String archivoPronostico = "C:\\Users\\fcaucota\\eclipse-workspace\\prode\\src\\resources\\pronostico.csv";
        
        
        if(args.length == 0) {
        //	System.out.print("Faltan las rutas de los archivos");
        //	System.exit(88);
        }else {
    		archivoResultados = args[0];
        	if (args.length > 1) {
        		archivoResultados = args[1];
        	}
        		
        }
        
        try {
			listadoResultados = new CsvToBeanBuilder<Resultado>(new FileReader(archivoResultados))
					.withType(Resultado.class)
					.build()
					.parse();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
        	listadoPronosticos = new CsvToBeanBuilder<Pronostico>(new FileReader(archivoPronostico))
					.withType(Pronostico.class)
					.build()
					.parse();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("Puntaje : " + calcularPuntaje(listadoPronosticos, listadoResultados));
       
    }
    
    private static int calcularPuntaje(List<Pronostico> listadoPronosticos, List<Resultado> listadoResultados) {
    	int unPronostico = -1;
    	int difGoles = 0;
    	int puntos = 0;
    	
    	for(Resultado resultadoPartido : listadoResultados) {
			difGoles = resultadoPartido.getGolesEquipo1() - resultadoPartido.getGolesEquipo2();
    		for(Pronostico pron : listadoPronosticos) {
    			
    			//System.out.println(pron.getEquipo1().toUpperCase().trim() + " - " + resultadoPartido.getEquipo1().toUpperCase().trim());
    			//System.out.println(pron.getEquipo2().toUpperCase().trim() + " - " + resultadoPartido.getEquipo2().toUpperCase().trim());
    			if(pron.getEquipo1().toUpperCase().trim().equals(resultadoPartido.getEquipo1().toUpperCase().trim()) && 
    			   pron.getEquipo2().toUpperCase().trim().equals(resultadoPartido.getEquipo2().toUpperCase().trim())) {
    				
    				
    				if(pron.getGanaLocal().toUpperCase().equals("X")) {
    					unPronostico = 1;
    	        	}else {
    	            	if(pron.getGanaVisitante().toUpperCase().equals("X")) {
    	            		unPronostico = 2;
    	            	}else {
    	            		unPronostico = 0;
    	            	}
    	        	}
        			//System.out.println("Pronostico:" + unPronostico + " -- Dif Goles:" + difGoles );
    				if( ((difGoles > 0  ) && (unPronostico == 1)) || 
    					((difGoles == 0 ) && (unPronostico == 0)) ||
    					((difGoles < 0  ) && (unPronostico == 2)) ){
    					puntos++;
    				}
    			}
    		}
    	}
    	return puntos;
    	
    }
    
}