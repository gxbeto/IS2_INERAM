package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem( )
   {
      this( -1, new ModelContext( StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem.class ));
   }

   public StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem( int remoteHandle ,
                                                                       ModelContext context )
   {
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2 = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3 = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url = "" ;
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

   public String getDisplaytype( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype ;
   }

   public void setDisplaytype( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype = value ;
   }

   public String getDescription( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description ;
   }

   public void setDescription( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description = value ;
   }

   public String getDescription2( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2 ;
   }

   public void setDescription2( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2 = value ;
   }

   public String getDescription3( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3 ;
   }

   public void setDescription3( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3 = value ;
   }

   public String getUrl( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url ;
   }

   public void setUrl( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url = value ;
   }

   protected byte sdtIsNull ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Displaytype ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description2 ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Description3 ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem_Url ;
}

