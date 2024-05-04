package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWPTransactionContext extends GxUserType
{
   public SdtWWPTransactionContext( )
   {
      this(  new ModelContext(SdtWWPTransactionContext.class));
   }

   public SdtWWPTransactionContext( ModelContext context )
   {
      super( context, "SdtWWPTransactionContext");
   }

   public SdtWWPTransactionContext( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle, context, "SdtWWPTransactionContext");
   }

   public SdtWWPTransactionContext( StructSdtWWPTransactionContext struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CallerObject") )
            {
               gxTv_SdtWWPTransactionContext_Callerobject = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CallerOnDelete") )
            {
               gxTv_SdtWWPTransactionContext_Callerondelete = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CallerURL") )
            {
               gxTv_SdtWWPTransactionContext_Callerurl = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TransactionName") )
            {
               gxTv_SdtWWPTransactionContext_Transactionname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Attributes") )
            {
               if ( gxTv_SdtWWPTransactionContext_Attributes == null )
               {
                  gxTv_SdtWWPTransactionContext_Attributes = new GXBaseCollection<com.wwpbaseobjects.SdtWWPTransactionContext_Attribute>(com.wwpbaseobjects.SdtWWPTransactionContext_Attribute.class, "WWPTransactionContext.Attribute", "Gregory", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtWWPTransactionContext_Attributes.readxmlcollection(oReader, "Attributes", "Attribute") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Attributes") )
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
         sName = "WWPTransactionContext" ;
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
      oWriter.writeElement("CallerObject", gxTv_SdtWWPTransactionContext_Callerobject);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("CallerOnDelete", GXutil.booltostr( gxTv_SdtWWPTransactionContext_Callerondelete));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("CallerURL", gxTv_SdtWWPTransactionContext_Callerurl);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("TransactionName", gxTv_SdtWWPTransactionContext_Transactionname);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( gxTv_SdtWWPTransactionContext_Attributes != null )
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
         gxTv_SdtWWPTransactionContext_Attributes.writexmlcollection(oWriter, "Attributes", sNameSpace1, "Attribute", sNameSpace1);
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
      AddObjectProperty("CallerObject", gxTv_SdtWWPTransactionContext_Callerobject, false, false);
      AddObjectProperty("CallerOnDelete", gxTv_SdtWWPTransactionContext_Callerondelete, false, false);
      AddObjectProperty("CallerURL", gxTv_SdtWWPTransactionContext_Callerurl, false, false);
      AddObjectProperty("TransactionName", gxTv_SdtWWPTransactionContext_Transactionname, false, false);
      if ( gxTv_SdtWWPTransactionContext_Attributes != null )
      {
         AddObjectProperty("Attributes", gxTv_SdtWWPTransactionContext_Attributes, false, false);
      }
   }

   public String getgxTv_SdtWWPTransactionContext_Callerobject( )
   {
      return gxTv_SdtWWPTransactionContext_Callerobject ;
   }

   public void setgxTv_SdtWWPTransactionContext_Callerobject( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Callerobject = value ;
   }

   public boolean getgxTv_SdtWWPTransactionContext_Callerondelete( )
   {
      return gxTv_SdtWWPTransactionContext_Callerondelete ;
   }

   public void setgxTv_SdtWWPTransactionContext_Callerondelete( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Callerondelete = value ;
   }

   public String getgxTv_SdtWWPTransactionContext_Callerurl( )
   {
      return gxTv_SdtWWPTransactionContext_Callerurl ;
   }

   public void setgxTv_SdtWWPTransactionContext_Callerurl( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Callerurl = value ;
   }

   public String getgxTv_SdtWWPTransactionContext_Transactionname( )
   {
      return gxTv_SdtWWPTransactionContext_Transactionname ;
   }

   public void setgxTv_SdtWWPTransactionContext_Transactionname( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Transactionname = value ;
   }

   public GXBaseCollection<com.wwpbaseobjects.SdtWWPTransactionContext_Attribute> getgxTv_SdtWWPTransactionContext_Attributes( )
   {
      if ( gxTv_SdtWWPTransactionContext_Attributes == null )
      {
         gxTv_SdtWWPTransactionContext_Attributes = new GXBaseCollection<com.wwpbaseobjects.SdtWWPTransactionContext_Attribute>(com.wwpbaseobjects.SdtWWPTransactionContext_Attribute.class, "WWPTransactionContext.Attribute", "Gregory", remoteHandle);
      }
      gxTv_SdtWWPTransactionContext_Attributes_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      return gxTv_SdtWWPTransactionContext_Attributes ;
   }

   public void setgxTv_SdtWWPTransactionContext_Attributes( GXBaseCollection<com.wwpbaseobjects.SdtWWPTransactionContext_Attribute> value )
   {
      gxTv_SdtWWPTransactionContext_Attributes_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPTransactionContext_Attributes = value ;
   }

   public void setgxTv_SdtWWPTransactionContext_Attributes_SetNull( )
   {
      gxTv_SdtWWPTransactionContext_Attributes_N = (byte)(1) ;
      gxTv_SdtWWPTransactionContext_Attributes = null ;
   }

   public boolean getgxTv_SdtWWPTransactionContext_Attributes_IsNull( )
   {
      if ( gxTv_SdtWWPTransactionContext_Attributes == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtWWPTransactionContext_Attributes_N( )
   {
      return gxTv_SdtWWPTransactionContext_Attributes_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWWPTransactionContext_Callerobject = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWPTransactionContext_Callerurl = "" ;
      gxTv_SdtWWPTransactionContext_Transactionname = "" ;
      gxTv_SdtWWPTransactionContext_Attributes_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWWPTransactionContext Clone( )
   {
      return (com.wwpbaseobjects.SdtWWPTransactionContext)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWWPTransactionContext struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWPTransactionContext_Callerobject(struct.getCallerobject());
         setgxTv_SdtWWPTransactionContext_Callerondelete(struct.getCallerondelete());
         setgxTv_SdtWWPTransactionContext_Callerurl(struct.getCallerurl());
         setgxTv_SdtWWPTransactionContext_Transactionname(struct.getTransactionname());
         GXBaseCollection<com.wwpbaseobjects.SdtWWPTransactionContext_Attribute> gxTv_SdtWWPTransactionContext_Attributes_aux = new GXBaseCollection<com.wwpbaseobjects.SdtWWPTransactionContext_Attribute>(com.wwpbaseobjects.SdtWWPTransactionContext_Attribute.class, "WWPTransactionContext.Attribute", "Gregory", remoteHandle);
         Vector<com.wwpbaseobjects.StructSdtWWPTransactionContext_Attribute> gxTv_SdtWWPTransactionContext_Attributes_aux1 = struct.getAttributes();
         if (gxTv_SdtWWPTransactionContext_Attributes_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtWWPTransactionContext_Attributes_aux1.size(); i++)
            {
               gxTv_SdtWWPTransactionContext_Attributes_aux.add(new com.wwpbaseobjects.SdtWWPTransactionContext_Attribute(gxTv_SdtWWPTransactionContext_Attributes_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtWWPTransactionContext_Attributes(gxTv_SdtWWPTransactionContext_Attributes_aux);
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWWPTransactionContext getStruct( )
   {
      com.wwpbaseobjects.StructSdtWWPTransactionContext struct = new com.wwpbaseobjects.StructSdtWWPTransactionContext ();
      struct.setCallerobject(getgxTv_SdtWWPTransactionContext_Callerobject());
      struct.setCallerondelete(getgxTv_SdtWWPTransactionContext_Callerondelete());
      struct.setCallerurl(getgxTv_SdtWWPTransactionContext_Callerurl());
      struct.setTransactionname(getgxTv_SdtWWPTransactionContext_Transactionname());
      struct.setAttributes(getgxTv_SdtWWPTransactionContext_Attributes().getStruct());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected byte gxTv_SdtWWPTransactionContext_Attributes_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_SdtWWPTransactionContext_Callerondelete ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWWPTransactionContext_Callerobject ;
   protected String gxTv_SdtWWPTransactionContext_Callerurl ;
   protected String gxTv_SdtWWPTransactionContext_Transactionname ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtWWPTransactionContext_Attribute> gxTv_SdtWWPTransactionContext_Attributes_aux ;
   protected GXBaseCollection<com.wwpbaseobjects.SdtWWPTransactionContext_Attribute> gxTv_SdtWWPTransactionContext_Attributes=null ;
}

