package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPColumnsSelector_Column extends GxUserType
{
   public SdtWWPColumnsSelector_Column( )
   {
      this(  new ModelContext(SdtWWPColumnsSelector_Column.class));
   }

   public SdtWWPColumnsSelector_Column( ModelContext context )
   {
      super( context, "SdtWWPColumnsSelector_Column");
   }

   public SdtWWPColumnsSelector_Column( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPColumnsSelector_Column");
   }

   public SdtWWPColumnsSelector_Column( StructSdtWWPColumnsSelector_Column struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
      mapper.put( "C" ,  "Columnname" );
      mapper.put( "V" ,  "Isvisible" );
      mapper.put( "D" ,  "Displayname" );
      mapper.put( "O" ,  "Order" );
      mapper.put( "G" ,  "Category" );
      mapper.put( "F" ,  "Fixed" );
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ColumnName") )
            {
               gxTv_SdtWWPColumnsSelector_Column_Columnname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "IsVisible") )
            {
               gxTv_SdtWWPColumnsSelector_Column_Isvisible = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DisplayName") )
            {
               gxTv_SdtWWPColumnsSelector_Column_Displayname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Order") )
            {
               gxTv_SdtWWPColumnsSelector_Column_Order = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Category") )
            {
               gxTv_SdtWWPColumnsSelector_Column_Category = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Fixed") )
            {
               gxTv_SdtWWPColumnsSelector_Column_Fixed = oReader.getValue() ;
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
         sName = "WWPColumnsSelector.Column" ;
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
      oWriter.writeElement("ColumnName", gxTv_SdtWWPColumnsSelector_Column_Columnname);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("IsVisible", GXutil.booltostr( gxTv_SdtWWPColumnsSelector_Column_Isvisible));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("DisplayName", gxTv_SdtWWPColumnsSelector_Column_Displayname);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Order", GXutil.trim( GXutil.str( gxTv_SdtWWPColumnsSelector_Column_Order, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Category", gxTv_SdtWWPColumnsSelector_Column_Category);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Fixed", gxTv_SdtWWPColumnsSelector_Column_Fixed);
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
      AddObjectProperty("C", gxTv_SdtWWPColumnsSelector_Column_Columnname, false, false);
      AddObjectProperty("V", gxTv_SdtWWPColumnsSelector_Column_Isvisible, false, false);
      AddObjectProperty("D", gxTv_SdtWWPColumnsSelector_Column_Displayname, false, false);
      AddObjectProperty("O", gxTv_SdtWWPColumnsSelector_Column_Order, false, false);
      AddObjectProperty("G", gxTv_SdtWWPColumnsSelector_Column_Category, false, false);
      AddObjectProperty("F", gxTv_SdtWWPColumnsSelector_Column_Fixed, false, false);
   }

   public String getgxTv_SdtWWPColumnsSelector_Column_Columnname( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Columnname ;
   }

   public void setgxTv_SdtWWPColumnsSelector_Column_Columnname( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Columnname = value ;
   }

   public boolean getgxTv_SdtWWPColumnsSelector_Column_Isvisible( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Isvisible ;
   }

   public void setgxTv_SdtWWPColumnsSelector_Column_Isvisible( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Isvisible = value ;
   }

   public String getgxTv_SdtWWPColumnsSelector_Column_Displayname( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Displayname ;
   }

   public void setgxTv_SdtWWPColumnsSelector_Column_Displayname( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Displayname = value ;
   }

   public short getgxTv_SdtWWPColumnsSelector_Column_Order( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Order ;
   }

   public void setgxTv_SdtWWPColumnsSelector_Column_Order( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Order = value ;
   }

   public String getgxTv_SdtWWPColumnsSelector_Column_Category( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Category ;
   }

   public void setgxTv_SdtWWPColumnsSelector_Column_Category( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Category = value ;
   }

   public String getgxTv_SdtWWPColumnsSelector_Column_Fixed( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Fixed ;
   }

   public void setgxTv_SdtWWPColumnsSelector_Column_Fixed( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Fixed = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPColumnsSelector_Column_Columnname = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWPColumnsSelector_Column_Displayname = "" ;
      gxTv_SdtWWPColumnsSelector_Column_Category = "" ;
      gxTv_SdtWWPColumnsSelector_Column_Fixed = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWWPColumnsSelector_Column Clone( )
   {
      return (com.wwpbaseobjects.SdtWWPColumnsSelector_Column)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWWPColumnsSelector_Column struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWPColumnsSelector_Column_Columnname(struct.getColumnname());
         setgxTv_SdtWWPColumnsSelector_Column_Isvisible(struct.getIsvisible());
         setgxTv_SdtWWPColumnsSelector_Column_Displayname(struct.getDisplayname());
         setgxTv_SdtWWPColumnsSelector_Column_Order(struct.getOrder());
         setgxTv_SdtWWPColumnsSelector_Column_Category(struct.getCategory());
         setgxTv_SdtWWPColumnsSelector_Column_Fixed(struct.getFixed());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWWPColumnsSelector_Column getStruct( )
   {
      com.wwpbaseobjects.StructSdtWWPColumnsSelector_Column struct = new com.wwpbaseobjects.StructSdtWWPColumnsSelector_Column ();
      struct.setColumnname(getgxTv_SdtWWPColumnsSelector_Column_Columnname());
      struct.setIsvisible(getgxTv_SdtWWPColumnsSelector_Column_Isvisible());
      struct.setDisplayname(getgxTv_SdtWWPColumnsSelector_Column_Displayname());
      struct.setOrder(getgxTv_SdtWWPColumnsSelector_Column_Order());
      struct.setCategory(getgxTv_SdtWWPColumnsSelector_Column_Category());
      struct.setFixed(getgxTv_SdtWWPColumnsSelector_Column_Fixed());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short gxTv_SdtWWPColumnsSelector_Column_Order ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtWWPColumnsSelector_Column_Isvisible ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPColumnsSelector_Column_Columnname ;
   protected String gxTv_SdtWWPColumnsSelector_Column_Displayname ;
   protected String gxTv_SdtWWPColumnsSelector_Column_Category ;
   protected String gxTv_SdtWWPColumnsSelector_Column_Fixed ;
}

