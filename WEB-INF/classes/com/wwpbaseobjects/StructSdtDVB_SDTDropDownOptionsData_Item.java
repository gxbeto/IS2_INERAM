package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtDVB_SDTDropDownOptionsData_Item implements Cloneable, java.io.Serializable
{
   public StructSdtDVB_SDTDropDownOptionsData_Item( )
   {
      this( -1, new ModelContext( StructSdtDVB_SDTDropDownOptionsData_Item.class ));
   }

   public StructSdtDVB_SDTDropDownOptionsData_Item( int remoteHandle ,
                                                    ModelContext context )
   {
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent = "" ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass = "" ;
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

   public String getIcon( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon ;
   }

   public void setIcon( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon = value ;
   }

   public String getIcon_gxi( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi ;
   }

   public void setIcon_gxi( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi = value ;
   }

   public String getFonticon( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon ;
   }

   public void setFonticon( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon = value ;
   }

   public String getTitle( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title ;
   }

   public void setTitle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title = value ;
   }

   public String getTooltip( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip ;
   }

   public void setTooltip( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip = value ;
   }

   public String getLink( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link ;
   }

   public void setLink( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link = value ;
   }

   public String getEventkey( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey ;
   }

   public void setEventkey( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey = value ;
   }

   public boolean getIsdivider( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider ;
   }

   public void setIsdivider( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider = value ;
   }

   public String getJsonclickevent( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent ;
   }

   public void setJsonclickevent( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent = value ;
   }

   public String getThemeclass( )
   {
      return gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass ;
   }

   public void setThemeclass( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Title ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Tooltip ;
   protected boolean gxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon_gxi ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Link ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Jsonclickevent ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Themeclass ;
   protected String gxTv_SdtDVB_SDTDropDownOptionsData_Item_Icon ;
}

