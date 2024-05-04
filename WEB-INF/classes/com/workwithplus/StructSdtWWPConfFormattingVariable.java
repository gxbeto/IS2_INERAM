package com.workwithplus ;
import com.genexus.*;

public final  class StructSdtWWPConfFormattingVariable implements Cloneable, java.io.Serializable
{
   public StructSdtWWPConfFormattingVariable( )
   {
      this( -1, new ModelContext( StructSdtWWPConfFormattingVariable.class ));
   }

   public StructSdtWWPConfFormattingVariable( int remoteHandle ,
                                              ModelContext context )
   {
      gxTv_SdtWWPConfFormattingVariable_Name = "" ;
      gxTv_SdtWWPConfFormattingVariable_Description = "" ;
      gxTv_SdtWWPConfFormattingVariable_Defaultvalue = "" ;
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

   public String getName( )
   {
      return gxTv_SdtWWPConfFormattingVariable_Name ;
   }

   public void setName( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPConfFormattingVariable_Name = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtWWPConfFormattingVariable_Description ;
   }

   public void setDescription( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPConfFormattingVariable_Description = value ;
   }

   public String getDefaultvalue( )
   {
      return gxTv_SdtWWPConfFormattingVariable_Defaultvalue ;
   }

   public void setDefaultvalue( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWPConfFormattingVariable_Defaultvalue = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtWWPConfFormattingVariable_Name ;
   protected String gxTv_SdtWWPConfFormattingVariable_Description ;
   protected String gxTv_SdtWWPConfFormattingVariable_Defaultvalue ;
}

