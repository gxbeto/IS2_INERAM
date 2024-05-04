package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPGridState_DynamicFilter implements Cloneable, java.io.Serializable
{
   public StructSdtWWPGridState_DynamicFilter( )
   {
      this( -1, new ModelContext( StructSdtWWPGridState_DynamicFilter.class ));
   }

   public StructSdtWWPGridState_DynamicFilter( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtWWPGridState_DynamicFilter_Selected = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Dsc = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Value = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Valuedsc = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Valueto = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Valuetodsc = "" ;
      gxTv_SdtWWPGridState_DynamicFilter_Dsc_N = (byte)(1) ;
      gxTv_SdtWWPGridState_DynamicFilter_Valuedsc_N = (byte)(1) ;
      gxTv_SdtWWPGridState_DynamicFilter_Valuetodsc_N = (byte)(1) ;
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

   public String getSelected( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Selected ;
   }

   public void setSelected( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Selected = value ;
   }

   public String getDsc( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Dsc ;
   }

   public void setDsc( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_Dsc_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Dsc = value ;
   }

   public String getValue( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Value ;
   }

   public void setValue( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Value = value ;
   }

   public String getValuedsc( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Valuedsc ;
   }

   public void setValuedsc( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_Valuedsc_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Valuedsc = value ;
   }

   public short getOperator( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Operator ;
   }

   public void setOperator( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Operator = value ;
   }

   public String getValueto( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Valueto ;
   }

   public void setValueto( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Valueto = value ;
   }

   public String getValuetodsc( )
   {
      return gxTv_SdtWWPGridState_DynamicFilter_Valuetodsc ;
   }

   public void setValuetodsc( String value )
   {
      gxTv_SdtWWPGridState_DynamicFilter_Valuetodsc_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPGridState_DynamicFilter_Valuetodsc = value ;
   }

   protected byte gxTv_SdtWWPGridState_DynamicFilter_Dsc_N ;
   protected byte gxTv_SdtWWPGridState_DynamicFilter_Valuedsc_N ;
   protected byte gxTv_SdtWWPGridState_DynamicFilter_Valuetodsc_N ;
   protected byte sdtIsNull ;
   protected short gxTv_SdtWWPGridState_DynamicFilter_Operator ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Selected ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Dsc ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Value ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Valuedsc ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Valueto ;
   protected String gxTv_SdtWWPGridState_DynamicFilter_Valuetodsc ;
}

