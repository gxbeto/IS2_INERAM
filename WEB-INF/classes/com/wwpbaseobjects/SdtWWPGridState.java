package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPGridState extends GxUserType
{
   public SdtWWPGridState( )
   {
      this(  new ModelContext(SdtWWPGridState.class));
   }

   public SdtWWPGridState( ModelContext context )
   {
      super( context, "SdtWWPGridState");
   }

   public SdtWWPGridState( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPGridState");
   }

   public SdtWWPGridState( StructSdtWWPGridState struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CurrentPage") )
            {
               gxTv_SdtWWPGridState_Currentpage = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OrderedBy") )
            {
               gxTv_SdtWWPGridState_Orderedby = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OrderedDsc") )
            {
               gxTv_SdtWWPGridState_Ordereddsc = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "HidingSearch") )
            {
               gxTv_SdtWWPGridState_Hidingsearch = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PageSize") )
            {
               gxTv_SdtWWPGridState_Pagesize = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CollapsedRecords") )
            {
               gxTv_SdtWWPGridState_Collapsedrecords = oReader.getValue() ;
               gxTv_SdtWWPGridState_Collapsedrecords_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "GroupBy") )
            {
               gxTv_SdtWWPGridState_Groupby = oReader.getValue() ;
               gxTv_SdtWWPGridState_Groupby_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FilterValues") )
            {
               if ( gxTv_SdtWWPGridState_Filtervalues == null )
               {
                  gxTv_SdtWWPGridState_Filtervalues = new GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_FilterValue>(com.wwpbaseobjects.SdtWWPGridState_FilterValue.class, "WWPGridState.FilterValue", "Gregory", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtWWPGridState_Filtervalues.readxmlcollection(oReader, "FilterValues", "FilterValue") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "FilterValues") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DynamicFilters") )
            {
               if ( gxTv_SdtWWPGridState_Dynamicfilters == null )
               {
                  gxTv_SdtWWPGridState_Dynamicfilters = new GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_DynamicFilter>(com.wwpbaseobjects.SdtWWPGridState_DynamicFilter.class, "WWPGridState.DynamicFilter", "Gregory", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtWWPGridState_Dynamicfilters.readxmlcollection(oReader, "DynamicFilters", "DynamicFilter") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "DynamicFilters") )
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
         sName = "WWPGridState" ;
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
      oWriter.writeElement("CurrentPage", GXutil.trim( GXutil.str( gxTv_SdtWWPGridState_Currentpage, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OrderedBy", GXutil.trim( GXutil.str( gxTv_SdtWWPGridState_Orderedby, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("OrderedDsc", GXutil.booltostr( gxTv_SdtWWPGridState_Ordereddsc));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("HidingSearch", GXutil.trim( GXutil.str( gxTv_SdtWWPGridState_Hidingsearch, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("PageSize", gxTv_SdtWWPGridState_Pagesize);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtWWPGridState_Collapsedrecords)==0) || ( gxTv_SdtWWPGridState_Collapsedrecords_N != 1 ) )
      {
         oWriter.writeElement("CollapsedRecords", gxTv_SdtWWPGridState_Collapsedrecords);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtWWPGridState_Groupby)==0) || ( gxTv_SdtWWPGridState_Groupby_N != 1 ) )
      {
         oWriter.writeElement("GroupBy", gxTv_SdtWWPGridState_Groupby);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
      }
      if ( gxTv_SdtWWPGridState_Filtervalues != null )
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
         gxTv_SdtWWPGridState_Filtervalues.writexmlcollection(oWriter, "FilterValues", sNameSpace1, "FilterValue", sNameSpace1);
      }
      if ( gxTv_SdtWWPGridState_Dynamicfilters != null )
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
         gxTv_SdtWWPGridState_Dynamicfilters.writexmlcollection(oWriter, "DynamicFilters", sNameSpace1, "DynamicFilter", sNameSpace1);
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
      AddObjectProperty("CurrentPage", gxTv_SdtWWPGridState_Currentpage, false, false);
      AddObjectProperty("OrderedBy", gxTv_SdtWWPGridState_Orderedby, false, false);
      AddObjectProperty("OrderedDsc", gxTv_SdtWWPGridState_Ordereddsc, false, false);
      AddObjectProperty("HidingSearch", gxTv_SdtWWPGridState_Hidingsearch, false, false);
      AddObjectProperty("PageSize", gxTv_SdtWWPGridState_Pagesize, false, false);
      AddObjectProperty("CollapsedRecords", gxTv_SdtWWPGridState_Collapsedrecords, false, false);
      AddObjectProperty("GroupBy", gxTv_SdtWWPGridState_Groupby, false, false);
      if ( gxTv_SdtWWPGridState_Filtervalues != null )
      {
         AddObjectProperty("FilterValues", gxTv_SdtWWPGridState_Filtervalues, false, false);
      }
      if ( gxTv_SdtWWPGridState_Dynamicfilters != null )
      {
         AddObjectProperty("DynamicFilters", gxTv_SdtWWPGridState_Dynamicfilters, false, false);
      }
   }

   public short getgxTv_SdtWWPGridState_Currentpage( )
   {
      return gxTv_SdtWWPGridState_Currentpage ;
   }

   public void setgxTv_SdtWWPGridState_Currentpage( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Currentpage = value ;
   }

   public short getgxTv_SdtWWPGridState_Orderedby( )
   {
      return gxTv_SdtWWPGridState_Orderedby ;
   }

   public void setgxTv_SdtWWPGridState_Orderedby( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Orderedby = value ;
   }

   public boolean getgxTv_SdtWWPGridState_Ordereddsc( )
   {
      return gxTv_SdtWWPGridState_Ordereddsc ;
   }

   public void setgxTv_SdtWWPGridState_Ordereddsc( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Ordereddsc = value ;
   }

   public byte getgxTv_SdtWWPGridState_Hidingsearch( )
   {
      return gxTv_SdtWWPGridState_Hidingsearch ;
   }

   public void setgxTv_SdtWWPGridState_Hidingsearch( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Hidingsearch = value ;
   }

   public String getgxTv_SdtWWPGridState_Pagesize( )
   {
      return gxTv_SdtWWPGridState_Pagesize ;
   }

   public void setgxTv_SdtWWPGridState_Pagesize( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Pagesize = value ;
   }

   public String getgxTv_SdtWWPGridState_Collapsedrecords( )
   {
      return gxTv_SdtWWPGridState_Collapsedrecords ;
   }

   public void setgxTv_SdtWWPGridState_Collapsedrecords( String value )
   {
      gxTv_SdtWWPGridState_Collapsedrecords_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Collapsedrecords = value ;
   }

   public String getgxTv_SdtWWPGridState_Groupby( )
   {
      return gxTv_SdtWWPGridState_Groupby ;
   }

   public void setgxTv_SdtWWPGridState_Groupby( String value )
   {
      gxTv_SdtWWPGridState_Groupby_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Groupby = value ;
   }

   public GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_FilterValue> getgxTv_SdtWWPGridState_Filtervalues( )
   {
      if ( gxTv_SdtWWPGridState_Filtervalues == null )
      {
         gxTv_SdtWWPGridState_Filtervalues = new GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_FilterValue>(com.wwpbaseobjects.SdtWWPGridState_FilterValue.class, "WWPGridState.FilterValue", "Gregory", remoteHandle);
      }
      gxTv_SdtWWPGridState_Filtervalues_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      return gxTv_SdtWWPGridState_Filtervalues ;
   }

   public void setgxTv_SdtWWPGridState_Filtervalues( GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_FilterValue> value )
   {
      gxTv_SdtWWPGridState_Filtervalues_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Filtervalues = value ;
   }

   public void setgxTv_SdtWWPGridState_Filtervalues_SetNull( )
   {
      gxTv_SdtWWPGridState_Filtervalues_N = (byte)(1) ;
      gxTv_SdtWWPGridState_Filtervalues = null ;
   }

   public boolean getgxTv_SdtWWPGridState_Filtervalues_IsNull( )
   {
      if ( gxTv_SdtWWPGridState_Filtervalues == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtWWPGridState_Filtervalues_N( )
   {
      return gxTv_SdtWWPGridState_Filtervalues_N ;
   }

   public GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_DynamicFilter> getgxTv_SdtWWPGridState_Dynamicfilters( )
   {
      if ( gxTv_SdtWWPGridState_Dynamicfilters == null )
      {
         gxTv_SdtWWPGridState_Dynamicfilters = new GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_DynamicFilter>(com.wwpbaseobjects.SdtWWPGridState_DynamicFilter.class, "WWPGridState.DynamicFilter", "Gregory", remoteHandle);
      }
      gxTv_SdtWWPGridState_Dynamicfilters_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      return gxTv_SdtWWPGridState_Dynamicfilters ;
   }

   public void setgxTv_SdtWWPGridState_Dynamicfilters( GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_DynamicFilter> value )
   {
      gxTv_SdtWWPGridState_Dynamicfilters_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Dynamicfilters = value ;
   }

   public void setgxTv_SdtWWPGridState_Dynamicfilters_SetNull( )
   {
      gxTv_SdtWWPGridState_Dynamicfilters_N = (byte)(1) ;
      gxTv_SdtWWPGridState_Dynamicfilters = null ;
   }

   public boolean getgxTv_SdtWWPGridState_Dynamicfilters_IsNull( )
   {
      if ( gxTv_SdtWWPGridState_Dynamicfilters == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtWWPGridState_Dynamicfilters_N( )
   {
      return gxTv_SdtWWPGridState_Dynamicfilters_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWPGridState_Pagesize = "" ;
      gxTv_SdtWWPGridState_Collapsedrecords = "" ;
      gxTv_SdtWWPGridState_Collapsedrecords_N = (byte)(1) ;
      gxTv_SdtWWPGridState_Groupby = "" ;
      gxTv_SdtWWPGridState_Groupby_N = (byte)(1) ;
      gxTv_SdtWWPGridState_Filtervalues_N = (byte)(1) ;
      gxTv_SdtWWPGridState_Dynamicfilters_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWWPGridState Clone( )
   {
      return (com.wwpbaseobjects.SdtWWPGridState)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWWPGridState struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWPGridState_Currentpage(struct.getCurrentpage());
         setgxTv_SdtWWPGridState_Orderedby(struct.getOrderedby());
         setgxTv_SdtWWPGridState_Ordereddsc(struct.getOrdereddsc());
         setgxTv_SdtWWPGridState_Hidingsearch(struct.getHidingsearch());
         setgxTv_SdtWWPGridState_Pagesize(struct.getPagesize());
         if ( struct.gxTv_SdtWWPGridState_Collapsedrecords_N == 0 )
         {
            setgxTv_SdtWWPGridState_Collapsedrecords(struct.getCollapsedrecords());
         }
         if ( struct.gxTv_SdtWWPGridState_Groupby_N == 0 )
         {
            setgxTv_SdtWWPGridState_Groupby(struct.getGroupby());
         }
         GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_FilterValue> gxTv_SdtWWPGridState_Filtervalues_aux = new GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_FilterValue>(com.wwpbaseobjects.SdtWWPGridState_FilterValue.class, "WWPGridState.FilterValue", "Gregory", remoteHandle);
         Vector<com.wwpbaseobjects.StructSdtWWPGridState_FilterValue> gxTv_SdtWWPGridState_Filtervalues_aux1 = struct.getFiltervalues();
         if (gxTv_SdtWWPGridState_Filtervalues_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtWWPGridState_Filtervalues_aux1.size(); i++)
            {
               gxTv_SdtWWPGridState_Filtervalues_aux.add(new com.wwpbaseobjects.SdtWWPGridState_FilterValue(gxTv_SdtWWPGridState_Filtervalues_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtWWPGridState_Filtervalues(gxTv_SdtWWPGridState_Filtervalues_aux);
         GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_DynamicFilter> gxTv_SdtWWPGridState_Dynamicfilters_aux = new GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_DynamicFilter>(com.wwpbaseobjects.SdtWWPGridState_DynamicFilter.class, "WWPGridState.DynamicFilter", "Gregory", remoteHandle);
         Vector<com.wwpbaseobjects.StructSdtWWPGridState_DynamicFilter> gxTv_SdtWWPGridState_Dynamicfilters_aux1 = struct.getDynamicfilters();
         if (gxTv_SdtWWPGridState_Dynamicfilters_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtWWPGridState_Dynamicfilters_aux1.size(); i++)
            {
               gxTv_SdtWWPGridState_Dynamicfilters_aux.add(new com.wwpbaseobjects.SdtWWPGridState_DynamicFilter(gxTv_SdtWWPGridState_Dynamicfilters_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtWWPGridState_Dynamicfilters(gxTv_SdtWWPGridState_Dynamicfilters_aux);
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWWPGridState getStruct( )
   {
      com.wwpbaseobjects.StructSdtWWPGridState struct = new com.wwpbaseobjects.StructSdtWWPGridState ();
      struct.setCurrentpage(getgxTv_SdtWWPGridState_Currentpage());
      struct.setOrderedby(getgxTv_SdtWWPGridState_Orderedby());
      struct.setOrdereddsc(getgxTv_SdtWWPGridState_Ordereddsc());
      struct.setHidingsearch(getgxTv_SdtWWPGridState_Hidingsearch());
      struct.setPagesize(getgxTv_SdtWWPGridState_Pagesize());
      if ( gxTv_SdtWWPGridState_Collapsedrecords_N == 0 )
      {
         struct.setCollapsedrecords(getgxTv_SdtWWPGridState_Collapsedrecords());
      }
      if ( gxTv_SdtWWPGridState_Groupby_N == 0 )
      {
         struct.setGroupby(getgxTv_SdtWWPGridState_Groupby());
      }
      struct.setFiltervalues(getgxTv_SdtWWPGridState_Filtervalues().getStruct());
      struct.setDynamicfilters(getgxTv_SdtWWPGridState_Dynamicfilters().getStruct());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected byte gxTv_SdtWWPGridState_Hidingsearch ;
   protected byte gxTv_SdtWWPGridState_Collapsedrecords_N ;
   protected byte gxTv_SdtWWPGridState_Groupby_N ;
   protected byte gxTv_SdtWWPGridState_Filtervalues_N ;
   protected byte gxTv_SdtWWPGridState_Dynamicfilters_N ;
   protected short gxTv_SdtWWPGridState_Currentpage ;
   protected short gxTv_SdtWWPGridState_Orderedby ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtWWPGridState_Ordereddsc ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPGridState_Collapsedrecords ;
   protected String gxTv_SdtWWPGridState_Pagesize ;
   protected String gxTv_SdtWWPGridState_Groupby ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_FilterValue> gxTv_SdtWWPGridState_Filtervalues_aux ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_DynamicFilter> gxTv_SdtWWPGridState_Dynamicfilters_aux ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_FilterValue> gxTv_SdtWWPGridState_Filtervalues=null ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtWWPGridState_DynamicFilter> gxTv_SdtWWPGridState_Dynamicfilters=null ;
}

