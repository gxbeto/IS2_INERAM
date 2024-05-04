package com.wwpbaseobjects ;
import com.genexus.*;

public final  class StructSdtWWP_SearchResults_WWP_SearchResultsItem implements Cloneable, java.io.Serializable
{
   public StructSdtWWP_SearchResults_WWP_SearchResultsItem( )
   {
      this( -1, new ModelContext( StructSdtWWP_SearchResults_WWP_SearchResultsItem.class ));
   }

   public StructSdtWWP_SearchResults_WWP_SearchResultsItem( int remoteHandle ,
                                                            ModelContext context )
   {
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon = "" ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N = (byte)(1) ;
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

   public String getCategoryname( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname ;
   }

   public void setCategoryname( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname = value ;
   }

   public String getCategoryicon( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon ;
   }

   public void setCategoryicon( String value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon = value ;
   }

   public boolean getShowingallresults( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults ;
   }

   public void setShowingallresults( boolean value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults = value ;
   }

   public short getOrderindex( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex ;
   }

   public void setOrderindex( short value )
   {
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex = value ;
   }

   public java.util.Vector<com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> getResult( )
   {
      return gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result ;
   }

   public void setResult( java.util.Vector<com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> value )
   {
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N = (byte)(0) ;
      sdtIsNull = (byte)(0) ;
      gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result = value ;
   }

   protected byte gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result_N ;
   protected byte sdtIsNull ;
   protected short gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Orderindex ;
   protected boolean gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Showingallresults ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryname ;
   protected String gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Categoryicon ;
   protected java.util.Vector<com.wwpbaseobjects.StructSdtWWP_SearchResults_WWP_SearchResultsItem_ResultItem> gxTv_SdtWWP_SearchResults_WWP_SearchResultsItem_Result=null ;
}

