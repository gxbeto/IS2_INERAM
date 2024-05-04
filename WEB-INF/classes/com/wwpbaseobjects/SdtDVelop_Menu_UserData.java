package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDVelop_Menu_UserData extends GxUserType
{
   public SdtDVelop_Menu_UserData( )
   {
      this(  new ModelContext(SdtDVelop_Menu_UserData.class));
   }

   public SdtDVelop_Menu_UserData( ModelContext context )
   {
      super( context, "SdtDVelop_Menu_UserData");
   }

   public SdtDVelop_Menu_UserData( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtDVelop_Menu_UserData");
   }

   public SdtDVelop_Menu_UserData( StructSdtDVelop_Menu_UserData struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PhotoUri") )
            {
               gxTv_SdtDVelop_Menu_UserData_Photouri = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FirstLine") )
            {
               gxTv_SdtDVelop_Menu_UserData_Firstline = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecondLine") )
            {
               gxTv_SdtDVelop_Menu_UserData_Secondline = oReader.getValue() ;
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
         sName = "DVelop_Menu_UserData" ;
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
      oWriter.writeElement("PhotoUri", gxTv_SdtDVelop_Menu_UserData_Photouri);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("FirstLine", gxTv_SdtDVelop_Menu_UserData_Firstline);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("SecondLine", gxTv_SdtDVelop_Menu_UserData_Secondline);
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
      AddObjectProperty("PhotoUri", gxTv_SdtDVelop_Menu_UserData_Photouri, false, false);
      AddObjectProperty("FirstLine", gxTv_SdtDVelop_Menu_UserData_Firstline, false, false);
      AddObjectProperty("SecondLine", gxTv_SdtDVelop_Menu_UserData_Secondline, false, false);
   }

   public String getgxTv_SdtDVelop_Menu_UserData_Photouri( )
   {
      return gxTv_SdtDVelop_Menu_UserData_Photouri ;
   }

   public void setgxTv_SdtDVelop_Menu_UserData_Photouri( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_UserData_Photouri = value ;
   }

   public String getgxTv_SdtDVelop_Menu_UserData_Firstline( )
   {
      return gxTv_SdtDVelop_Menu_UserData_Firstline ;
   }

   public void setgxTv_SdtDVelop_Menu_UserData_Firstline( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_UserData_Firstline = value ;
   }

   public String getgxTv_SdtDVelop_Menu_UserData_Secondline( )
   {
      return gxTv_SdtDVelop_Menu_UserData_Secondline ;
   }

   public void setgxTv_SdtDVelop_Menu_UserData_Secondline( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_UserData_Secondline = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtDVelop_Menu_UserData_Photouri = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtDVelop_Menu_UserData_Firstline = "" ;
      gxTv_SdtDVelop_Menu_UserData_Secondline = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtDVelop_Menu_UserData Clone( )
   {
      return (com.wwpbaseobjects.SdtDVelop_Menu_UserData)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtDVelop_Menu_UserData struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtDVelop_Menu_UserData_Photouri(struct.getPhotouri());
         setgxTv_SdtDVelop_Menu_UserData_Firstline(struct.getFirstline());
         setgxTv_SdtDVelop_Menu_UserData_Secondline(struct.getSecondline());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtDVelop_Menu_UserData getStruct( )
   {
      com.wwpbaseobjects.StructSdtDVelop_Menu_UserData struct = new com.wwpbaseobjects.StructSdtDVelop_Menu_UserData ();
      struct.setPhotouri(getgxTv_SdtDVelop_Menu_UserData_Photouri());
      struct.setFirstline(getgxTv_SdtDVelop_Menu_UserData_Firstline());
      struct.setSecondline(getgxTv_SdtDVelop_Menu_UserData_Secondline());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtDVelop_Menu_UserData_Photouri ;
   protected String gxTv_SdtDVelop_Menu_UserData_Firstline ;
   protected String gxTv_SdtDVelop_Menu_UserData_Secondline ;
}

