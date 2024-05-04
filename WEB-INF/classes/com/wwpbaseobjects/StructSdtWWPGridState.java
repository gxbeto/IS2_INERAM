package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPGridState implements Cloneable, java.io.Serializable
{
   public StructSdtWWPGridState( )
   {
      this( -1, new ModelContext( StructSdtWWPGridState.class ));
   }

   public StructSdtWWPGridState( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_SdtWWPGridState_Pagesize = "" ;
      gxTv_SdtWWPGridState_Collapsedrecords = "" ;
      gxTv_SdtWWPGridState_Groupby = "" ;
      gxTv_SdtWWPGridState_Collapsedrecords_N = (byte)(1) ;
      gxTv_SdtWWPGridState_Groupby_N = (byte)(1) ;
      gxTv_SdtWWPGridState_Filtervalues_N = (byte)(1) ;
      gxTv_SdtWWPGridState_Dynamicfilters_N = (byte)(1) ;
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

   public short getCurrentpage( )
   {
      return gxTv_SdtWWPGridState_Currentpage ;
   }

   public void setCurrentpage( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Currentpage = value ;
   }

   public short getOrderedby( )
   {
      return gxTv_SdtWWPGridState_Orderedby ;
   }

   public void setOrderedby( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Orderedby = value ;
   }

   public boolean getOrdereddsc( )
   {
      return gxTv_SdtWWPGridState_Ordereddsc ;
   }

   public void setOrdereddsc( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Ordereddsc = value ;
   }

   public byte getHidingsearch( )
   {
      return gxTv_SdtWWPGridState_Hidingsearch ;
   }

   public void setHidingsearch( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Hidingsearch = value ;
   }

   public String getPagesize( )
   {
      return gxTv_SdtWWPGridState_Pagesize ;
   }

   public void setPagesize( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Pagesize = value ;
   }

   public String getCollapsedrecords( )
   {
      return gxTv_SdtWWPGridState_Collapsedrecords ;
   }

   public void setCollapsedrecords( String value )
   {
      gxTv_SdtWWPGridState_Collapsedrecords_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Collapsedrecords = value ;
   }

   public String getGroupby( )
   {
      return gxTv_SdtWWPGridState_Groupby ;
   }

   public void setGroupby( String value )
   {
      gxTv_SdtWWPGridState_Groupby_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Groupby = value ;
   }

   public java.util.Vector<com.wwpbaseobjects.StructSdtWWPGridState_FilterValue> getFiltervalues( )
   {
      return gxTv_SdtWWPGridState_Filtervalues ;
   }

   public void setFiltervalues( java.util.Vector<com.wwpbaseobjects.StructSdtWWPGridState_FilterValue> value )
   {
      gxTv_SdtWWPGridState_Filtervalues_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Filtervalues = value ;
   }

   public java.util.Vector<com.wwpbaseobjects.StructSdtWWPGridState_DynamicFilter> getDynamicfilters( )
   {
      return gxTv_SdtWWPGridState_Dynamicfilters ;
   }

   public void setDynamicfilters( java.util.Vector<com.wwpbaseobjects.StructSdtWWPGridState_DynamicFilter> value )
   {
      gxTv_SdtWWPGridState_Dynamicfilters_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_Dynamicfilters = value ;
   }

   protected byte gxTv_SdtWWPGridState_Hidingsearch ;
   protected byte gxTv_SdtWWPGridState_Collapsedrecords_N ;
   protected byte gxTv_SdtWWPGridState_Groupby_N ;
   protected byte gxTv_SdtWWPGridState_Filtervalues_N ;
   protected byte gxTv_SdtWWPGridState_Dynamicfilters_N ;
   protected byte sdtIsNull ;
   protected short gxTv_SdtWWPGridState_Currentpage ;
   protected short gxTv_SdtWWPGridState_Orderedby ;
   protected boolean gxTv_SdtWWPGridState_Ordereddsc ;
   protected String gxTv_SdtWWPGridState_Collapsedrecords ;
   protected String gxTv_SdtWWPGridState_Pagesize ;
   protected String gxTv_SdtWWPGridState_Groupby ;
   protected java.util.Vector<com.wwpbaseobjects.StructSdtWWPGridState_FilterValue> gxTv_SdtWWPGridState_Filtervalues=null ;
   protected java.util.Vector<com.wwpbaseobjects.StructSdtWWPGridState_DynamicFilter> gxTv_SdtWWPGridState_Dynamicfilters=null ;
}

