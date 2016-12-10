package br.com.codecode.dryutil.postmon;

public class EstadoInfo {
	String area_km2;
	int codigo_ibge;
	String nome;

	
	@Override
	public String toString() {
		return "\n [area_km2=" + area_km2 + ", codigo_ibge=" + codigo_ibge + ", nome=" + nome + "]";
	}
	
	
}
