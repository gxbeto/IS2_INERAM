package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtGoogleDocsResult implements Cloneable, java.io.Serializable
{
   public StructSdtGoogleDocsResult( )
   {
      this( -1, new ModelContext( StructSdtGoogleDocsResult.class ));
   }

   public StructSdtGoogleDocsResult( int remoteHandle ,
                                     ModelContext context )
   {
      gxTv_SdtGoogleDocsResult_Error = "" ;
      gxTv_SdtGoogleDocsResult_Docs_N = (byte)(1) ;
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

   public boolean getSuccess( )
   {
      return gxTv_SdtGoogleDocsResult_Success ;
   }

   public void setSuccess( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Success = value ;
   }

   public String getError( )
   {
      return gxTv_SdtGoogleDocsResult_Error ;
   }

   public void setError( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Error = value ;
   }

   public java.util.Vector<com.wwpbaseobjects.StructSdtGoogleDocsResult_Doc> getDocs( )
   {
      return gxTv_SdtGoogleDocsResult_Docs ;
   }

   public void setDocs( java.util.Vector<com.wwpbaseobjects.StructSdtGoogleDocsResult_Doc> value )
   {
      gxTv_SdtGoogleDocsResult_Docs_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Docs = value ;
   }

   protected byte gxTv_SdtGoogleDocsResult_Docs_N ;
   protected byte sdtIsNull ;
   protected boolean gxTv_SdtGoogleDocsResult_Success ;
   protected String gxTv_SdtGoogleDocsResult_Error ;
   protected java.util.Vector<com.wwpbaseobjects.StructSdtGoogleDocsResult_Doc> gxTv_SdtGoogleDocsResult_Docs=null ;
}

