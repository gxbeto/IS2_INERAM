package com.workwithplus ;
import com.genexus.*;

public final  class StructSdtWWP_Parameter implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_Parameter( )
   {
      this( -1, new ModelContext( StructSdtWWP_Parameter.class ));
   }

   public StructSdtWWP_Parameter( int remoteHandle ,
                                  ModelContext context )
   {
      gxTv_SdtWWP_Parameter_Wwpparameterkey = "" ;
      gxTv_SdtWWP_Parameter_Wwpparametercategory = "" ;
      gxTv_SdtWWP_Parameter_Wwpparameterdescription = "" ;
      gxTv_SdtWWP_Parameter_Wwpparametervalue = "" ;
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed = "" ;
      gxTv_SdtWWP_Parameter_Mode = "" ;
      gxTv_SdtWWP_Parameter_Wwpparameterkey_Z = "" ;
      gxTv_SdtWWP_Parameter_Wwpparametercategory_Z = "" ;
      gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z = "" ;
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z = "" ;
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

   public String getWwpparameterkey( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterkey ;
   }

   public void setWwpparameterkey( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparameterkey = value ;
   }

   public String getWwpparametercategory( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametercategory ;
   }

   public void setWwpparametercategory( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparametercategory = value ;
   }

   public String getWwpparameterdescription( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterdescription ;
   }

   public void setWwpparameterdescription( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparameterdescription = value ;
   }

   public String getWwpparametervalue( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametervalue ;
   }

   public void setWwpparametervalue( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparametervalue = value ;
   }

   public String getWwpparametervaluetrimmed( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed ;
   }

   public void setWwpparametervaluetrimmed( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed = value ;
   }

   public boolean getWwpparameterdisabledelete( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete ;
   }

   public void setWwpparameterdisabledelete( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtWWP_Parameter_Mode ;
   }

   public void setMode( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtWWP_Parameter_Initialized ;
   }

   public void setInitialized( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Initialized = value ;
   }

   public String getWwpparameterkey_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterkey_Z ;
   }

   public void setWwpparameterkey_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparameterkey_Z = value ;
   }

   public String getWwpparametercategory_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametercategory_Z ;
   }

   public void setWwpparametercategory_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparametercategory_Z = value ;
   }

   public String getWwpparameterdescription_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z ;
   }

   public void setWwpparameterdescription_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z = value ;
   }

   public String getWwpparametervaluetrimmed_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z ;
   }

   public void setWwpparametervaluetrimmed_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z = value ;
   }

   public boolean getWwpparameterdisabledelete_Z( )
   {
      return gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z ;
   }

   public void setWwpparameterdisabledelete_Z( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z = value ;
   }

   private byte sdtIsNull ;
   protected short gxTv_SdtWWP_Parameter_Initialized ;
   protected String gxTv_SdtWWP_Parameter_Mode ;
   protected boolean gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete ;
   protected boolean gxTv_SdtWWP_Parameter_Wwpparameterdisabledelete_Z ;
   protected String gxTv_SdtWWP_Parameter_Wwpparametervalue ;
   protected String gxTv_SdtWWP_Parameter_Wwpparameterkey ;
   protected String gxTv_SdtWWP_Parameter_Wwpparametercategory ;
   protected String gxTv_SdtWWP_Parameter_Wwpparameterdescription ;
   protected String gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed ;
   protected String gxTv_SdtWWP_Parameter_Wwpparameterkey_Z ;
   protected String gxTv_SdtWWP_Parameter_Wwpparametercategory_Z ;
   protected String gxTv_SdtWWP_Parameter_Wwpparameterdescription_Z ;
   protected String gxTv_SdtWWP_Parameter_Wwpparametervaluetrimmed_Z ;
}

