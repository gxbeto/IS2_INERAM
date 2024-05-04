package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSplitScreenDetailInfo extends GxUserType
{
   public SdtSplitScreenDetailInfo( )
   {
      this(  new ModelContext(SdtSplitScreenDetailInfo.class));
   }

   public SdtSplitScreenDetailInfo( ModelContext context )
   {
      super( context, "SdtSplitScreenDetailInfo");
   }

   public SdtSplitScreenDetailInfo( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtSplitScreenDetailInfo");
   }

   public SdtSplitScreenDetailInfo( StructSdtSplitScreenDetailInfo struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Link") )
            {
               gxTv_SdtSplitScreenDetailInfo_Link = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") )
            {
               gxTv_SdtSplitScreenDetailInfo_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Keys") )
            {
               gxTv_SdtSplitScreenDetailInfo_Keys = oReader.getValue() ;
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
         sName = "SplitScreenDetailInfo" ;
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
      oWriter.writeElement("Link", gxTv_SdtSplitScreenDetailInfo_Link);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Title", gxTv_SdtSplitScreenDetailInfo_Title);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Keys", gxTv_SdtSplitScreenDetailInfo_Keys);
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
      AddObjectProperty("Link", gxTv_SdtSplitScreenDetailInfo_Link, false, false);
      AddObjectProperty("Title", gxTv_SdtSplitScreenDetailInfo_Title, false, false);
      AddObjectProperty("Keys", gxTv_SdtSplitScreenDetailInfo_Keys, false, false);
   }

   public String getgxTv_SdtSplitScreenDetailInfo_Link( )
   {
      return gxTv_SdtSplitScreenDetailInfo_Link ;
   }

   public void setgxTv_SdtSplitScreenDetailInfo_Link( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtSplitScreenDetailInfo_Link = value ;
   }

   public String getgxTv_SdtSplitScreenDetailInfo_Title( )
   {
      return gxTv_SdtSplitScreenDetailInfo_Title ;
   }

   public void setgxTv_SdtSplitScreenDetailInfo_Title( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtSplitScreenDetailInfo_Title = value ;
   }

   public String getgxTv_SdtSplitScreenDetailInfo_Keys( )
   {
      return gxTv_SdtSplitScreenDetailInfo_Keys ;
   }

   public void setgxTv_SdtSplitScreenDetailInfo_Keys( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtSplitScreenDetailInfo_Keys = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSplitScreenDetailInfo_Link = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtSplitScreenDetailInfo_Title = "" ;
      gxTv_SdtSplitScreenDetailInfo_Keys = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtSplitScreenDetailInfo Clone( )
   {
      return (com.wwpbaseobjects.SdtSplitScreenDetailInfo)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtSplitScreenDetailInfo struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtSplitScreenDetailInfo_Link(struct.getLink());
         setgxTv_SdtSplitScreenDetailInfo_Title(struct.getTitle());
         setgxTv_SdtSplitScreenDetailInfo_Keys(struct.getKeys());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtSplitScreenDetailInfo getStruct( )
   {
      com.wwpbaseobjects.StructSdtSplitScreenDetailInfo struct = new com.wwpbaseobjects.StructSdtSplitScreenDetailInfo ();
      struct.setLink(getgxTv_SdtSplitScreenDetailInfo_Link());
      struct.setTitle(getgxTv_SdtSplitScreenDetailInfo_Title());
      struct.setKeys(getgxTv_SdtSplitScreenDetailInfo_Keys());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSplitScreenDetailInfo_Link ;
   protected String gxTv_SdtSplitScreenDetailInfo_Title ;
   protected String gxTv_SdtSplitScreenDetailInfo_Keys ;
}

