package com.chakray.samples.jaxws.jaxwsSecureClient;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

public class ClientPasswordCallback implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException, 
            UnsupportedCallbackException {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];

        if ("admin".equals(pc.getIdentifier())) {
            pc.setPassword("admin");
        } // else {...} - can add more users, access DB, etc.
    }
}

