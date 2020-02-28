package practica;

public class Persona {
	private int id;
    private String nombreP;
    private String apellidoP;
    private String apellidoM;
    private int nip,fondos,numeroTarjeta;

    
    private int edadP;

    public int getId() {
        return id;
    }

    public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public int getFondos() {
		return fondos;
	}

	public void setFondos(int fondos) {
		this.fondos = fondos;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public void setId(int id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public int getEdadP() {
        return edadP;
    }

    public void setEdadP(int edadP) {
        this.edadP = edadP;
    }

    @Override
    public String toString() {
    	String variables = "Nombre: "+ nombreP +", Número de tarjeta: "+numeroTarjeta+", Fondos: "+fondos;
    	return variables;
        //return "Persona{" + "id: " + id + ", Nombre: " + nombreP + " " + apellidoP + " " + apellidoM + ", Edad: " + edadP + " años"+numeroTarjeta+"" +'}';
    }
}
