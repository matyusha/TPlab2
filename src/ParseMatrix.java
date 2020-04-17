import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ParseMatrix {
    private File file;
    private JAXBContext jaxbContext = JAXBContext.newInstance(Matrix.class);
    private Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    private Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    ParseMatrix() throws JAXBException {
        file = new File("Matrix.xml");
    }

    ParseMatrix(File file) throws JAXBException {
        this.file = file;
    }

    public Matrix ReadMatrix() throws JAXBException {
        return (Matrix) jaxbUnmarshaller.unmarshal(file);
    }

    public void WriteMatrix(Matrix matrix) throws JAXBException {
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(matrix, file);
        System.out.println("Matrix saved in file" + file.getName());
    }
}