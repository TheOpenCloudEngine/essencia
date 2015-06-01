package org.uengine.essencia.common;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SerializeUtils {
	public static <T> void serialize(Object object, Class<T> clazz, String filename) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(object, new File(filename));
	}
	
	public static <T> T deserialize(Class<T> clazz, String filename) throws JAXBException{
		File file = new File(filename);
		JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		T t = (T) jaxbUnmarshaller.unmarshal(file);
		return t;
	}
}
