package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGoogleDocsResult extends GxUserType
{
   public SdtGoogleDocsResult( )
   {
      this(  new ModelContext(SdtGoogleDocsResult.class));
   }

   public SdtGoogleDocsResult( ModelContext context )
   {
      super( context, "SdtGoogleDocsResult");
   }

   public SdtGoogleDocsResult( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtGoogleDocsResult");
   }

   public SdtGoogleDocsResult( StructSdtGoogleDocsResult struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Success") )
            {
               gxTv_SdtGoogleDocsResult_Success = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Error") )
            {
               gxTv_SdtGoogleDocsResult_Error = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Docs") )
            {
               if ( gxTv_SdtGoogleDocsResult_Docs == null )
               {
                  gxTv_SdtGoogleDocsResult_Docs = new GXBaseCollection<com.wwpbaseobjects.SdtGoogleDocsResult_Doc>(com.wwpbaseobjects.SdtGoogleDocsResult_Doc.class, "GoogleDocsResult.Doc", "DVelop.Extensions.GoogleDocs", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtGoogleDocsResult_Docs.readxmlcollection(oReader, "Docs", "Doc") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Docs") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "Result" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "DVelop.Extensions.GoogleDocs" ;
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
      oWriter.writeElement("Success", GXutil.booltostr( gxTv_SdtGoogleDocsResult_Success));
      if ( GXutil.strcmp(sNameSpace, "DVelop.Extensions.GoogleDocs") != 0 )
      {
         oWriter.writeAttribute("xmlns", "DVelop.Extensions.GoogleDocs");
      }
      oWriter.writeElement("Error", gxTv_SdtGoogleDocsResult_Error);
      if ( GXutil.strcmp(sNameSpace, "DVelop.Extensions.GoogleDocs") != 0 )
      {
         oWriter.writeAttribute("xmlns", "DVelop.Extensions.GoogleDocs");
      }
      if ( gxTv_SdtGoogleDocsResult_Docs != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "DVelop.Extensions.GoogleDocs") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "DVelop.Extensions.GoogleDocs" ;
         }
         else
         {
            sNameSpace1 = "DVelop.Extensions.GoogleDocs" ;
         }
         gxTv_SdtGoogleDocsResult_Docs.writexmlcollection(oWriter, "Docs", sNameSpace1, "Doc", sNameSpace1);
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
      AddObjectProperty("Success", gxTv_SdtGoogleDocsResult_Success, false, false);
      AddObjectProperty("Error", gxTv_SdtGoogleDocsResult_Error, false, false);
      if ( gxTv_SdtGoogleDocsResult_Docs != null )
      {
         AddObjectProperty("Docs", gxTv_SdtGoogleDocsResult_Docs, false, false);
      }
   }

   public boolean getgxTv_SdtGoogleDocsResult_Success( )
   {
      return gxTv_SdtGoogleDocsResult_Success ;
   }

   public void setgxTv_SdtGoogleDocsResult_Success( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Success = value ;
   }

   public String getgxTv_SdtGoogleDocsResult_Error( )
   {
      return gxTv_SdtGoogleDocsResult_Error ;
   }

   public void setgxTv_SdtGoogleDocsResult_Error( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Error = value ;
   }

   public GXBaseCollection<com.wwpbaseobjects.SdtGoogleDocsResult_Doc> getgxTv_SdtGoogleDocsResult_Docs( )
   {
      if ( gxTv_SdtGoogleDocsResult_Docs == null )
      {
         gxTv_SdtGoogleDocsResult_Docs = new GXBaseCollection<com.wwpbaseobjects.SdtGoogleDocsResult_Doc>(com.wwpbaseobjects.SdtGoogleDocsResult_Doc.class, "GoogleDocsResult.Doc", "DVelop.Extensions.GoogleDocs", remoteHandle);
      }
      gxTv_SdtGoogleDocsResult_Docs_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      return gxTv_SdtGoogleDocsResult_Docs ;
   }

   public void setgxTv_SdtGoogleDocsResult_Docs( GXBaseCollection<com.wwpbaseobjects.SdtGoogleDocsResult_Doc> value )
   {
      gxTv_SdtGoogleDocsResult_Docs_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Docs = value ;
   }

   public void setgxTv_SdtGoogleDocsResult_Docs_SetNull( )
   {
      gxTv_SdtGoogleDocsResult_Docs_N = (byte)(1) ;
      gxTv_SdtGoogleDocsResult_Docs = null ;
   }

   public boolean getgxTv_SdtGoogleDocsResult_Docs_IsNull( )
   {
      if ( gxTv_SdtGoogleDocsResult_Docs == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtGoogleDocsResult_Docs_N( )
   {
      return gxTv_SdtGoogleDocsResult_Docs_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      sdtIsNull = (byte)(1) ;
      gxTv_SdtGoogleDocsResult_Error = "" ;
      gxTv_SdtGoogleDocsResult_Docs_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtGoogleDocsResult Clone( )
   {
      return (com.wwpbaseobjects.SdtGoogleDocsResult)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtGoogleDocsResult struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtGoogleDocsResult_Success(struct.getSuccess());
         setgxTv_SdtGoogleDocsResult_Error(struct.getError());
         GXBaseCollection<com.wwpbaseobjects.SdtGoogleDocsResult_Doc> gxTv_SdtGoogleDocsResult_Docs_aux = new GXBaseCollection<com.wwpbaseobjects.SdtGoogleDocsResult_Doc>(com.wwpbaseobjects.SdtGoogleDocsResult_Doc.class, "GoogleDocsResult.Doc", "DVelop.Extensions.GoogleDocs", remoteHandle);
         Vector<com.wwpbaseobjects.StructSdtGoogleDocsResult_Doc> gxTv_SdtGoogleDocsResult_Docs_aux1 = struct.getDocs();
         if (gxTv_SdtGoogleDocsResult_Docs_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtGoogleDocsResult_Docs_aux1.size(); i++)
            {
               gxTv_SdtGoogleDocsResult_Docs_aux.add(new com.wwpbaseobjects.SdtGoogleDocsResult_Doc(gxTv_SdtGoogleDocsResult_Docs_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtGoogleDocsResult_Docs(gxTv_SdtGoogleDocsResult_Docs_aux);
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtGoogleDocsResult getStruct( )
   {
      com.wwpbaseobjects.StructSdtGoogleDocsResult struct = new com.wwpbaseobjects.StructSdtGoogleDocsResult ();
      struct.setSuccess(getgxTv_SdtGoogleDocsResult_Success());
      struct.setError(getgxTv_SdtGoogleDocsResult_Error());
      struct.setDocs(getgxTv_SdtGoogleDocsResult_Docs().getStruct());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected byte gxTv_SdtGoogleDocsResult_Docs_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtGoogleDocsResult_Success ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtGoogleDocsResult_Error ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtGoogleDocsResult_Doc> gxTv_SdtGoogleDocsResult_Docs_aux ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtGoogleDocsResult_Doc> gxTv_SdtGoogleDocsResult_Docs=null ;
}

