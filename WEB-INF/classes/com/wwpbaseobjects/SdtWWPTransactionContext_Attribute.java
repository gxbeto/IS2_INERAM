package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPTransactionContext_Attribute extends GxUserType
{
   public SdtWWPTransactionContext_Attribute( )
   {
      this(  new ModelContext(SdtWWPTransactionContext_Attribute.class));
   }

   public SdtWWPTransactionContext_Attribute( ModelContext context )
   {
      super( context, "SdtWWPTransactionContext_Attribute");
   }

   public SdtWWPTransactionContext_Attribute( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPTransactionContext_Attribute");
   }

   public SdtWWPTransactionContext_Attribute( StructSdtWWPTransactionContext_Attribute struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "AttributeName") )
            {
               gxTv_SdtWWPTransactionContext_Attribute_Attributename = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AttributeValue") )
            {
               gxTv_SdtWWPTransactionContext_Attribute_Attributevalue = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "WWPTransactionContext.Attribute" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("AttributeName", gxTv_SdtWWPTransactionContext_Attribute_Attributename);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("AttributeValue", gxTv_SdtWWPTransactionContext_Attribute_Attributevalue);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeEndElement();
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("AttributeName", gxTv_SdtWWPTransactionContext_Attribute_Attributename, false, false);
      AddObjectProperty("AttributeValue", gxTv_SdtWWPTransactionContext_Attribute_Attributevalue, false, false);
   }

   public String getgxTv_SdtWWPTransactionContext_Attribute_Attributename( )
   {
      return gxTv_SdtWWPTransactionContext_Attribute_Attributename ;
   }

   public void setgxTv_SdtWWPTransactionContext_Attribute_Attributename( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Attribute_Attributename = value ;
   }

   public String getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( )
   {
      return gxTv_SdtWWPTransactionContext_Attribute_Attributevalue ;
   }

   public void setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Attribute_Attributevalue = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPTransactionContext_Attribute_Attributename = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWPTransactionContext_Attribute_Attributevalue = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWWPTransactionContext_Attribute Clone( )
   {
      return (com.wwpbaseobjects.SdtWWPTransactionContext_Attribute)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWWPTransactionContext_Attribute struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWPTransactionContext_Attribute_Attributename(struct.getAttributename());
         setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(struct.getAttributevalue());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWWPTransactionContext_Attribute getStruct( )
   {
      com.wwpbaseobjects.StructSdtWWPTransactionContext_Attribute struct = new com.wwpbaseobjects.StructSdtWWPTransactionContext_Attribute ();
      struct.setAttributename(getgxTv_SdtWWPTransactionContext_Attribute_Attributename());
      struct.setAttributevalue(getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPTransactionContext_Attribute_Attributename ;
   protected String gxTv_SdtWWPTransactionContext_Attribute_Attributevalue ;
}

