package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWPColumnsSelector_Column implements Cloneable, java.io.Serializable
{
   public StructSdtWWPColumnsSelector_Column( )
   {
      this( -1, new ModelContext( StructSdtWWPColumnsSelector_Column.class ));
   }

   public StructSdtWWPColumnsSelector_Column( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_SdtWWPColumnsSelector_Column_Columnname = "" ;
      gxTv_SdtWWPColumnsSelector_Column_Displayname = "" ;
      gxTv_SdtWWPColumnsSelector_Column_Category = "" ;
      gxTv_SdtWWPColumnsSelector_Column_Fixed = "" ;
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

   public String getColumnname( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Columnname ;
   }

   public void setColumnname( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Columnname = value ;
   }

   public boolean getIsvisible( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Isvisible ;
   }

   public void setIsvisible( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Isvisible = value ;
   }

   public String getDisplayname( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Displayname ;
   }

   public void setDisplayname( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Displayname = value ;
   }

   public short getOrder( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Order ;
   }

   public void setOrder( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Order = value ;
   }

   public String getCategory( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Category ;
   }

   public void setCategory( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Category = value ;
   }

   public String getFixed( )
   {
      return gxTv_SdtWWPColumnsSelector_Column_Fixed ;
   }

   public void setFixed( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPColumnsSelector_Column_Fixed = value ;
   }

   protected byte sdtIsNull ;
   protected short gxTv_SdtWWPColumnsSelector_Column_Order ;
   protected boolean gxTv_SdtWWPColumnsSelector_Column_Isvisible ;
   protected String gxTv_SdtWWPColumnsSelector_Column_Columnname ;
   protected String gxTv_SdtWWPColumnsSelector_Column_Displayname ;
   protected String gxTv_SdtWWPColumnsSelector_Column_Category ;
   protected String gxTv_SdtWWPColumnsSelector_Column_Fixed ;
}

