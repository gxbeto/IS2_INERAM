package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem extends GxUserType
{
   public SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem( )
   {
      this(  new ModelContext(SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem.class));
   }

   public SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem( ModelContext context )
   {
      super( context, "SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem");
   }

   public SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem( int remoteHandle ,
                                                                 ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem");
   }

   public SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem( StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisplayType") )
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description2") )
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description3") )
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Url") )
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url = oReader.getValue() ;
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
         sName = "WWP_SearchResults.WWP_SearchResultsItem.ResultItem" ;
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
      oWriter.writeElement("DisplayType", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Description", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Description2", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Description3", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Url", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url);
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
      AddObjectProperty("DisplayType", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype, false, false);
      AddObjectProperty("Description", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description, false, false);
      AddObjectProperty("Description2", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2, false, false);
      AddObjectProperty("Description3", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3, false, false);
      AddObjectProperty("Url", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url, false, false);
   }

   public String getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype = value ;
   }

   public String getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description = value ;
   }

   public String getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2 ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2 = value ;
   }

   public String getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3 ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3 = value ;
   }

   public String getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2 = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3 = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem Clone( )
   {
      return (com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype(struct.getDisplaytype());
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description(struct.getDescription());
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2(struct.getDescription2());
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3(struct.getDescription3());
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url(struct.getUrl());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem getStruct( )
   {
      com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem struct = new com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem ();
      struct.setDisplaytype(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype());
      struct.setDescription(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description());
      struct.setDescription2(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2());
      struct.setDescription3(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3());
      struct.setUrl(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2 ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3 ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url ;
}

