package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtGridStateCollection_Item extends GxUserType
{
   public SdtGridStateCollection_Item( )
   {
      this(  new ModelContext(SdtGridStateCollection_Item.class));
   }

   public SdtGridStateCollection_Item( ModelContext context )
   {
      super( context, "SdtGridStateCollection_Item");
   }

   public SdtGridStateCollection_Item( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtGridStateCollection_Item");
   }

   public SdtGridStateCollection_Item( StructSdtGridStateCollection_Item struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtGridStateCollection_Item_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GridStateXML") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtGridStateCollection_Item_Gridstatexml = oReader.getValue() ;
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
         sName = "GridStateCollection.Item" ;
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
      oWriter.writeElement("Title", gxTv_SdtGridStateCollection_Item_Title);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("GridStateXML", gxTv_SdtGridStateCollection_Item_Gridstatexml);
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
      AddObjectProperty("Title", gxTv_SdtGridStateCollection_Item_Title, false, false);
      AddObjectProperty("GridStateXML", gxTv_SdtGridStateCollection_Item_Gridstatexml, false, false);
   }

   public String getgxTv_SdtGridStateCollection_Item_Title( )
   {
      return gxTv_SdtGridStateCollection_Item_Title ;
   }

   public void setgxTv_SdtGridStateCollection_Item_Title( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGridStateCollection_Item_Title = value ;
   }

   public String getgxTv_SdtGridStateCollection_Item_Gridstatexml( )
   {
      return gxTv_SdtGridStateCollection_Item_Gridstatexml ;
   }

   public void setgxTv_SdtGridStateCollection_Item_Gridstatexml( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGridStateCollection_Item_Gridstatexml = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtGridStateCollection_Item_Title = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtGridStateCollection_Item_Gridstatexml = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtGridStateCollection_Item Clone( )
   {
      return (com.wwpbaseobjects.SdtGridStateCollection_Item)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtGridStateCollection_Item struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtGridStateCollection_Item_Title(struct.getTitle());
         setgxTv_SdtGridStateCollection_Item_Gridstatexml(struct.getGridstatexml());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtGridStateCollection_Item getStruct( )
   {
      com.wwpbaseobjects.StructSdtGridStateCollection_Item struct = new com.wwpbaseobjects.StructSdtGridStateCollection_Item ();
      struct.setTitle(getgxTv_SdtGridStateCollection_Item_Title());
      struct.setGridstatexml(getgxTv_SdtGridStateCollection_Item_Gridstatexml());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtGridStateCollection_Item_Gridstatexml ;
   protected String gxTv_SdtGridStateCollection_Item_Title ;
}

