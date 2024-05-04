package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWizardSteps_WizardStepsItem extends GxUserType
{
   public SdtWizardSteps_WizardStepsItem( )
   {
      this(  new ModelContext(SdtWizardSteps_WizardStepsItem.class));
   }

   public SdtWizardSteps_WizardStepsItem( ModelContext context )
   {
      super( context, "SdtWizardSteps_WizardStepsItem");
   }

   public SdtWizardSteps_WizardStepsItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtWizardSteps_WizardStepsItem");
   }

   public SdtWizardSteps_WizardStepsItem( StructSdtWizardSteps_WizardStepsItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Code") )
            {
               gxTv_SdtWizardSteps_WizardStepsItem_Code = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Title") )
            {
               gxTv_SdtWizardSteps_WizardStepsItem_Title = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Description") )
            {
               gxTv_SdtWizardSteps_WizardStepsItem_Description = oReader.getValue() ;
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
         sName = "WizardSteps.WizardStepsItem" ;
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
      oWriter.writeElement("Code", gxTv_SdtWizardSteps_WizardStepsItem_Code);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Title", gxTv_SdtWizardSteps_WizardStepsItem_Title);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Description", gxTv_SdtWizardSteps_WizardStepsItem_Description);
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
      AddObjectProperty("Code", gxTv_SdtWizardSteps_WizardStepsItem_Code, false, false);
      AddObjectProperty("Title", gxTv_SdtWizardSteps_WizardStepsItem_Title, false, false);
      AddObjectProperty("Description", gxTv_SdtWizardSteps_WizardStepsItem_Description, false, false);
   }

   public String getgxTv_SdtWizardSteps_WizardStepsItem_Code( )
   {
      return gxTv_SdtWizardSteps_WizardStepsItem_Code ;
   }

   public void setgxTv_SdtWizardSteps_WizardStepsItem_Code( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWizardSteps_WizardStepsItem_Code = value ;
   }

   public String getgxTv_SdtWizardSteps_WizardStepsItem_Title( )
   {
      return gxTv_SdtWizardSteps_WizardStepsItem_Title ;
   }

   public void setgxTv_SdtWizardSteps_WizardStepsItem_Title( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWizardSteps_WizardStepsItem_Title = value ;
   }

   public String getgxTv_SdtWizardSteps_WizardStepsItem_Description( )
   {
      return gxTv_SdtWizardSteps_WizardStepsItem_Description ;
   }

   public void setgxTv_SdtWizardSteps_WizardStepsItem_Description( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWizardSteps_WizardStepsItem_Description = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtWizardSteps_WizardStepsItem_Code = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWizardSteps_WizardStepsItem_Title = "" ;
      gxTv_SdtWizardSteps_WizardStepsItem_Description = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem Clone( )
   {
      return (com.wwpbaseobjects.SdtWizardSteps_WizardStepsItem)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtWizardSteps_WizardStepsItem struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWizardSteps_WizardStepsItem_Code(struct.getCode());
         setgxTv_SdtWizardSteps_WizardStepsItem_Title(struct.getTitle());
         setgxTv_SdtWizardSteps_WizardStepsItem_Description(struct.getDescription());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtWizardSteps_WizardStepsItem getStruct( )
   {
      com.wwpbaseobjects.StructSdtWizardSteps_WizardStepsItem struct = new com.wwpbaseobjects.StructSdtWizardSteps_WizardStepsItem ();
      struct.setCode(getgxTv_SdtWizardSteps_WizardStepsItem_Code());
      struct.setTitle(getgxTv_SdtWizardSteps_WizardStepsItem_Title());
      struct.setDescription(getgxTv_SdtWizardSteps_WizardStepsItem_Description());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtWizardSteps_WizardStepsItem_Code ;
   protected String gxTv_SdtWizardSteps_WizardStepsItem_Title ;
   protected String gxTv_SdtWizardSteps_WizardStepsItem_Description ;
}

