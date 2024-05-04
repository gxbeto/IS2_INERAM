package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_DesignSystemSettings extends GxUserType
{
   public SdtWWP_DesignSystemSettings( )
   {
      this(  new ModelContext(SdtWWP_DesignSystemSettings.class));
   }

   public SdtWWP_DesignSystemSettings( ModelContext context )
   {
      super( context, "SdtWWP_DesignSystemSettings");
   }

   public SdtWWP_DesignSystemSettings( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_DesignSystemSettings");
   }

   public SdtWWP_DesignSystemSettings( StructSdtWWP_DesignSystemSettings struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "BaseColor") )
            {
               gxTv_SdtWWP_DesignSystemSettings_Basecolor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "BackgroundStyle") )
            {
               gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FontSize") )
            {
               gxTv_SdtWWP_DesignSystemSettings_Fontsize = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuColor") )
            {
               gxTv_SdtWWP_DesignSystemSettings_Menucolor = oReader.getValue() ;
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
         sName = "WWP_DesignSystemSettings" ;
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
      oWriter.writeElement("BaseColor", gxTv_SdtWWP_DesignSystemSettings_Basecolor);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("BackgroundStyle", gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("FontSize", gxTv_SdtWWP_DesignSystemSettings_Fontsize);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuColor", gxTv_SdtWWP_DesignSystemSettings_Menucolor);
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
      AddObjectProperty("BaseColor", gxTv_SdtWWP_DesignSystemSettings_Basecolor, false, false);
      AddObjectProperty("BackgroundStyle", gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle, false, false);
      AddObjectProperty("FontSize", gxTv_SdtWWP_DesignSystemSettings_Fontsize, false, false);
      AddObjectProperty("MenuColor", gxTv_SdtWWP_DesignSystemSettings_Menucolor, false, false);
   }

   public String getgxTv_SdtWWP_DesignSystemSettings_Basecolor( )
   {
      return gxTv_SdtWWP_DesignSystemSettings_Basecolor ;
   }

   public void setgxTv_SdtWWP_DesignSystemSettings_Basecolor( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_DesignSystemSettings_Basecolor = value ;
   }

   public String getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle( )
   {
      return gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle ;
   }

   public void setgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle = value ;
   }

   public String getgxTv_SdtWWP_DesignSystemSettings_Fontsize( )
   {
      return gxTv_SdtWWP_DesignSystemSettings_Fontsize ;
   }

   public void setgxTv_SdtWWP_DesignSystemSettings_Fontsize( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_DesignSystemSettings_Fontsize = value ;
   }

   public String getgxTv_SdtWWP_DesignSystemSettings_Menucolor( )
   {
      return gxTv_SdtWWP_DesignSystemSettings_Menucolor ;
   }

   public void setgxTv_SdtWWP_DesignSystemSettings_Menucolor( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_DesignSystemSettings_Menucolor = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWP_DesignSystemSettings_Basecolor = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle = "" ;
      gxTv_SdtWWP_DesignSystemSettings_Fontsize = "" ;
      gxTv_SdtWWP_DesignSystemSettings_Menucolor = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWWP_DesignSystemSettings Clone( )
   {
      return (com.wwpbaseobjects.SdtWWP_DesignSystemSettings)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWWP_DesignSystemSettings struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWP_DesignSystemSettings_Basecolor(struct.getBasecolor());
         setgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle(struct.getBackgroundstyle());
         setgxTv_SdtWWP_DesignSystemSettings_Fontsize(struct.getFontsize());
         setgxTv_SdtWWP_DesignSystemSettings_Menucolor(struct.getMenucolor());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWWP_DesignSystemSettings getStruct( )
   {
      com.wwpbaseobjects.StructSdtWWP_DesignSystemSettings struct = new com.wwpbaseobjects.StructSdtWWP_DesignSystemSettings ();
      struct.setBasecolor(getgxTv_SdtWWP_DesignSystemSettings_Basecolor());
      struct.setBackgroundstyle(getgxTv_SdtWWP_DesignSystemSettings_Backgroundstyle());
      struct.setFontsize(getgxTv_SdtWWP_DesignSystemSettings_Fontsize());
      struct.setMenucolor(getgxTv_SdtWWP_DesignSystemSettings_Menucolor());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWP_DesignSystemSettings_Basecolor ;
   protected String gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle ;
   protected String gxTv_SdtWWP_DesignSystemSettings_Fontsize ;
   protected String gxTv_SdtWWP_DesignSystemSettings_Menucolor ;
}

