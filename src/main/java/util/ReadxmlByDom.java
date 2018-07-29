package util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import other.Phone;

/**
 * 用DOM方式读取xml文件
 * @author lzc
 */
public class ReadxmlByDom 
{
    private static DocumentBuilderFactory dbFactory = null;
    private static DocumentBuilder db = null;
    private static Document document = null;
    private static List<Phone> phones = null;
    static
    {
        try 
        {
            dbFactory = DocumentBuilderFactory.newInstance();
            db = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param fileName
     * @return
     * @throws Exception
     * @
     */
    public static synchronized List<Phone> getPhones(String fileName) throws Exception
    {
        document = db.parse(fileName);
        NodeList phoneList = document.getElementsByTagName("phone");
        phones = new ArrayList<Phone>();

        for (int i = 0; i < phoneList.getLength() ; i++)
        {
            Phone phone = new Phone();
            org.w3c.dom.Node node = phoneList.item(i);
            NodeList cList = node.getChildNodes();

            ArrayList<String> contents = new ArrayList<String>();
            for (int j = 1; j < cList.getLength() ; j += 2)
            {
                org.w3c.dom.Node cNode = cList.item(j);
                String content = cNode.getFirstChild().getTextContent();
                contents.add(content);
            }

            phone.setDeviceName(contents.get(0));
            phone.setPlatformName(contents.get(1));
            phone.setAppPackage(contents.get(2));
            phone.setAppActivity(contents.get(3));
            phone.setPlatformVersion(contents.get(4));
            phone.setResetKeyboard(contents.get(5));
            phone.setUnicodeKeyboard(contents.get(6));
            phone.setUdid(contents.get(7));
            phone.setHost(contents.get(8));
            phone.setPort(contents.get(9));
            
            phones.add(phone);
        }
        
        return phones;
    }
}
