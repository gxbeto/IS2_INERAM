package com.workwithplus ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtWWP_Parameter extends GxSilentTrnSdt
{
   public SdtWWP_Parameter( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtWWP_Parameter.class));
   }

   public SdtWWP_Parameter( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtWWP_Parameter");
      initialize( remoteHandle) ;
   }

   public SdtWWP_Parameter( int remoteHandle ,
                            StructSdtWWP_Parameter struct )
   {
      this(remoteHandle);
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

   public void Load( String AV4WWPParameterKey )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {AV4WWPParameterKey});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"WWPParameterKey", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "WorkWithPlus\\WWP_Parameter");
      metadata.set("BT", "WWP_Parameter");
      metadata.set("PK", "[ \"WWPParameterKey\" ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterKey") )
            {
               gxTv_SdtWWP_Parameter_Wwpparameterkey = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterCategory") )
            {
               gxTv_SdtWWP_Parameter_Wwpparametercategory = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterDescription") )
            {
               gxTv_SdtWWP_Parameter_Wwpparameterdescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterValue") )
            {
               gxTv_SdtWWP_Parameter_Wwpparametervalue = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterValueTrimmed") )
            {
               gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterDisableDelete") )
            {
               gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtWWP_Parameter_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtWWP_Parameter_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterKey_Z") )
            {
               gxTv_SdtWWP_Parameter_Wwpparameterkey_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterCategory_Z") )
            {
               gxTv_SdtWWP_Parameter_Wwpparametercategory_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterDescription_Z") )
            {
               gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterValueTrimmed_Z") )
            {
               gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "WWPParameterDisableDelete_Z") )
            {
               gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "WWP_Parameter" ;
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
      oWriter.writeElement("WWPParameterKey", gxTv_SdtWWP_Parameter_Wwpparameterkey);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("WWPParameterCategory", gxTv_SdtWWP_Parameter_Wwpparametercategory);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("WWPParameterDescription", gxTv_SdtWWP_Parameter_Wwpparameterdescription);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("WWPParameterValue", gxTv_SdtWWP_Parameter_Wwpparametervalue);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("WWPParameterValueTrimmed", gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("WWPParameterDisableDelete", GXutil.booltostr( gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtWWP_Parameter_Mode);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtWWP_Parameter_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("WWPParameterKey_Z", gxTv_SdtWWP_Parameter_Wwpparameterkey_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("WWPParameterCategory_Z", gxTv_SdtWWP_Parameter_Wwpparametercategory_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("WWPParameterDescription_Z", gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("WWPParameterValueTrimmed_Z", gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z);
         if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
         {
            oWriter.writeAttribute("xmlns", "Gregory");
         }
         oWriter.writeElement("WWPParameterDisableDelete_Z", GXutil.booltostr( gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z));
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
      AddObjectProperty("WWPParameterKey", gxTv_SdtWWP_Parameter_Wwpparameterkey, false, includeNonInitialized);
      AddObjectProperty("WWPParameterCategory", gxTv_SdtWWP_Parameter_Wwpparametercategory, false, includeNonInitialized);
      AddObjectProperty("WWPParameterDescription", gxTv_SdtWWP_Parameter_Wwpparameterdescription, false, includeNonInitialized);
      AddObjectProperty("WWPParameterValue", gxTv_SdtWWP_Parameter_Wwpparametervalue, false, includeNonInitialized);
      AddObjectProperty("WWPParameterValueTrimmed", gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed, false, includeNonInitialized);
      AddObjectProperty("WWPParameterDisableDelete", gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtWWP_Parameter_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtWWP_Parameter_Initialized, false, includeNonInitialized);
         AddObjectProperty("WWPParameterKey_Z", gxTv_SdtWWP_Parameter_Wwpparameterkey_Z, false, includeNonInitialized);
         AddObjectProperty("WWPParameterCategory_Z", gxTv_SdtWWP_Parameter_Wwpparametercategory_Z, false, includeNonInitialized);
         AddObjectProperty("WWPParameterDescription_Z", gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z, false, includeNonInitialized);
         AddObjectProperty("WWPParameterValueTrimmed_Z", gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z, false, includeNonInitialized);
         AddObjectProperty("WWPParameterDisableDelete_Z", gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.workwithplus.SdtWWP_Parameter sdt )
   {
      if ( sdt.IsDirty("WWPParameterKey") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtWWP_Parameter_Wwpparameterkey = sdt.getgxTv_SdtWWP_Parameter_Wwpparameterkey() ;
      }
      if ( sdt.IsDirty("WWPParameterCategory") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtWWP_Parameter_Wwpparametercategory = sdt.getgxTv_SdtWWP_Parameter_Wwpparametercategory() ;
      }
      if ( sdt.IsDirty("WWPParameterDescription") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtWWP_Parameter_Wwpparameterdescription = sdt.getgxTv_SdtWWP_Parameter_Wwpparameterdescription() ;
      }
      if ( sdt.IsDirty("WWPParameterValue") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtWWP_Parameter_Wwpparametervalue = sdt.getgxTv_SdtWWP_Parameter_Wwpparametervalue() ;
      }
      if ( sdt.IsDirty("WWPParameterValueTrimmed") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed = sdt.getgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed() ;
      }
      if ( sdt.IsDirty("WWPParameterDisableDelete") )
      {
         sdtIsNull = (byte)(0) ;
         gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete = sdt.getgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete() ;
      }
   }

   public String getgxTv_SdtWWP_Parameter_Wwpparameterkey( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterkey ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparameterkey( String value )
   {
      sdtIsNull = (byte)(0) ;
      if ( GXutil.strcmp(gxTv_SdtWWP_Parameter_Wwpparameterkey, value) != 0 )
      {
         gxTv_SdtWWP_Parameter_Mode = "INS" ;
         this.setgxTv_SdtWWP_Parameter_Wwpparameterkey_Z_SetNull( );
         this.setgxTv_SdtWWP_Parameter_Wwpparametercategory_Z_SetNull( );
         this.setgxTv_SdtWWP_Parameter_Wwpparameterdescription_Z_SetNull( );
         this.setgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z_SetNull( );
         this.setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z_SetNull( );
      }
      SetDirty("Wwpparameterkey");
      gxTv_SdtWWP_Parameter_Wwpparameterkey = value ;
   }

   public String getgxTv_SdtWWP_Parameter_Wwpparametercategory( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametercategory ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparametercategory( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparametercategory");
      gxTv_SdtWWP_Parameter_Wwpparametercategory = value ;
   }

   public String getgxTv_SdtWWP_Parameter_Wwpparameterdescription( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterdescription ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparameterdescription( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparameterdescription");
      gxTv_SdtWWP_Parameter_Wwpparameterdescription = value ;
   }

   public String getgxTv_SdtWWP_Parameter_Wwpparametervalue( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametervalue ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparametervalue( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparametervalue");
      gxTv_SdtWWP_Parameter_Wwpparametervalue = value ;
   }

   public String getgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparametervaluetrimmed");
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed = value ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_SetNull( )
   {
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed = "" ;
      SetDirty("Wwpparametervaluetrimmed");
   }

   public boolean getgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparameterdisabledelete");
      gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete = value ;
   }

   public String getgxTv_SdtWWP_Parameter_Mode( )
   {
      return gxTv_SdtWWP_Parameter_Mode ;
   }

   public void setgxTv_SdtWWP_Parameter_Mode( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtWWP_Parameter_Mode = value ;
   }

   public void setgxTv_SdtWWP_Parameter_Mode_SetNull( )
   {
      gxTv_SdtWWP_Parameter_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtWWP_Parameter_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtWWP_Parameter_Initialized( )
   {
      return gxTv_SdtWWP_Parameter_Initialized ;
   }

   public void setgxTv_SdtWWP_Parameter_Initialized( short value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtWWP_Parameter_Initialized = value ;
   }

   public void setgxTv_SdtWWP_Parameter_Initialized_SetNull( )
   {
      gxTv_SdtWWP_Parameter_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtWWP_Parameter_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Parameter_Wwpparameterkey_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterkey_Z ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparameterkey_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparameterkey_Z");
      gxTv_SdtWWP_Parameter_Wwpparameterkey_Z = value ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparameterkey_Z_SetNull( )
   {
      gxTv_SdtWWP_Parameter_Wwpparameterkey_Z = "" ;
      SetDirty("Wwpparameterkey_Z");
   }

   public boolean getgxTv_SdtWWP_Parameter_Wwpparameterkey_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Parameter_Wwpparametercategory_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametercategory_Z ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparametercategory_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparametercategory_Z");
      gxTv_SdtWWP_Parameter_Wwpparametercategory_Z = value ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparametercategory_Z_SetNull( )
   {
      gxTv_SdtWWP_Parameter_Wwpparametercategory_Z = "" ;
      SetDirty("Wwpparametercategory_Z");
   }

   public boolean getgxTv_SdtWWP_Parameter_Wwpparametercategory_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Parameter_Wwpparameterdescription_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparameterdescription_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparameterdescription_Z");
      gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z = value ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparameterdescription_Z_SetNull( )
   {
      gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z = "" ;
      SetDirty("Wwpparameterdescription_Z");
   }

   public boolean getgxTv_SdtWWP_Parameter_Wwpparameterdescription_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparametervaluetrimmed_Z");
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z = value ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z_SetNull( )
   {
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z = "" ;
      SetDirty("Wwpparametervaluetrimmed_Z");
   }

   public boolean getgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      SetDirty("Wwpparameterdisabledelete_Z");
      gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z = value ;
   }

   public void setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z_SetNull( )
   {
      gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z = false ;
      SetDirty("Wwpparameterdisabledelete_Z");
   }

   public boolean getgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.workwithplus.wwp_parameter_bc obj;
      obj = new com.workwithplus.wwp_parameter_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtWWP_Parameter_Wwpparameterkey = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtWWP_Parameter_Wwpparametercategory = "" ;
      gxTv_SdtWWP_Parameter_Wwpparameterdescription = "" ;
      gxTv_SdtWWP_Parameter_Wwpparametervalue = "" ;
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed = "" ;
      gxTv_SdtWWP_Parameter_Mode = "" ;
      gxTv_SdtWWP_Parameter_Wwpparameterkey_Z = "" ;
      gxTv_SdtWWP_Parameter_Wwpparametercategory_Z = "" ;
      gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z = "" ;
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.workwithplus.SdtWWP_Parameter Clone( )
   {
      com.workwithplus.SdtWWP_Parameter sdt;
      com.workwithplus.wwp_parameter_bc obj;
      sdt = (com.workwithplus.SdtWWP_Parameter)(clone()) ;
      obj = (com.workwithplus.wwp_parameter_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.workwithplus.StructSdtWWP_Parameter struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtWWP_Parameter_Wwpparameterkey(struct.getWwpparameterkey());
         setgxTv_SdtWWP_Parameter_Wwpparametercategory(struct.getWwpparametercategory());
         setgxTv_SdtWWP_Parameter_Wwpparameterdescription(struct.getWwpparameterdescription());
         setgxTv_SdtWWP_Parameter_Wwpparametervalue(struct.getWwpparametervalue());
         setgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed(struct.getWwpparametervaluetrimmed());
         setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete(struct.getWwpparameterdisabledelete());
         setgxTv_SdtWWP_Parameter_Mode(struct.getMode());
         setgxTv_SdtWWP_Parameter_Initialized(struct.getInitialized());
         setgxTv_SdtWWP_Parameter_Wwpparameterkey_Z(struct.getWwpparameterkey_Z());
         setgxTv_SdtWWP_Parameter_Wwpparametercategory_Z(struct.getWwpparametercategory_Z());
         setgxTv_SdtWWP_Parameter_Wwpparameterdescription_Z(struct.getWwpparameterdescription_Z());
         setgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z(struct.getWwpparametervaluetrimmed_Z());
         setgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z(struct.getWwpparameterdisabledelete_Z());
      }
   }

   @SuppressWarnings("unchecked")
   public com.workwithplus.StructSdtWWP_Parameter getStruct( )
   {
      com.workwithplus.StructSdtWWP_Parameter struct = new com.workwithplus.StructSdtWWP_Parameter ();
      struct.setWwpparameterkey(getgxTv_SdtWWP_Parameter_Wwpparameterkey());
      struct.setWwpparametercategory(getgxTv_SdtWWP_Parameter_Wwpparametercategory());
      struct.setWwpparameterdescription(getgxTv_SdtWWP_Parameter_Wwpparameterdescription());
      struct.setWwpparametervalue(getgxTv_SdtWWP_Parameter_Wwpparametervalue());
      struct.setWwpparametervaluetrimmed(getgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed());
      struct.setWwpparameterdisabledelete(getgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete());
      struct.setMode(getgxTv_SdtWWP_Parameter_Mode());
      struct.setInitialized(getgxTv_SdtWWP_Parameter_Initialized());
      struct.setWwpparameterkey_Z(getgxTv_SdtWWP_Parameter_Wwpparameterkey_Z());
      struct.setWwpparametercategory_Z(getgxTv_SdtWWP_Parameter_Wwpparametercategory_Z());
      struct.setWwpparameterdescription_Z(getgxTv_SdtWWP_Parameter_Wwpparameterdescription_Z());
      struct.setWwpparametervaluetrimmed_Z(getgxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z());
      struct.setWwpparameterdisabledelete_Z(getgxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z());
      return struct ;
   }

   private byte sdtIsNull ;
   private short gxTv_SdtWWP_Parameter_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtWWP_Parameter_Mode ;
   private String sTagName ;
   private boolean gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete ;
   private boolean gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtWWP_Parameter_Wwpparametervalue ;
   private String gxTv_SdtWWP_Parameter_Wwpparameterkey ;
   private String gxTv_SdtWWP_Parameter_Wwpparametercategory ;
   private String gxTv_SdtWWP_Parameter_Wwpparameterdescription ;
   private String gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed ;
   private String gxTv_SdtWWP_Parameter_Wwpparameterkey_Z ;
   private String gxTv_SdtWWP_Parameter_Wwpparametercategory_Z ;
   private String gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z ;
   private String gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z ;
}

