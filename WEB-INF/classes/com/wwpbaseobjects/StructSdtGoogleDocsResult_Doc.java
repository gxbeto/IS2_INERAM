package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtGoogleDocsResult_Doc implements Cloneable, java.io.Serializable
{
   public StructSdtGoogleDocsResult_Doc( )
   {
      this( -1, new ModelContext( StructSdtGoogleDocsResult_Doc.class ));
   }

   public StructSdtGoogleDocsResult_Doc( int remoteHandle ,
                                         ModelContext context )
   {
      gxTv_SdtGoogleDocsResult_Doc_Type = "" ;
      gxTv_SdtGoogleDocsResult_Doc_Title = "" ;
      gxTv_SdtGoogleDocsResult_Doc_Url = "" ;
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

   public String getType( )
   {
      return gxTv_SdtGoogleDocsResult_Doc_Type ;
   }

   public void setType( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Doc_Type = value ;
   }

   public String getTitle( )
   {
      return gxTv_SdtGoogleDocsResult_Doc_Title ;
   }

   public void setTitle( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Doc_Title = value ;
   }

   public String getUrl( )
   {
      return gxTv_SdtGoogleDocsResult_Doc_Url ;
   }

   public void setUrl( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtGoogleDocsResult_Doc_Url = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtGoogleDocsResult_Doc_Type ;
   protected String gxTv_SdtGoogleDocsResult_Doc_Title ;
   protected String gxTv_SdtGoogleDocsResult_Doc_Url ;
}

