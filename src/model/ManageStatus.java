/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.lang.Thread.State;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author HOANG_HUYNH
 */
public class ManageStatus implements IManageStatus{
    private Status status;
    public ManageStatus(){
        readStatus();
    }
    public void readStatus(){
        try{
            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource("C:\\Users\\HOANG_HUYNH\\Favorites\\Documents\\NetBeansProjects\\IDictionary\\savestate.xml");
            XMLStreamReader xsr = xif.createXMLStreamReader(xml);
            JAXBContext jc = JAXBContext.newInstance(Status.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            status = unmarshaller.unmarshal(xsr, Status.class).getValue();
        }
        catch(Exception w){
            status=null;
        }
    }
    public void writeStatus(){
        try {
            File file = new File("/savestate.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Status.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(status, file);
        } 
        catch (JAXBException e) {
            ////nothing
        }
    }
    public Status getStatus(){
        return this.status;
    }
}
