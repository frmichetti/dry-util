package br.com.frmichetti.dryutil.teste.HTTP;

import java.net.URL;

import br.com.frmichetti.dryutil.factory.HTTP;

public class TesteHTTPSend {

    public static void main(String ... args) throws Exception {

	String resp = HTTP.doSend(new URL("http://localhost:8080/carhollics-webservice/services/usuario/firebaselogin"),"Sg6wwENmztNGHcBRljYxlaPXHMt2", "POST", 20_000);
	
	System.out.println(resp);
	

    }

}
