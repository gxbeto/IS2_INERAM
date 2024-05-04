package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtMenuItem extends GxSilentTrnSdt
{
   public SdtMenuItem( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtMenuItem.class));
   }

   public SdtMenuItem( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "SdtMenuItem");
      initialize( remoteHandle) ;
   }

   public SdtMenuItem( int remoteHandle ,
                       StructSdtMenuItem struct )
   {
      this(remoteHandle);
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

   public void Load( short AV10MenuItemId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV10MenuItemId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"MenuItemId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WWPBaseObjects\\MenuItem");
      metadata.set("BT", "MenuItem");
      metadata.set("PK", "[ \"MenuItemId\" ]");
      metadata.set("PKAssigned", "[ \"MenuItemId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"MenuItemId\" ],\"FKMap\":[ \"MenuItemFatherId-MenuItemId\" ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemId") )
            {
               gxTv_SdtMenuItem_Menuitemid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemCaption") )
            {
               gxTv_SdtMenuItem_Menuitemcaption = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemOrder") )
            {
               gxTv_SdtMenuItem_Menuitemorder = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemFatherId") )
            {
               gxTv_SdtMenuItem_Menuitemfatherid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemFatherCaption") )
            {
               gxTv_SdtMenuItem_Menuitemfathercaption = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemFatherType") )
            {
               gxTv_SdtMenuItem_Menuitemfathertype = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemType") )
            {
               gxTv_SdtMenuItem_Menuitemtype = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemLink") )
            {
               gxTv_SdtMenuItem_Menuitemlink = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemLinkParameters") )
            {
               gxTv_SdtMenuItem_Menuitemlinkparameters = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemLinkTarget") )
            {
               gxTv_SdtMenuItem_Menuitemlinktarget = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemIconClass") )
            {
               gxTv_SdtMenuItem_Menuitemiconclass = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemShowDeveloperMenuOption") )
            {
               gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemShowEditMenuOptions") )
            {
               gxTv_SdtMenuItem_Menuitemshoweditmenuoptions = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtMenuItem_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtMenuItem_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemId_Z") )
            {
               gxTv_SdtMenuItem_Menuitemid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemCaption_Z") )
            {
               gxTv_SdtMenuItem_Menuitemcaption_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemOrder_Z") )
            {
               gxTv_SdtMenuItem_Menuitemorder_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemFatherId_Z") )
            {
               gxTv_SdtMenuItem_Menuitemfatherid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemFatherCaption_Z") )
            {
               gxTv_SdtMenuItem_Menuitemfathercaption_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemFatherType_Z") )
            {
               gxTv_SdtMenuItem_Menuitemfathertype_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemType_Z") )
            {
               gxTv_SdtMenuItem_Menuitemtype_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemLink_Z") )
            {
               gxTv_SdtMenuItem_Menuitemlink_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemLinkParameters_Z") )
            {
               gxTv_SdtMenuItem_Menuitemlinkparameters_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemLinkTarget_Z") )
            {
               gxTv_SdtMenuItem_Menuitemlinktarget_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemIconClass_Z") )
            {
               gxTv_SdtMenuItem_Menuitemiconclass_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemShowDeveloperMenuOption_Z") )
            {
               gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemShowEditMenuOptions_Z") )
            {
               gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MenuItemFatherId_N") )
            {
               gxTv_SdtMenuItem_Menuitemfatherid_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "MenuItem" ;
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
      oWriter.writeElement("MenuItemId", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemCaption", gxTv_SdtMenuItem_Menuitemcaption);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemOrder", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemorder, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemFatherId", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemfatherid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemFatherCaption", gxTv_SdtMenuItem_Menuitemfathercaption);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemFatherType", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemfathertype, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemType", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemtype, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemLink", gxTv_SdtMenuItem_Menuitemlink);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemLinkParameters", gxTv_SdtMenuItem_Menuitemlinkparameters);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemLinkTarget", gxTv_SdtMenuItem_Menuitemlinktarget);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemIconClass", gxTv_SdtMenuItem_Menuitemiconclass);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemShowDeveloperMenuOption", GXutil.booltostr( gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("MenuItemShowEditMenuOptions", GXutil.booltostr( gxTv_SdtMenuItem_Menuitemshoweditmenuoptions));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtMenuItem_Mode);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemId_Z", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemCaption_Z", gxTv_SdtMenuItem_Menuitemcaption_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemOrder_Z", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemorder_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemFatherId_Z", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemfatherid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemFatherCaption_Z", gxTv_SdtMenuItem_Menuitemfathercaption_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemFatherType_Z", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemfathertype_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemType_Z", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemtype_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemLink_Z", gxTv_SdtMenuItem_Menuitemlink_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemLinkParameters_Z", gxTv_SdtMenuItem_Menuitemlinkparameters_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemLinkTarget_Z", gxTv_SdtMenuItem_Menuitemlinktarget_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemIconClass_Z", gxTv_SdtMenuItem_Menuitemiconclass_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemShowDeveloperMenuOption_Z", GXutil.booltostr( gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemShowEditMenuOptions_Z", GXutil.booltostr( gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("MenuItemFatherId_N", GXutil.trim( GXutil.str( gxTv_SdtMenuItem_Menuitemfatherid_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
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
      AddObjectProperty("MenuItemId", gxTv_SdtMenuItem_Menuitemid, false, includeNonInitialized);
      AddObjectProperty("MenuItemCaption", gxTv_SdtMenuItem_Menuitemcaption, false, includeNonInitialized);
      AddObjectProperty("MenuItemOrder", gxTv_SdtMenuItem_Menuitemorder, false, includeNonInitialized);
      AddObjectProperty("MenuItemFatherId", gxTv_SdtMenuItem_Menuitemfatherid, false, includeNonInitialized);
      AddObjectProperty("MenuItemFatherId_N", gxTv_SdtMenuItem_Menuitemfatherid_N, false, includeNonInitialized);
      AddObjectProperty("MenuItemFatherCaption", gxTv_SdtMenuItem_Menuitemfathercaption, false, includeNonInitialized);
      AddObjectProperty("MenuItemFatherType", gxTv_SdtMenuItem_Menuitemfathertype, false, includeNonInitialized);
      AddObjectProperty("MenuItemType", gxTv_SdtMenuItem_Menuitemtype, false, includeNonInitialized);
      AddObjectProperty("MenuItemLink", gxTv_SdtMenuItem_Menuitemlink, false, includeNonInitialized);
      AddObjectProperty("MenuItemLinkParameters", gxTv_SdtMenuItem_Menuitemlinkparameters, false, includeNonInitialized);
      AddObjectProperty("MenuItemLinkTarget", gxTv_SdtMenuItem_Menuitemlinktarget, false, includeNonInitialized);
      AddObjectProperty("MenuItemIconClass", gxTv_SdtMenuItem_Menuitemiconclass, false, includeNonInitialized);
      AddObjectProperty("MenuItemShowDeveloperMenuOption", gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption, false, includeNonInitialized);
      AddObjectProperty("MenuItemShowEditMenuOptions", gxTv_SdtMenuItem_Menuitemshoweditmenuoptions, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtMenuItem_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtMenuItem_Initialized, false, includeNonInitialized);
         AddObjectProperty("MenuItemId_Z", gxTv_SdtMenuItem_Menuitemid_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemCaption_Z", gxTv_SdtMenuItem_Menuitemcaption_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemOrder_Z", gxTv_SdtMenuItem_Menuitemorder_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemFatherId_Z", gxTv_SdtMenuItem_Menuitemfatherid_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemFatherCaption_Z", gxTv_SdtMenuItem_Menuitemfathercaption_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemFatherType_Z", gxTv_SdtMenuItem_Menuitemfathertype_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemType_Z", gxTv_SdtMenuItem_Menuitemtype_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemLink_Z", gxTv_SdtMenuItem_Menuitemlink_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemLinkParameters_Z", gxTv_SdtMenuItem_Menuitemlinkparameters_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemLinkTarget_Z", gxTv_SdtMenuItem_Menuitemlinktarget_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemIconClass_Z", gxTv_SdtMenuItem_Menuitemiconclass_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemShowDeveloperMenuOption_Z", gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemShowEditMenuOptions_Z", gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z, false, includeNonInitialized);
         AddObjectProperty("MenuItemFatherId_N", gxTv_SdtMenuItem_Menuitemfatherid_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.wwpbaseobjects.SdtMenuItem sdt )
   {
      if ( sdt.IsDirty("MenuItemId") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemid = sdt.getgxTv_SdtMenuItem_Menuitemid() ;
      }
      if ( sdt.IsDirty("MenuItemCaption") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemcaption = sdt.getgxTv_SdtMenuItem_Menuitemcaption() ;
      }
      if ( sdt.IsDirty("MenuItemOrder") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemorder = sdt.getgxTv_SdtMenuItem_Menuitemorder() ;
      }
      if ( sdt.IsDirty("MenuItemFatherId") )
      {
         gxTv_SdtMenuItem_Menuitemfatherid_N = sdt.getgxTv_SdtMenuItem_Menuitemfatherid_N() ;
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemfatherid = sdt.getgxTv_SdtMenuItem_Menuitemfatherid() ;
      }
      if ( sdt.IsDirty("MenuItemFatherCaption") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemfathercaption = sdt.getgxTv_SdtMenuItem_Menuitemfathercaption() ;
      }
      if ( sdt.IsDirty("MenuItemFatherType") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemfathertype = sdt.getgxTv_SdtMenuItem_Menuitemfathertype() ;
      }
      if ( sdt.IsDirty("MenuItemType") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemtype = sdt.getgxTv_SdtMenuItem_Menuitemtype() ;
      }
      if ( sdt.IsDirty("MenuItemLink") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemlink = sdt.getgxTv_SdtMenuItem_Menuitemlink() ;
      }
      if ( sdt.IsDirty("MenuItemLinkParameters") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemlinkparameters = sdt.getgxTv_SdtMenuItem_Menuitemlinkparameters() ;
      }
      if ( sdt.IsDirty("MenuItemLinkTarget") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemlinktarget = sdt.getgxTv_SdtMenuItem_Menuitemlinktarget() ;
      }
      if ( sdt.IsDirty("MenuItemIconClass") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemiconclass = sdt.getgxTv_SdtMenuItem_Menuitemiconclass() ;
      }
      if ( sdt.IsDirty("MenuItemShowDeveloperMenuOption") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption = sdt.getgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption() ;
      }
      if ( sdt.IsDirty("MenuItemShowEditMenuOptions") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtMenuItem_Menuitemshoweditmenuoptions = sdt.getgxTv_SdtMenuItem_Menuitemshoweditmenuoptions() ;
      }
   }

   public short getgxTv_SdtMenuItem_Menuitemid( )
   {
      return gxTv_SdtMenuItem_Menuitemid ;
   }

   public void setgxTv_SdtMenuItem_Menuitemid( short value )
   {
      sdtIsNull = (byte)(0) ;
      if ( gxTv_SdtMenuItem_Menuitemid != value )
      {
         gxTv_SdtMenuItem_Mode = "INS" ;
         this.setgxTv_SdtMenuItem_Menuitemid_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemcaption_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemorder_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemfatherid_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemfathercaption_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemfathertype_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemtype_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemlink_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemlinkparameters_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemlinktarget_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemiconclass_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z_SetNull( );
         this.setgxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z_SetNull( );
      }
      SetDirty("Menuitemid");
      gxTv_SdtMenuItem_Menuitemid = value ;
   }

   public String getgxTv_SdtMenuItem_Menuitemcaption( )
   {
      return gxTv_SdtMenuItem_Menuitemcaption ;
   }

   public void setgxTv_SdtMenuItem_Menuitemcaption( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemcaption");
      gxTv_SdtMenuItem_Menuitemcaption = value ;
   }

   public short getgxTv_SdtMenuItem_Menuitemorder( )
   {
      return gxTv_SdtMenuItem_Menuitemorder ;
   }

   public void setgxTv_SdtMenuItem_Menuitemorder( short value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemorder");
      gxTv_SdtMenuItem_Menuitemorder = value ;
   }

   public short getgxTv_SdtMenuItem_Menuitemfatherid( )
   {
      return gxTv_SdtMenuItem_Menuitemfatherid ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfatherid( short value )
   {
      gxTv_SdtMenuItem_Menuitemfatherid_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemfatherid");
      gxTv_SdtMenuItem_Menuitemfatherid = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfatherid_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemfatherid_N = (byte)(1) ;
      gxTv_SdtMenuItem_Menuitemfatherid = (short)(0) ;
      SetDirty("Menuitemfatherid");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemfatherid_IsNull( )
   {
      return (gxTv_SdtMenuItem_Menuitemfatherid_N==1) ;
   }

   public String getgxTv_SdtMenuItem_Menuitemfathercaption( )
   {
      return gxTv_SdtMenuItem_Menuitemfathercaption ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfathercaption( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemfathercaption");
      gxTv_SdtMenuItem_Menuitemfathercaption = value ;
   }

   public byte getgxTv_SdtMenuItem_Menuitemfathertype( )
   {
      return gxTv_SdtMenuItem_Menuitemfathertype ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfathertype( byte value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemfathertype");
      gxTv_SdtMenuItem_Menuitemfathertype = value ;
   }

   public byte getgxTv_SdtMenuItem_Menuitemtype( )
   {
      return gxTv_SdtMenuItem_Menuitemtype ;
   }

   public void setgxTv_SdtMenuItem_Menuitemtype( byte value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemtype");
      gxTv_SdtMenuItem_Menuitemtype = value ;
   }

   public String getgxTv_SdtMenuItem_Menuitemlink( )
   {
      return gxTv_SdtMenuItem_Menuitemlink ;
   }

   public void setgxTv_SdtMenuItem_Menuitemlink( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemlink");
      gxTv_SdtMenuItem_Menuitemlink = value ;
   }

   public String getgxTv_SdtMenuItem_Menuitemlinkparameters( )
   {
      return gxTv_SdtMenuItem_Menuitemlinkparameters ;
   }

   public void setgxTv_SdtMenuItem_Menuitemlinkparameters( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemlinkparameters");
      gxTv_SdtMenuItem_Menuitemlinkparameters = value ;
   }

   public String getgxTv_SdtMenuItem_Menuitemlinktarget( )
   {
      return gxTv_SdtMenuItem_Menuitemlinktarget ;
   }

   public void setgxTv_SdtMenuItem_Menuitemlinktarget( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemlinktarget");
      gxTv_SdtMenuItem_Menuitemlinktarget = value ;
   }

   public String getgxTv_SdtMenuItem_Menuitemiconclass( )
   {
      return gxTv_SdtMenuItem_Menuitemiconclass ;
   }

   public void setgxTv_SdtMenuItem_Menuitemiconclass( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemiconclass");
      gxTv_SdtMenuItem_Menuitemiconclass = value ;
   }

   public boolean getgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption( )
   {
      return gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption ;
   }

   public void setgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemshowdevelopermenuoption");
      gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption = value ;
   }

   public boolean getgxTv_SdtMenuItem_Menuitemshoweditmenuoptions( )
   {
      return gxTv_SdtMenuItem_Menuitemshoweditmenuoptions ;
   }

   public void setgxTv_SdtMenuItem_Menuitemshoweditmenuoptions( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemshoweditmenuoptions");
      gxTv_SdtMenuItem_Menuitemshoweditmenuoptions = value ;
   }

   public String getgxTv_SdtMenuItem_Mode( )
   {
      return gxTv_SdtMenuItem_Mode ;
   }

   public void setgxTv_SdtMenuItem_Mode( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtMenuItem_Mode = value ;
   }

   public void setgxTv_SdtMenuItem_Mode_SetNull( )
   {
      gxTv_SdtMenuItem_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtMenuItem_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMenuItem_Initialized( )
   {
      return gxTv_SdtMenuItem_Initialized ;
   }

   public void setgxTv_SdtMenuItem_Initialized( short value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtMenuItem_Initialized = value ;
   }

   public void setgxTv_SdtMenuItem_Initialized_SetNull( )
   {
      gxTv_SdtMenuItem_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtMenuItem_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMenuItem_Menuitemid_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemid_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemid_Z( short value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemid_Z");
      gxTv_SdtMenuItem_Menuitemid_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemid_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemid_Z = (short)(0) ;
      SetDirty("Menuitemid_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMenuItem_Menuitemcaption_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemcaption_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemcaption_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemcaption_Z");
      gxTv_SdtMenuItem_Menuitemcaption_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemcaption_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemcaption_Z = "" ;
      SetDirty("Menuitemcaption_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemcaption_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMenuItem_Menuitemorder_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemorder_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemorder_Z( short value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemorder_Z");
      gxTv_SdtMenuItem_Menuitemorder_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemorder_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemorder_Z = (short)(0) ;
      SetDirty("Menuitemorder_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemorder_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtMenuItem_Menuitemfatherid_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemfatherid_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfatherid_Z( short value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemfatherid_Z");
      gxTv_SdtMenuItem_Menuitemfatherid_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfatherid_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemfatherid_Z = (short)(0) ;
      SetDirty("Menuitemfatherid_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemfatherid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMenuItem_Menuitemfathercaption_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemfathercaption_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfathercaption_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemfathercaption_Z");
      gxTv_SdtMenuItem_Menuitemfathercaption_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfathercaption_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemfathercaption_Z = "" ;
      SetDirty("Menuitemfathercaption_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemfathercaption_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtMenuItem_Menuitemfathertype_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemfathertype_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfathertype_Z( byte value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemfathertype_Z");
      gxTv_SdtMenuItem_Menuitemfathertype_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfathertype_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemfathertype_Z = (byte)(0) ;
      SetDirty("Menuitemfathertype_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemfathertype_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtMenuItem_Menuitemtype_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemtype_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemtype_Z( byte value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemtype_Z");
      gxTv_SdtMenuItem_Menuitemtype_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemtype_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemtype_Z = (byte)(0) ;
      SetDirty("Menuitemtype_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemtype_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMenuItem_Menuitemlink_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemlink_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemlink_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemlink_Z");
      gxTv_SdtMenuItem_Menuitemlink_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemlink_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemlink_Z = "" ;
      SetDirty("Menuitemlink_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemlink_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMenuItem_Menuitemlinkparameters_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemlinkparameters_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemlinkparameters_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemlinkparameters_Z");
      gxTv_SdtMenuItem_Menuitemlinkparameters_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemlinkparameters_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemlinkparameters_Z = "" ;
      SetDirty("Menuitemlinkparameters_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemlinkparameters_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMenuItem_Menuitemlinktarget_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemlinktarget_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemlinktarget_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemlinktarget_Z");
      gxTv_SdtMenuItem_Menuitemlinktarget_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemlinktarget_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemlinktarget_Z = "" ;
      SetDirty("Menuitemlinktarget_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemlinktarget_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtMenuItem_Menuitemiconclass_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemiconclass_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemiconclass_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemiconclass_Z");
      gxTv_SdtMenuItem_Menuitemiconclass_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemiconclass_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemiconclass_Z = "" ;
      SetDirty("Menuitemiconclass_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemiconclass_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemshowdevelopermenuoption_Z");
      gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z = false ;
      SetDirty("Menuitemshowdevelopermenuoption_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z ;
   }

   public void setgxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemshoweditmenuoptions_Z");
      gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z = false ;
      SetDirty("Menuitemshoweditmenuoptions_Z");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtMenuItem_Menuitemfatherid_N( )
   {
      return gxTv_SdtMenuItem_Menuitemfatherid_N ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfatherid_N( byte value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Menuitemfatherid_N");
      gxTv_SdtMenuItem_Menuitemfatherid_N = value ;
   }

   public void setgxTv_SdtMenuItem_Menuitemfatherid_N_SetNull( )
   {
      gxTv_SdtMenuItem_Menuitemfatherid_N = (byte)(0) ;
      SetDirty("Menuitemfatherid_N");
   }

   public boolean getgxTv_SdtMenuItem_Menuitemfatherid_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.wwpbaseobjects.menuitem_bc obj;
      obj = new com.wwpbaseobjects.menuitem_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      sdtIsNull = (byte)(1) ;
      gxTv_SdtMenuItem_Menuitemcaption = "" ;
      gxTv_SdtMenuItem_Menuitemfathercaption = "" ;
      gxTv_SdtMenuItem_Menuitemlink = "" ;
      gxTv_SdtMenuItem_Menuitemlinkparameters = "" ;
      gxTv_SdtMenuItem_Menuitemlinktarget = "" ;
      gxTv_SdtMenuItem_Menuitemiconclass = "" ;
      gxTv_SdtMenuItem_Mode = "" ;
      gxTv_SdtMenuItem_Menuitemcaption_Z = "" ;
      gxTv_SdtMenuItem_Menuitemfathercaption_Z = "" ;
      gxTv_SdtMenuItem_Menuitemlink_Z = "" ;
      gxTv_SdtMenuItem_Menuitemlinkparameters_Z = "" ;
      gxTv_SdtMenuItem_Menuitemlinktarget_Z = "" ;
      gxTv_SdtMenuItem_Menuitemiconclass_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtMenuItem Clone( )
   {
      com.wwpbaseobjects.SdtMenuItem sdt;
      com.wwpbaseobjects.menuitem_bc obj;
      sdt = (com.wwpbaseobjects.SdtMenuItem)(clone()) ;
      obj = (com.wwpbaseobjects.menuitem_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtMenuItem struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtMenuItem_Menuitemid(struct.getMenuitemid());
         setgxTv_SdtMenuItem_Menuitemcaption(struct.getMenuitemcaption());
         setgxTv_SdtMenuItem_Menuitemorder(struct.getMenuitemorder());
         setgxTv_SdtMenuItem_Menuitemfatherid(struct.getMenuitemfatherid());
         setgxTv_SdtMenuItem_Menuitemfathercaption(struct.getMenuitemfathercaption());
         setgxTv_SdtMenuItem_Menuitemfathertype(struct.getMenuitemfathertype());
         setgxTv_SdtMenuItem_Menuitemtype(struct.getMenuitemtype());
         setgxTv_SdtMenuItem_Menuitemlink(struct.getMenuitemlink());
         setgxTv_SdtMenuItem_Menuitemlinkparameters(struct.getMenuitemlinkparameters());
         setgxTv_SdtMenuItem_Menuitemlinktarget(struct.getMenuitemlinktarget());
         setgxTv_SdtMenuItem_Menuitemiconclass(struct.getMenuitemiconclass());
         setgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption(struct.getMenuitemshowdevelopermenuoption());
         setgxTv_SdtMenuItem_Menuitemshoweditmenuoptions(struct.getMenuitemshoweditmenuoptions());
         setgxTv_SdtMenuItem_Mode(struct.getMode());
         setgxTv_SdtMenuItem_Initialized(struct.getInitialized());
         setgxTv_SdtMenuItem_Menuitemid_Z(struct.getMenuitemid_Z());
         setgxTv_SdtMenuItem_Menuitemcaption_Z(struct.getMenuitemcaption_Z());
         setgxTv_SdtMenuItem_Menuitemorder_Z(struct.getMenuitemorder_Z());
         setgxTv_SdtMenuItem_Menuitemfatherid_Z(struct.getMenuitemfatherid_Z());
         setgxTv_SdtMenuItem_Menuitemfathercaption_Z(struct.getMenuitemfathercaption_Z());
         setgxTv_SdtMenuItem_Menuitemfathertype_Z(struct.getMenuitemfathertype_Z());
         setgxTv_SdtMenuItem_Menuitemtype_Z(struct.getMenuitemtype_Z());
         setgxTv_SdtMenuItem_Menuitemlink_Z(struct.getMenuitemlink_Z());
         setgxTv_SdtMenuItem_Menuitemlinkparameters_Z(struct.getMenuitemlinkparameters_Z());
         setgxTv_SdtMenuItem_Menuitemlinktarget_Z(struct.getMenuitemlinktarget_Z());
         setgxTv_SdtMenuItem_Menuitemiconclass_Z(struct.getMenuitemiconclass_Z());
         setgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z(struct.getMenuitemshowdevelopermenuoption_Z());
         setgxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z(struct.getMenuitemshoweditmenuoptions_Z());
         setgxTv_SdtMenuItem_Menuitemfatherid_N(struct.getMenuitemfatherid_N());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtMenuItem getStruct( )
   {
      com.wwpbaseobjects.StructSdtMenuItem struct = new com.wwpbaseobjects.StructSdtMenuItem ();
      struct.setMenuitemid(getgxTv_SdtMenuItem_Menuitemid());
      struct.setMenuitemcaption(getgxTv_SdtMenuItem_Menuitemcaption());
      struct.setMenuitemorder(getgxTv_SdtMenuItem_Menuitemorder());
      struct.setMenuitemfatherid(getgxTv_SdtMenuItem_Menuitemfatherid());
      struct.setMenuitemfathercaption(getgxTv_SdtMenuItem_Menuitemfathercaption());
      struct.setMenuitemfathertype(getgxTv_SdtMenuItem_Menuitemfathertype());
      struct.setMenuitemtype(getgxTv_SdtMenuItem_Menuitemtype());
      struct.setMenuitemlink(getgxTv_SdtMenuItem_Menuitemlink());
      struct.setMenuitemlinkparameters(getgxTv_SdtMenuItem_Menuitemlinkparameters());
      struct.setMenuitemlinktarget(getgxTv_SdtMenuItem_Menuitemlinktarget());
      struct.setMenuitemiconclass(getgxTv_SdtMenuItem_Menuitemiconclass());
      struct.setMenuitemshowdevelopermenuoption(getgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption());
      struct.setMenuitemshoweditmenuoptions(getgxTv_SdtMenuItem_Menuitemshoweditmenuoptions());
      struct.setMode(getgxTv_SdtMenuItem_Mode());
      struct.setInitialized(getgxTv_SdtMenuItem_Initialized());
      struct.setMenuitemid_Z(getgxTv_SdtMenuItem_Menuitemid_Z());
      struct.setMenuitemcaption_Z(getgxTv_SdtMenuItem_Menuitemcaption_Z());
      struct.setMenuitemorder_Z(getgxTv_SdtMenuItem_Menuitemorder_Z());
      struct.setMenuitemfatherid_Z(getgxTv_SdtMenuItem_Menuitemfatherid_Z());
      struct.setMenuitemfathercaption_Z(getgxTv_SdtMenuItem_Menuitemfathercaption_Z());
      struct.setMenuitemfathertype_Z(getgxTv_SdtMenuItem_Menuitemfathertype_Z());
      struct.setMenuitemtype_Z(getgxTv_SdtMenuItem_Menuitemtype_Z());
      struct.setMenuitemlink_Z(getgxTv_SdtMenuItem_Menuitemlink_Z());
      struct.setMenuitemlinkparameters_Z(getgxTv_SdtMenuItem_Menuitemlinkparameters_Z());
      struct.setMenuitemlinktarget_Z(getgxTv_SdtMenuItem_Menuitemlinktarget_Z());
      struct.setMenuitemiconclass_Z(getgxTv_SdtMenuItem_Menuitemiconclass_Z());
      struct.setMenuitemshowdevelopermenuoption_Z(getgxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z());
      struct.setMenuitemshoweditmenuoptions_Z(getgxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z());
      struct.setMenuitemfatherid_N(getgxTv_SdtMenuItem_Menuitemfatherid_N());
      return struct ;
   }

   private byte sdtIsNull ;
   private byte gxTv_SdtMenuItem_Menuitemfathertype ;
   private byte gxTv_SdtMenuItem_Menuitemtype ;
   private byte gxTv_SdtMenuItem_Menuitemfathertype_Z ;
   private byte gxTv_SdtMenuItem_Menuitemtype_Z ;
   private byte gxTv_SdtMenuItem_Menuitemfatherid_N ;
   private short gxTv_SdtMenuItem_Menuitemid ;
   private short gxTv_SdtMenuItem_Menuitemorder ;
   private short gxTv_SdtMenuItem_Menuitemfatherid ;
   private short gxTv_SdtMenuItem_Initialized ;
   private short gxTv_SdtMenuItem_Menuitemid_Z ;
   private short gxTv_SdtMenuItem_Menuitemorder_Z ;
   private short gxTv_SdtMenuItem_Menuitemfatherid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtMenuItem_Mode ;
   private String sTagName ;
   private boolean gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption ;
   private boolean gxTv_SdtMenuItem_Menuitemshoweditmenuoptions ;
   private boolean gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z ;
   private boolean gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtMenuItem_Menuitemcaption ;
   private String gxTv_SdtMenuItem_Menuitemfathercaption ;
   private String gxTv_SdtMenuItem_Menuitemlink ;
   private String gxTv_SdtMenuItem_Menuitemlinkparameters ;
   private String gxTv_SdtMenuItem_Menuitemlinktarget ;
   private String gxTv_SdtMenuItem_Menuitemiconclass ;
   private String gxTv_SdtMenuItem_Menuitemcaption_Z ;
   private String gxTv_SdtMenuItem_Menuitemfathercaption_Z ;
   private String gxTv_SdtMenuItem_Menuitemlink_Z ;
   private String gxTv_SdtMenuItem_Menuitemlinkparameters_Z ;
   private String gxTv_SdtMenuItem_Menuitemlinktarget_Z ;
   private String gxTv_SdtMenuItem_Menuitemiconclass_Z ;
}

