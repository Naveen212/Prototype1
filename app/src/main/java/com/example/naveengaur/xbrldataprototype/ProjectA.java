package com.example.naveengaur.xbrldataprototype;

/**
 * Created by naveengaur on 4/4/18.
 */
import java.net.*;
import java.io.*;
import java.util.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;
import javax.xml.xpath.XPathExpressionException;
public class ProjectA {
    private static final String  URL1="http://edgaronline.api.mashery.com/v2/companies?companynames=*";
    private static final String  URL1_2="*&limit=10&appkey=geff5qfm8ce9ndqvve7hu9yy";
    private static final String xURL1="https://csuite.xbrl.us/php/dispatch.php?Task=xbrlValues&Element=Assets,Liabilities&Year=2014&Period=Y&CIK=";
    private static final String xURL1_2="&API_Key=4b979bba-7f27-4643-9d52-6b2cdb5a924a" ;

    private String CompName;
    private String Cik;
    private String Url_Api;
    private String Liabilities;
    private String Assets;
    private long assetsAmount;
    private long liabilitiesAmount;
    private static XPathFactory xpathFactory=null;
    private static XPath  xpath=null;
    private static InputSource  source;

    // constructor
    public ProjectA(String CompName)
    {
        this.CompName=CompName;
        getCik();
        elements();
    }
    // Connect to the URL
    private String url(String Url_Api)
    {
        String response=new String();
        try{
            URL url=new URL(Url_Api);
            BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            for(String l;(l=reader.readLine())!=null;response+=l);
            return response;


        }
        catch( MalformedURLException e )
        {

        }
        catch (IOException i)
        {
            System.out.print("Something went wrong");
        }
        return response;
    }
    // establishes connectionand calls parser
    public void getCik()
    {

        Url_Api=URL1+CompName+URL1_2;



        String response=url(Url_Api);
        this.Cik=Parser_For_Cik(response);

    }
    // to get the cik for the company, we need to parse the response

    private String Parser_For_Cik(String response)
    {

        int index=response.indexOf("cik");
        response=response.substring(index+14);

        int index2=response.indexOf('"');

        response=response.substring(0,index2);
        response.trim();
        return response;


    }
    // to get  the values of the elments for a particular company
    private void elements()
    { xpathFactory = XPathFactory.newInstance();
        xpath = xpathFactory.newXPath();
        Url_Api=xURL1+Cik+xURL1_2;
        String response=url(Url_Api);
        helper(response);



    }
    //this deletes the section of the response,after we've done with that
    //partiular part ofthe response
    private  void helper(String response)
    {
        String response1=response;
        // value of i dependsupon numberof elements
        for(int i=0;i<2;i++)
        {
            xpath(response1);
            StringBuffer str=new StringBuffer(response);
            int index=response.indexOf("<fact>");
            int index2=response.indexOf("<count>");
            str.replace(index,index2,"");

            response1=new String(str);


        }
    }
    // xml  parser
    private void xpath(String response)
    {
        try{
            source = new InputSource(new StringReader(response));
            String name = xpath.evaluate("/dataRequest/fact/elementName", source);
            source = new InputSource(new StringReader(response));
            String amount = xpath.evaluate("/dataRequest/fact/amount", source);
            valueLocator( name, amount);
        }
        catch(XPathExpressionException e)
        {

            System.out.println("Boom");
        }



    }

    // detects the element name and put its value in the right variable
    private void valueLocator(String name,String amount)
    {
        switch(name)
        {
            case "Liabilities" : this.liabilitiesAmount=Long.parseLong(amount);  // int can't store  the number we get,soconvert it into long.

                break;
            case "Assets": assetsAmount=Long.parseLong(amount);
                break;
            default : //liabilitiesAmount="pop";//System.out.println("Invalid Response");

        }



    }
    public String toString()
    {


        return "[Cik for the company is : "+ Cik+ " "+" Liabilities of the company are : "+ this.liabilitiesAmount+ " "+"Assets of the company are : "+this.assetsAmount+ " "+"]";


    }

    public long getAssetsAmountAmount()
    {
        return assetsAmount;

    }
    public long getLiabilitiesAmount()
    {
        return liabilitiesAmount;
    }
    public String getCIK()
    {
        return Cik;
    }






}
