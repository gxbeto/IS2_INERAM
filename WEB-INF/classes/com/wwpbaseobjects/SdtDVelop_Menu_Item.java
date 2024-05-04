package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDVelop_Menu_Item extends GxUserType
{
   public SdtDVelop_Menu_Item( )
   {
      this(  new ModelContext(SdtDVelop_Menu_Item.class));
   }

   public SdtDVelop_Menu_Item( ModelContext context )
   {
      super( context, "SdtDVelop_Menu_Item");
   }

   public SdtDVelop_Menu_Item( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtDVelop_Menu_Item");
   }

   public SdtDVelop_Menu_Item( StructSdtDVelop_Menu_Item struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "id") )
            {
               gxTv_SdtDVelop_Menu_Item_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "tooltip") )
            {
               gxTv_SdtDVelop_Menu_Item_Tooltip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "link") )
            {
               gxTv_SdtDVelop_Menu_Item_Link = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "linkTarget") )
            {
               gxTv_SdtDVelop_Menu_Item_Linktarget = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "iconClass") )
            {
               gxTv_SdtDVelop_Menu_Item_Iconclass = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "caption") )
            {
               gxTv_SdtDVelop_Menu_Item_Caption = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "authorizationKey") )
            {
               gxTv_SdtDVelop_Menu_Item_Authorizationkey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "additionalData") )
            {
               gxTv_SdtDVelop_Menu_Item_Additionaldata = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "submenuImage") )
            {
               gxTv_SdtDVelop_Menu_Item_Submenuimage = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "submenuImage_GXI") )
            {
               gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "subItems") )
            {
               if ( gxTv_SdtDVelop_Menu_Item_Subitems == null )
               {
                  gxTv_SdtDVelop_Menu_Item_Subitems = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>(com.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Gregory", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtDVelop_Menu_Item_Subitems.readxmlcollection(oReader, "subItems", "Item") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "subItems") )
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
         sName = "DVelop_Menu.Item" ;
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
      oWriter.writeElement("id", gxTv_SdtDVelop_Menu_Item_Id);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("tooltip", gxTv_SdtDVelop_Menu_Item_Tooltip);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("link", gxTv_SdtDVelop_Menu_Item_Link);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("linkTarget", gxTv_SdtDVelop_Menu_Item_Linktarget);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("iconClass", gxTv_SdtDVelop_Menu_Item_Iconclass);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("caption", gxTv_SdtDVelop_Menu_Item_Caption);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("authorizationKey", gxTv_SdtDVelop_Menu_Item_Authorizationkey);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("additionalData", gxTv_SdtDVelop_Menu_Item_Additionaldata);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("submenuImage", gxTv_SdtDVelop_Menu_Item_Submenuimage);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("submenuImage_GXI", gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( gxTv_SdtDVelop_Menu_Item_Subitems != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "Gregory") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "Gregory" ;
         }
         else
         {
            sNameSpace1 = "Gregory" ;
         }
         gxTv_SdtDVelop_Menu_Item_Subitems.writexmlcollection(oWriter, "subItems", sNameSpace1, "Item", sNameSpace1);
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
      AddObjectProperty("id", gxTv_SdtDVelop_Menu_Item_Id, false, false);
      AddObjectProperty("tooltip", gxTv_SdtDVelop_Menu_Item_Tooltip, false, false);
      AddObjectProperty("link", gxTv_SdtDVelop_Menu_Item_Link, false, false);
      AddObjectProperty("linkTarget", gxTv_SdtDVelop_Menu_Item_Linktarget, false, false);
      AddObjectProperty("iconClass", gxTv_SdtDVelop_Menu_Item_Iconclass, false, false);
      AddObjectProperty("caption", gxTv_SdtDVelop_Menu_Item_Caption, false, false);
      AddObjectProperty("authorizationKey", gxTv_SdtDVelop_Menu_Item_Authorizationkey, false, false);
      AddObjectProperty("additionalData", gxTv_SdtDVelop_Menu_Item_Additionaldata, false, false);
      AddObjectProperty("submenuImage", gxTv_SdtDVelop_Menu_Item_Submenuimage, false, false);
      AddObjectProperty("submenuImage_GXI", gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi, false, false);
      if ( gxTv_SdtDVelop_Menu_Item_Subitems != null )
      {
         AddObjectProperty("subItems", gxTv_SdtDVelop_Menu_Item_Subitems, false, false);
      }
   }

   public String getgxTv_SdtDVelop_Menu_Item_Id( )
   {
      return gxTv_SdtDVelop_Menu_Item_Id ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Id( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Id = value ;
   }

   public String getgxTv_SdtDVelop_Menu_Item_Tooltip( )
   {
      return gxTv_SdtDVelop_Menu_Item_Tooltip ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Tooltip( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Tooltip = value ;
   }

   public String getgxTv_SdtDVelop_Menu_Item_Link( )
   {
      return gxTv_SdtDVelop_Menu_Item_Link ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Link( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Link = value ;
   }

   public String getgxTv_SdtDVelop_Menu_Item_Linktarget( )
   {
      return gxTv_SdtDVelop_Menu_Item_Linktarget ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Linktarget( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Linktarget = value ;
   }

   public String getgxTv_SdtDVelop_Menu_Item_Iconclass( )
   {
      return gxTv_SdtDVelop_Menu_Item_Iconclass ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Iconclass( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Iconclass = value ;
   }

   public String getgxTv_SdtDVelop_Menu_Item_Caption( )
   {
      return gxTv_SdtDVelop_Menu_Item_Caption ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Caption( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Caption = value ;
   }

   public String getgxTv_SdtDVelop_Menu_Item_Authorizationkey( )
   {
      return gxTv_SdtDVelop_Menu_Item_Authorizationkey ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Authorizationkey( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Authorizationkey = value ;
   }

   public String getgxTv_SdtDVelop_Menu_Item_Additionaldata( )
   {
      return gxTv_SdtDVelop_Menu_Item_Additionaldata ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Additionaldata( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Additionaldata = value ;
   }

   @GxUpload
   public String getgxTv_SdtDVelop_Menu_Item_Submenuimage( )
   {
      return gxTv_SdtDVelop_Menu_Item_Submenuimage ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Submenuimage( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Submenuimage = value ;
   }

   public String getgxTv_SdtDVelop_Menu_Item_Submenuimage_gxi( )
   {
      return gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Submenuimage_gxi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi = value ;
   }

   public GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> getgxTv_SdtDVelop_Menu_Item_Subitems( )
   {
      if ( gxTv_SdtDVelop_Menu_Item_Subitems == null )
      {
         gxTv_SdtDVelop_Menu_Item_Subitems = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>(com.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Gregory", remoteHandle);
      }
      gxTv_SdtDVelop_Menu_Item_Subitems_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      return gxTv_SdtDVelop_Menu_Item_Subitems ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Subitems( GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> value )
   {
      gxTv_SdtDVelop_Menu_Item_Subitems_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_Item_Subitems = value ;
   }

   public void setgxTv_SdtDVelop_Menu_Item_Subitems_SetNull( )
   {
      gxTv_SdtDVelop_Menu_Item_Subitems_N = (byte)(1) ;
      gxTv_SdtDVelop_Menu_Item_Subitems = null ;
   }

   public boolean getgxTv_SdtDVelop_Menu_Item_Subitems_IsNull( )
   {
      if ( gxTv_SdtDVelop_Menu_Item_Subitems == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtDVelop_Menu_Item_Subitems_N( )
   {
      return gxTv_SdtDVelop_Menu_Item_Subitems_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtDVelop_Menu_Item_Id = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtDVelop_Menu_Item_Tooltip = "" ;
      gxTv_SdtDVelop_Menu_Item_Link = "" ;
      gxTv_SdtDVelop_Menu_Item_Linktarget = "" ;
      gxTv_SdtDVelop_Menu_Item_Iconclass = "" ;
      gxTv_SdtDVelop_Menu_Item_Caption = "" ;
      gxTv_SdtDVelop_Menu_Item_Authorizationkey = "" ;
      gxTv_SdtDVelop_Menu_Item_Additionaldata = "" ;
      gxTv_SdtDVelop_Menu_Item_Submenuimage = "" ;
      gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi = "" ;
      gxTv_SdtDVelop_Menu_Item_Subitems_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtDVelop_Menu_Item Clone( )
   {
      return (com.wwpbaseobjects.SdtDVelop_Menu_Item)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtDVelop_Menu_Item struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtDVelop_Menu_Item_Id(struct.getId());
         setgxTv_SdtDVelop_Menu_Item_Tooltip(struct.getTooltip());
         setgxTv_SdtDVelop_Menu_Item_Link(struct.getLink());
         setgxTv_SdtDVelop_Menu_Item_Linktarget(struct.getLinktarget());
         setgxTv_SdtDVelop_Menu_Item_Iconclass(struct.getIconclass());
         setgxTv_SdtDVelop_Menu_Item_Caption(struct.getCaption());
         setgxTv_SdtDVelop_Menu_Item_Authorizationkey(struct.getAuthorizationkey());
         setgxTv_SdtDVelop_Menu_Item_Additionaldata(struct.getAdditionaldata());
         setgxTv_SdtDVelop_Menu_Item_Submenuimage(struct.getSubmenuimage());
         setgxTv_SdtDVelop_Menu_Item_Submenuimage_gxi(struct.getSubmenuimage_gxi());
         GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> gxTv_SdtDVelop_Menu_Item_Subitems_aux = new GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item>(com.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "Gregory", remoteHandle);
         Vector<com.wwpbaseobjects.StructSdtDVelop_Menu_Item> gxTv_SdtDVelop_Menu_Item_Subitems_aux1 = struct.getSubitems();
         if (gxTv_SdtDVelop_Menu_Item_Subitems_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtDVelop_Menu_Item_Subitems_aux1.size(); i++)
            {
               gxTv_SdtDVelop_Menu_Item_Subitems_aux.add(new com.wwpbaseobjects.SdtDVelop_Menu_Item(gxTv_SdtDVelop_Menu_Item_Subitems_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtDVelop_Menu_Item_Subitems(gxTv_SdtDVelop_Menu_Item_Subitems_aux);
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtDVelop_Menu_Item getStruct( )
   {
      com.wwpbaseobjects.StructSdtDVelop_Menu_Item struct = new com.wwpbaseobjects.StructSdtDVelop_Menu_Item ();
      struct.setId(getgxTv_SdtDVelop_Menu_Item_Id());
      struct.setTooltip(getgxTv_SdtDVelop_Menu_Item_Tooltip());
      struct.setLink(getgxTv_SdtDVelop_Menu_Item_Link());
      struct.setLinktarget(getgxTv_SdtDVelop_Menu_Item_Linktarget());
      struct.setIconclass(getgxTv_SdtDVelop_Menu_Item_Iconclass());
      struct.setCaption(getgxTv_SdtDVelop_Menu_Item_Caption());
      struct.setAuthorizationkey(getgxTv_SdtDVelop_Menu_Item_Authorizationkey());
      struct.setAdditionaldata(getgxTv_SdtDVelop_Menu_Item_Additionaldata());
      struct.setSubmenuimage(getgxTv_SdtDVelop_Menu_Item_Submenuimage());
      struct.setSubmenuimage_gxi(getgxTv_SdtDVelop_Menu_Item_Submenuimage_gxi());
      struct.setSubitems(getgxTv_SdtDVelop_Menu_Item_Subitems().getStruct());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected byte gxTv_SdtDVelop_Menu_Item_Subitems_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtDVelop_Menu_Item_Id ;
   protected String gxTv_SdtDVelop_Menu_Item_Tooltip ;
   protected String gxTv_SdtDVelop_Menu_Item_Link ;
   protected String gxTv_SdtDVelop_Menu_Item_Linktarget ;
   protected String gxTv_SdtDVelop_Menu_Item_Iconclass ;
   protected String gxTv_SdtDVelop_Menu_Item_Caption ;
   protected String gxTv_SdtDVelop_Menu_Item_Authorizationkey ;
   protected String gxTv_SdtDVelop_Menu_Item_Additionaldata ;
   protected String gxTv_SdtDVelop_Menu_Item_Submenuimage_gxi ;
   protected String gxTv_SdtDVelop_Menu_Item_Submenuimage ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> gxTv_SdtDVelop_Menu_Item_Subitems_aux ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtDVelop_Menu_Item> gxTv_SdtDVelop_Menu_Item_Subitems=null ;
}

