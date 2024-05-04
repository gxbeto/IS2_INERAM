package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtBlobData extends GxUserType
{
   public SdtBlobData( )
   {
      this(  new ModelContext(SdtBlobData.class));
   }

   public SdtBlobData( ModelContext context )
   {
      super( context, "SdtBlobData");
   }

   public SdtBlobData( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtBlobData");
   }

   public SdtBlobData( StructSdtBlobData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "path") )
            {
               gxTv_SdtBlobData_Path = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "filename") )
            {
               gxTv_SdtBlobData_Filename = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fileextension") )
            {
               gxTv_SdtBlobData_Fileextension = oReader.getValue() ;
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
         sName = "BlobData" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "Gregory" ;
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
      oWriter.writeElement("path", gxTv_SdtBlobData_Path);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("filename", gxTv_SdtBlobData_Filename);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("fileextension", gxTv_SdtBlobData_Fileextension);
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
      AddObjectProperty("path", gxTv_SdtBlobData_Path, false, false);
      AddObjectProperty("filename", gxTv_SdtBlobData_Filename, false, false);
      AddObjectProperty("fileextension", gxTv_SdtBlobData_Fileextension, false, false);
   }

   public String getgxTv_SdtBlobData_Path( )
   {
      return gxTv_SdtBlobData_Path ;
   }

   public void setgxTv_SdtBlobData_Path( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtBlobData_Path = value ;
   }

   public String getgxTv_SdtBlobData_Filename( )
   {
      return gxTv_SdtBlobData_Filename ;
   }

   public void setgxTv_SdtBlobData_Filename( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtBlobData_Filename = value ;
   }

   public String getgxTv_SdtBlobData_Fileextension( )
   {
      return gxTv_SdtBlobData_Fileextension ;
   }

   public void setgxTv_SdtBlobData_Fileextension( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtBlobData_Fileextension = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtBlobData_Path = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtBlobData_Filename = "" ;
      gxTv_SdtBlobData_Fileextension = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtBlobData Clone( )
   {
      return (com.wwpbaseobjects.SdtBlobData)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtBlobData struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtBlobData_Path(struct.getPath());
         setgxTv_SdtBlobData_Filename(struct.getFilename());
         setgxTv_SdtBlobData_Fileextension(struct.getFileextension());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtBlobData getStruct( )
   {
      com.wwpbaseobjects.StructSdtBlobData struct = new com.wwpbaseobjects.StructSdtBlobData ();
      struct.setPath(getgxTv_SdtBlobData_Path());
      struct.setFilename(getgxTv_SdtBlobData_Filename());
      struct.setFileextension(getgxTv_SdtBlobData_Fileextension());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtBlobData_Path ;
   protected String gxTv_SdtBlobData_Filename ;
   protected String gxTv_SdtBlobData_Fileextension ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

