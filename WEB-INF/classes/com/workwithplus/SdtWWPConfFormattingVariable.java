package com.workwithplus ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPConfFormattingVariable extends GxUserType
{
   public SdtWWPConfFormattingVariable( )
   {
      this(  new ModelContext(SdtWWPConfFormattingVariable.class));
   }

   public SdtWWPConfFormattingVariable( ModelContext context )
   {
      super( context, "SdtWWPConfFormattingVariable");
   }

   public SdtWWPConfFormattingVariable( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPConfFormattingVariable");
   }

   public SdtWWPConfFormattingVariable( StructSdtWWPConfFormattingVariable struct )
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
               gxTv_SdtWWPConfFormattingVariable_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtWWPConfFormattingVariable_Description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DefaultValue") )
            {
               gxTv_SdtWWPConfFormattingVariable_Defaultvalue = oReader.getValue() ;
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
         sName = "WWPConfFormattingVariable" ;
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
      oWriter.writeElement("Name", gxTv_SdtWWPConfFormattingVariable_Name);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Description", gxTv_SdtWWPConfFormattingVariable_Description);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("DefaultValue", gxTv_SdtWWPConfFormattingVariable_Defaultvalue);
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
      AddObjectProperty("Name", gxTv_SdtWWPConfFormattingVariable_Name, false, false);
      AddObjectProperty("Description", gxTv_SdtWWPConfFormattingVariable_Description, false, false);
      AddObjectProperty("DefaultValue", gxTv_SdtWWPConfFormattingVariable_Defaultvalue, false, false);
   }

   public String getgxTv_SdtWWPConfFormattingVariable_Name( )
   {
      return gxTv_SdtWWPConfFormattingVariable_Name ;
   }

   public void setgxTv_SdtWWPConfFormattingVariable_Name( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPConfFormattingVariable_Name = value ;
   }

   public String getgxTv_SdtWWPConfFormattingVariable_Description( )
   {
      return gxTv_SdtWWPConfFormattingVariable_Description ;
   }

   public void setgxTv_SdtWWPConfFormattingVariable_Description( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPConfFormattingVariable_Description = value ;
   }

   public String getgxTv_SdtWWPConfFormattingVariable_Defaultvalue( )
   {
      return gxTv_SdtWWPConfFormattingVariable_Defaultvalue ;
   }

   public void setgxTv_SdtWWPConfFormattingVariable_Defaultvalue( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPConfFormattingVariable_Defaultvalue = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPConfFormattingVariable_Name = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWPConfFormattingVariable_Description = "" ;
      gxTv_SdtWWPConfFormattingVariable_Defaultvalue = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.workwithplus.SdtWWPConfFormattingVariable Clone( )
   {
      return (com.workwithplus.SdtWWPConfFormattingVariable)(clone()) ;
   }

   public void setStruct( com.workwithplus.StructSdtWWPConfFormattingVariable struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWPConfFormattingVariable_Name(struct.getName());
         setgxTv_SdtWWPConfFormattingVariable_Description(struct.getDescription());
         setgxTv_SdtWWPConfFormattingVariable_Defaultvalue(struct.getDefaultvalue());
      }
   }

   @SuppressWarnings("unchecked")
   public com.workwithplus.StructSdtWWPConfFormattingVariable getStruct( )
   {
      com.workwithplus.StructSdtWWPConfFormattingVariable struct = new com.workwithplus.StructSdtWWPConfFormattingVariable ();
      struct.setName(getgxTv_SdtWWPConfFormattingVariable_Name());
      struct.setDescription(getgxTv_SdtWWPConfFormattingVariable_Description());
      struct.setDefaultvalue(getgxTv_SdtWWPConfFormattingVariable_Defaultvalue());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPConfFormattingVariable_Name ;
   protected String gxTv_SdtWWPConfFormattingVariable_Description ;
   protected String gxTv_SdtWWPConfFormattingVariable_Defaultvalue ;
}

