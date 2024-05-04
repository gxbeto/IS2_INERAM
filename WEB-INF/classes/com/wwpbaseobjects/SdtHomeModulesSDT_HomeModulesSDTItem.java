package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtHomeModulesSDT_HomeModulesSDTItem extends GxUserType
{
   public SdtHomeModulesSDT_HomeModulesSDTItem( )
   {
      this(  new ModelContext(SdtHomeModulesSDT_HomeModulesSDTItem.class));
   }

   public SdtHomeModulesSDT_HomeModulesSDTItem( ModelContext context )
   {
      super( context, "SdtHomeModulesSDT_HomeModulesSDTItem");
   }

   public SdtHomeModulesSDT_HomeModulesSDTItem( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle, context, "SdtHomeModulesSDT_HomeModulesSDTItem");
   }

   public SdtHomeModulesSDT_HomeModulesSDTItem( StructSdtHomeModulesSDT_HomeModulesSDTItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionTitle") )
            {
               gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionDescription") )
            {
               gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionIconThemeClass") )
            {
               gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionType") )
            {
               gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionBackgroundImage") )
            {
               gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionBackgroundImage_GXI") )
            {
               gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionSize") )
            {
               gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionProgressValue") )
            {
               gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionWCLink") )
            {
               gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink = oReader.getValue() ;
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
         sName = "HomeModulesSDT.HomeModulesSDTItem" ;
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
      oWriter.writeElement("OptionTitle", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OptionDescription", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OptionIconThemeClass", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OptionType", GXutil.trim( GXutil.str( gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OptionBackgroundImage", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OptionBackgroundImage_GXI", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OptionSize", GXutil.trim( GXutil.str( gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OptionProgressValue", GXutil.trim( GXutil.str( gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OptionWCLink", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
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
      AddObjectProperty("OptionTitle", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle, false, false);
      AddObjectProperty("OptionDescription", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription, false, false);
      AddObjectProperty("OptionIconThemeClass", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass, false, false);
      AddObjectProperty("OptionType", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype, false, false);
      AddObjectProperty("OptionBackgroundImage", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage, false, false);
      AddObjectProperty("OptionBackgroundImage_GXI", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi, false, false);
      AddObjectProperty("OptionSize", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize, false, false);
      AddObjectProperty("OptionProgressValue", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue, false, false);
      AddObjectProperty("OptionWCLink", gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink, false, false);
   }

   public String getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle ;
   }

   public void setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle = value ;
   }

   public String getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription ;
   }

   public void setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription = value ;
   }

   public String getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass ;
   }

   public void setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass = value ;
   }

   public byte getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype ;
   }

   public void setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype = value ;
   }

   @GxUpload
   public String getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage ;
   }

   public void setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage = value ;
   }

   public String getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi ;
   }

   public void setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi = value ;
   }

   public byte getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize ;
   }

   public void setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize = value ;
   }

   public byte getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue ;
   }

   public void setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue = value ;
   }

   public String getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink ;
   }

   public void setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription = "" ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass = "" ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage = "" ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi = "" ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem Clone( )
   {
      return (com.wwpbaseobjects.SdtHomeModulesSDT_HomeModulesSDTItem)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtHomeModulesSDT_HomeModulesSDTItem struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle(struct.getOptiontitle());
         setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription(struct.getOptiondescription());
         setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass(struct.getOptioniconthemeclass());
         setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype(struct.getOptiontype());
         setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage(struct.getOptionbackgroundimage());
         setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi(struct.getOptionbackgroundimage_gxi());
         setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize(struct.getOptionsize());
         setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue(struct.getOptionprogressvalue());
         setgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink(struct.getOptionwclink());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtHomeModulesSDT_HomeModulesSDTItem getStruct( )
   {
      com.wwpbaseobjects.StructSdtHomeModulesSDT_HomeModulesSDTItem struct = new com.wwpbaseobjects.StructSdtHomeModulesSDT_HomeModulesSDTItem ();
      struct.setOptiontitle(getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle());
      struct.setOptiondescription(getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription());
      struct.setOptioniconthemeclass(getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass());
      struct.setOptiontype(getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype());
      struct.setOptionbackgroundimage(getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage());
      struct.setOptionbackgroundimage_gxi(getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi());
      struct.setOptionsize(getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize());
      struct.setOptionprogressvalue(getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue());
      struct.setOptionwclink(getgxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected byte gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype ;
   protected byte gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize ;
   protected byte gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage ;
}

