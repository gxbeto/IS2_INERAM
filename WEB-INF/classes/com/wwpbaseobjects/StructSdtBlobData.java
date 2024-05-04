package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtBlobData implements Cloneable, java.io.Serializable
{
   public StructSdtBlobData( )
   {
      this( -1, new ModelContext( StructSdtBlobData.class ));
   }

   public StructSdtBlobData( int remoteHandle ,
                             ModelContext context )
   {
      gxTv_SdtBlobData_Path = "" ;
      gxTv_SdtBlobData_Filename = "" ;
      gxTv_SdtBlobData_Fileextension = "" ;
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

   public String getPath( )
   {
      return gxTv_SdtBlobData_Path ;
   }

   public void setPath( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtBlobData_Path = value ;
   }

   public String getFilename( )
   {
      return gxTv_SdtBlobData_Filename ;
   }

   public void setFilename( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtBlobData_Filename = value ;
   }

   public String getFileextension( )
   {
      return gxTv_SdtBlobData_Fileextension ;
   }

   public void setFileextension( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtBlobData_Fileextension = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtBlobData_Path ;
   protected String gxTv_SdtBlobData_Filename ;
   protected String gxTv_SdtBlobData_Fileextension ;
}

