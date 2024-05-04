package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtMenuItem implements Cloneable, java.io.Serializable
{
   public StructSdtMenuItem( )
   {
      this( -1, new ModelContext( StructSdtMenuItem.class ));
   }

   public StructSdtMenuItem( int remoteHandle ,
                             ModelContext context )
   {
      gxTv_SdtMenuItem_Menuitemcaption = "" ;
      gxTv_SdtMenuItem_Menuitemfathercaption = "" ;
      gxTv_SdtMenuItem_Menuitemlink = "" ;
      gxTv_SdtMenuItem_Menuitemlinkparameters = "" ;
      gxTv_SdtMenuItem_Menuitemlinktarget = "" ;
      gxTv_SdtMenuItem_Menuitemiconclass = "" ;
      gxTv_SdtMenuItem_Mode = "" ;
      gxTv_SdtMenuItem_Menuitemcaption_Z = "" ;
      gxTv_SdtMenuItem_Menuitemfathercaption_Z = "" ;
      gxTv_SdtMenuItem_Menuitemlink_Z = "" ;
      gxTv_SdtMenuItem_Menuitemlinkparameters_Z = "" ;
      gxTv_SdtMenuItem_Menuitemlinktarget_Z = "" ;
      gxTv_SdtMenuItem_Menuitemiconclass_Z = "" ;
      gxTv_SdtMenuItem_Menuitemfatherid_N = (byte)(1) ;
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

   public short getMenuitemid( )
   {
      return gxTv_SdtMenuItem_Menuitemid ;
   }

   public void setMenuitemid( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemid = value ;
   }

   public String getMenuitemcaption( )
   {
      return gxTv_SdtMenuItem_Menuitemcaption ;
   }

   public void setMenuitemcaption( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemcaption = value ;
   }

   public short getMenuitemorder( )
   {
      return gxTv_SdtMenuItem_Menuitemorder ;
   }

   public void setMenuitemorder( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemorder = value ;
   }

   public short getMenuitemfatherid( )
   {
      return gxTv_SdtMenuItem_Menuitemfatherid ;
   }

   public void setMenuitemfatherid( short value )
   {
      gxTv_SdtMenuItem_Menuitemfatherid_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemfatherid = value ;
   }

   public String getMenuitemfathercaption( )
   {
      return gxTv_SdtMenuItem_Menuitemfathercaption ;
   }

   public void setMenuitemfathercaption( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemfathercaption = value ;
   }

   public byte getMenuitemfathertype( )
   {
      return gxTv_SdtMenuItem_Menuitemfathertype ;
   }

   public void setMenuitemfathertype( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemfathertype = value ;
   }

   public byte getMenuitemtype( )
   {
      return gxTv_SdtMenuItem_Menuitemtype ;
   }

   public void setMenuitemtype( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemtype = value ;
   }

   public String getMenuitemlink( )
   {
      return gxTv_SdtMenuItem_Menuitemlink ;
   }

   public void setMenuitemlink( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemlink = value ;
   }

   public String getMenuitemlinkparameters( )
   {
      return gxTv_SdtMenuItem_Menuitemlinkparameters ;
   }

   public void setMenuitemlinkparameters( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemlinkparameters = value ;
   }

   public String getMenuitemlinktarget( )
   {
      return gxTv_SdtMenuItem_Menuitemlinktarget ;
   }

   public void setMenuitemlinktarget( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemlinktarget = value ;
   }

   public String getMenuitemiconclass( )
   {
      return gxTv_SdtMenuItem_Menuitemiconclass ;
   }

   public void setMenuitemiconclass( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemiconclass = value ;
   }

   public boolean getMenuitemshowdevelopermenuoption( )
   {
      return gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption ;
   }

   public void setMenuitemshowdevelopermenuoption( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption = value ;
   }

   public boolean getMenuitemshoweditmenuoptions( )
   {
      return gxTv_SdtMenuItem_Menuitemshoweditmenuoptions ;
   }

   public void setMenuitemshoweditmenuoptions( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemshoweditmenuoptions = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtMenuItem_Mode ;
   }

   public void setMode( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtMenuItem_Initialized ;
   }

   public void setInitialized( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Initialized = value ;
   }

   public short getMenuitemid_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemid_Z ;
   }

   public void setMenuitemid_Z( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemid_Z = value ;
   }

   public String getMenuitemcaption_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemcaption_Z ;
   }

   public void setMenuitemcaption_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemcaption_Z = value ;
   }

   public short getMenuitemorder_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemorder_Z ;
   }

   public void setMenuitemorder_Z( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemorder_Z = value ;
   }

   public short getMenuitemfatherid_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemfatherid_Z ;
   }

   public void setMenuitemfatherid_Z( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemfatherid_Z = value ;
   }

   public String getMenuitemfathercaption_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemfathercaption_Z ;
   }

   public void setMenuitemfathercaption_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemfathercaption_Z = value ;
   }

   public byte getMenuitemfathertype_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemfathertype_Z ;
   }

   public void setMenuitemfathertype_Z( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemfathertype_Z = value ;
   }

   public byte getMenuitemtype_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemtype_Z ;
   }

   public void setMenuitemtype_Z( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemtype_Z = value ;
   }

   public String getMenuitemlink_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemlink_Z ;
   }

   public void setMenuitemlink_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemlink_Z = value ;
   }

   public String getMenuitemlinkparameters_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemlinkparameters_Z ;
   }

   public void setMenuitemlinkparameters_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemlinkparameters_Z = value ;
   }

   public String getMenuitemlinktarget_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemlinktarget_Z ;
   }

   public void setMenuitemlinktarget_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemlinktarget_Z = value ;
   }

   public String getMenuitemiconclass_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemiconclass_Z ;
   }

   public void setMenuitemiconclass_Z( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemiconclass_Z = value ;
   }

   public boolean getMenuitemshowdevelopermenuoption_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z ;
   }

   public void setMenuitemshowdevelopermenuoption_Z( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z = value ;
   }

   public boolean getMenuitemshoweditmenuoptions_Z( )
   {
      return gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z ;
   }

   public void setMenuitemshoweditmenuoptions_Z( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z = value ;
   }

   public byte getMenuitemfatherid_N( )
   {
      return gxTv_SdtMenuItem_Menuitemfatherid_N ;
   }

   public void setMenuitemfatherid_N( byte value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtMenuItem_Menuitemfatherid_N = value ;
   }

   protected byte gxTv_SdtMenuItem_Menuitemfathertype ;
   protected byte gxTv_SdtMenuItem_Menuitemtype ;
   protected byte gxTv_SdtMenuItem_Menuitemfathertype_Z ;
   protected byte gxTv_SdtMenuItem_Menuitemtype_Z ;
   protected byte gxTv_SdtMenuItem_Menuitemfatherid_N ;
   private byte sdtIsNull ;
   protected short gxTv_SdtMenuItem_Menuitemid ;
   protected short gxTv_SdtMenuItem_Menuitemorder ;
   protected short gxTv_SdtMenuItem_Menuitemfatherid ;
   protected short gxTv_SdtMenuItem_Initialized ;
   protected short gxTv_SdtMenuItem_Menuitemid_Z ;
   protected short gxTv_SdtMenuItem_Menuitemorder_Z ;
   protected short gxTv_SdtMenuItem_Menuitemfatherid_Z ;
   protected String gxTv_SdtMenuItem_Mode ;
   protected boolean gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption ;
   protected boolean gxTv_SdtMenuItem_Menuitemshoweditmenuoptions ;
   protected boolean gxTv_SdtMenuItem_Menuitemshowdevelopermenuoption_Z ;
   protected boolean gxTv_SdtMenuItem_Menuitemshoweditmenuoptions_Z ;
   protected String gxTv_SdtMenuItem_Menuitemcaption ;
   protected String gxTv_SdtMenuItem_Menuitemfathercaption ;
   protected String gxTv_SdtMenuItem_Menuitemlink ;
   protected String gxTv_SdtMenuItem_Menuitemlinkparameters ;
   protected String gxTv_SdtMenuItem_Menuitemlinktarget ;
   protected String gxTv_SdtMenuItem_Menuitemiconclass ;
   protected String gxTv_SdtMenuItem_Menuitemcaption_Z ;
   protected String gxTv_SdtMenuItem_Menuitemfathercaption_Z ;
   protected String gxTv_SdtMenuItem_Menuitemlink_Z ;
   protected String gxTv_SdtMenuItem_Menuitemlinkparameters_Z ;
   protected String gxTv_SdtMenuItem_Menuitemlinktarget_Z ;
   protected String gxTv_SdtMenuItem_Menuitemiconclass_Z ;
}

