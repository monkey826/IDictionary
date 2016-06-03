/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
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
    private IStatus status;
    public ManageStatus(){
        readStatus();
    }
    public void readStatus(){
        try{
           
            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource(this.getClass().getClassLoader().getResource("data/savestate.xml").toString());
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
            File file = new File(this.getClass().getClassLoader().getResource("data/savestate.xml").toString().substring(6));
            JAXBContext jaxbContext = JAXBContext.newInstance(Status.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(status, file);
        } 
        catch (JAXBException e) {
            ////nothing
        }
    }
    public void setStatus(IStatus status){
        this.status=status;
        
    }
    public IStatus getStatus(){
        return this.status;
    }
    public void setSizeStatus(int sizeSpell,int sizeWordType,int sizeWordMean,int sizePhrase){
        status.setSizeMean(sizeWordMean);
        status.setSizeSpell(sizeSpell);
        status.setSizePhrase(sizePhrase);
        status.setSizeType(sizeWordType);
    }
    public void setColorStatus(String colorSpell,String colorWordType,String colorWordMean,String colorPhrase){
        status.setColorMean(colorWordMean);
        status.setColorPhrase(colorPhrase);
        status.setColorSpell(colorSpell);
        status.setColorType(colorWordType);
    }
    public void setLanguageStatus(int language){
        status.setLanguageDisplay(language);
    }
    public void setDictionaryStatus(int dict){
        status.setTypeDictionary(dict);
    }
}