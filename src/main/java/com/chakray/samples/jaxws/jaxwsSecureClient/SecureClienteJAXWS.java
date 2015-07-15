package com.chakray.samples.jaxws.jaxwsSecureClient;

import javax.xml.ws.BindingProvider;

import org.blogs.ejemplos.serviciosaxis2.HolaatiFault_Exception;
import org.blogs.ejemplos.serviciosaxis2.HolamundoPortType;
import org.blogs.ejemplos.serviciosaxis2.HolamundoWSDL;
import org.blogs.ejemplos.serviciosaxis2.Persona;
import org.blogs.ejemplos.serviciosaxis2.PersonaRespuesta;

@SuppressWarnings("restriction")
public class SecureClienteJAXWS {

	public static void main(String[] args) {

		String trustStore = null;
		trustStore = "wso2carbon.jks";
		System.setProperty("javax.net.ssl.trustStore", trustStore);
		System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");
				
		HolamundoWSDL service = new HolamundoWSDL();
		HolamundoPortType port = service.getHolamundoHttpsSoap12Endpoint();

		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"https://localhost:9445/services/HolamundoWSDL");

		Persona persona = new Persona();
		persona.setNombre("Jorge");
		persona.setApellidos("Infante Osorio");

		PersonaRespuesta response;
		try {
			response = port.holaati(persona);
			System.out.println(response.getSaludo().toString());

		} catch (HolaatiFault_Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR STARTUP: " + e.getMessage());
		}
	}

}
