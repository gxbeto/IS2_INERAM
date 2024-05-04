package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtSplitScreenDetailInfo implements Cloneable, java.io.Serializable
{
   public StructSdtSplitScreenDetailInfo( )
   {
      this( -1, new ModelContext( StructSdtSplitScreenDetailInfo.class ));
   }

   public StructSdtSplitScreenDetailInfo( int remoteHandle ,
                                          ModelContext context )
   {
      gxTv_SdtSplitScreenDetailInfo_Link = "" ;
      gxTv_SdtSplitScreenDetailInfo_Title = "" ;
      gxTv_SdtSplitScreenDetailInfo_Keys = "" ;
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

   public String getLink( )
   {
      return gxTv_SdtSplitScreenDetailInfo_Link ;
   }

   public void setLink( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtSplitScreenDetailInfo_Link = value ;
   }

   public String getTitle( )
   {
      return gxTv_SdtSplitScreenDetailInfo_Title ;
   }

   public void setTitle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtSplitScreenDetailInfo_Title = value ;
   }

   public String getKeys( )
   {
      return gxTv_SdtSplitScreenDetailInfo_Keys ;
   }

   public void setKeys( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtSplitScreenDetailInfo_Keys = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtSplitScreenDetailInfo_Link ;
   protected String gxTv_SdtSplitScreenDetailInfo_Title ;
   protected String gxTv_SdtSplitScreenDetailInfo_Keys ;
}

