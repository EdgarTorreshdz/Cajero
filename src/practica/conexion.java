package practica;
import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class conexion {

	    private ObjectContainer db = null;
	    
	    private void abrirRegistro(){
	        db = Db4oEmbedded.openFile("registrousuarios");
	    }
	    
	    private void cerrarRegistro(){
	        db.close();
	    }
	    
	    public void insertarRegistro(Persona p){
	        abrirRegistro();
	        db.store(p);
	        cerrarRegistro();
	    }
	    
	    public Persona seleccionarPersona(Persona p){
	        abrirRegistro();
			ObjectSet resultado=db.queryByExample(p);
			Persona persona=(Persona) resultado.next();
			cerrarRegistro();
	        return persona;
	    }  

	    public void actualizacionPersona(int id, String nomP, String apeP, String apeM, int edadP,int nip, int fondos, int numeroTarjeta){
	        abrirRegistro();
	        Persona p = new Persona();
	        p.setId(id);
	        ObjectSet resultado = db.queryByExample(p);
	        Persona preresultado = (Persona) resultado.next();
	        preresultado.setNombreP(nomP);
	        preresultado.setApellidoP(apeP);
	        preresultado.setApellidoM(apeM);
	        preresultado.setEdadP(edadP);
	        preresultado.setNip(nip);
	        preresultado.setFondos(fondos);
	        preresultado.setNumeroTarjeta(numeroTarjeta);
	        db.store(preresultado);
	        cerrarRegistro();
	    }
	    public void eliminarRegistros(int id) {
			abrirRegistro();
			Persona p = new Persona();
			p.setId(id);
			ObjectSet resultado=db.queryByExample(p);
			Persona preresultado=(Persona) resultado.next();
			db.delete(preresultado);
			cerrarRegistro();
			
			
		}
}
