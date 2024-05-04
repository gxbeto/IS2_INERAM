package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPGridState_FilterValue extends GxUserType
{
   public SdtWWPGridState_FilterValue( )
   {
      this(  new ModelContext(SdtWWPGridState_FilterValue.class));
   }

   public SdtWWPGridState_FilterValue( ModelContext context )
   {
      super( context, "SdtWWPGridState_FilterValue");
   }

   public SdtWWPGridState_FilterValue( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPGridState_FilterValue");
   }

   public SdtWWPGridState_FilterValue( StructSdtWWPGridState_FilterValue struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") )
            {
               gxTv_SdtWWPGridState_FilterValue_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Dsc") )
            {
               gxTv_SdtWWPGridState_FilterValue_Dsc = oReader.getValue() ;
               gxTv_SdtWWPGridState_FilterValue_Dsc_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Value") )
            {
               gxTv_SdtWWPGridState_FilterValue_Value = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ValueDsc") )
            {
               gxTv_SdtWWPGridState_FilterValue_Valuedsc = oReader.getValue() ;
               gxTv_SdtWWPGridState_FilterValue_Valuedsc_N = (byte)(0) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Operator") )
            {
               gxTv_SdtWWPGridState_FilterValue_Operator = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ValueTo") )
            {
               gxTv_SdtWWPGridState_FilterValue_Valueto = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ValueToDsc") )
            {
               gxTv_SdtWWPGridState_FilterValue_Valuetodsc = oReader.getValue() ;
               gxTv_SdtWWPGridState_FilterValue_Valuetodsc_N = (byte)(0) ;
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
         sName = "WWPGridState.FilterValue" ;
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
      oWriter.writeElement("Name", gxTv_SdtWWPGridState_FilterValue_Name);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtWWPGridState_FilterValue_Dsc)==0) || ( gxTv_SdtWWPGridState_FilterValue_Dsc_N != 1 ) )
      {
         oWriter.writeElement("Dsc", gxTv_SdtWWPGridState_FilterValue_Dsc);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
      }
      oWriter.writeElement("Value", gxTv_SdtWWPGridState_FilterValue_Value);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtWWPGridState_FilterValue_Valuedsc)==0) || ( gxTv_SdtWWPGridState_FilterValue_Valuedsc_N != 1 ) )
      {
         oWriter.writeElement("ValueDsc", gxTv_SdtWWPGridState_FilterValue_Valuedsc);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
      }
      oWriter.writeElement("Operator", GXutil.trim( GXutil.str( gxTv_SdtWWPGridState_FilterValue_Operator, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("ValueTo", gxTv_SdtWWPGridState_FilterValue_Valueto);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( ! (GXutil.strcmp("", gxTv_SdtWWPGridState_FilterValue_Valuetodsc)==0) || ( gxTv_SdtWWPGridState_FilterValue_Valuetodsc_N != 1 ) )
      {
         oWriter.writeElement("ValueToDsc", gxTv_SdtWWPGridState_FilterValue_Valuetodsc);
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
      AddObjectProperty("Name", gxTv_SdtWWPGridState_FilterValue_Name, false, false);
      AddObjectProperty("Dsc", gxTv_SdtWWPGridState_FilterValue_Dsc, false, false);
      AddObjectProperty("Value", gxTv_SdtWWPGridState_FilterValue_Value, false, false);
      AddObjectProperty("ValueDsc", gxTv_SdtWWPGridState_FilterValue_Valuedsc, false, false);
      AddObjectProperty("Operator", gxTv_SdtWWPGridState_FilterValue_Operator, false, false);
      AddObjectProperty("ValueTo", gxTv_SdtWWPGridState_FilterValue_Valueto, false, false);
      AddObjectProperty("ValueToDsc", gxTv_SdtWWPGridState_FilterValue_Valuetodsc, false, false);
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Name( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Name ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Name( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Name = value ;
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Dsc( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Dsc ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Dsc( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_Dsc_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Dsc = value ;
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Value( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Value ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Value( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Value = value ;
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Valuedsc( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Valuedsc ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Valuedsc( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_Valuedsc_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Valuedsc = value ;
   }

   public short getgxTv_SdtWWPGridState_FilterValue_Operator( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Operator ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Operator( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Operator = value ;
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Valueto( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Valueto ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Valueto( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Valueto = value ;
   }

   public String getgxTv_SdtWWPGridState_FilterValue_Valuetodsc( )
   {
      return gxTv_SdtWWPGridState_FilterValue_Valuetodsc ;
   }

   public void setgxTv_SdtWWPGridState_FilterValue_Valuetodsc( String value )
   {
      gxTv_SdtWWPGridState_FilterValue_Valuetodsc_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_FilterValue_Valuetodsc = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPGridState_FilterValue_Name = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWPGridState_FilterValue_Dsc = "" ;
      gxTv_SdtWWPGridState_FilterValue_Dsc_N = (byte)(1) ;
      gxTv_SdtWWPGridState_FilterValue_Value = "" ;
      gxTv_SdtWWPGridState_FilterValue_Valuedsc = "" ;
      gxTv_SdtWWPGridState_FilterValue_Valuedsc_N = (byte)(1) ;
      gxTv_SdtWWPGridState_FilterValue_Valueto = "" ;
      gxTv_SdtWWPGridState_FilterValue_Valuetodsc = "" ;
      gxTv_SdtWWPGridState_FilterValue_Valuetodsc_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWWPGridState_FilterValue Clone( )
   {
      return (com.wwpbaseobjects.SdtWWPGridState_FilterValue)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWWPGridState_FilterValue struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWPGridState_FilterValue_Name(struct.getName());
         if ( struct.gxTv_SdtWWPGridState_FilterValue_Dsc_N == 0 )
         {
            setgxTv_SdtWWPGridState_FilterValue_Dsc(struct.getDsc());
         }
         setgxTv_SdtWWPGridState_FilterValue_Value(struct.getValue());
         if ( struct.gxTv_SdtWWPGridState_FilterValue_Valuedsc_N == 0 )
         {
            setgxTv_SdtWWPGridState_FilterValue_Valuedsc(struct.getValuedsc());
         }
         setgxTv_SdtWWPGridState_FilterValue_Operator(struct.getOperator());
         setgxTv_SdtWWPGridState_FilterValue_Valueto(struct.getValueto());
         if ( struct.gxTv_SdtWWPGridState_FilterValue_Valuetodsc_N == 0 )
         {
            setgxTv_SdtWWPGridState_FilterValue_Valuetodsc(struct.getValuetodsc());
         }
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWWPGridState_FilterValue getStruct( )
   {
      com.wwpbaseobjects.StructSdtWWPGridState_FilterValue struct = new com.wwpbaseobjects.StructSdtWWPGridState_FilterValue ();
      struct.setName(getgxTv_SdtWWPGridState_FilterValue_Name());
      if ( gxTv_SdtWWPGridState_FilterValue_Dsc_N == 0 )
      {
         struct.setDsc(getgxTv_SdtWWPGridState_FilterValue_Dsc());
      }
      struct.setValue(getgxTv_SdtWWPGridState_FilterValue_Value());
      if ( gxTv_SdtWWPGridState_FilterValue_Valuedsc_N == 0 )
      {
         struct.setValuedsc(getgxTv_SdtWWPGridState_FilterValue_Valuedsc());
      }
      struct.setOperator(getgxTv_SdtWWPGridState_FilterValue_Operator());
      struct.setValueto(getgxTv_SdtWWPGridState_FilterValue_Valueto());
      if ( gxTv_SdtWWPGridState_FilterValue_Valuetodsc_N == 0 )
      {
         struct.setValuetodsc(getgxTv_SdtWWPGridState_FilterValue_Valuetodsc());
      }
      return struct ;
   }

   protected byte sdtIsNull ;
   protected byte gxTv_SdtWWPGridState_FilterValue_Dsc_N ;
   protected byte gxTv_SdtWWPGridState_FilterValue_Valuedsc_N ;
   protected byte gxTv_SdtWWPGridState_FilterValue_Valuetodsc_N ;
   protected short gxTv_SdtWWPGridState_FilterValue_Operator ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPGridState_FilterValue_Name ;
   protected String gxTv_SdtWWPGridState_FilterValue_Dsc ;
   protected String gxTv_SdtWWPGridState_FilterValue_Value ;
   protected String gxTv_SdtWWPGridState_FilterValue_Valuedsc ;
   protected String gxTv_SdtWWPGridState_FilterValue_Valueto ;
   protected String gxTv_SdtWWPGridState_FilterValue_Valuetodsc ;
}

