package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtDVB_SDTComboData_Item implements Cloneable, java.io.Serializable
{
   public StructSdtDVB_SDTComboData_Item( )
   {
      this( -1, new ModelContext( StructSdtDVB_SDTComboData_Item.class ));
   }

   public StructSdtDVB_SDTComboData_Item( int remoteHandle ,
                                          ModelContext context )
   {
      gxTv_SdtDVB_SDTComboData_Item_Id = "" ;
      gxTv_SdtDVB_SDTComboData_Item_Title = "" ;
      gxTv_SdtDVB_SDTComboData_Item_Children_N = (byte)(1) ;
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
      return gxTv_SdtDVB_SDTComboData_Item_Id ;
   }

   public void setId( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTComboData_Item_Id = value ;
   }

   public String getTitle( )
   {
      return gxTv_SdtDVB_SDTComboData_Item_Title ;
   }

   public void setTitle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTComboData_Item_Title = value ;
   }

   public java.util.Vector<com.wwpbaseobjects.StructSdtDVB_SDTComboData_Item> getChildren( )
   {
      return gxTv_SdtDVB_SDTComboData_Item_Children ;
   }

   public void setChildren( java.util.Vector<com.wwpbaseobjects.StructSdtDVB_SDTComboData_Item> value )
   {
      gxTv_SdtDVB_SDTComboData_Item_Children_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTComboData_Item_Children = value ;
   }

   protected byte gxTv_SdtDVB_SDTComboData_Item_Children_N ;
   protected byte sdtIsNull ;
   protected String gxTv_SdtDVB_SDTComboData_Item_Id ;
   protected String gxTv_SdtDVB_SDTComboData_Item_Title ;
   protected java.util.Vector<com.wwpbaseobjects.StructSdtDVB_SDTComboData_Item> gxTv_SdtDVB_SDTComboData_Item_Children=null ;
}

