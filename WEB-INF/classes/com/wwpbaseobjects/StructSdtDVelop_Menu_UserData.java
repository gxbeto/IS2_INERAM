package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtDVelop_Menu_UserData implements Cloneable, java.io.Serializable
{
   public StructSdtDVelop_Menu_UserData( )
   {
      this( -1, new ModelContext( StructSdtDVelop_Menu_UserData.class ));
   }

   public StructSdtDVelop_Menu_UserData( int remoteHandle ,
                                         ModelContext context )
   {
      gxTv_SdtDVelop_Menu_UserData_Photouri = "" ;
      gxTv_SdtDVelop_Menu_UserData_Firstline = "" ;
      gxTv_SdtDVelop_Menu_UserData_Secondline = "" ;
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

   public String getPhotouri( )
   {
      return gxTv_SdtDVelop_Menu_UserData_Photouri ;
   }

   public void setPhotouri( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_UserData_Photouri = value ;
   }

   public String getFirstline( )
   {
      return gxTv_SdtDVelop_Menu_UserData_Firstline ;
   }

   public void setFirstline( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_UserData_Firstline = value ;
   }

   public String getSecondline( )
   {
      return gxTv_SdtDVelop_Menu_UserData_Secondline ;
   }

   public void setSecondline( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtDVelop_Menu_UserData_Secondline = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtDVelop_Menu_UserData_Photouri ;
   protected String gxTv_SdtDVelop_Menu_UserData_Firstline ;
   protected String gxTv_SdtDVelop_Menu_UserData_Secondline ;
}

