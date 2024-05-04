package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtGridStateCollection_Item implements Cloneable, java.io.Serializable
{
   public StructSdtGridStateCollection_Item( )
   {
      this( -1, new ModelContext( StructSdtGridStateCollection_Item.class ));
   }

   public StructSdtGridStateCollection_Item( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtGridStateCollection_Item_Title = "" ;
      gxTv_SdtGridStateCollection_Item_Gridstatexml = "" ;
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

   public String getTitle( )
   {
      return gxTv_SdtGridStateCollection_Item_Title ;
   }

   public void setTitle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGridStateCollection_Item_Title = value ;
   }

   public String getGridstatexml( )
   {
      return gxTv_SdtGridStateCollection_Item_Gridstatexml ;
   }

   public void setGridstatexml( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGridStateCollection_Item_Gridstatexml = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtGridStateCollection_Item_Gridstatexml ;
   protected String gxTv_SdtGridStateCollection_Item_Title ;
}

