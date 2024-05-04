package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_SearchResults_WWP_SearchResultsItem extends GxUserType
{
   public SdtWWP_SearchResults_WWP_SearchResultsItem( )
   {
      this(  new ModelContext(SdtWWP_SearchResults_WWP_SearchResultsItem.class));
   }

   public SdtWWP_SearchResults_WWP_SearchResultsItem( ModelContext context )
   {
      super( context, "SdtWWP_SearchResults_WWP_SearchResultsItem");
   }

   public SdtWWP_SearchResults_WWP_SearchResultsItem( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_SearchResults_WWP_SearchResultsItem");
   }

   public SdtWWP_SearchResults_WWP_SearchResultsItem( StructSdtWWP_SearchResults_WWP_SearchResultsItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CategoryName") )
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CategoryIcon") )
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ShowingAllResults") )
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OrderIndex") )
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Result") )
            {
               if ( gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result == null )
               {
                  gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem.class, "WWP_SearchResults.WWP_SearchResultsItem.ResultItem", "Gregory", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result.readxmlcollection(oReader, "Result", "ResultItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Result") )
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
         sName = "WWP_SearchResults.WWP_SearchResultsItem" ;
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
      oWriter.writeElement("CategoryName", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("CategoryIcon", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("ShowingAllResults", GXutil.booltostr( gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OrderIndex", GXutil.trim( GXutil.str( gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result != null )
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
         gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result.writexmlcollection(oWriter, "Result", sNameSpace1, "ResultItem", sNameSpace1);
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
      AddObjectProperty("CategoryName", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname, false, false);
      AddObjectProperty("CategoryIcon", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon, false, false);
      AddObjectProperty("ShowingAllResults", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults, false, false);
      AddObjectProperty("OrderIndex", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex, false, false);
      if ( gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result != null )
      {
         AddObjectProperty("Result", gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result, false, false);
      }
   }

   public String getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname = value ;
   }

   public String getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon = value ;
   }

   public boolean getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults = value ;
   }

   public short getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex = value ;
   }

   public GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result( )
   {
      if ( gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result == null )
      {
         gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem.class, "WWP_SearchResults.WWP_SearchResultsItem.ResultItem", "Gregory", remoteHandle);
      }
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result( GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> value )
   {
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result = value ;
   }

   public void setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_SetNull( )
   {
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N = (byte)(1) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result = null ;
   }

   public boolean getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_IsNull( )
   {
      if ( gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem Clone( )
   {
      return (com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname(struct.getCategoryname());
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon(struct.getCategoryicon());
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults(struct.getShowingallresults());
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex(struct.getOrderindex());
         GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_aux = new GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem>(com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem.class, "WWP_SearchResults.WWP_SearchResultsItem.ResultItem", "Gregory", remoteHandle);
         Vector<com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_aux1 = struct.getResult();
         if (gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_aux1.size(); i++)
            {
               gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_aux.add(new com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem(gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result(gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_aux);
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem getStruct( )
   {
      com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem struct = new com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem ();
      struct.setCategoryname(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname());
      struct.setCategoryicon(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon());
      struct.setShowingallresults(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults());
      struct.setOrderindex(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex());
      struct.setResult(getgxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result().getStruct());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected byte gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N ;
   protected short gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_aux ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result=null ;
}

