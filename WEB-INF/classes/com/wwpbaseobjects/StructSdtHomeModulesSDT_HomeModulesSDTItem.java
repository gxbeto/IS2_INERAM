package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtHomeModulesSDT_HomeModulesSDTItem implements Cloneable, java.io.Serializable
{
   public StructSdtHomeModulesSDT_HomeModulesSDTItem( )
   {
      this( -1, new ModelContext( StructSdtHomeModulesSDT_HomeModulesSDTItem.class ));
   }

   public StructSdtHomeModulesSDT_HomeModulesSDTItem( int remoteHandle ,
                                                      ModelContext context )
   {
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle = "" ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription = "" ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass = "" ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage = "" ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi = "" ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink = "" ;
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

   public String getOptiontitle( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle ;
   }

   public void setOptiontitle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle = value ;
   }

   public String getOptiondescription( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription ;
   }

   public void setOptiondescription( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription = value ;
   }

   public String getOptioniconthemeclass( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass ;
   }

   public void setOptioniconthemeclass( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass = value ;
   }

   public byte getOptiontype( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype ;
   }

   public void setOptiontype( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype = value ;
   }

   public String getOptionbackgroundimage( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage ;
   }

   public void setOptionbackgroundimage( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage = value ;
   }

   public String getOptionbackgroundimage_gxi( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi ;
   }

   public void setOptionbackgroundimage_gxi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi = value ;
   }

   public byte getOptionsize( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize ;
   }

   public void setOptionsize( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize = value ;
   }

   public byte getOptionprogressvalue( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue ;
   }

   public void setOptionprogressvalue( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue = value ;
   }

   public String getOptionwclink( )
   {
      return gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink ;
   }

   public void setOptionwclink( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink = value ;
   }

   protected byte gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontype ;
   protected byte gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionsize ;
   protected byte gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionprogressvalue ;
   protected byte sdtIsNull ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiontitle ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optiondescription ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optioniconthemeclass ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage_gxi ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionwclink ;
   protected String gxTv_SdtHomeModulesSDT_HomeModulesSDTItem_Optionbackgroundimage ;
}

