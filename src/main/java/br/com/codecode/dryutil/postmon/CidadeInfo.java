package br.com.codecode.dryutil.postmon;

public class CidadeInfo {
	String area_km2; 
	int codigo_ibge; 
	String estado;
		
	@Override
	public String toString() {
		return "\n [area_km2=" + area_km2 + ", codigo_ibge=" + codigo_ibge + ", estado=" + estado + "]";
	}
	
	

}
