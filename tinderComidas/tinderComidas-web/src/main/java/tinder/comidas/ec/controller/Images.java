package tinder.comidas.ec.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import tinder.comidas.ec.model.Comida;
import tinder.comidas.ec.service.ComidaService;
import tinder.comidas.ec.util.SessionUtils;

@ManagedBean
@RequestScoped
public class Images {
	
	@Inject
	ComidaService comidaService;

	public StreamedContent getImage() throws IOException {
			HttpSession session = SessionUtils.getSession();

			Comida comida = new Comida();
      
            // So, browser is requesting the image. Get ID value from actual request param.
            String id = session.getAttribute("comidaId").toString();
             comida = comidaService.find(Long.valueOf(id));
            
            if(comida.getImagen() != null) {
            return new DefaultStreamedContent(new ByteArrayInputStream(comida.getImagen()));
            }else {
            	return null;
            }
        
    }
}
