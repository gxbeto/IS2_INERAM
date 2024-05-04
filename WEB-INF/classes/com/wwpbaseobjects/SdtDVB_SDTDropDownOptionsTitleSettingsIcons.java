package com.wwpbaseobjects ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtDVB_SDTDropDownOptionsTitleSettingsIcons extends GxUserType
{
   public SdtDVB_SDTDropDownOptionsTitleSettingsIcons( )
   {
      this(  new ModelContext(SdtDVB_SDTDropDownOptionsTitleSettingsIcons.class));
   }

   public SdtDVB_SDTDropDownOptionsTitleSettingsIcons( ModelContext context )
   {
      super( context, "SdtDVB_SDTDropDownOptionsTitleSettingsIcons");
   }

   public SdtDVB_SDTDropDownOptionsTitleSettingsIcons( int remoteHandle ,
                                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtDVB_SDTDropDownOptionsTitleSettingsIcons");
   }

   public SdtDVB_SDTDropDownOptionsTitleSettingsIcons( StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
      mapper.put( "def" ,  "Default_fi" );
      mapper.put( "fil" ,  "Filtered_fi" );
      mapper.put( "asc" ,  "Sortedasc_fi" );
      mapper.put( "dsc" ,  "Sorteddsc_fi" );
      mapper.put( "fasc" ,  "Filteredsortedasc_fi" );
      mapper.put( "fdsc" ,  "Filteredsorteddsc_fi" );
      mapper.put( "osasc" ,  "Optionsortasc_fi" );
      mapper.put( "osdsc" ,  "Optionsortdsc_fi" );
      mapper.put( "app" ,  "Optionapplyfilter_fi" );
      mapper.put( "fildata" ,  "Optionfilteringdata_fi" );
      mapper.put( "cle" ,  "Optioncleanfilters_fi" );
      mapper.put( "selo" ,  "Selectedoption_fi" );
      mapper.put( "mul" ,  "Multiseloption_fi" );
      mapper.put( "muls" ,  "Multiselseloption_fi" );
      mapper.put( "tcol" ,  "Treeviewcollapse_fi" );
      mapper.put( "texp" ,  "Treeviewexpand_fi" );
      mapper.put( "fixl" ,  "Fixleft_fi" );
      mapper.put( "fixr" ,  "Fixright_fi" );
      mapper.put( "og" ,  "Optiongroup_fi" );
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Default_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Filtered_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SortedASC_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SortedDSC_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FilteredSortedASC_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FilteredSortedDSC_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionSortASC_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionSortDSC_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionApplyFilter_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionFilteringData_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionCleanFilters_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SelectedOption_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MultiselOption_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MultiselSelOption_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TreeviewCollapse_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TreeviewExpand_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FixLeft_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "FixRight_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "OptionGroup_fi") && ( oReader.getNodeType() != 2 ) && ( GXutil.strcmp(oReader.getNamespaceURI(), "") == 0 ) )
            {
               gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi = oReader.getValue() ;
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
         sName = "TitleSettingsIcons" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "" ;
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
      oWriter.writeElement("Default_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("Filtered_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("SortedASC_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("SortedDSC_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("FilteredSortedASC_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("FilteredSortedDSC_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("OptionSortASC_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("OptionSortDSC_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("OptionApplyFilter_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("OptionFilteringData_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("OptionCleanFilters_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("SelectedOption_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("MultiselOption_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("MultiselSelOption_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("TreeviewCollapse_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("TreeviewExpand_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("FixLeft_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("FixRight_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
      }
      oWriter.writeElement("OptionGroup_fi", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi);
      if ( GXutil.strcmp(sNameSpace, "") != 0 )
      {
         oWriter.writeAttribute("xmlns", "");
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
      AddObjectProperty("def", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi, false, false);
      AddObjectProperty("fil", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi, false, false);
      AddObjectProperty("asc", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi, false, false);
      AddObjectProperty("dsc", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi, false, false);
      AddObjectProperty("fasc", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi, false, false);
      AddObjectProperty("fdsc", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi, false, false);
      AddObjectProperty("osasc", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi, false, false);
      AddObjectProperty("osdsc", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi, false, false);
      AddObjectProperty("app", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi, false, false);
      AddObjectProperty("fildata", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi, false, false);
      AddObjectProperty("cle", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi, false, false);
      AddObjectProperty("selo", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi, false, false);
      AddObjectProperty("mul", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi, false, false);
      AddObjectProperty("muls", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi, false, false);
      AddObjectProperty("tcol", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi, false, false);
      AddObjectProperty("texp", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi, false, false);
      AddObjectProperty("fixl", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi, false, false);
      AddObjectProperty("fixr", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi, false, false);
      AddObjectProperty("og", gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi, false, false);
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi = value ;
   }

   public String getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi ;
   }

   public void setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons Clone( )
   {
      return (com.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons)(clone()) ;
   }

   public void setStruct( com.wwpbaseobjects.StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi(struct.getDefault_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi(struct.getFiltered_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi(struct.getSortedasc_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi(struct.getSorteddsc_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi(struct.getFilteredsortedasc_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi(struct.getFilteredsorteddsc_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi(struct.getOptionsortasc_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi(struct.getOptionsortdsc_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi(struct.getOptionapplyfilter_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi(struct.getOptionfilteringdata_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi(struct.getOptioncleanfilters_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi(struct.getSelectedoption_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi(struct.getMultiseloption_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi(struct.getMultiselseloption_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi(struct.getTreeviewcollapse_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi(struct.getTreeviewexpand_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi(struct.getFixleft_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi(struct.getFixright_fi());
         setgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi(struct.getOptiongroup_fi());
      }
   }

   @SuppressWarnings("unchecked")
   public com.wwpbaseobjects.StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons getStruct( )
   {
      com.wwpbaseobjects.StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons struct = new com.wwpbaseobjects.StructSdtDVB_SDTDropDownOptionsTitleSettingsIcons ();
      struct.setDefault_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi());
      struct.setFiltered_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi());
      struct.setSortedasc_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi());
      struct.setSorteddsc_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi());
      struct.setFilteredsortedasc_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi());
      struct.setFilteredsorteddsc_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi());
      struct.setOptionsortasc_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi());
      struct.setOptionsortdsc_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi());
      struct.setOptionapplyfilter_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi());
      struct.setOptionfilteringdata_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi());
      struct.setOptioncleanfilters_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi());
      struct.setSelectedoption_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi());
      struct.setMultiseloption_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi());
      struct.setMultiselseloption_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi());
      struct.setTreeviewcollapse_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi());
      struct.setTreeviewexpand_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi());
      struct.setFixleft_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi());
      struct.setFixright_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi());
      struct.setOptiongroup_fi(getgxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Default_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filtered_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sortedasc_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Sorteddsc_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsortedasc_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Filteredsorteddsc_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortasc_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionsortdsc_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionapplyfilter_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optionfilteringdata_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optioncleanfilters_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Selectedoption_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiseloption_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Multiselseloption_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewcollapse_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Treeviewexpand_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixleft_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Fixright_fi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons_Optiongroup_fi ;
}

