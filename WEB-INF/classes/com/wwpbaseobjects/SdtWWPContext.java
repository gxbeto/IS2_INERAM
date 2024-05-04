package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPContext extends GxUserType
{
   public SdtWWPContext( )
   {
      this(  new ModelContext(SdtWWPContext.class));
   }

   public SdtWWPContext( ModelContext context )
   {
      super( context, "SdtWWPContext");
   }

   public SdtWWPContext( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPContext");
   }

   public SdtWWPContext( StructSdtWWPContext struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserId") )
            {
               gxTv_SdtWWPContext_Userid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "UserName") )
            {
               gxTv_SdtWWPContext_Username = oReader.getValue() ;
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
         sName = "WWPContext" ;
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
      oWriter.writeElement("UserId", GXutil.trim( GXutil.str( gxTv_SdtWWPContext_Userid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("UserName", gxTv_SdtWWPContext_Username);
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
      AddObjectProperty("UserId", gxTv_SdtWWPContext_Userid, false, false);
      AddObjectProperty("UserName", gxTv_SdtWWPContext_Username, false, false);
   }

   public short getgxTv_SdtWWPContext_Userid( )
   {
      return gxTv_SdtWWPContext_Userid ;
   }

   public void setgxTv_SdtWWPContext_Userid( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPContext_Userid = value ;
   }

   public String getgxTv_SdtWWPContext_Username( )
   {
      return gxTv_SdtWWPContext_Username ;
   }

   public void setgxTv_SdtWWPContext_Username( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPContext_Username = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWPContext_Username = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWWPContext Clone( )
   {
      return (com.wwpbaseobjects.SdtWWPContext)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWWPContext struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWPContext_Userid(struct.getUserid());
         setgxTv_SdtWWPContext_Username(struct.getUsername());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWWPContext getStruct( )
   {
      com.wwpbaseobjects.StructSdtWWPContext struct = new com.wwpbaseobjects.StructSdtWWPContext ();
      struct.setUserid(getgxTv_SdtWWPContext_Userid());
      struct.setUsername(getgxTv_SdtWWPContext_Username());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short gxTv_SdtWWPContext_Userid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPContext_Username ;
}

