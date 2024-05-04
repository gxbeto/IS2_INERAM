package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGoogleDocsResult_Doc extends GxUserType
{
   public SdtGoogleDocsResult_Doc( )
   {
      this(  new ModelContext(SdtGoogleDocsResult_Doc.class));
   }

   public SdtGoogleDocsResult_Doc( ModelContext context )
   {
      super( context, "SdtGoogleDocsResult_Doc");
   }

   public SdtGoogleDocsResult_Doc( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtGoogleDocsResult_Doc");
   }

   public SdtGoogleDocsResult_Doc( StructSdtGoogleDocsResult_Doc struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Type") )
            {
               gxTv_SdtGoogleDocsResult_Doc_Type = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") )
            {
               gxTv_SdtGoogleDocsResult_Doc_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "URL") )
            {
               gxTv_SdtGoogleDocsResult_Doc_Url = oReader.getValue() ;
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
         sName = "GoogleDocsResult.Doc" ;
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
      oWriter.writeElement("Type", gxTv_SdtGoogleDocsResult_Doc_Type);
      if ( GXutil.strcmp(sNameSpace, "DVelop.Extensions.GoogleDocs") != 0 )
      {
         oWriter.writeAttribute("xmlns", "DVelop.Extensions.GoogleDocs");
      }
      oWriter.writeElement("Title", gxTv_SdtGoogleDocsResult_Doc_Title);
      if ( GXutil.strcmp(sNameSpace, "DVelop.Extensions.GoogleDocs") != 0 )
      {
         oWriter.writeAttribute("xmlns", "DVelop.Extensions.GoogleDocs");
      }
      oWriter.writeElement("URL", gxTv_SdtGoogleDocsResult_Doc_Url);
      if ( GXutil.strcmp(sNameSpace, "DVelop.Extensions.GoogleDocs") != 0 )
      {
         oWriter.writeAttribute("xmlns", "DVelop.Extensions.GoogleDocs");
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
      AddObjectProperty("Type", gxTv_SdtGoogleDocsResult_Doc_Type, false, false);
      AddObjectProperty("Title", gxTv_SdtGoogleDocsResult_Doc_Title, false, false);
      AddObjectProperty("URL", gxTv_SdtGoogleDocsResult_Doc_Url, false, false);
   }

   public String getgxTv_SdtGoogleDocsResult_Doc_Type( )
   {
      return gxTv_SdtGoogleDocsResult_Doc_Type ;
   }

   public void setgxTv_SdtGoogleDocsResult_Doc_Type( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Doc_Type = value ;
   }

   public String getgxTv_SdtGoogleDocsResult_Doc_Title( )
   {
      return gxTv_SdtGoogleDocsResult_Doc_Title ;
   }

   public void setgxTv_SdtGoogleDocsResult_Doc_Title( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Doc_Title = value ;
   }

   public String getgxTv_SdtGoogleDocsResult_Doc_Url( )
   {
      return gxTv_SdtGoogleDocsResult_Doc_Url ;
   }

   public void setgxTv_SdtGoogleDocsResult_Doc_Url( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Doc_Url = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGoogleDocsResult_Doc_Type = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtGoogleDocsResult_Doc_Title = "" ;
      gxTv_SdtGoogleDocsResult_Doc_Url = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtGoogleDocsResult_Doc Clone( )
   {
      return (com.wwpbaseobjects.SdtGoogleDocsResult_Doc)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtGoogleDocsResult_Doc struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtGoogleDocsResult_Doc_Type(struct.getType());
         setgxTv_SdtGoogleDocsResult_Doc_Title(struct.getTitle());
         setgxTv_SdtGoogleDocsResult_Doc_Url(struct.getUrl());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtGoogleDocsResult_Doc getStruct( )
   {
      com.wwpbaseobjects.StructSdtGoogleDocsResult_Doc struct = new com.wwpbaseobjects.StructSdtGoogleDocsResult_Doc ();
      struct.setType(getgxTv_SdtGoogleDocsResult_Doc_Type());
      struct.setTitle(getgxTv_SdtGoogleDocsResult_Doc_Title());
      struct.setUrl(getgxTv_SdtGoogleDocsResult_Doc_Url());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtGoogleDocsResult_Doc_Type ;
   protected String gxTv_SdtGoogleDocsResult_Doc_Title ;
   protected String gxTv_SdtGoogleDocsResult_Doc_Url ;
}

