package com ;
import com.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtTreeNodeCollection_TreeNode extends GxUserType
{
   public SdtTreeNodeCollection_TreeNode( )
   {
      this(  new ModelContext(SdtTreeNodeCollection_TreeNode.class));
   }

   public SdtTreeNodeCollection_TreeNode( ModelContext context )
   {
      super( context, "SdtTreeNodeCollection_TreeNode");
   }

   public SdtTreeNodeCollection_TreeNode( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "SdtTreeNodeCollection_TreeNode");
   }

   public SdtTreeNodeCollection_TreeNode( StructSdtTreeNodeCollection_TreeNode struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Id") )
            {
               gxTv_SdtTreeNodeCollection_TreeNode_Id = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Name") )
            {
               gxTv_SdtTreeNodeCollection_TreeNode_Name = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Link") )
            {
               gxTv_SdtTreeNodeCollection_TreeNode_Link = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LinkTarget") )
            {
               gxTv_SdtTreeNodeCollection_TreeNode_Linktarget = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Expanded") )
            {
               gxTv_SdtTreeNodeCollection_TreeNode_Expanded = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "DynamicLoad") )
            {
               gxTv_SdtTreeNodeCollection_TreeNode_Dynamicload = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Icon") )
            {
               gxTv_SdtTreeNodeCollection_TreeNode_Icon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "IconWhenSelected") )
            {
               gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Nodes") )
            {
               if ( gxTv_SdtTreeNodeCollection_TreeNode_Nodes == null )
               {
                  gxTv_SdtTreeNodeCollection_TreeNode_Nodes = new GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>(com.SdtTreeNodeCollection_TreeNode.class, "TreeNode", "Gregory", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtTreeNodeCollection_TreeNode_Nodes.readxml(oReader, "Nodes") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Nodes") )
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
         sName = "TreeNodeCollection.TreeNode" ;
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
      oWriter.writeElement("Id", gxTv_SdtTreeNodeCollection_TreeNode_Id);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Name", gxTv_SdtTreeNodeCollection_TreeNode_Name);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Link", gxTv_SdtTreeNodeCollection_TreeNode_Link);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("LinkTarget", gxTv_SdtTreeNodeCollection_TreeNode_Linktarget);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Expanded", GXutil.booltostr( gxTv_SdtTreeNodeCollection_TreeNode_Expanded));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("DynamicLoad", GXutil.booltostr( gxTv_SdtTreeNodeCollection_TreeNode_Dynamicload));
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("Icon", gxTv_SdtTreeNodeCollection_TreeNode_Icon);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      oWriter.writeElement("IconWhenSelected", gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected);
      if ( GXutil.strcmp(sNameSpace, "Gregory") != 0 )
      {
         oWriter.writeAttribute("xmlns", "Gregory");
      }
      if ( gxTv_SdtTreeNodeCollection_TreeNode_Nodes != null )
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
         gxTv_SdtTreeNodeCollection_TreeNode_Nodes.writexml(oWriter, "Nodes", sNameSpace1, sIncludeState);
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
      AddObjectProperty("Id", gxTv_SdtTreeNodeCollection_TreeNode_Id, false, false);
      AddObjectProperty("Name", gxTv_SdtTreeNodeCollection_TreeNode_Name, false, false);
      AddObjectProperty("Link", gxTv_SdtTreeNodeCollection_TreeNode_Link, false, false);
      AddObjectProperty("LinkTarget", gxTv_SdtTreeNodeCollection_TreeNode_Linktarget, false, false);
      AddObjectProperty("Expanded", gxTv_SdtTreeNodeCollection_TreeNode_Expanded, false, false);
      AddObjectProperty("DynamicLoad", gxTv_SdtTreeNodeCollection_TreeNode_Dynamicload, false, false);
      AddObjectProperty("Icon", gxTv_SdtTreeNodeCollection_TreeNode_Icon, false, false);
      AddObjectProperty("IconWhenSelected", gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected, false, false);
      if ( gxTv_SdtTreeNodeCollection_TreeNode_Nodes != null )
      {
         AddObjectProperty("Nodes", gxTv_SdtTreeNodeCollection_TreeNode_Nodes, false, false);
      }
   }

   public String getgxTv_SdtTreeNodeCollection_TreeNode_Id( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Id ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Id( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Id = value ;
   }

   public String getgxTv_SdtTreeNodeCollection_TreeNode_Name( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Name ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Name( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Name = value ;
   }

   public String getgxTv_SdtTreeNodeCollection_TreeNode_Link( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Link ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Link( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Link = value ;
   }

   public String getgxTv_SdtTreeNodeCollection_TreeNode_Linktarget( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Linktarget ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Linktarget( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Linktarget = value ;
   }

   public boolean getgxTv_SdtTreeNodeCollection_TreeNode_Expanded( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Expanded ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Expanded( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Expanded = value ;
   }

   public boolean getgxTv_SdtTreeNodeCollection_TreeNode_Dynamicload( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Dynamicload ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Dynamicload( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Dynamicload = value ;
   }

   public String getgxTv_SdtTreeNodeCollection_TreeNode_Icon( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Icon ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Icon( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Icon = value ;
   }

   public String getgxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected = value ;
   }

   public GXBaseCollection<com.SdtTreeNodeCollection_TreeNode> getgxTv_SdtTreeNodeCollection_TreeNode_Nodes( )
   {
      if ( gxTv_SdtTreeNodeCollection_TreeNode_Nodes == null )
      {
         gxTv_SdtTreeNodeCollection_TreeNode_Nodes = new GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>(com.SdtTreeNodeCollection_TreeNode.class, "TreeNode", "Gregory", remoteHandle);
      }
      gxTv_SdtTreeNodeCollection_TreeNode_Nodes_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      return gxTv_SdtTreeNodeCollection_TreeNode_Nodes ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Nodes( GXBaseCollection<com.SdtTreeNodeCollection_TreeNode> value )
   {
      gxTv_SdtTreeNodeCollection_TreeNode_Nodes_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Nodes = value ;
   }

   public void setgxTv_SdtTreeNodeCollection_TreeNode_Nodes_SetNull( )
   {
      gxTv_SdtTreeNodeCollection_TreeNode_Nodes_N = (byte)(1) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Nodes = null ;
   }

   public boolean getgxTv_SdtTreeNodeCollection_TreeNode_Nodes_IsNull( )
   {
      if ( gxTv_SdtTreeNodeCollection_TreeNode_Nodes == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtTreeNodeCollection_TreeNode_Nodes_N( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Nodes_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtTreeNodeCollection_TreeNode_Id = "" ;
      sdtIsNull = (byte)(1) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Name = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Link = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Linktarget = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Icon = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Nodes_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return sdtIsNull ;
   }

   public com.SdtTreeNodeCollection_TreeNode Clone( )
   {
      return (com.SdtTreeNodeCollection_TreeNode)(clone()) ;
   }

   public void setStruct( com.StructSdtTreeNodeCollection_TreeNode struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtTreeNodeCollection_TreeNode_Id(struct.getId());
         setgxTv_SdtTreeNodeCollection_TreeNode_Name(struct.getName());
         setgxTv_SdtTreeNodeCollection_TreeNode_Link(struct.getLink());
         setgxTv_SdtTreeNodeCollection_TreeNode_Linktarget(struct.getLinktarget());
         setgxTv_SdtTreeNodeCollection_TreeNode_Expanded(struct.getExpanded());
         setgxTv_SdtTreeNodeCollection_TreeNode_Dynamicload(struct.getDynamicload());
         setgxTv_SdtTreeNodeCollection_TreeNode_Icon(struct.getIcon());
         setgxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected(struct.getIconwhenselected());
         GXBaseCollection<com.SdtTreeNodeCollection_TreeNode> gxTv_SdtTreeNodeCollection_TreeNode_Nodes_aux = new GXBaseCollection<com.SdtTreeNodeCollection_TreeNode>(com.SdtTreeNodeCollection_TreeNode.class, "TreeNode", "Gregory", remoteHandle);
         Vector<com.StructSdtTreeNodeCollection_TreeNode> gxTv_SdtTreeNodeCollection_TreeNode_Nodes_aux1 = struct.getNodes();
         if (gxTv_SdtTreeNodeCollection_TreeNode_Nodes_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtTreeNodeCollection_TreeNode_Nodes_aux1.size(); i++)
            {
               gxTv_SdtTreeNodeCollection_TreeNode_Nodes_aux.add(new com.SdtTreeNodeCollection_TreeNode(gxTv_SdtTreeNodeCollection_TreeNode_Nodes_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtTreeNodeCollection_TreeNode_Nodes(gxTv_SdtTreeNodeCollection_TreeNode_Nodes_aux);
      }
   }

   @SuppressWarnings("unchecked")
   public com.StructSdtTreeNodeCollection_TreeNode getStruct( )
   {
      com.StructSdtTreeNodeCollection_TreeNode struct = new com.StructSdtTreeNodeCollection_TreeNode ();
      struct.setId(getgxTv_SdtTreeNodeCollection_TreeNode_Id());
      struct.setName(getgxTv_SdtTreeNodeCollection_TreeNode_Name());
      struct.setLink(getgxTv_SdtTreeNodeCollection_TreeNode_Link());
      struct.setLinktarget(getgxTv_SdtTreeNodeCollection_TreeNode_Linktarget());
      struct.setExpanded(getgxTv_SdtTreeNodeCollection_TreeNode_Expanded());
      struct.setDynamicload(getgxTv_SdtTreeNodeCollection_TreeNode_Dynamicload());
      struct.setIcon(getgxTv_SdtTreeNodeCollection_TreeNode_Icon());
      struct.setIconwhenselected(getgxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected());
      struct.setNodes(getgxTv_SdtTreeNodeCollection_TreeNode_Nodes().getStruct());
      return struct ;
   }

   protected byte sdtIsNull ;
   protected byte gxTv_SdtTreeNodeCollection_TreeNode_Nodes_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Id ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Name ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Link ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Linktarget ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Icon ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected ;
   protected String sTagName ;
   protected boolean gxTv_SdtTreeNodeCollection_TreeNode_Expanded ;
   protected boolean gxTv_SdtTreeNodeCollection_TreeNode_Dynamicload ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<com.SdtTreeNodeCollection_TreeNode> gxTv_SdtTreeNodeCollection_TreeNode_Nodes_aux ;
   protected GXBaseCollection<com.SdtTreeNodeCollection_TreeNode> gxTv_SdtTreeNodeCollection_TreeNode_Nodes=null ;
}

