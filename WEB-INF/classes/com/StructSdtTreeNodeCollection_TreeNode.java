package com ;
import com.genexus.*;

public final  class StructSdtTreeNodeCollection_TreeNode implements Cloneable, java.io.Serializable
{
   public StructSdtTreeNodeCollection_TreeNode( )
   {
      this( -1, new ModelContext( StructSdtTreeNodeCollection_TreeNode.class ));
   }

   public StructSdtTreeNodeCollection_TreeNode( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_SdtTreeNodeCollection_TreeNode_Id = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Name = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Link = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Linktarget = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Icon = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected = "" ;
      gxTv_SdtTreeNodeCollection_TreeNode_Nodes_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public String getId( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Id ;
   }

   public void setId( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Id = value ;
   }

   public String getName( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Name ;
   }

   public void setName( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Name = value ;
   }

   public String getLink( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Link ;
   }

   public void setLink( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Link = value ;
   }

   public String getLinktarget( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Linktarget ;
   }

   public void setLinktarget( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Linktarget = value ;
   }

   public boolean getExpanded( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Expanded ;
   }

   public void setExpanded( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Expanded = value ;
   }

   public boolean getDynamicload( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Dynamicload ;
   }

   public void setDynamicload( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Dynamicload = value ;
   }

   public String getIcon( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Icon ;
   }

   public void setIcon( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Icon = value ;
   }

   public String getIconwhenselected( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected ;
   }

   public void setIconwhenselected( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected = value ;
   }

   public java.util.Vector<com.StructSdtTreeNodeCollection_TreeNode> getNodes( )
   {
      return gxTv_SdtTreeNodeCollection_TreeNode_Nodes ;
   }

   public void setNodes( java.util.Vector<com.StructSdtTreeNodeCollection_TreeNode> value )
   {
      gxTv_SdtTreeNodeCollection_TreeNode_Nodes_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtTreeNodeCollection_TreeNode_Nodes = value ;
   }

   protected byte gxTv_SdtTreeNodeCollection_TreeNode_Nodes_N ;
   protected byte sdtIsNull ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Id ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Name ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Link ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Linktarget ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Icon ;
   protected String gxTv_SdtTreeNodeCollection_TreeNode_Iconwhenselected ;
   protected boolean gxTv_SdtTreeNodeCollection_TreeNode_Expanded ;
   protected boolean gxTv_SdtTreeNodeCollection_TreeNode_Dynamicload ;
   protected java.util.Vector<com.StructSdtTreeNodeCollection_TreeNode> gxTv_SdtTreeNodeCollection_TreeNode_Nodes=null ;
}

