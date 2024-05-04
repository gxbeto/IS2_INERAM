package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWP_DesignSystemSettings implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_DesignSystemSettings( )
   {
      this( -1, new ModelContext( StructSdtWWP_DesignSystemSettings.class ));
   }

   public StructSdtWWP_DesignSystemSettings( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtWWP_DesignSystemSettings_Basecolor = "" ;
      gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle = "" ;
      gxTv_SdtWWP_DesignSystemSettings_Fontsize = "" ;
      gxTv_SdtWWP_DesignSystemSettings_Menucolor = "" ;
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

   public String getBasecolor( )
   {
      return gxTv_SdtWWP_DesignSystemSettings_Basecolor ;
   }

   public void setBasecolor( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_DesignSystemSettings_Basecolor = value ;
   }

   public String getBackgroundstyle( )
   {
      return gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle ;
   }

   public void setBackgroundstyle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle = value ;
   }

   public String getFontsize( )
   {
      return gxTv_SdtWWP_DesignSystemSettings_Fontsize ;
   }

   public void setFontsize( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_DesignSystemSettings_Fontsize = value ;
   }

   public String getMenucolor( )
   {
      return gxTv_SdtWWP_DesignSystemSettings_Menucolor ;
   }

   public void setMenucolor( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_DesignSystemSettings_Menucolor = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtWWP_DesignSystemSettings_Basecolor ;
   protected String gxTv_SdtWWP_DesignSystemSettings_Backgroundstyle ;
   protected String gxTv_SdtWWP_DesignSystemSettings_Fontsize ;
   protected String gxTv_SdtWWP_DesignSystemSettings_Menucolor ;
}

