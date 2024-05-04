package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDVB_SDTComboData_Item extends GxUserType
{
   public SdtDVB_SDTComboData_Item( )
   {
      this(  new ModelContext(SdtDVB_SDTComboData_Item.class));
   }

   public SdtDVB_SDTComboData_Item( ModelContext context )
   {
      super( context, "SdtDVB_SDTComboData_Item");
   }

   public SdtDVB_SDTComboData_Item( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtDVB_SDTComboData_Item");
   }

   public SdtDVB_SDTComboData_Item( StructSdtDVB_SDTComboData_Item struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
      mapper.put( "T" ,  "Title" );
      mapper.put( "C" ,  "Children" );
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ID") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTComboData_Item_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTComboData_Item_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Children") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               if ( gxTv_SdtDVB_SDTComboData_Item_Children == null )
               {
                  gxTv_SdtDVB_SDTComboData_Item_Children = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtDVB_SDTComboData_Item_Children.readxml(oReader, "Children") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Children") )
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
         sName = "DVB_SDTComboData.Item" ;
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
      oWriter.writeElement("ID", gxTv_SdtDVB_SDTComboData_Item_Id);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("Title", gxTv_SdtDVB_SDTComboData_Item_Title);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      if ( gxTv_SdtDVB_SDTComboData_Item_Children != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "" ;
         }
         else
         {
            sNameSpace1 = "" ;
         }
         gxTv_SdtDVB_SDTComboData_Item_Children.writexml(oWriter, "Children", sNameSpace1, sIncludeState);
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
      AddObjectProperty("ID", gxTv_SdtDVB_SDTComboData_Item_Id, false, false);
      AddObjectProperty("T", gxTv_SdtDVB_SDTComboData_Item_Title, false, false);
      if ( gxTv_SdtDVB_SDTComboData_Item_Children != null )
      {
         AddObjectProperty("C", gxTv_SdtDVB_SDTComboData_Item_Children, false, false);
      }
   }

   public String getgxTv_SdtDVB_SDTComboData_Item_Id( )
   {
      return gxTv_SdtDVB_SDTComboData_Item_Id ;
   }

   public void setgxTv_SdtDVB_SDTComboData_Item_Id( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTComboData_Item_Id = value ;
   }

   public String getgxTv_SdtDVB_SDTComboData_Item_Title( )
   {
      return gxTv_SdtDVB_SDTComboData_Item_Title ;
   }

   public void setgxTv_SdtDVB_SDTComboData_Item_Title( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTComboData_Item_Title = value ;
   }

   public GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> getgxTv_SdtDVB_SDTComboData_Item_Children( )
   {
      if ( gxTv_SdtDVB_SDTComboData_Item_Children == null )
      {
         gxTv_SdtDVB_SDTComboData_Item_Children = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      }
      gxTv_SdtDVB_SDTComboData_Item_Children_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      return gxTv_SdtDVB_SDTComboData_Item_Children ;
   }

   public void setgxTv_SdtDVB_SDTComboData_Item_Children( GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> value )
   {
      gxTv_SdtDVB_SDTComboData_Item_Children_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTComboData_Item_Children = value ;
   }

   public void setgxTv_SdtDVB_SDTComboData_Item_Children_SetNull( )
   {
      gxTv_SdtDVB_SDTComboData_Item_Children_N = (byte)(1) ;
      gxTv_SdtDVB_SDTComboData_Item_Children = null ;
   }

   public boolean getgxTv_SdtDVB_SDTComboData_Item_Children_IsNull( )
   {
      if ( gxTv_SdtDVB_SDTComboData_Item_Children == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtDVB_SDTComboData_Item_Children_N( )
   {
      return gxTv_SdtDVB_SDTComboData_Item_Children_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtDVB_SDTComboData_Item_Id = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtDVB_SDTComboData_Item_Title = "" ;
      gxTv_SdtDVB_SDTComboData_Item_Children_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtDVB_SDTComboData_Item Clone( )
   {
      return (com.wwpbaseobjects.SdtDVB_SDTComboData_Item)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtDVB_SDTComboData_Item struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtDVB_SDTComboData_Item_Id(struct.getId());
         setgxTv_SdtDVB_SDTComboData_Item_Title(struct.getTitle());
         GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> gxTv_SdtDVB_SDTComboData_Item_Children_aux = new GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
         Vector<com.wwpbaseobjects.StructSdtDVB_SDTComboData_Item> gxTv_SdtDVB_SDTComboData_Item_Children_aux1 = struct.getChildren();
         if (gxTv_SdtDVB_SDTComboData_Item_Children_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtDVB_SDTComboData_Item_Children_aux1.size(); i++)
            {
               gxTv_SdtDVB_SDTComboData_Item_Children_aux.add(new com.wwpbaseobjects.SdtDVB_SDTComboData_Item(gxTv_SdtDVB_SDTComboData_Item_Children_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtDVB_SDTComboData_Item_Children(gxTv_SdtDVB_SDTComboData_Item_Children_aux);
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtDVB_SDTComboData_Item getStruct( )
   {
      com.wwpbaseobjects.StructSdtDVB_SDTComboData_Item struct = new com.wwpbaseobjects.StructSdtDVB_SDTComboData_Item ();
      struct.setId(getgxTv_SdtDVB_SDTComboData_Item_Id());
      struct.setTitle(getgxTv_SdtDVB_SDTComboData_Item_Title());
      struct.setChildren(getgxTv_SdtDVB_SDTComboData_Item_Children().getStruct());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected byte gxTv_SdtDVB_SDTComboData_Item_Children_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtDVB_SDTComboData_Item_Id ;
   protected String gxTv_SdtDVB_SDTComboData_Item_Title ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> gxTv_SdtDVB_SDTComboData_Item_Children_aux ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtDVB_SDTComboData_Item> gxTv_SdtDVB_SDTComboData_Item_Children=null ;
}

