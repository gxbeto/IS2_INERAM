package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDVB_SDTDropDownOptionsData_Item extends GxUserType
{
   public SdtDVB_SDTDropDownOptionsData_Item( )
   {
      this(  new ModelContext(SdtDVB_SDTDropDownOptionsData_Item.class));
   }

   public SdtDVB_SDTDropDownOptionsData_Item( ModelContext context )
   {
      super( context, "SdtDVB_SDTDropDownOptionsData_Item");
   }

   public SdtDVB_SDTDropDownOptionsData_Item( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle, context, "SdtDVB_SDTDropDownOptionsData_Item");
   }

   public SdtDVB_SDTDropDownOptionsData_Item( StructSdtDVB_SDTDropDownOptionsData_Item struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Icon") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Icon_GXI") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FontIcon") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Tooltip") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Link") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EventKey") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "IsDivider") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "JSonclickEvent") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ThemeClass") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass = oReader.getValue() ;
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
         sName = "DVB_SDTDropDownOptionsData.Item" ;
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
      oWriter.writeElement("Icon", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("Icon_GXI", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("FontIcon", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("Title", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("Tooltip", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("Link", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("EventKey", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("IsDivider", GXutil.booltostr( gxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider));
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("JSonclickEvent", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("ThemeClass", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
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
      AddObjectProperty("Icon", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon, false, false);
      AddObjectProperty("Icon_GXI", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi, false, false);
      AddObjectProperty("FontIcon", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon, false, false);
      AddObjectProperty("Title", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title, false, false);
      AddObjectProperty("Tooltip", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip, false, false);
      AddObjectProperty("Link", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link, false, false);
      AddObjectProperty("EventKey", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey, false, false);
      AddObjectProperty("IsDivider", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider, false, false);
      AddObjectProperty("JSonclickEvent", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent, false, false);
      AddObjectProperty("ThemeClass", gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass, false, false);
   }

   @GxUpload
   public String getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Link( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Link( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey = value ;
   }

   public boolean getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item Clone( )
   {
      return (com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtDVB_SDTDropDownOptionsData_Item struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon(struct.getIcon());
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi(struct.getIcon_gxi());
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon(struct.getFonticon());
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title(struct.getTitle());
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip(struct.getTooltip());
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Link(struct.getLink());
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey(struct.getEventkey());
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider(struct.getIsdivider());
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent(struct.getJsonclickevent());
         setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass(struct.getThemeclass());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtDVB_SDTDropDownOptionsData_Item getStruct( )
   {
      com.wwpbaseobjects.StructSdtDVB_SDTDropDownOptionsData_Item struct = new com.wwpbaseobjects.StructSdtDVB_SDTDropDownOptionsData_Item ();
      struct.setIcon(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon());
      struct.setIcon_gxi(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi());
      struct.setFonticon(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon());
      struct.setTitle(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title());
      struct.setTooltip(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip());
      struct.setLink(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Link());
      struct.setEventkey(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey());
      struct.setIsdivider(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider());
      struct.setJsonclickevent(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent());
      struct.setThemeclass(getgxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip ;
   protected String sTagName ;
   protected boolean gxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon ;
}

