/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.dry.postmon;

public class CEP {
	
	String bairro;
	String cidade; 
	long cep; 
	String logradouro;
	EstadoInfo estado_info;
	CidadeInfo cidade_info;
	
	@Override
	public String toString() {
		return "\n [bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + ", logradouro=" + logradouro
				+ ", \nestado_info=" + estado_info + ", \ncidade_info=" + cidade_info + "]";
	}

}
