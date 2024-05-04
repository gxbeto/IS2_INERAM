package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtProgramNames_ProgramName implements Cloneable, java.io.Serializable
{
   public StructSdtProgramNames_ProgramName( )
   {
      this( -1, new ModelContext( StructSdtProgramNames_ProgramName.class ));
   }

   public StructSdtProgramNames_ProgramName( int remoteHandle ,
                                             ModelContext context )
   {
      gxTv_SdtProgramNames_ProgramName_Name = "" ;
      gxTv_SdtProgramNames_ProgramName_Description = "" ;
      gxTv_SdtProgramNames_ProgramName_Link = "" ;
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
      return gxTv_SdtProgramNames_ProgramName_Name ;
   }

   public void setName( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtProgramNames_ProgramName_Name = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtProgramNames_ProgramName_Description ;
   }

   public void setDescription( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtProgramNames_ProgramName_Description = value ;
   }

   public String getLink( )
   {
      return gxTv_SdtProgramNames_ProgramName_Link ;
   }

   public void setLink( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtProgramNames_ProgramName_Link = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtProgramNames_ProgramName_Name ;
   protected String gxTv_SdtProgramNames_ProgramName_Description ;
   protected String gxTv_SdtProgramNames_ProgramName_Link ;
}

